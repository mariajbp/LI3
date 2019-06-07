import java.util.Comparator;
/**
* Classe DecrescenteComparatorCliente que impõem uma ordem decrescente a um par de produtos e inteiros
**/
public class DecrescenteComparatorProduto implements Comparator<Pair<Produto,Integer>>
{
   public int compare(Pair<Produto,Integer> p1, Pair<Produto,Integer> p2)
   {
        double x1 = p1.getSnd();
        double x2 =  p2.getSnd();
        
        if(x2 <= x1) return -1;
        return 1;
   }
}
