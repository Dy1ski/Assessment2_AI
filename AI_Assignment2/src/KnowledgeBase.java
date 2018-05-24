import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase
{
    private List<tellAskSentence> sentences;

    //Dylan:: constructor to initialise new sentence for knowledge base
    public KnowledgeBase ()
    {
        sentences = new ArrayList<tellAskSentence> ();
    }

    //Dylan: re-evaluate knowledge base sentence
    public tellAskSentence updatedSentence()
    {
        String temp = "";

        for (tellAskSentence s : sentences)
        {
            temp = temp + s.getSentence();
            if (s != sentences.get(sentences.size()))
            {
                temp = temp + ';';
            }
        }

        return new tellAskSentence(temp);
    }


    //Dylan: getter for returning the updated KB sentence for queries
    public List<tellAskSentence> getSentences()
    {
        return sentences;
    }

    //Dylan: adding the tell part into the sentence for knowledge base
    public void tell(tellAskSentence sentence)
    {
        sentences.add(sentence);
    }

    public void tellComplete(List<tellAskSentence> s)
    {
        sentences.addAll(s);
    }

    //Dylan: returns size of sentence.
    public int size()
    {
        return sentences.size();
    }
}