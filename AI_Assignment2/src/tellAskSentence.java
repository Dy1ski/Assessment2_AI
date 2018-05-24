import java.util.ArrayList;
import java.util.List;

public class tellAskSentence
{
    private String sentence;
    private List<String> literals = new ArrayList<String>();
    private List<String> propositionals = new ArrayList<String>();

    //Jonathan: Constructer to initialise literals and propositionals strings.

    public tellAskSentence (String s)
    {
        sentence = s;
        //Jonathan: call readInTestFile class to read txt file and populate appropriate strings to be used for algorithms.
        readInTestFile p = new readInTestFile ();

        //Jonathan: add all literals from sentence string
        literals.addAll(p.getLiterals (sentence));

        //Jonathan: add all propositionals from sentence string
        propositionals.addAll(p.getProps(sentence));
    }

    //Jonathan: returns sentence to be used in other classes
    public String getSentence()
    {
        return sentence;
    }

//Jonathan: un-used
//    public Boolean isClause()
//    {
//        if (propositionals.size() > 0)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }

    //Dylan: literal getter
    public List<String> getLiteral()
    {
        return literals;
    }

    //Dylan: propositional getter
    public List<String> getProp()
    {
        return propositionals;
    }

    //Dylan: literal getter with index
    public String getLiteral(int index)
    {
        return literals.get(index);
    }

    //Dylan: prop getter with index
    public String getProp( int index)
    {
        return propositionals.get(index);
    }

    //Jonathan: getter for all variables.
    public List<String> getAll()
    {
        List<String> temp = new ArrayList<String> ();
        temp.addAll(literals);
        temp.addAll(propositionals);

        return temp;
    }

    //Jonathan: a method to check if the string contains any propositionals
    public Boolean containsProp (String s)
    {
        for (String prop : propositionals)
        {
            if (prop == s)
                return true;
        }
        return false;
    }

}

