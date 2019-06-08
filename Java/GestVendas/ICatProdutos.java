import java.io.Serializable;
import java.util.TreeSet; 
import java.util.Set;

/**
* 
**/
public interface ICatProdutos extends Serializable
{
    public void addProduto(Produto p);
    public boolean containsProduto(String codigo);
    public Set<Produto> getCatalogo();
    public int CatalogoSize();
}
