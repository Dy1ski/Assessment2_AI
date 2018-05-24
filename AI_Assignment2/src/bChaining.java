import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class bChaining
{
    public static String bTell;
    public static String bAsk;
    public static ArrayList<String> bClauses;
    public static ArrayList<String> bEntailed;
    public static ArrayList<String> bAgenda;
    public static ArrayList<String> bFacts;

    // constructor
    public bChaining(String ask, String tell)
    {
        bTell = tell;
        bAsk = ask;
        bClauses = new ArrayList<String>();
        bEntailed = new ArrayList<String>();
        bAgenda = new  ArrayList<String>();
        bFacts = new ArrayList<String>();
        // InitValues(tell)l
    }
    public static void initValues(String told)
    {
        bAgenda.add(bAsk);
        String[] bSentence = told.split(";");

        for(int i=0; i < bSentence.length;i++)
        {
            if(!bSentence[i].contains("=>"))
            {
                bFacts.add(bSentence[i]);
            }
            else
            {
                bClauses.add(bSentence[i]);
            }
        }
    }



    public boolean backwordsEntails()
    {
        while(!bAgenda.isEmpty())
        {
            String query = bAgenda.remove(bAgenda.size()-1);
            bEntailed.add(query);

            if(!bFacts.contains(query))
            {
                ArrayList<String> b = new ArrayList<>();
                for(int i=0; i < bClauses.size(); i++)
                {
                    if(backwardsContains(bClauses.get(i),query)) //
                    {
                        ArrayList<String> bTemp = backwardsContext(bClauses.get(i));
                        for(int k =0; k < bTemp.size(); k++)
                        {
                            b.add(bTemp.get(k));
                        }
                    }
                }
                if(b.size()==0)
                {
                    return false;
                }
                else
                {
                    for(int i = 0; i < b.size(); i++)
                    {
                        if(!bEntailed.contains((b.get(i))))
                        {
                            bAgenda.add(b.get(i));
                        }
                    }

                    }
            }
        }
        return true;
    }

    public String Execution()
    {
        String eOutput = "";
        if(backwordsEntails()) {
            eOutput = "Yes: ";
            for (int i = bEntailed.size() - 1; i >= 0; i++) {
                if (i == 0) {
                    eOutput += bEntailed.get(i);
                } else {
                    eOutput += bEntailed.get(i) + ", ";
                }
            }
        }
        else
        {
            eOutput = "NO";
        }
        return eOutput;
    }

    public static ArrayList<String> backwardsContext(String clause)
    {
        String bContext = clause.split("=>")[0];
        ArrayList<String> cTemp = new ArrayList<String>();
        String[] joins = bContext.split("&");

        for(int i=0; i < joins.length;i++)
        {
            if(!bAgenda.contains((joins[i])))
            {
                cTemp.add(joins[i]);
            }
        }
        return cTemp;
    }
    public static boolean backwardsContains(String cClause, String c)
    {
        String bConclusion = cClause.split("=>")[1];
        if(bConclusion.equals(c))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
