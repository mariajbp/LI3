import java.io.Serializable;
import java.util.Map;
import java.util.List;

/**
* 
**/
public interface IFaturacao extends Serializable
{
   /**
   * Método que devolve a fatuação total global
   * @return Fatuação total global
   **/
   public double getFtrTotal();
    
   /**
   * Método que devolve a fatuação total mnsal
   * @return Fatuação total mensal
   **/
   public double[] getFtrMensal();
   
   /**
   * Método que devolve o total gasto por um cliente por mês
   * @returns   HashMap dos clientes e o seu total gasto por um cliente por mês
   **/
    public Map<Cliente, List<Integer>> getClMes();
    
   /**
   * Método que devolve o preço total de todos os items de um determinado produto por mes
   * @returns   HashMap do preço total de todos os items de um determinado produto por mes
   **/
   public Map<Produto, List<Integer>> getProdMes();
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   * * @param    HashMap do valor total gasto por um cliente por mês
   **/ 
   public void setClMes(Map<Cliente, List<Integer>> cl);
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   * * @param    HashMap do valor total gasto por um cliente por mês
   **/ 
   public void setProdMes(Map<Produto, List<Integer>> prd);
   
   public void addVenda(Venda v);
}
