import java.io.Serializable;
import java.util.TreeSet; 
import java.util.Set;

/**
* 
**/
public interface ICatClientes extends Serializable 
{
  public void addCliente(Cliente c);
  
  public boolean containsCliente(String codigo);
  
  public Set<Cliente> getCatalogo();
  
  public int CatalogoSize();
}
