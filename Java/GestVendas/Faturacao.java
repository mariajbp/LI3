import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
* 
**/
public class Faturacao implements Serializable, IFaturacao   
{ 
    private double ftrTotal;
    private double[] ftrMensal;
    private Map<Produto, List<Double>> prodPrecoMes1;
    private Map<Produto, List<Double>> prodPrecoMes2;
    private Map<Produto, List<Double>> prodPrecoMes3;
    private Map<Produto, List<Integer>> prodUnidadeMes;
    
    /** 
    * Construtor vazio que cria uma instância Faturacao
    **/
    public Faturacao()
    {
        this.ftrTotal = 0.0;
        this. ftrMensal = new double[12];
        this.prodPrecoMes1 = new HashMap<Produto, List<Double>>(); 
        this.prodPrecoMes2 = new HashMap<Produto, List<Double>>();
        this.prodPrecoMes3 = new HashMap<Produto, List<Double>>(); 
        this.prodUnidadeMes = new HashMap<Produto, List<Integer>>();
    }
    
    /** 
    * Construtor de cópia que cria uma nova instância Faturacao a partir de uma Faturacao passado como parâmetro 
    **/
    public Faturacao(double ftr, double[] ftrmes, HashMap<Produto, List<Double>> prod1, HashMap<Produto, List<Double>> prod2,
                     HashMap<Produto, List<Double>> prod3, Map<Produto, List<Integer>> unit)
    {
        this.ftrTotal = ftr;
        this.ftrMensal = ftrmes;
        this.prodPrecoMes1 = prod1;
        this.prodPrecoMes2 = prod2;
        this.prodPrecoMes3 = prod3;
        this.prodUnidadeMes = unit;
    }
    
