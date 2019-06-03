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
   **/
   public double getFtrTotal();
   
   /**
   * Método que devolve a fatuação total mnsal
   **/
   public double[] getFtrMensal();
   
   /**
   * Método que devolve a faturação total de um determinado produto por mes
   **/
   public Map<Produto, List<Double>> getProdPrecoMes1();
   
   /**
   * Método que devolve a faturação total de um determinado produto por mes
   **/
   public Map<Produto, List<Double>> getProdPrecoMes2();
   
   /**
   * Método que devolve a faturação total de um determinado produto por mes
   **/
   public Map<Produto, List<Double>> getProdPrecoMes3(); 
    
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   **/ 
   public void setProdPrecoMes1(Map<Produto, List<Double>> prd);
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   **/ 
   public void setProdPrecoMes2(Map<Produto, List<Double>> prd);
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   **/ 
   public void setProdPrecoMes3(Map<Produto, List<Double>> prd);
   
   /**
   * Método que devolve o número total de unidades vendidas de um determinado produto por mes
   **/
   public Map<Produto, List<Integer>> getProdUnidadeMes();
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   **/ 
   public void setProdUnidadeMes(Map<Produto, List<Integer>> prd);
   
   /**
   * Método que calcula a faturação anual de determinado produto
   **/
   public double ftrAnualProd(Produto p) throws NoProdutosException;
   
   /**
   * Método que atualiza o preço de um produto por mês
   **/
    public void updateProdPrecoMes(Produto p, double preco, int mes, int filial);
   
   /**
   * Método que atualiza o número de unidades de um produto por mês  
   **/
   public void updateProdUnidadeMes(Produto p, int unidades, int mes);
   
   /**
   * Método que divide as carateristicas de uma venda pelos Maps da classe
   **/
    public void addVenda(Venda v);
    
   public Map<Produto, Integer>  prodsVendidosAnual(); 
}