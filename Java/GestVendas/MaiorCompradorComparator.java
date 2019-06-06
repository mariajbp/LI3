import java.util.Comparator;

/**
* Classe  que impõem uma ordem quando se quer adicionar um cliente a uma coleção
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

