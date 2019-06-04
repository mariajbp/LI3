import java.util.Comparator;

/**
* Classe ProdutosMaisCompradosComparator que impõem uma ordem aos registos de produtos através da quantidade comprada
**/
public class ProdutosMaisCompradosComparator  implements Comparator<RegistoProduto>
{
    public int compare(RegistoProduto r1, RegistoProduto r2)
    {
       int q1 = r1.quantos();
       int q2 = r2.quantos();
       
       if(q1 >= q2) return -1;
       return 1;
    }
}
