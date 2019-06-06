import java.util.Comparator;

/**
* 
**/
public class MaisCompradosComparator implements Comparator<Pair<Produto,Integer>>
{
   public int compare(Pair<Produto,Integer> p1, Pair<Produto,Integer> p2)
   {
        double x1 = p1.getSnd();
        double x2 =  p2.getSnd();
        
        if(x1 >= x2) return -1;
        return 1;
   } 
}

