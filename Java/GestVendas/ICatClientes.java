import java.io.Serializable;
import java.util.TreeSet; 
import java.util.Set;

/**
* 
**/
public interface ICatClientes extends Serializable 
{
  /**
  * Método que devolve o catalogo de Clientes
  * @return Catalogo de produtos válidos
  **/
  public Set<Cliente> getCatalogo();
  
  /**
  * Método que define o catalogo de Clientes
  * @param Catalogo de clientes válidos
  **/
   public void setCatalogo(Set<Cliente> cl);
  
  
}
