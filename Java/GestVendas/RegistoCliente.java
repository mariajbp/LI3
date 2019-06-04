import java.io.Serializable;
import java.util.TreeSet; 

/**
* Classe RegistoCliente que contém estruturas com dados de 
**/

public class RegistoCliente implements Serializable
{
    /** Número de compras efetuadas, por mês **/
    private int vezes;
    
    /** Par de produtos e dinheiro gasto no mesmo, por mês **/
    private TreeSet<Pair<Produto, Integer>> prod;
    
    /** Número de unidades compradas, nesse mês **/
    int unidades;
    
    /** Total gasto pelo cliente nesse mês**/
    double totalGasto;
    
    /** 
    * Construtor vazio que cria uma instância Faturacao
    **/
    public RegistoCliente() 
    {
        this.vezes = 0;
        this.prod = new TreeSet<>();
        this.unidades = 0;
        this.totalGasto = 0.0;
    }
    
    public RegistoCliente(int vezes, TreeSet<Pair<Produto,Integer>> prod, int unidades, double total)
    {
        this.vezes = vezes;
        this.prod = prod;
        this.unidades = unidades;
        this.totalGasto = total;
    }
    
    public RegistoCliente(RegistoCliente rc)
    {
        this.vezes = rc.getVezes();
        this.prod = rc.getProd();
        this.unidades = rc.getUnidades();
        this.totalGasto = rc.getTotal();
    }
    
    /**
    * Método que devolve 
    * @return 
    **/
    public int getVezes(){ return this.vezes;}
    
    /**
    * Método que devolve 
    * @return 
    **/
    public TreeSet<Pair<Produto,Integer>> getProd() {return new TreeSet<>(this.prod);}
    
    /**
    * Método que devolve 
    * @return 
    **/
    public int getUnidades(){ return this.unidades;}
    
    /**
    * Método que devolve 
    * @return 
    **/
    public double getTotal(){ return this.totalGasto;}
    
    /**
    * Método que defgine
    * @return 
    **/
    public void setVezes(int v){this.vezes = v;}
    
    /**
    * Método que defgine
    * @return 
    **/
    public TreeSet<Pair<Produto,Integer>> setProd(){return new TreeSet<>(this.prod);}
    
    /**
    * Método que defgine
    * @return 
    **/
    public void setUnidades(int u){this.unidades = u;}
    
    /**
    * Método que defgine
    * @return 
    **/
    public void setTotal(int t){this.totalGasto = t;}
    
    /** 
    * Método que cria uma cópia de uma identificação de um RegistoCliente
    **/
    public RegistoCliente clone(){return new RegistoCliente(this);}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      RegistoCliente rc = (RegistoCliente) o;     
      return this.vezes == rc.getVezes() && this.prod.equals(rc.getProd()) && 
             this.unidades == rc.getUnidades() && this.totalGasto == rc.getTotal() ;
    }
    
    /**
    * Método que converte uma identificação numa string 
    **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Número de compras:").append(vezes).append("\n");
       sb.append("Número de unidades compradas:").append(unidades).append("\n");
       sb.append("Total gasto:").append(totalGasto).append("\n");
       sb.append("Produtos:").append(prod).append("\n");
       return sb.toString();
    }
    
    /**
    * Método que 
    * @param
    **/
    public void updateVezes(int v)
    {
        this.vezes += v;
    }
    
    /**
    * Método que 
    * @param
    **/
    public void updateUnidades(int u)
    {
        this.unidades += u;
    }
    
    /**
    * Método que 
    * @param
    **/
    public void updateTotalgASTO(int TG)
    {
        this.totalGasto += TG;
    }
    
    
}
