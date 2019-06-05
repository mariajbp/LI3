import java.io.Serializable;
import java.util.TreeSet;
import java.util.Iterator; 

/**
* Classe RegistoCliente que contém estruturas com dados de de um registo
**/

public class RegistoCliente implements Serializable
{
    /** Número de compras efetuadas, por mês **/
    private int vezes;
    
    /** Par de produtos com informação de unidades compradas e dinheiro gasto no mesmo, por mês **/
    private TreeSet<Pair<Produto, Pair<Integer,Double>>> prod;
    
    /** Número de unidades compradas, nesse mês **/
    int unidades;
    
    /** Total gasto pelo cliente nesse mês **/
    double totalGasto;
    
    /** 
    * Construtor vazio que cria uma instância CatalogoCliente
    **/
    public RegistoCliente() 
    {
        this.vezes = 0;
        this.prod = new TreeSet<>();
        this.unidades = 0;
        this.totalGasto = 0.0;
    }
    
    /** 
    * Construtor que cria um novo RegistoCliente a partir dos parâmetros dados 
    **/
    public RegistoCliente(int vezes, TreeSet<Pair<Produto, Pair<Integer,Double>>> prod, int unidades, double total)
    {
        this.vezes = vezes;
        this.prod = prod;
        this.unidades = unidades;
        this.totalGasto = total;
    }
    
    /** 
    * Construtor de cópia que cria uma nova instância CatalogoCliente a partir de uma CatalogoCliente passado como parâmetro 
    **/
    public RegistoCliente(RegistoCliente rc)
    {
        this.vezes = rc.getVezes();
        this.prod = rc.getProd();
        this.unidades = rc.getUnidades();
        this.totalGasto = rc.getTotal();
    }
    
    /**
    * Método que devolve o número de compras efetuadas por mês
    * @return   Número de compras efetuadas por mês
    **/
    public int getVezes(){ return this.vezes;}
    
    /**
    * Método que devolve pares de produtos e dinheiro gasto no mesmo, por mês
    * @return   Pares de produtos e dinheiro gasto no mesmo, por mês
    **/
    public TreeSet<Pair<Produto, Pair<Integer,Double>>> getProd() {return new TreeSet<>(this.prod);}
    
    /**
    * Método que devolve o número de unidades compradas, nesse mês
    * @return   Número de unidades compradas, nesse mês
    **/
    public int getUnidades(){ return this.unidades;}
    
    /**
    * Método que devolve o total gasto pelo cliente nesse mês
    * @return    Total gasto pelo cliente nesse mês
    **/
    public double getTotal(){ return this.totalGasto;}
    
    /**
    * Método que define  o número de compras efetuadas por mês
    * @param   Número de compras efetuadas por mês  
    **/
    public void setVezes(int v){this.vezes = v;}
    
    /**
    * Método que define pares de produtos e dinheiro gasto no mesmo, por mês
    * @param Pares de produtos e dinheiro gasto no mesmo, por mês
    **/
    public void setProd(TreeSet<Pair<Produto, Pair<Integer,Double>> > t){this.prod = t;}
    
    /**
    * Método que define o número de unidades compradas, nesse mês
    * @param   Número de unidades compradas, nesse mês
    **/
    public void setUnidades(int u){this.unidades = u;}
    
    /**
    * Método que define o total gasto pelo cliente nesse mês
    * @return   Total gasto pelo cliente nesse mês
    **/
    public void setTotal(double t){this.totalGasto = t;}
    
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
    /*
    public int getUnidades(Produto p)
    {
        
    }
    */
    /**
    * Método que atualiza o número de compras efetuadas por mês
    * @param   Novo número de compras efetuadas
    **/
    public void updateVezes()
    {
        this.vezes++;
    }
    
    /**
    * Método que atualiza o número de unidades compradas nesse mês
    * @param    Novo número de unidades compradas, nesse mês
    **/
    public void updateUnidades(int u)
    {
        this.unidades += u;
    }
    
    /**
    * Método que atualiza o total gasto nesse mês
    * @param    Novo total gasto nesse mês
    **/
    public void updateTotalGasto(double tg)
    {
        this.totalGasto += tg;
    }
    
    /** 
    * Método que dado um par Produto/Gasto compradas verifica se o Produto já existe e faz o seu Registo atualizando o valor total gasto nesse produto.
    * @param Par<Cliente, Integer>
    **/
   public void updateRegCliente(Produto prd, double g, int uni)
   {
       Pair<Produto,  Pair<Integer,Double>> pair = new Pair<>();
       Iterator it = this.prod.iterator();
       while(it.hasNext()){
           pair = (Pair) it.next();
           if(pair.getFst().equals(prd)){
               Pair<Produto,  Pair<Integer,Double>> newPair = new Pair<>();
               int uniOld = (int) pair.getSnd().getFst();
               double gOld = (double) pair.getSnd().getSnd();
               
               Pair<Integer,Double> newPair2 = new Pair<>();
               newPair2.setFst(uni + uniOld);
               newPair2.setSnd(g + gOld);
               
               this.prod.remove(pair);
               newPair.setFst(prd);
               newPair.setSnd(newPair2);
               
               this.prod.add(newPair);
               break;
            }
        }
    }
    
    
}
