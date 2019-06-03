import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
* Classe Filial que contém estruturas com dados de uma filial
*/

public class Filial implements Serializable, IFilial
{
    /**Map que a cada Produto faz corresponder um Set com um par (Mês, Cliente) **/
    Map<Produto, Set<Pair>> pClientes; 
    
    /** Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses **/
    Map<Produto, List<Integer>>  pUnidades;
    
    /**Map que a cada Cliente faz corresponder um par (Mês, Produto) **/
    Map<Cliente, Set<Pair>> cProdutos;
    
    /**Map que a cada Cliente faz corresponder uma Lista com 12 posições (meses) com pares (Nº de unidades compradas, Total Gasto) **/
    Map<Cliente, List<Pair>> cUnidadesGasto; 
    
    /**Map que a cada Cliente faz corresponder um Map com todos os produtos distintos comprados e o número de unidades total **/
    Map<Cliente, Map<Produto, Integer>> clProds;
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial()
    {
        this.pClientes = new HashMap<Produto, Set<Pair>>();
        this.pUnidades = new HashMap<Produto, List<Integer>>();
        this.cProdutos = new HashMap<Cliente, Set<Pair>>();
        this.cUnidadesGasto = new HashMap<Cliente, List<Pair>>();
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>();
    }
    
    /** 
    * Construtor que cria uma nova Filial a partir dos parâmetros dados  
    **/
    public Filial(Map<Produto, Set<Pair>> pCl, Map<Produto, List<Integer>> pUn, Map<Cliente, Set<Pair>> cProd, Map<Cliente, List<Pair>> cUnProd, Map<Cliente, Map<Produto, Integer>> clProd)
    {
        this.pClientes = pCl;
        this.pUnidades = pUn;
        this.cProdutos = cProd;
        this.cUnidadesGasto = cUnProd;
        this.clProds = clProds;
    }
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial(Filial f)
    {
        this.pClientes = f.getPClientes();
        this.pUnidades = f.getPUnidades();
        this.cProdutos = f.getCProdutos();
        this.cUnidadesGasto = f.getCUnidadesGasto();
        this.clProds = f.getClProds();
    }
    
    /**
    * Método que devolve um Map que a cada Produto faz corresponder um Set com um par (Mês, Cliente) 
    * @returns Map que a cada Produto faz corresponder um Set com um par (Mês, Cliente) 
    **/
    public Map<Produto, Set<Pair>> getPClientes(){
        return new HashMap<Produto, Set<Pair>>(this.pClientes);
    }
    
    /**
    * Método que devolve um Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses 
    * @returns Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses 
    **/
    public Map<Produto, List<Integer>> getPUnidades(){
        return new HashMap<Produto, List<Integer>>(this.pUnidades);
    }
    
    /**
    * Método que devolve um Map que a cada Cliente faz corresponder um par (Mês, Produto)
    * @returns Map que a cada Cliente faz corresponder um par (Mês, Produto)
    **/
    public Map<Cliente, Set<Pair>> getCProdutos(){
        return new HashMap<Cliente, Set<Pair>>(this.cProdutos);
    }
    
    /**
    * Método que devolve um Map que a cada Cliente faz corresponder uma Lista com 12 posições (meses) com pares (Nº de unidades compradas, Total Gasto)
    * @returns Map que a cada Cliente faz corresponder uma Lista com 12 posições (meses) com pares (Nº de unidades compradas, Total Gasto)
    **/
    public Map<Cliente, List<Pair>> getCUnidadesGasto(){
        return new HashMap<Cliente, List<Pair>>(this.cUnidadesGasto);
    }
    
    /**
    * Método que devolve um Map que a cada Cliente faz corresponder um Map com todos os produtos distintos comprados e o número de unidades total
    * @returns Map que a cada Cliente faz corresponder um Map com todos os produtos distintos comprados e o número de unidades total
    **/
    public Map<Cliente, Map<Produto, Integer>> getClProds(){
        return new HashMap<Cliente, Map<Produto, Integer>>(this.clProds);
    }
    
    /**
    * Método que define um Map que a cada Produto faz corresponder um Set com um par (Mês, Cliente) 
    * @param Map que a cada Produto faz corresponder um Set com um par (Mês, Cliente) 
    **/
    public void setPClientes(Map<Produto, Set<Pair>> pcl){
        this.pClientes.clear();
        this.pClientes = new HashMap<Produto, Set<Pair>>(pcl);
    }
    
    /**
    * Método que define um Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses 
    * @param Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses 
    **/
    public void setPUnidades(Map<Produto, List<Integer>> pUn){
        this.pUnidades.clear();
        this.pUnidades = new HashMap<Produto, List<Integer>>(pUn);
    }
    
    /**
    * Método que define um Map que a cada Cliente faz corresponder um par (Mês, Produto)
    * @param Map que a cada Cliente faz corresponder um par (Mês, Produto)
    **/
    public void setCProdutos(Map<Cliente, Set<Pair>> cProd){
        this.cProdutos.clear();
        this.cProdutos = new HashMap<Cliente, Set<Pair>>(cProd);
    }
    
    /**
    * Método que define um Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses 
    * @param Map que a cada Produto faz corresponder uma Lista com 12 posições (meses) e o número de unidades compradas em cada um desses meses 
    **/
    public void setCUnidadesGasto(Map<Cliente, List<Pair>> cUG){
        this.cUnidadesGasto.clear();
        this.cUnidadesGasto = new HashMap<Cliente, List<Pair>>(cUG);
    }
    
