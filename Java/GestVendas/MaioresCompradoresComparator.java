import java.util.Comparator;

/**
* Classe MaisCompradosComparator que impõem uma ordem ao número de vezes que os clientes efetuaram compras
**/
<<<<<<< HEAD
/*
public class MaioresCompradoresComparator implements Comparator<RegistoClientes>, Serilizable
{
    public int compare(RegistoClientes r1, RegistoClientes r2)
=======

public class MaioresCompradoresComparator implements Comparator<RegistoCliente> 
{   
    public int compare(RegistoCliente r1, RegistoCliente r2)

>>>>>>> f6643919c71d76a475b25b4a97bd698ffa021e24
    {
       int v1 = r1.getVezes();
       int v2 = r2.getVezes();
       
       if(v1 >= v2) return -1;
       return 1;
    }
} 
<<<<<<< HEAD
*/
=======
>>>>>>> f6643919c71d76a475b25b4a97bd698ffa021e24
