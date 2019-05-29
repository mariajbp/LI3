import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Filial implements IFilial 
{
    //Tabela
    //Não estava a conseguir copiar os arrays, perguntar ao professor, por agora fica assim até descobrir 
    //Pair[][] mesFilial;
    Map<Integer, Pair> f1;
    Map<Integer, Pair> f2;
    Map<Integer, Pair> f3;
    //  Produto, <NºCl, NºV, Total>
    Map<Produto, TripleList> produtos;     
    //  Cliente, <NºProd distintos, Nº Comprados, Faturado>
    Map<Cliente, TripleList> clientes;
    //  Client, <Produto, NºProd>
    Map<Cliente, Map<Produto, Integer>> clProds;
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial()
    {
        //this.mesFilial = new Pair[3][12];
        this.f1 = new HashMap<Integer, Pair>(12);
        this.f2 = new HashMap<Integer, Pair>(12);
        this.f3 = new HashMap<Integer, Pair>(12);
        this.produtos = new HashMap<Produto, TripleList>();
        this.clientes = new HashMap<Cliente, TripleList>();
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>();
    }
    
    /** 
    * Construtor que cria um novo Filial a partir dos parâmetros dados  
    **/
    public Filial(Map<Integer, Pair> f1, Map<Integer, Pair> f2, Map<Integer, Pair> f3, Map<Produto, TripleList> prod, Map<Cliente, TripleList> cl, Map<Cliente, Map<Produto, Integer>> clProd)
    {
        this.f1 = new HashMap<Integer, Pair>(f1);
        this.f2 = new HashMap<Integer, Pair>(f2);
        this.f3 = new HashMap<Integer, Pair>(f3);
        this.produtos = new HashMap<Produto, TripleList>(prod);
        this.clientes = new HashMap<Cliente, TripleList>(cl);
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>(clProd);
    }
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial(Filial f)
    {
        this.f1 = f.getF1();
        this.f2 = f.getF2();
        this.f3 = f.getF3();
        this.produtos = f.getProdutos();
        this.clientes = f.getClientes();
        this.clProds = f.getClProds();
    }
    
    /**
    * Método que devolve uma mapa com um par que contém o número total de vendas e clientes, por mês da filial em questão
    * @return Mapa com um que contém o número total de vendas e clientes
    **/
    public Map<Integer, Pair> getF1(){return new HashMap<Integer, Pair>(this.f1);}
    
    /**
    * Método que devolve uma mapa com um par que contém o número total de vendas e clientes, por mês da filial em questão
    * @return Mapa com um que contém o número total de vendas e clientes
    **/
    public Map<Integer, Pair> getF2(){return new HashMap<Integer, Pair>(this.f2);}
    
    /**
    * Método que devolve uma mapa com um par que contém o número total de vendas e clientes, por mês da filial em questão
    * @return Mapa com um que contém o número total de vendas e clientes
    **/
    public Map<Integer, Pair> getF3(){return new HashMap<Integer, Pair>(this.f3);}
    
    /**
    * Método que devolve uma mapa com um triplo que contém o número de clientes, vendas e total faturado de determinado produto, organizado por mês
    * @return Mapa com um que contém o número de clientes, vendas e total faturado de determinado produto, organizado por mês
    **/
    public Map<Produto, TripleList> getProdutos(){return new HashMap<Produto, TripleList>(this.produtos);}
    
    
    public Map<Cliente, TripleList> getClientes(){return new HashMap<Cliente, TripleList>(this.clientes);}
    public Map<Cliente, Map<Produto, Integer>> getClProds(){return new HashMap<Cliente, Map<Produto, Integer>>(this.clProds);}
    
    //Setters
    public void setF1(Map<Integer, Pair> f1)
    {
        this.f1.clear();
        this.f1 = new HashMap<Integer, Pair>(f1);
    }
    public void setF2(Map<Integer, Pair> f2)
    {
        this.f2.clear();
        this.f2 = new HashMap<Integer, Pair>(f2);
    }
    public void setF3(Map<Integer, Pair> f3)
    {
        this.f3.clear();
        this.f3 = new HashMap<Integer, Pair>(f3);
    }
    public void setProdutos(Map<Produto, TripleList> p)
    {
        this.produtos.clear();
        this.produtos = new HashMap<Produto, TripleList>(p);
    }
    public void setClientes(Map<Cliente, TripleList> c)
    {
        this.clientes.clear();
        this.clientes = new HashMap<Cliente, TripleList>(c);
    }
    public void setClProds(Map<Cliente, Map<Produto, Integer>> cp)
    {
        this.clProds.clear();
        this.clProds = new HashMap<Cliente, Map<Produto, Integer>>(cp);
    }
    
    /** 
    * Método que cria uma cópia de uma identificação de um Cliente
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
       return this.f1.equals(f.getF1()) && this.f2.equals(f.getF2()) && this.f3.equals(f.getF3()) &&
              this.produtos.equals(f.getProdutos()) && 
              this.clientes.equals(f.getClientes()) &&
              this.clProds.equals(f.getClProds());
    }

   /**
   * Método que converte uma identificação numa string
   * @return  
   **/
    public String toString(){return " ";}
    
    
    //Métodos
    
    
    
}
