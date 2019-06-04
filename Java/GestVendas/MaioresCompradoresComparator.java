import java.util.Comparator;

/**
* Classe MaisCompradosComparator que impõem uma ordem ao número de vezes que os clientes efetuaram compras
**/


public class MaioresCompradoresComparator implements Comparator<RegistoCliente> 
{   
    public int compare(RegistoCliente r1, RegistoCliente r2)


    {
       int v1 = r1.getVezes();
       int v2 = r2.getVezes();
       
       if(v1 >= v2) return -1;
       return 1;
    }
} 
