import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
public class main
{
    public static void main(String [] args) throws IOException
    {
        //Dylan: Take in the arguement
        if(args.length < 2)
        {

            System.out.println("run.bat <FileName> <Method>");
            System.out.println("*Please use the correct format*");

        }
        else
          {
              String result = "";
              readInTestFile r = new readInTestFile();
              String method = args[1];
              String[] fileContent = r.readProblem(args[0]);
              List<tellAskSentence> recievedKB = r.getKB(fileContent[1]);
              tellAskSentence receivedQuery = r.receivedQuery(fileContent[3]);
              KnowledgeBase KB = new KnowledgeBase();
              KB.tellComplete(receivedKB);
              KB.tell(receivedQuery);
            // getting info on information

              FileInputStream in = new FileInputStream(args[0]);
              // like tutorial
              BufferedReader buff = new BufferedReader(new InputStreamReader(in));
              // getting info out on screen
// do a switch statement*************************************************
              buff.readLine();
              String tell = buff.readLine();
              buff.readLine();
              String ask = buff.readLine();
              if(method.equals("BC"))
              {
                  bChaining backwardChain = new bChaining(ask, tell);
                  System.out.println(backwardChain.Execution());
              }
              if(method.equals("FC"))
              {
                  fChaining forwardChain = new fChaining(ask, tell);
                  System.out.print(forwardChain.execution());

              }
          }


    }
}