    /** 
    * Construtor que cria uma nova instância Faturacao a partir de uma Faturacao passado como parâmetro 
    **/
    public Faturacao(Faturacao f) 
    {
       this.ftrTotal = f.getFtrTotal();
       this.ftrMensal = f.getFtrMensal();
       this.prodPrecoMes1 = f.getProdPrecoMes1();
       this.prodPrecoMes2 = f.getProdPrecoMes2();
       this.prodPrecoMes3 = f.getProdPrecoMes3();
       this.prodUnidadeMes = f.getProdUnidadeMes();
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
    * Método que devolve a faturação total de um determinado produto por mes
    * @returns   HashMap da faturação total de um determinado produto por mes
    **/
    public Map<Produto, List<Double>> getProdPrecoMes1() 
    {
       return new HashMap<Produto, List<Double>>(this.prodPrecoMes1);
    }
    
    /**
    * Método que devolve a faturação total de um determinado produto por mes
    * @returns   HashMap da faturação total de um determinado produto por mes
    **/
    public Map<Produto, List<Double>> getProdPrecoMes2() 
    {
       return new HashMap<Produto, List<Double>>(this.prodPrecoMes2);
    }
    
    /**
    * Método que devolve a faturação total de um determinado produto por mes
    * @returns   HashMap da faturação total de um determinado produto por mes
    **/
    public Map<Produto, List<Double>> getProdPrecoMes3() 
    {
       return new HashMap<Produto, List<Double>>(this.prodPrecoMes3);
    }
    
    /**
    * Método que define um hashMap a partir de um hashMap passado como parâmetro
    * * @param    HashMap da faturação total de um determinado produto por mes
    **/ 
    public void setProdPrecoMes1(Map<Produto, List<Double>> prd)
    {
       this.prodPrecoMes1.clear();
       this.prodPrecoMes1 = new HashMap<Produto, List<Double>>(prd); 
    }
    
    /**
    * Método que define um hashMap a partir de um hashMap passado como parâmetro
    * * @param    HashMap da faturação total de um determinado produto por mes
    **/ 
    public void setProdPrecoMes2(Map<Produto, List<Double>> prd)
    {
       this.prodPrecoMes2.clear();
       this.prodPrecoMes2 = new HashMap<Produto, List<Double>>(prd); 
    }
    
    /**
    * Método que define um hashMap a partir de um hashMap passado como parâmetro
    * * @param    HashMap da faturação total de um determinado produto por mes
    **/ 
    public void setProdPrecoMes3(Map<Produto, List<Double>> prd)
    {
       this.prodPrecoMes3.clear();
       this.prodPrecoMes3 = new HashMap<Produto, List<Double>>(prd); 
    }
    
    /**
    * Método que devolve o número total de unidades vendidas de um determinado produto por mes
    * @returns   HashMap do número total de unidades vendidas de um determinado produto por mes
    **/
    public Map<Produto, List<Integer>> getProdUnidadeMes() 
    {
       return new HashMap<Produto, List<Integer>>(this.prodUnidadeMes);
    }
    
    /**
    * Método que define um hashMap a partir de um hashMap passado como parâmetro
    * * @param    HashMap da faturação total de um determinado produto por mes
    **/ 
    public void setProdUnidadeMes(Map<Produto, List<Integer>> prd)
    {
       this.prodUnidadeMes.clear();
       this.prodUnidadeMes = new HashMap<Produto, List<Integer>>(prd); 
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
      return this.ftrTotal == f.getFtrTotal() && this.ftrMensal.equals(f.getProdPrecoMes1()) && this.prodPrecoMes1.equals(f.getProdPrecoMes1())
             && this.prodPrecoMes2.equals(f.getProdPrecoMes2()) && this.prodPrecoMes3.equals(f.getProdPrecoMes3());
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
    * Método que calcula a faturação anual de determinado produto
    * @return  Faturação anual de determinado produto
    **/
    public double ftrAnualProd(Produto p) throws NoProdutosException
    {
        double total = 0;
        if(prodPrecoMes1.containsKey(p))
        {  
          List prods = prodPrecoMes1.get(prodPrecoMes1);
          Iterator<Integer> it = prods.iterator();
          while(it.hasNext())
          {
              total += it.next(); 
          }
        }
        if(prodPrecoMes2.containsKey(p))
        {  
          List prods = prodPrecoMes2.get(prodPrecoMes2);
          Iterator<Integer> it = prods.iterator();
          while(it.hasNext())
          {
              total += it.next(); 
          }
        }
        if(prodPrecoMes3.containsKey(p))
        {  
          List prods = prodPrecoMes2.get(prodPrecoMes3);
          Iterator<Integer> it = prods.iterator();
          while(it.hasNext())
          {
              total += it.next(); 
          }
        }
        else
        {
            throw new NoProdutosException();
        }
        return total;
    }
    
    /**
    * Método que atualiza as caracteristicas de
    * @param   
    * @param   
    * @param   
    * @param     
    **/
    public void updateProdPrecoMes(Produto p, double preco, int mes, int filial) 
    {
        double precoAtual = 0;
        double precoAtualizado = 0;
        int index = mes-1;
        if(filial == 1)
        {
           if(!this.prodPrecoMes1.containsKey(p))
           {
                List<Double> l = new ArrayList<Double>(12);
                l.add(index, preco);
                this.prodPrecoMes1.put(p,l);
            }
        
            else 
            {
               List l = this.prodPrecoMes1.get(p); 
               precoAtual = (double)l.get(index); 
               precoAtualizado = precoAtual + preco;
               l.add(index, precoAtualizado);
               this.prodPrecoMes1.put(p,l);
            } 
        }
        
        if(filial == 2)
        {
           if(!this.prodPrecoMes2.containsKey(p))
           {
                List<Double> l = new ArrayList<Double>(12);
                l.add(index, preco);
                this.prodPrecoMes2.put(p,l);
            }
        
            else 
            {
               List l = this.prodPrecoMes2.get(p); 
               precoAtual = (double)l.get(index); 
               precoAtualizado = precoAtual + preco;
               l.add(index, precoAtualizado);
               this.prodPrecoMes2.put(p,l);
            } 
        }
        
        if(filial == 3)
        {
           if(!this.prodPrecoMes3.containsKey(p))
           {
                List<Double> l = new ArrayList<Double>(12);
                l.add(index, preco);
                this.prodPrecoMes3.put(p,l);
            }
        
            else 
            {
               List l = this.prodPrecoMes3.get(p); 
               precoAtual = (double)l.get(index); 
               precoAtualizado = precoAtual + preco;
               l.add(index, precoAtualizado);
               this.prodPrecoMes3.put(p,l);
            } 
        }
    }
    
    /**
    * Método que atualiza as caracteristicas de
    * @param   
    * @param   
    * @param   
    * @param     
    **/
    public void updateProdUnidadeMes(Produto p, int unidades, int mes)
    {
       int index = mes-1;
       int unidadesAtuais = 0;
       int unidadesAtualizadas = 0;
       if(!this.prodUnidadeMes.containsKey(p)) 
       {
            List<Integer> l = new ArrayList<Integer>(12);
            l.add(index,unidades);
            this.prodUnidadeMes.put(p,l);  
       }
       else
       {
            List l = this.prodUnidadeMes.get(p); 
            unidadesAtuais = (Integer)l.get(index); 
            unidadesAtualizadas = unidadesAtuais + unidades;
            l.add(index, unidadesAtualizadas);
            this.prodUnidadeMes.put(p,l);
       }
    }
    
    /**
    * Método que
    **/
    public void addVenda(Venda v)
    {
       updateProdPrecoMes(v.getProduto(), v.getPreco(), v.getMes(), v.getFilial()); 
       updateProdUnidadeMes(v.getProduto(), v.getUnidades(), v.getMes());   
    } 
}
