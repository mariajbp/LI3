import java.util.Comparator;

/**
* Classe MaisCompradosComparator que impõem uma ordem quando 
**/
public class MaioresCompradoresComparator implements Comparator<Filial>
{
    public int compare(Filial f1, Filial f2)
    {
        double p1 = 0;//f1.getPrice();
        double p2 = 0;//f2.getPrice();
        
        if(p1 >= p2) return -1;
        return 1;
    }
}
