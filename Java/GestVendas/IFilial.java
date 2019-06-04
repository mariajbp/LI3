import java.io.Serializable;
import java.util.Set;

/**
* 
**/
public interface IFilial extends Serializable
{
    public void getClientesDistintos(Set<Cliente> c);
    public void addVenda(Venda v);
}
