import java.util.HashMap;
import java.util.Map;

public class construction
{
   private Map<getSetSymbol,Boolean> assign = new HashMap<getSetSymbol, Boolean>();

   public boolean gValue (getSetSymbol getSetSymbol) throws Exception {
       if(assign.containsKey(getSetSymbol))
       {
           return assign.get(getSetSymbol);
       }
       else
       {
           throw new Exception("Symbol not found");
       }

   }
   public void removeSymbol(getSetSymbol getSetSymbol)
   {
       assign.remove(getSetSymbol);
   }
   public void addSymbol(getSetSymbol getSetSymbol)
   {
       assign.put(getSetSymbol, getSetSymbol.gValue());
   }
}
