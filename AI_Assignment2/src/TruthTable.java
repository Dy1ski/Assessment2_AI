import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TruthTable
{
    private String[] headTable;
    private int[][] bodyTable;

    private List<tellAskSentence> kb = new ArrayList<tellAskSentence>();
    private List<String> literals = new ArrayList<String>();
    private List<String> clauses = new ArrayList<String>();

    private Boolean Solution;

    //Dylan: constructor for knowledge base. sets initial variables
    public TruthTable (KnowledgeBase KB)
    {
        Solution = false;
        kb = KB.getSentences();

        headTable = constructHeader();
        bodyTable = constructBody();

        generateTable(0, bodyTable.length, new int[bodyTable.length]);

    }

    //Jonathan: method to check if entails with truth table sorting
    public void Entails()
    {
        for (int i = literals.size(); i < headTable.length; i++)
        {
            String clause = headTable[i];

            if (clause.contains ("&") && clause.contains("="))
            {
                for (int j = 0; j < bodyTable[0].length; j++)
                {
                    if (bodyTable[i][j] == 0 && bodyTable[i+1][j] == 0 && bodyTable[i+2] [j] == 0)
                    {
                        bodyTable[i][j] =  1;
                    }
                    else if (bodyTable[i][j] == 0 && bodyTable[i+1][j] == 0 && bodyTable[i+2] [j] == 1)
                    {
                        bodyTable[i][j] = 1;
                    }
                    else if (bodyTable[i][j] == 1 && bodyTable[i+1][j] == 0 && bodyTable[i+2] [j] == 0)
                    {
                        bodyTable[i][j] = 0;
                    }
                    else
                    {
                        bodyTable[i][j] = 1;
                    }
                }
            }
            else if (clause.contains ("=>"))
            {
                for (int j = 0; j < bodyTable.length; j++)
                {
                    if (bodyTable[i][j] == 0 && bodyTable[i+1][j] == 0)
                    {
                        bodyTable[i][j] = 1;
                    }
                    else if (bodyTable[i][j] == 0 && bodyTable[i+1][j] == 1)
                    {
                        bodyTable[i][j] = 1;
                    }
                    else if (bodyTable[i][j] == 1 && bodyTable[i+1][j] == 0)
                    {
                        bodyTable[i][j] = 0;
                    }
                    else
                    {
                        bodyTable[i][j] = 1;
                    }
                }
            }
            else
            {
                for (int j = 0; j < bodyTable.length; j++)
                {
                    if (bodyTable[i] [j] == 0)
                    {
                        bodyTable[i][j] = 0;
                    }
                    else
                    {
                        bodyTable[i][j] = 1;
                    }
                }
            }
        }
    }

    //Dylan: Method to produce a result as string
    public String solvable()
    {
        if (Solution)
        {
            return "YES";
        }
        else
        {
            return "NO";
        }
    }

    //Dylan: Method to extract clause
    private List<String> recievedClauses(List<tellAskSentence> toExtract)
    {
        List<String> result = new ArrayList<String> ();

        for(tellAskSentence s : toExtract)
        {
            if (!result.contains(s))
            {
                result.add(s.getSentence());
            }
        }
        return result;
    }

    //Dylan: To return number of models within the truth table
    public int TTModelCheck(tellAskSentence query)
    {
        int result = 0;
        for (int j = 0; j < bodyTable[0].length; j++)
        {
            Boolean model = true;

            for (int i = 0; i < bodyTable.length; i++)
            {
                if(bodyTable[i][j] == 0)
                {
                    model = false;
                }
            }
            if (model)
            {
                result++;
            }
        }

        if (result > 0)
        {
            Solution = true;
        }
        return result;
    }

    //Jonathan: builds head
    private String[] constructHeader()
    {
        List<String> resultClauses = recievedClauses(kb);
        clauses.addAll(resultClauses);
        List<String> resultList = new ArrayList<String> ();
        resultList.addAll(clauses);
        String[] result = resultList.toArray(new String[0]);
        return  result;
    }

    //Dylan: builds body
    private int[][] constructBody()
    {
        int width;
        int height;

        width = headTable.length;
        height = (int) Math.pow(2,headTable.length);

        int[][] result = new int[width][height];

        return result;
    }

    //Jonathan & Dylan produces table
    private void generateTable(int index, int size, int[] current)
    {
        int j = 0;
        if (index == size)
        {
            for (int i = 0; i < size; i++)
            {
                bodyTable[i][j] = current[i];
            }
            j++;
        }
        else
        {
            for (int i = 0; i < 2; i++)
            {
                current[index] = i;
                generateTable(index + 1, size, current);
            }
        }
    }

    //un-used
    public void printTable()
    {
        String headOutput = "|";
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter("out.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File does not exist");
            e.printStackTrace();
        }

        for (String s : headTable)
        {
            headOutput = headOutput + s + "|";
        }

        System.out.println(headOutput);
        for (int i = 0; i < bodyTable[0].length; i++)
        {
            String output = "|";

            for (int j = 0; j < bodyTable.length; j++)
            {
                if (bodyTable[j][i] == 0)
                {
                    output = output + "T|";
                }
                else
                {
                    output = output + "F|";
                }
            }
            writer.print(output);
            System.out.println(output);
        }
    }
}
	
