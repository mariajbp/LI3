import java.util.Comparator;

/**
* Classe MaisCompradosComparator que impõem uma ordem quando se quer adicionar um veículo a uma coleção
**/
public class MaisCompradosComparator implements Comparator<Filial>
{
    public int compare(Filial f1, Filial f2)
    {
        double p1 = v1.getPrice();
        double p2 = v2.getPrice();
        
        if(p1 >= p2) return -1;
        return 1;
    }
}
