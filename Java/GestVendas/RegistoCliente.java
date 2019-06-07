import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator; 
import java.util.Set;
import java.util.TreeSet;

/**
* Classe RegistoCliente que contém estruturas com dados de de um registo
**/

public class RegistoCliente implements Serializable
{
    /** Número de compras efetuadas, por mês **/
    private int vezes;
    
    /** Map de produtos e pares de unidades compradas e dinheiro gasto no mesmo, por mês **/
    private Map<Produto, Pair<Integer,Double>> prod;
    
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
        this.prod = new HashMap<>();
        this.unidades = 0;
        this.totalGasto = 0.0;
    }
    
    /** 
    * Construtor que cria um novo RegistoCliente a partir dos parâmetros dados 
    **/
    public RegistoCliente(int vezes, HashMap<Produto, Pair<Integer,Double>> prod, int unidades, double total)
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
    public Map<Produto, Pair<Integer,Double>> getProd() {return new HashMap<>(this.prod);}
    
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
    public void setProd(Map<Produto, Pair<Integer,Double>> t){this.prod = t;}
    
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
      if(o == null || this.getClass() != o.getClass()) return false;
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
       Pair<Integer,Double> pair = new Pair<>();
       Pair<Integer,Double> newPair = new Pair<>();
       
       if(!this.prod.containsKey(prd))
       {
           newPair.setFst(uni);
           newPair.setSnd(g);
        }
       else
       {
           pair = this.prod.get(prd);
           int uniOld = pair.getFst();
           double gOld = pair.getSnd();
           
           newPair.setFst(uni+uniOld);
           newPair.setSnd(g+gOld);
        }
       this.prod.put(prd, newPair);
    }
    
    /**
    * ?????????
    **/
    public int produtosDistintos()
    {
        int size;
        return size = this.prod.size();
    }
    
    /**
    * ?????????
    **/
    public void ProdutosDistintos(Set<Produto> s)
    {
        Iterator it = this.prod.keySet().iterator();
        while(it.hasNext())
        {
            Produto p = (Produto)it.next();
            s.add(p);
        }
    }
    /*
    //Devolve um set ordenado com os 5 produtos mais comprados e as suas unidades
    public Set<Produto> ProdutosMaisComprados()
    {
        Set<Pair<Produto, Integer>> s = new TreeSet<>(new ProdutoMaisCompradoComparator());
        
        for(Map.Entry<Produto, Pair<Integer, Double>> e : prod.entrySet())
        {
            Pair<Integer, Double> p = e.get(e.getKey());
            
            Pair<Produto, Integer> pair = new Pair(e.getKey(), p.getFst());
            s.add(pair);
        }   
        
        Set<Pair<Produto, Integer>> top5 = new TreeSet<>();
        int i = 0;
        Iterator it = new s.iterator();
        while(it.hasNext() && i < 5)
        {
            p = it.next();
            top5.add(p);
            i++;
        }
        return top5;
    }
    
    
    //Preenche um set com os 5 produtos mais comprados e unidades
    public void AddProdutosMaisComprados(Set<Pair<Produto, Integer>> s )
    {   
        for(Map.Entry<Produto, Pair<Integer, Double>> e : prod.entrySet())
        {
            Pair<Integer, Double> p = e.get(e.getKey());
            
            Pair<Produto, Integer> pair = new Pair(e.getKey(), p.getFst());
            s.add(pair);
        }   
        
        Set<Pair<Produto, Integer>> top5 = new TreeSet<>();
        int i = 0;
        Iterator it = new s.iterator();
        while(it.hasNext() && i < 5)
        {
            p = it.next();
            top5.add(p);
            i++;
        }
    }*/
}
