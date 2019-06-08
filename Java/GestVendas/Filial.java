import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


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
    * Método que preenche um Set de Clientes
    * @param Set a preencher
    **/ 
    public void getClientes(Set<Cliente> c)
    {
        Set<Cliente> s = this.regCl.keySet();
        
        Iterator it = s.iterator();
        while(it.hasNext())
        {   
            Cliente cl = (Cliente) it.next();
            c.add(cl.clone());
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
    * Método que preenche um Map de pares com as informações de um cliente e número de unidades compradas anualmente (query 6)
    **/ 
    public void getClientesProdutosDistintos(Map<Cliente, Set<Produto>> m)
    {   
        
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            Set<Produto> p1 = new TreeSet<>();
            for(RegistoCliente rc : e.getValue())
            {   
                Set<Produto> p = new TreeSet<>();
                p = rc.getProd().keySet();
                Iterator it = p.iterator();
                while(it.hasNext())
                {
                    Produto prd = (Produto) it.next();
                    p1.add(prd.clone());
                }
            }   
            
            if(m.containsKey(e.getKey()))
            {
               Set<Produto> tmp = m.get(e.getKey());
               Iterator i = p1.iterator();
               while(i.hasNext())
               {
                   Produto prd2 = (Produto) i.next();
                   tmp.add(prd2);
               }
               m.put(e.getKey(), tmp); 
            }
            else
                m.put(e.getKey(), p1);
        }
    }
    
    /**
    * Método que preenche um Map de pares com as informações de um Produto e as unidades vendidas anualmente (query 6)
    **/
    public void getProdUnidades(Map<Produto, Integer> s)
    {
        for(Map.Entry<Produto, List<RegistoProduto>> e : regProd.entrySet())
        {
            Pair<Produto, Integer> p = new Pair<>();
            int unidades = 0;
            for(RegistoProduto rp : e.getValue())
            { 
                unidades += rp.getUnidades();
            }
            
            if(s.containsKey(e.getKey()))
            {
                int uniOld = s.get(e.getKey());
                s.put(e.getKey(), uniOld + unidades); 
            }
            else
            {
                s.put(e.getKey(), unidades);
            }
        }
    }

    /**
    * Método que calcula as unidades vendidas mensalmente de um produto
    * @param   Produto em questão
    * @param   Total de unidades vendidas
    **/ 
    public int getUnidadesMes(Produto p, int mes) throws ProdutoInvalidoException
    {
        try
        {
            return this.regProd.get(p).get(mes-1).getUnidades();
        }catch(NullPointerException e){throw new ProdutoInvalidoException();}
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
    * Método que calcula o número de clientes que efetuaram compras na filial, num determinado mês (query 2)
    * @param   Mês das compras
    * @param   Total de clientes que efetuaram compras
    **/
    public int getClientesDistintosTotal(int mes)
    {
        int cl = 0;
        RegistoCliente rc = new RegistoCliente();
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            if(!e.getValue().get(mes - 1).equals(rc))   //se não for um registo vazio
                cl++;
        }
        return cl;
    }
     
    /**
    * Método que preenche um set com clientes distintos de um certo mes
    * @param   Mês das compras
    * @param   Set de clientes
    **/
    public void getClientesDistintosMes(int mes, Set<Cliente> cl)
    {
        RegistoCliente rc = new RegistoCliente();
        for(Map.Entry<Cliente, List<RegistoCliente>> e : regCl.entrySet())
        {
            if(!e.getValue().get(mes - 1).equals(rc))   //se não for um registo vazio
                cl.add(e.getKey());
        }
    } 
    

    /**
    * Método que calcula o total de vendas mensal
    * @param   Mês das compras
    * @param   Total de vendas
    **/
    public int totalVendas(int mes) throws InputInvalidoException
    {
        int v = 0;
        try
        {
            for(Map.Entry<Cliente, List<RegistoCliente>> e : this.regCl.entrySet())
            {
                v += e.getValue().get(mes-1).getVezes();
            }
            return v;
        }catch(IndexOutOfBoundsException e){throw new InputInvalidoException("Mês inválido");}
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
    * @param
    * @param
    * @param
    **/
    public void ProdutosDistintos(Set<Produto> s, int mes, Cliente c) throws ClienteInvalidoException
    {
        try
        {
            this.regCl.get(c).get(mes-1).ProdutosDistintos(s);
        }catch(NullPointerException e){throw new ClienteInvalidoException();}
    }

    /**
    * ?????????
    * @param 
    * @param 
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
    * @param    Cliente em questão
    * @returns
    **/
    public Set<Produto> comprasDistintasClientes(Cliente c) //query 8
    {
        Set<Produto> set = new TreeSet<>();
        if(regCl.containsKey(c))
        {
            List<RegistoCliente> rc = regCl.get(c);
            Iterator<RegistoCliente> it = rc.iterator();
            while(it.hasNext())
            {
               RegistoCliente reg = it.next(); 
               Iterator i = reg.getProd().keySet().iterator();
               while(i.hasNext())
               {
                   Produto p = (Produto) i.next();
                   set.add(p.clone()); 
               }
            }
        }
        return set;
    }

    
    /**
    * ??
    * @param
    * @param
    **/
    public void getClientes(Produto p, Set<Cliente> s) throws ProdutoInvalidoException
    { 
        if(regProd.containsKey(p))
        {
            List<RegistoProduto> rp = regProd.get(p);
            Iterator<RegistoProduto> it = rp.iterator();
            while(it.hasNext())
            { 
                RegistoProduto r = it.next();
                Iterator i = r.getRegisto().iterator();
                while(i.hasNext())
                {
                    Cliente c = (Cliente) i.next();
                    s.add(c.clone()); 
                }
            }
        }
        else
            throw new ProdutoInvalidoException();
    }
    
    /**
    * Método que calcula o gasto anual de um cliente
    * @param     Cliente em questão 
    * @returns   Gasto anual de um cliente
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
                    total = pair.getSnd();
                    p.setSnd(total);
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
    * Método que calcula a quantidade de unidades compradas por um cliente, anualmente
    * @param     Cliente em questão 
    * @returns   Quantidade de unidades compradas por um cliente, anualmente
    **/
    public Pair<Cliente,Integer> clienteUnidadesAnual(Cliente c) 
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
                    total = pair.getFst();  
                }
                p.setFst(c);
                p.setSnd(total);
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
    
     //query 5 dá p par produtos e unidades anuais de um cliente
    /**
    * Método que preenche um Map com as informações associadas a um Cliente sobre os Produtos que comprou e o número de unidades 
    * @param   Cliente
    * @param   Map que associa a cada produto as unidades compradas
    **/
     public void numCompradoProds(Cliente c, Map<Produto, Integer> s) throws ClienteInvalidoException
     {  
             try 
             { 
                 Pair<Integer,Double> pair = new Pair();
             
                 List<RegistoCliente> rc = regCl.get(c);
                 Iterator<RegistoCliente> it = rc.iterator();
                 while(it.hasNext())
                 {
                    RegistoCliente r = it.next();
                    Map<Produto, Pair<Integer,Double>> prod = r.getProd();
                    for(Map.Entry<Produto, Pair<Integer,Double>> e : prod.entrySet())
                    {
                        pair = e.getValue();
                        if(s.containsKey(e.getKey()))
                        {
                            int uniOld = s.get(e.getKey());
                            s.put(e.getKey(), pair.getFst()+uniOld);
                        }
                        else
                        {
                            s.put(e.getKey(), pair.getFst());
                        }
                        
                    }
                 }
              }catch(NullPointerException e){throw new ClienteInvalidoException();}
      }

     /**
     * Método que dado um produto, retorna  lista com o seu total faturado por mês (query 10)
     * @param   Produto a determinar
     * @param   Lista com o total faturado por mês
     **/
     public List<Double> totalFtrProd(Produto p)
     {
          double ftr;
          Pair<Produto,Double> pair = new Pair();
          List<Double> l = new ArrayList<>();
          if(regProd.containsKey(p))
          {
              List<RegistoProduto> rp = regProd.get(p);
              Iterator<RegistoProduto> it = rp.iterator();
              while(it.hasNext())
              {
                 RegistoProduto r = it.next();
                 ftr = r.getFaturado();
                 l.add(ftr);
              }
          }
          return l;
     }
}

