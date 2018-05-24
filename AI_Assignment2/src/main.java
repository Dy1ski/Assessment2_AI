import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
public class main
{
    public static void main(String [] args) throws IOException
    {
        //Dylan: Take in the two argument
        if(args.length < 2)
        {

            System.out.println("run.bat <FileName> <Method>");
            System.out.println("*Please use the correct format*");

        }
        else {
            //Jonathan: initialise all classes and start to process text files
            String result = "";
            readInTestFile r = new readInTestFile();
            String method = args[1];
            String[] fileContent = r.readProblem(args[0]);
            List<tellAskSentence> receivedKB = r.getKB(fileContent[1]);
            tellAskSentence receivedQuery = r.receivedQuery(fileContent[3]);
            KnowledgeBase KB = new KnowledgeBase();
            KB.tellComplete(receivedKB);
            KB.tell(receivedQuery);
            // Dylan: getting info on information

            FileInputStream in = new FileInputStream(args[0]);
            // Dylan: like tutorial
            BufferedReader buff = new BufferedReader(new InputStreamReader(in));
            // Dylan: getting info out on screen
            // do a switch statement possibly.

            buff.readLine();
            String tell = buff.readLine();
            buff.readLine();
            String ask = buff.readLine();

            //Dylan: Backward Chaining implementation
            if (method.equals("BC")) {
                bChaining backwardChain = new bChaining(ask, tell);
                System.out.println(backwardChain.Execution());
            }

            //Jonathan: Forward Chaining implementation
            if (method.equals("FC")) {
                fChaining forwardChain = new fChaining(ask, tell);
                System.out.print(forwardChain.execution());

            }
            //Dylan: Truth Table Checking implementation
            if (method.equals("TT"))
            {
                TruthTable TT = new TruthTable(KB);
                TT.Entails();
                int modelCount = TT.TTModelCheck(receivedQuery);
                result = (TT.solvable() + (": " + modelCount));
            }

            System.out.println(result);
        }


    }
}