import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
* 
**/
public class Faturacao implements Serializable, IFaturacao
{
    private double ftrTotal;
    private double[] ftrMensal;
    private Map<Cliente, List<Integer>> clMes;
    private Map<Produto, List<Integer>> prodMes;
    
    /** 
    * Construtor vazio que cria uma instância Faturacao
    **/
    public Faturacao()
    {
        this.ftrTotal = 0.0;
        this. ftrMensal = new double[12];
        this.clMes = new HashMap<>();
        this.prodMes = new HashMap<>();
    }
    
    /** 
    * Construtor de cópia que cria uma nova instância Faturacao a partir de uma Faturacao passado como parâmetro 
    **/
    public Faturacao(double ftr, double[] ftrmes, HashMap<Cliente, List<Integer>> cl, HashMap<Produto, List<Integer>> prod)
    {
        this.ftrTotal = ftr;
        this.ftrMensal = ftrmes;
        this.clMes = cl;
        this.prodMes = prod;
    }
    
    /** 
    * Construtor que cria uma nova instância Faturacao a partir de uma Faturacao passado como parâmetro 
    **/
    public Faturacao(Faturacao f) 
    {
       this.ftrTotal = f.getFtrTotal();
       this.ftrMensal = f.getFtrMensal();
       this.clMes = f.getClMes();
       this.prodMes = f.getProdMes();
    }
    
    /**
    * Método que devolve a fatuação total global
    * @return Fatuação total global
    **/
    public double getFtrTotal(){ return this.ftrTotal;}
    
    /**
    * Método que devolve a fatuação total mnsal
    * @return Fatuação total mensal
    **/
    public double[] getFtrMensal(){ return this.ftrMensal;}
    
    /**
    * Método que devolve o total gasto por um cliente por mês
    * @returns   HashMap dos clientes e o seu total gasto por um cliente por mês
    **/
    public Map<Cliente, List<Integer>> getClMes()
    {
       return new HashMap<Cliente, List<Integer>>(this.clMes);
    }
    
    /**
    * Método que devolve o preço total de todos os items de um determinado produto por mes
    * @returns   HashMap do preço total de todos os items de um determinado produto por mes
    **/
    public Map<Produto, List<Integer>> getProdMes()
    {
       return new HashMap<Produto, List<Integer>>(this.prodMes);
    }
    
    
    
    /**
    * Método que define um hashMap a partir de um hashMap passado como parâmetro
    * * @param    HashMap do valor total gasto por um cliente por mês
    **/ 
    public void setClMes(Map<Cliente, List<Integer>> cl)
    {
       this.clMes.clear();
       this.clMes = new HashMap<Cliente, List<Integer>>(cl);
    }
    
    /**
    * Método que define um hashMap a partir de um hashMap passado como parâmetro
    * * @param    HashMap do valor total gasto por um cliente por mês
    **/ 
    public void setProdMes(Map<Produto, List<Integer>> prd)
    {
       this.prodMes.clear();
       this.prodMes = new HashMap<Produto, List<Integer>>(prd);
    }
    
    /** 
    * Método que cria uma cópia de uma identificação de uma Faturação
    **/
    public Faturacao clone(){return new Faturacao(this);}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      Faturacao f  = (Faturacao) o;     
      return this.ftrTotal == f.getFtrTotal() && this.ftrMensal.equals(f.getProdMes()) &&
             this.clMes.equals(f.getClMes()) && this.prodMes.equals(f.getProdMes());
    }
    
    /**
    * Método que converte uma identificação numa string
    * @return  
    **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Total global faturado:").append(ftrTotal).append("\n");
       return sb.toString();
    }
    
    /**
    * Método que 
    **/
    public void addVenda(Venda v)
    {} 
}
