import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collection;

import static java.lang.System.out;
/**
* Classe Filial que contém estruturas com dados de uma filial
*/
public class Filial implements Serializable, IFilial
{
    /** Registo mensal de cada produto **/
    private Map<Produto, List<RegistoProduto>> regProd;
     
    /** Registo mensal de cada cliente **/
    private Map<Cliente, List<RegistoCliente>> regCl;
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial()
    {
        this.regProd = new HashMap<Produto, List<RegistoProduto>>();
        this.regCl = new HashMap<Cliente, List<RegistoCliente>>();
    }
    
    /** 
    * Construtor que cria uma nova Filial a partir dos parâmetros dados  
    **/
    public Filial(Map<Produto, List<RegistoProduto>> regProd, Map<Cliente, List<RegistoCliente>> regCl )
    {
        this.regProd = regProd;
        this.regCl = regCl;
    }
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial(Filial f)
    {
        this.regProd = f.getRegProd();
        this.regCl = f.getRegCl();
    }
    
    /**
    * Método que associa um registo a um produto
    **/
    public Map<Produto, List<RegistoProduto>> getRegProd()
    {
        return new HashMap<Produto, List<RegistoProduto>>(this.regProd);
    }
    
    /**
    * Método que associa um registo a um cliente 
    **/
    public Map<Cliente, List<RegistoCliente>> getRegCl()
    {
        return new HashMap<Cliente, List<RegistoCliente>>(this.regCl);
    }
    
    /**
    * Método que define um registo de determinado produto
    **/
    public void setRegProd(Map<Produto, List<RegistoProduto>> regP)
    {
        this.regProd.clear();
        this.regProd = new HashMap<>(regP);
    }
    
    /**
    * Método que define um registo de determinado cliente
    **/
    public void setRegCl(Map<Cliente, List<RegistoCliente>> regC)
    {
        this.regCl.clear();
        this.regCl = new HashMap<>(regC);
    }
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    {
         if(this == o) return true;
         if(o == null || this.getClass() != o.getClass()) return false;
         Filial f  = (Filial) o;     
         return this.regProd.equals(f.getRegProd()) && this.regCl.equals(f.getRegCl());
    }
    
    /** 
    * Método que cria uma cópia de uma identificação de uma Faturação
    **/
    public Filial clone()
    {
        return new Filial(this);
    }
    
    /**
    * Método que converte uma identificação numa string 
    **/
    public String toString()
    {
        return " ";
    }
    
    /**
    * Método que preenche um Set de produtos (query 1)
    * @param Set a preencher
    **/ 
    public void getProdutos(Set<Produto> p)
    {
        Set<Produto> s = this.regProd.keySet();
        
        Iterator it = s.iterator();
        while(it.hasNext())
        {   
            Produto pd = (Produto) it.next();
            p.add(pd.clone());
        }
    }
    
