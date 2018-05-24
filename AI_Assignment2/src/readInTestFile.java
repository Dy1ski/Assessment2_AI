import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

//Jonathan: created a parser class to read in test file and organize accordingly...
// found help via

public class readInTestFile
{
    public readInTestFile ()
    {
    }

    //Jonathan: Method to read test file via buffer reader and put it to string for further processing.
    public String[] readProblemFile(String fileName)
    {

        try
        {
            FileReader reader = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(reader);
            String[] result = new String[4];
            int i = 0;
            while (i < 4)
            {
                result[i] = buffer.readLine();
                i++;
            }

            buffer.close();
            return result;
        }
        catch(FileNotFoundException ex) //Jonathan: catch if file not found
        {
            System.out.println("Error: File not found.");
            System.exit(1);
        }
        catch(IOException ex) //Jonathan: catch if error in reading file
        {
            System.out.println("Error in reading file.");
            System.exit(1);
        }

        return null;
    }

    //Jonathan: Method to remove white spaces when reading in
    public String removeWhiteSpace(String input)
    {
        String[] resultArray = input.split(" ");
        String result = "";

        for (int i = 0; i < resultArray.length; i++)
        {
            result = result + resultArray [i];
        }

        return result;
    }

    //Jonathan: method to extract knowledge base as sentence.
    public List<tellAskSentence> extractKB(String input)
    {
        List<tellAskSentence> extractedKB = new ArrayList<tellAskSentence>();
        String[] tell = input.split(";");
        for (String s : tell)
        {
            extractedKB.add(new tellAskSentence(s));
        }
        return extractedKB;
    }

    //Jonathan: Method to get propositional symbols
    public List<String> getProps(String s)
    {
        List<String> props = new ArrayList<String> ();

        if (s.contains ("&"))
        {
            props.add ("&");
        }
        if (s.contains ("=>"))
        {
            props.add ("=>");
        }
        return props;
    }

    //Jonathan: method to get literals
    public List<String> getLiterals(String s)
    {
        List<String> literals = new ArrayList<String> ();

        String [] toAdd = s.split("[\\&\\=\\>]");

        int c = 0;
        while (c < toAdd.length)
        {
            literals.add(toAdd[c]);
            c ++;
        }

        literals.removeAll(Arrays.asList("", null));
        literals.removeAll(Arrays.asList("", " "));

        return literals;
    }

    //method to extract query from concacted string input.
    public tellAskSentence extractQuery(String input)
    {
        return new tellAskSentence(input);
    }
}