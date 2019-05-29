import java.io.Serializable;
import java.util.TreeSet; 
import java.util.Set;

/**
* 
**/
public interface ICatProdutos extends Serializable
{
    public Set<Produto> getCatalogo();
    
    public void setCatalogo(Set<Produto> pp);
     
}
