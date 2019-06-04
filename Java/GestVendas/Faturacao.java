import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

import static java.lang.System.out;
/**
* Classe Faturação que contém estruturas com dados de uma faturação
**/
public class Faturacao implements Serializable, IFaturacao   
{ 
    /** Faturação total **/
    private double ftrTotal;
    
    /** Array da faturação mensal **/
    private double[] ftrMensal;
    
    /** Map que contém para cada produto a sua faturação mensal, por filial **/
    private Map<Produto, List<Double>> prodPrecoMes1;
    
    /** Map que contém para cada produto a sua faturação mensal, por filial **/
    private Map<Produto, List<Double>> prodPrecoMes2;
    
    /** Map que contém para cada produto a sua faturação mensal, por filial **/
    private Map<Produto, List<Double>> prodPrecoMes3;
    
    /** Map que contém para cada produto a quantidade de unidades vendidas, por mes **/
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
    * Construtor que cria uma nova Faturacao a partir dos parâmetros dados 
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
    * Construtor de cópia que cria uma nova instância Faturacao a partir de uma Faturacao passado como parâmetro 
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
    **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Total global faturado:").append(ftrTotal).append("\n");
       return sb.toString();
    }
    
    /**
    * Método que calcula a faturação anual de determinado produto
    * @param   Produto a calcular
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
    * Método que atualiza o preço de um produto por mês
    * @param  Produto a atualizar  
    * @param  Preço a atualizar 
    * @param  Mês da venda do produto 
    * @param  Filial em que o produto foi vendido  
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
                List<Double> a = new ArrayList<>(12);
                for(int i = 0; i < 12; i++)
                    a.add(0.0);
                a.set(index, preco);
                this.prodPrecoMes1.put(p,a);
            }
            else{
               List a = this.prodPrecoMes1.get(p); 
               precoAtual = (double)a.get(index); 
               precoAtualizado = precoAtual + preco;
               a.set(index, precoAtualizado);
               this.prodPrecoMes1.put(p,a);
            }
        }
        else
            if(filial == 2)
            {
               if(!this.prodPrecoMes1.containsKey(p))
               {
                    List<Double> a = new ArrayList<>(12);
                    for(int i = 0; i < 12; i++)
                        a.add(0.0);
                    a.set(index, preco);
                    this.prodPrecoMes1.put(p,a);
                }
                else{
                   List a = this.prodPrecoMes1.get(p); 
                   precoAtual = (double)a.get(index); 
                   precoAtualizado = precoAtual + preco;
                   a.set(index, precoAtualizado);
                   this.prodPrecoMes1.put(p,a);
                }
            }
            else
                if(filial == 3)
                {
                   if(!this.prodPrecoMes1.containsKey(p))
                   {
                        List<Double> a = new ArrayList<>(12);
                        for(int i = 0; i < 12; i++)
                            a.add(0.0);
                        a.set(index, preco);
                        this.prodPrecoMes1.put(p,a);
                    }
                    else{
                       List a = this.prodPrecoMes1.get(p); 
                       precoAtual = (double)a.get(index); 
                       precoAtualizado = precoAtual + preco;
                       a.set(index, precoAtualizado);
                       this.prodPrecoMes1.put(p,a); 
                    }
                }
    }
    
    /**
    * Método que atualiza o número de unidades de um produto por mês
    * @param Produto a atualizar   
    * @param Número de unidades a atualizar 
    * @param Mês de compra do produto  
    **/
    public void updateProdUnidadeMes(Produto p, int unidades, int mes)
    {
       int index = mes-1;
       int unidadesAtuais = 0;
       int unidadesAtualizadas = 0;
       if(!this.prodUnidadeMes.containsKey(p)) 
       {   
            //out.println("nao contém");
            List<Integer> l = new ArrayList<Integer>(12);
            for(int i = 0; i < 12; i++)
                    l.add(0);
            l.set(index,unidades);
            this.prodUnidadeMes.put(p,l);  
       }
       else{
           List l = this.prodUnidadeMes.get(p); 
           unidadesAtuais = (Integer)l.get(index); 
           unidadesAtualizadas = unidadesAtuais + unidades;
           l.set(index, unidadesAtualizadas);
           this.prodUnidadeMes.replace(p,l);
        }
    }
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    * @param Venda a adicionar
    **/
    public void addVenda(Venda v)
    {
       updateProdPrecoMes(v.getProduto(), v.getPreco(), v.getMes(), v.getFilial()); 
       updateProdUnidadeMes(v.getProduto(), v.getUnidades(), v.getMes());   
    } 
    
    /**
    * Método que determina o total de certo produto vendido anualmente
    * @return Map que contém o total de certo produto vendido anualmente
    **/
    public Map<Produto, Integer>  prodsVendidosAnual()
    {
        Map<Produto, Integer> map = new HashMap<>(); 
        for(Map.Entry<Produto, List<Integer>> e : this.prodUnidadeMes.entrySet())
        {
            List<Integer> l = e.getValue();
            Integer sum = l.stream().collect(Collectors.summingInt(Integer::intValue));
            map.put(e.getKey(), sum);
        } 
        return map;
    }
}