
import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class fChaining
{
    public static String fTell;
    public static String fAsk;
    public static ArrayList<String> fAgenda;
    public static ArrayList<String> fClause;
    public static ArrayList<String> fFacts;
    public static ArrayList<String> fEntailed;
    public static ArrayList<Integer> fCount;

    //Jonathan: constructor to initialise variables for FC method
    public fChaining(String pAsk, String pTell)
    {
        fTell = pTell;
        fAsk = pAsk;
        fAgenda = new ArrayList<String>();
        fClause = new ArrayList<String>();
        fFacts = new ArrayList<String>();
        fEntailed = new ArrayList<String>();
        fCount = new ArrayList<Integer>();
        initValues(fTell);

    }

    //Dylan: method to initialise the method
    public static void initValues(String fT)
    {
        String[] fSentence = fT.split(";");
        for (int i = 0; i < fSentence.length;i++) {
            if (!fSentence[i].contains("=>")) {
                fAgenda.add(fSentence[i]);
            }
            else {
                fClause.add(fSentence[i]);
                fCount.add(fSentence[i].split("&").length);
            }
        }

    }

    //Jonathan: method to execute FC Method
    public String execution()
    {
        String eOutput = "";
        if(forwardEntails())
        {
            eOutput = "YES";
            for(int i=0; i < fEntailed.size();i++)
            {
                eOutput += fEntailed.get(i)+", ";
            }
            eOutput += fAsk;
        }
        else
        {
            eOutput = "NO";
        }
        return eOutput;
    }

    //Dylan: method which checks if p appears in the premise of a given clause
    //	input : clause, p
    //	output : true if p is in the premise of clause
    public static boolean forwardPC(String fClause, String f)
    {
        String fC = fClause.split("=>")[0];
        String []  joins = fC.split("&");
        if(joins.length==1)
        {
            return fC.equals(f);
        }
        else
        {
            return Arrays.asList(joins).contains(f);
        }
    }


    //Jonathan: Forward Chaining Algorithm.
    public boolean forwardEntails()
    {
        while(!fAgenda.isEmpty())
        {
            String f = fAgenda.remove(0);
            fEntailed.add(f);

            for(int i = 0; i< fClause.size(); i++)
            {
                if(forwardPC(fClause.get(i),f)) {
                    Integer k = fCount.get(i);

                    fCount.set(i,--k);


                    if(fCount.get(i)== 0) {
                        String hD = fClause.get(i).split("=>")[1];

                        if (hD.equals(fAsk)) {
                            return true;
                        }
                        fAgenda.add(hD);

                    }
                }
            }
        }
        return false;
    }
}