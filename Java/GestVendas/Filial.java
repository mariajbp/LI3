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
    
    
    /** Registo anual de cada cliente **/
    /*
    private Map<Cliente, RegistoCliente> anual;
    */
    
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
    * Método que devolve 
    * @returns 
    **/
    public Map<Produto, List<RegistoProduto>> getRegProd()
    {
        return new HashMap<Produto, List<RegistoProduto>>(this.regProd);
    }
    
    /**
    * Método que devolve 
    * @returns 
    **/
    public Map<Cliente, List<RegistoCliente>> getRegCl()
    {
        return new HashMap<Cliente, List<RegistoCliente>>(this.regCl);
    }
    
    /**
    * Método que define 
    * @param 
    **/
    public void setRegProd(Map<Produto, List<RegistoProduto>> regP)
    {
        this.regProd.clear();
        this.regProd = new HashMap<>(regP);
    }
    
    /**
    * Método que define 
    * @param 
    **/
    public void setRegCl(Map<Cliente, List<RegistoCliente>> regC)
    {
        this.regCl.clear();
        this.regCl = new HashMap<>(regC);
    }
    
    public boolean equals(Object o)
    {
         if(this == o) return true;
         if(o == null && this.getClass() != o.getClass()) return false;
         Filial f  = (Filial) o;     
         return this.regProd.equals(f.getRegProd()) && this.regCl.equals(f.getRegCl());
    }
    
    public Filial clone()
    {
        return new Filial(this);
    }
    
    public String toString()
    {
        return " ";
    }
    
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
    
    public int getClientesDistintos(Produto p, int mes)
    {
        if(this.regProd.containsKey(p))
            return this.regProd.get(p).get(mes-1).ClientesDistintos();
        else
            return -1;
    }
    
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
    
    public void updateRegCl(Cliente c, Produto p, int uni, double t, int mes)    
    {
        if(!this.regCl.containsKey(c)){
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
    
    public void addVenda(Venda v)
    {
        updateRegProd(v.getProduto(), v.getCliente(), v.getUnidades(), v.getMes());
        updateRegCl(v.getCliente(), v.getProduto(), v.getUnidades(), v.getPreco() * v.getUnidades(), v.getMes());
    }
}
