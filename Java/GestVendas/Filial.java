import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

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
         if(o == null && this.getClass() != o.getClass()) return false;
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
    * Método que produz a lista com os clientes distintos de uma compra
    * @param   Lista de clientes de uma compra
    **/
    public void getClientesDistintos(Set<Cliente> s)
    {
        Set<Cliente> tmp = regCl.keySet();
        Cliente c = new Cliente();
        Iterator it = tmp.iterator();
        while(it.hasNext())
        {
            c = (Cliente) it.next();
            s.add(c);
        }
    }
    
    /**
    * Método que devolve os clientes distintos de determinado produto, num mes
    * @param   Produto comprado
    * @param   Mês da compra
    **/
    public int getClientesDistintos(Produto p, int mes)
    {
        if(this.regProd.containsKey(p))
            return this.regProd.get(p).get(mes-1).ClientesDistintos();
        else
            return -1;
    }
    
    
    /**
    * Método que atualiza o registo de um produto
    * @param   Produto comprado
    * @param   Cliente que efetuou a compra
    * @param   Número de unidades adquiridas
    * @param   Mês da compra
    **/
    public void updateRegProd(Produto p, Cliente c, int uni, int mes)
    {
        if(!this.regProd.containsKey(p)){
            ArrayList<RegistoProduto> a = new ArrayList<>();
            for(int i = 0; i < 12; i++)
                    a.add(new RegistoProduto());
            RegistoProduto rp = a.get(mes-1);
            rp.updateRegProduto(c, uni);
            a.remove(mes-1);
            a.add(mes-1, rp);
            this.regProd.put(p, a);
        }
        else
        {
            List<RegistoProduto> a = this.regProd.get(p);
            RegistoProduto rp = a.get(mes-1);
            rp.updateRegProduto(c, uni);
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
            a.add(rc);
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
            a.add(rc);
            this.regCl.put(c, a);
        }
    }
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    **/
    public void addVenda(Venda v)
    {
        updateRegProd(v.getProduto(), v.getCliente(), v.getUnidades(), v.getMes());
        updateRegCl(v.getCliente(), v.getProduto(), v.getUnidades(), v.getPreco() * v.getUnidades(), v.getMes());
    }
    
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
}
