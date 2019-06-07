import java.util.Comparator;

/**
* Classe MaiorCompradorComparator que ordena clientes através do número de unidades compradas
**/
public class MaiorCompradorComparator implements Comparator<Pair<Cliente, Double>>
{
    public int compare(Pair<Cliente, Double> c1, Pair<Cliente, Double> c2)
    {
        double x1 = c1.getSnd();
        double x2 =  c2.getSnd();
        
        if(x1 >= x2) return -1;
        return 1;
    }
   
}

