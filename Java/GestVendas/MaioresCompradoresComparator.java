import java.util.Comparator;
import java.io.Serializable;

/**
* Classe MaisCompradosComparator que impõem uma ordem ao número de vezes que os clientes efetuaram compras
**/
public class MaioresCompradoresComparator implements Comparator<RegistoClientes>, Serilizable;
{
    public int compare(RegistoClientes r1, RegistoClientes r2)
    {
       int v1 = r1.getVezes();
       int v2 = r2.getVezes();
       
       if(v1 >= v2) return -1;
       return 1;
    }
} 