    /**
    * Método que preenche uma lista de clientes com o seu total faturado anualmente (query 7)
    * @returns lista de clientes com o seu total faturado anualmente
    **/ 
    public List<Pair<Cliente, Double>> getClientesFaturacao()
    {
        List<Pair<Cliente, Double>> s = new ArrayList<>();
        
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            Pair<Cliente, Double> p = new Pair<>();
            double faturado = 0;
            for(RegistoCliente rc : e.getValue())
            { 
                faturado += rc.getTotal();
            }
            p.setFst(e.getKey());
            p.setSnd(faturado);
            s.add(p); 
        }
        return s;
    }
    
    /**
    * Método que preenche preenche uma lista de pares com as informações de um cliente e número de unidades compradas anualmente (query 6)
    * @returns lista de clientes com o seu total faturado anualmente
    **/ 
    public List<Pair<Cliente, Integer>> getClientesProdutosDistintos()
    {
        List<Pair<Cliente, Integer>> s = new ArrayList<>();
        Set<Produto> prd = new TreeSet<>();
        
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            Pair<Cliente, Integer> p = new Pair<>();
            for(RegistoCliente rc : e.getValue())
            { 
                rc.ProdutosDistintos(prd);
            }
            
            p.setFst(e.getKey());
            p.setSnd(prd.size());
            s.add(p); 
        }
        return s;
    }
    
    //Preenche uma lista de pares( clientes, total faturado anual)---> query 6
    public List<Pair<Produto, Integer>> getProdUnidades()
    {
        List<Pair<Produto, Integer>> s = new ArrayList<>();
        
        for(Map.Entry<Produto, List<RegistoProduto>> e : regProd.entrySet())
        {
            Pair<Produto, Integer> p = new Pair<>();
            int unidades = 0;
            for(RegistoProduto rp : e.getValue())
            { 
                unidades += rp.getUnidades();
            }
            p.setFst(e.getKey());
            p.setSnd(unidades);
            s.add(p); 
        }
        return s;
    }
    
    public void getProdUnidades(List<Pair<Produto, Integer>> s)
    {
        for(Map.Entry<Produto, List<RegistoProduto>> e : regProd.entrySet())
        {
            Pair<Produto, Integer> p = new Pair<>();
            int unidades = 0;
            for(RegistoProduto rp : e.getValue())
            { 
                unidades += rp.getUnidades();
            }
            p.setFst(e.getKey());
            p.setSnd(unidades);
            s.add(p); 
        }
    }
    
    /**
    * Método que retorna um set de produtos 
    **/
    public Set<Produto> getProdutos()
    {
        return this.regProd.keySet();
    }
    
    /**
    * Método que calcula as unidades vendidas anualmente de um produto
    * @param   Produto em questão
    * @param   Total de unidades vendidas
    **/
    public int getUnidadesAnual(Produto p)
    {
        int unidades = 0;
        if(this.regProd.containsKey(p))
        {
            List<RegistoProduto> l = this.regProd.get(p);
            
            for(RegistoProduto rp: l)
            {
                unidades+=rp.getUnidades();
            }
        }
        return unidades;
    }
    
    /**
    * Método que calcula as unidades vendidas mensalmente de um produto
    * @param   Produto em questão
    * @param   Total de unidades vendidas
    **/
    public int getUnidadesMes(Produto p, int mes)
    {
        int unidades = 0;
        if(this.regProd.containsKey(p))
        {
            unidades = this.regProd.get(p).get(mes-1).getUnidades();
        }        
        return unidades;
    }
    
    /**
    * Método que calcula a faturação de um produto num determinado mês
    * @param   Produto em questão
    * @param   Faturação mensal
    **/
    public double getFtrMensal(Produto p, int mes)
    {
        double f = 0;
        if(this.regProd.containsKey(p))
        {
            f = this.regProd.get(p).get(mes-1).getFaturado();
        }        
        return f;
    }
    
    /**
    * Método que calcula o número de clientes distintos que adquiriram determinado produto mensalmente
    * @param     Produto comprado
    * @param     Mês da compra
    * @returns   Número de clientes distintos que adquiriram o produto
    **/
    public int getClientesDistintos(Produto p, int mes)
    {
        if(this.regProd.containsKey(p))
            return this.regProd.get(p).get(mes-1).ClientesDistintos();
        else
            return 0;
    }
    

    /**
    * Método que calcula o total de vendas mensal
    * @param   Mês das compras
    * @param   Total de vendas
    **/

    //Todos os clientes que compraram nesta filial no mes x ---> query 2
    public int getClientesDistintosTotal(int mes)
    {
        int cl = 0;
        RegistoCliente rc = new RegistoCliente();
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            if(!e.getValue().get(mes).equals(rc))   //se não for um registo vazio
                cl++;
        }
        return cl;
    }
     
    //Preenche um set com clientes distintos de um certo mes
    public void getClientesDistintosMes(int mes, Set<Cliente> cl)
    {
        RegistoCliente rc = new RegistoCliente();
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            if(!e.getValue().get(mes).equals(rc))   //se não for um registo vazio
                cl.add(e.getKey());
        }
    }
    
    public int totalVendas(int mes)
    {
        int v = 0;
        for(Map.Entry<Cliente, List<RegistoCliente>> e : this.regCl.entrySet())
        {
            v += e.getValue().get(mes-1).getVezes();
        }
        return v;
    }
    
    /**
    * Método que atualiza o registo de um produto
    * @param   Produto comprado
    * @param   Cliente que efetuou a compra
    * @param   Mês da compra
    * @param
    * @param
    **/
    public void updateRegProd(Produto p, Cliente c, int mes, double f, int uni)
    {
        if(!this.regProd.containsKey(p))
        {
            ArrayList<RegistoProduto> a = new ArrayList<>();
            for(int i = 0; i < 12; i++)
                    a.add(new RegistoProduto());
            RegistoProduto rp = a.get(mes-1);
            rp.updateRegProduto(c, uni, f);
            a.remove(mes-1);
            a.add(mes-1, rp);
            this.regProd.put(p, a); 
        }
        else
        {
            List<RegistoProduto> a = this.regProd.get(p);
            RegistoProduto rp = a.get(mes-1); 
            rp.updateRegProduto(c, uni, f);
            a.remove(mes-1);
            a.add(mes-1, rp);
            this.regProd.put(p, a);
        }
    }
    
    
    /**
    * Método que atualiza o registo de um cliente
    * @param   Produto comprado
    * @param   Cliente que efetuou a compra
    * @param   Número de unidades adquiridas
    * @param   ???
    * @param   Mês da compra
    **/
    public void updateRegCl(Cliente c, Produto p, int uni, double t, int mes)    
    {
        if(!this.regCl.containsKey(c))
        {
            ArrayList<RegistoCliente> a = new ArrayList<>();
            for(int i = 0; i < 12; i++)
                    a.add(new RegistoCliente());
            RegistoCliente rc = a.get(mes-1);
            rc.updateRegCliente(p, t, uni);
            rc.updateTotalGasto(t);
            rc.updateUnidades(uni);
            rc.updateVezes();
            a.remove(mes-1);
            a.add(mes-1, rc);
            this.regCl.put(c, a);
        }
        else
        {
            List<RegistoCliente> a =  this.regCl.get(c);
            RegistoCliente rc = a.get(mes-1);
            rc.updateRegCliente(p, t, uni);
            rc.updateTotalGasto(t);
            rc.updateUnidades(uni);
            rc.updateVezes();
            a.remove(mes-1);
            a.add(mes-1, rc);
            this.regCl.put(c, a);
        }
    }
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    **/
    public void addVenda(Venda v)
    {
        updateRegProd(v.getProduto(), v.getCliente(), v.getMes(), v.getPreco()*v.getUnidades(), v.getUnidades());
        updateRegCl(v.getCliente(), v.getProduto(), v.getUnidades(), v.getPreco() * v.getUnidades(), v.getMes());
    }
    
    /**
    * Método que 
    * @returns   
    **/
    public HashMap<Cliente, Integer> comprasAnuais()
    {
        int total = 0;
        HashMap<Cliente, Integer> l = new HashMap<>();
        List<RegistoCliente> rc = new ArrayList<>();  
        for(Map.Entry<Cliente, List<RegistoCliente>> e : this.regCl.entrySet())
        {
               rc = e.getValue();
               Iterator<RegistoCliente> it = rc.iterator();
               while(it.hasNext())
               {
                    RegistoCliente reg = it.next();
                    total += reg.getTotal();
               }
               l.put(e.getKey(), total);
        }
        return l; 
    }
    
    /*
    public int distintosProd(Produto produto)
    {
        int d = 0;
        for(Map.Entry<Produto, List<RegistoProduto>> e : regProd.entrySet())
        {
               if(produto == e.getKey())
               {
                     List<RegistoProduto> reg = e.getValue();
                     d = reg.size();
               }
        }   
        return d;
    }*/

    /**
    * Método que calcula o numero de compras totais e o total gasto por um cliente num mês
    * @param     Cliente em questão
    * @param     Mês a calcular
    * @returns   Numero de compras totais e o total gasto por um cliente num mês   
    **/
    public Pair<Integer,Double> comprasTotais(Cliente c, int mes) 
    {
       int index = mes-1;
       Pair<Integer,Double> pair = new Pair(); 
       int vezes = 0;
       double total = 0;
      
       if(regCl.containsKey(c))
       {
               List<RegistoCliente> lrc = regCl.get(c);
               RegistoCliente rc = lrc.get(index);
               vezes = rc.getVezes();
               total = rc.getTotal();
        }
       pair.setFst(vezes);
       pair.setSnd(total); 
       return pair;
    }
    
    /**
    * ?????????
    **/
    public Pair<Integer,Double> comprasTotaisAnual(Cliente c) //numero de compras totais e total gasto no mes 
    {
       Pair<Integer,Double> pair = new Pair(); 
       int vezes = 0;
       double total = 0;
      
       if(regCl.containsKey(c))
       {
         List<RegistoCliente> lrc = regCl.get(c);
         Iterator<RegistoCliente> it = lrc.iterator();
         while(it.hasNext())
         {
             RegistoCliente rc = it.next();
             vezes += rc.getVezes();
             total += rc.getTotal();
          }
        }
       
       pair.setFst(vezes);
       pair.setSnd(total);
       return pair;
    }
    
    /**
    * Método que calcula o numero de produtos distintos adquiridos por um cliente em determinado mês
    * @param     Cliente em questão
    * @param     Mês a calcular
    * @returns   Número de produtos distintos adquiridos   
    **/
    public int ProdutosDistintos(Cliente c, int mes)
    {
        return this.regCl.get(c).get(mes-1).produtosDistintos();
    }
     
    /**
    * ?????????
    **/
    public void ProdutosDistintos(Set<Produto> s, int mes, Cliente c)
    {
        this.regCl.get(c).get(mes-1).ProdutosDistintos(s);
    }

    /**
    * ?????????
    **/
    public void clDistintos(Produto p, Set<Cliente> s) // query 6
    {   
        if(regProd.containsKey(p))
        {
           List<RegistoProduto> lrp = regProd.get(p); 
           Iterator<RegistoProduto> it = lrp.iterator();
           while(it.hasNext())
           {
               RegistoProduto rp = it.next();
               Iterator i = rp.getRegisto().iterator();
               while(i.hasNext())
               {
                   Cliente c = (Cliente) i.next();
                   s.add(c);
                }
           }
        }
    }
    
    /**
    * ?????????
    **/
    public Set<Produto> comprasDistintasClientes(Cliente c) //query 8
    {
        Set<Produto> tmp = new TreeSet<>(); 
        Set<Produto> set = new TreeSet<>();
        if(regCl.containsKey(c))
        {
            List<RegistoCliente> rc = regCl.get(c);
            Iterator<RegistoCliente> it = rc.iterator();
            while(it.hasNext())
            {
               RegistoCliente reg = it.next(); 
               tmp = (reg.getProd().keySet()); 
               set.addAll(tmp);
            }
        }
        return set;
    }

    
    /**
    * ?????????
    **/
    public Set<Cliente> getClientes(Produto p) //clientes que comprar um prod num ano

    { 
        Set<Cliente> s = new TreeSet<>();
        if(regProd.containsKey(p))
        {
            List<RegistoProduto> rp = regProd.get(p);
            Iterator<RegistoProduto> it = rp.iterator();
            while(it.hasNext())
            {
                RegistoProduto r = it.next();
                s.addAll(r.getRegisto()); 
            }
        }
        return s;
    }
    
    /**
    * ?????????
    **/
    public Pair<Cliente,Double> clienteGastoAnual(Cliente c) //gasto anual de um cliente
    {
        double total = 0;
        List<Pair<Cliente,Double>> l = new ArrayList();
        Pair<Integer,Double> pair = new Pair();
        Pair<Cliente,Double> pfinal = new Pair();
        Pair<Cliente,Double> p = new Pair();
        
        if(regCl.containsKey(c))
        {
            List<RegistoCliente> rc = regCl.get(c);
            Iterator<RegistoCliente> it = rc.iterator();
            while(it.hasNext())
            {
                RegistoCliente r = it.next();
                Map<Produto, Pair<Integer,Double>> prod = r.getProd();
                for(Map.Entry<Produto, Pair<Integer,Double>> e : prod.entrySet())
                {
                    pair = e.getValue();
                    p.setFst(c);
                    p.setSnd(pair.getSnd());
                }
            }
        }       
        
        Iterator<Pair<Cliente,Double>> it = l.iterator();
        while(it.hasNext())
        {
             Pair<Cliente,Double> pcd = it.next();
             total += pcd.getSnd();

        }
        pfinal.setFst(c);
        pfinal.setSnd(total);
        return pfinal; 
    }
    
    /**
    * ?????????
    **/
    public Pair<Cliente,Integer> clienteUnidadesAnual(Cliente c) //unidades compradas anual de um cliente
    {
        int total = 0;
        List<Pair<Cliente,Integer>> l = new ArrayList();
        Pair<Integer,Double> pair = new Pair();
        Pair<Cliente,Integer> pfinal = new Pair();
        Pair<Cliente,Integer> p = new Pair();
        
        if(regCl.containsKey(c))
        {
            List<RegistoCliente> rc = regCl.get(c);
            Iterator<RegistoCliente> it = rc.iterator();
            while(it.hasNext())
            {
                RegistoCliente r = it.next();
                Map<Produto, Pair<Integer,Double>> prod = r.getProd();
                for(Map.Entry<Produto, Pair<Integer,Double>> e : prod.entrySet())
                {
                    pair = e.getValue();
                    p.setFst(c);
                    p.setSnd(pair.getFst());
                }
            }
        }       
        
        Iterator<Pair<Cliente,Integer>> it = l.iterator();
        while(it.hasNext())
        {
             Pair<Cliente,Integer> pcd = it.next();
             total += pcd.getSnd();
        }
        pfinal.setFst(c);
        pfinal.setSnd(total);
        return pfinal; 
    }

}

