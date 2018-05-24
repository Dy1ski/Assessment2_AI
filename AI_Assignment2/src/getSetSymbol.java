public class getSetSymbol
{
    private Boolean bolValue; // our string
    private String pString;

    //Dylan: constructor that initialises values
    public getSetSymbol(String b)
    {
        pString = b;
        bolValue = false;
    }

    // set our value
    public void sValue(Boolean a)
    {
        bolValue = a;
    }
    public Boolean gValue()
    {
        return bolValue;
    }
    public String gSymbol()
    {
        return pString;
    }
}