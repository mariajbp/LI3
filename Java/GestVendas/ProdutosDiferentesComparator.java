import java.util.Comparator;
/**
* 
**/
public class ProdutosDiferentesComparator implements Comparator<Pair<Cliente,Integer>>
{
   public int compare(Pair<Cliente,Integer> p1, Pair<Cliente,Integer> p2)
   {
        double x1 = p1.getSnd();
        double x2 =  p2.getSnd();
        
        if(x1 >= x2) return -1;
        return 1;
   }
}