    /**
    * Método que define um Map que a cada Cliente faz corresponder um Map com todos os produtos distintos comprados e o número de unidades total
    * @param Map que a cada Cliente faz corresponder um Map com todos os produtos distintos comprados e o número de unidades total
    **/
    public void setClProds(Map<Cliente, Map<Produto, Integer>> cp)
    {
        this.clProds.clear();
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>(cp);
    }
    
    /** 
    * Método que cria uma cópia de uma identificação de um Cliente
    * @returns Filial cópia
    **/
    public Filial clone(){return new Filial(this);}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o){
       if(o == this)
            return true;
       if(o == null || o.getClass() != this.getClass() )
            return false;
       Filial f = (Filial) o;
       return this.pClientes.equals(f.getPClientes()) && this.pUnidades.equals(f.getPUnidades()) && this.cProdutos.equals(f.getCProdutos()) &&
              this.cUnidadesGasto.equals(f.getCUnidadesGasto()) && this.clProds.equals(f.getClProds());
    }

    
    /**
    * Método que converte uma identificação numa string
    * @returns String
    **/
    public String toString(){return " ";}
    
    
    //Métodos
    /**
    * Método que atualiza as informações relativas a um Produto
    * @param Produto a atualizar
    * @param Cliente que o comprou
    * @param Mês
    **/
    public void updatePClientes(Produto p, Cliente c, int mes){
        if(!this.pClientes.containsKey(p))
                this.pClientes.put(p, new TreeSet<>());
        TreeSet<Pair> s = new TreeSet<>(this.pClientes.get(p));
        Pair<Integer, Cliente> pair = new Pair(mes, c);
        if(!s.contains(pair))
            s.add(pair);  
        this.pClientes.put(p, s);
    }
    
    /**
    * Método que atualiza as informações relativas a um Produto
    * @param Produto a atualizar
    * @param Unidades vendidas
    * @param Mês
    **/
    public void updatePUnidades(Produto p, int uni, int mes){
        if(!this.pUnidades.containsKey(p)){
            ArrayList<Integer> a = new ArrayList<>(12);
            for(int i = 0; i < 12; i++)
                a.add(0);
            this.pUnidades.put(p, a);
            }
        ArrayList<Integer> l = new ArrayList<>(this.pUnidades.get(p));
        int uniOld = 0;
        uniOld = l.get(mes-1);
        l.set(mes-1, uniOld + uni);
        this.pUnidades.put(p, l);
    }
    
    /**
    * Método que atualiza as informações relativas a um Cliente
    * @param Cliente a atualizar
    * @param Produto Comprado
    * @param Mês
    **/
    public void updateCProdutos(Cliente c, Produto p, int mes){
        if(!this.cProdutos.containsKey(c))
                this.cProdutos.put(c, new TreeSet<>());
        TreeSet<Pair> s = new TreeSet<>(this.cProdutos.get(c));
        Pair<Integer, Produto> pair = new Pair(mes, p);
        if(!s.contains(pair))
            s.add(pair);  
        this.cProdutos.put(c, s);
    }
    
    /**
    * Método que atualiza as informações relativas a um Cliente
    * @param Cliente a atualizar
    * @param Unidades compradas
    * @param Gasto
    * @param Mês
    **/
    public void updateCUnidadesGasto(Cliente c, int uni, double gasto, int mes){
        if(!this.cUnidadesGasto.containsKey(c)){
            ArrayList<Pair> a = new ArrayList<>(12);
            for(int i = 0; i < 12; i++)
                a.add(new Pair());
            this.cUnidadesGasto.put(c, a);
        }
        ArrayList<Pair> l = new ArrayList<>(this.cUnidadesGasto.get(c));
        Pair<Integer, Double> pair = l.get(mes-1);
        if(!pair.isEmpty()){
            int uniOld = pair.getFst();
            double gastoOld = pair.getSnd();
        
            pair.setFst(uniOld+uni);
            pair.setSnd(gastoOld+gasto);
        }
        else{
            pair.setFst(uni);
            pair.setSnd(gasto);
        }
            
        l.set(mes-1, pair);
        this.cUnidadesGasto.put(c, l);  
    }
    
    /**
    * Método que atualiza as informações relativas a um Cliente e aos Produtos que adequiriu
    * @param Cliente a atualizar
    * @param Produto que comprou 
    * @param Unidades compradas (totais)
    **/
    public void updateClProds(Cliente c, Produto p, int uni){
        if(!this.clProds.containsKey(c))
                this.clProds.put(c, new HashMap<>());
        HashMap<Produto, Integer> m = new HashMap<>(this.clProds.get(c));
        if(!m.containsKey(p))
                m.put(p, uni);
        else{
            int uniOld = m.get(p);
            m.put(p, uniOld+uni);
        }
        this.clProds.get(c).put(p, uni);
    }
    
    /**
    * Método que divide as carateristicas de uma venda pelas estruturas de classe
    * @param Venda a adicionar
    **/
    public void addVenda(Venda v)
    {
        updatePClientes(v.getProduto(), v.getCliente(), v.getMes());
        updatePUnidades(v.getProduto(), v.getUnidades(), v.getMes());
        updateCProdutos(v.getCliente(), v.getProduto(), v.getMes());
        updateCUnidadesGasto(v.getCliente(), v.getUnidades(), v.getUnidades()*v.getPreco(), v.getMes()); 
        updateClProds(v.getCliente(), v.getProduto(), v.getUnidades());  
    }   
    
    //map cliente -> o que gastou num ano
    public Map<Produto, Integer>  prodsVendidosAnual()
    {
        int total = 0;
        Map<Produto, Integer> map = new HashMap<>(); 

        for(Map.Entry<Cliente, List<Pair>> e : this.cUnidadesGasto.entrySet())
        {

        } 
        return map;
       
    }
    
    
}
