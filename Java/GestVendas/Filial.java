import java.util.*;
import java.lang.Object;
/**
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filial
{
    //Tabela
    //Não estava a conseguir copiar os arrays, perguntar ao professor, por agora fica assim até descobrir 
    //Pair[][] mesFilial;
    Map<Integer, Pair> f1;
    Map<Integer, Pair> f2;
    Map<Integer, Pair> f3;
    //  Produto, <NºCl, NºV, Total>
    Map<String, TripleList> produtos;     
    //  Cliente, <NºProd distintos, Nº Comprados, Faturado>
    Map<String, TripleList> clientes;
    //  Client, <Produto, NºProd>
    Map<String, Map<String, Integer>> clProds;
    
    public Filial(){
        //this.mesFilial = new Pair[3][12];
        this.f1 = new HashMap<Integer, Pair>(12);
        this.f2 = new HashMap<Integer, Pair>(12);
        this.f3 = new HashMap<Integer, Pair>(12);
        this.produtos = new HashMap<String, TripleList>();
        this.clientes = new HashMap<String, TripleList>();
        this.clProds = new HashMap<String, Map<String, Integer>>();
    }
    
    public Filial(Map<Integer, Pair> f1, Map<Integer, Pair> f2, Map<Integer, Pair> f3, Map<String, TripleList> prod, Map<String, TripleList> cl, Map<String, Map<String, Integer>> clProd){
        this.f1 = new HashMap<Integer, Pair>(f1);
        this.f2 = new HashMap<Integer, Pair>(f2);
        this.f3 = new HashMap<Integer, Pair>(f3);
        this.produtos = new HashMap<String, TripleList>(prod);
        this.clientes = new HashMap<String, TripleList>(cl);
        this.clProds = new HashMap<String, Map<String, Integer>>(clProd);
    }
    
    public Filial(Filial f){
        this.f1 = f.getF1();
        this.f2 = f.getF2();
        this.f3 = f.getF3();
        this.produtos = f.getProdutos();
        this.clientes = f.getClientes();
        this.clProds = f.getClProds();
    }
    
    //Getters
    public Map<Integer, Pair> getF1(){return new HashMap<Integer, Pair>(this.f1);}
    public Map<Integer, Pair> getF2(){return new HashMap<Integer, Pair>(this.f2);}
    public Map<Integer, Pair> getF3(){return new HashMap<Integer, Pair>(this.f3);}
    public Map<String, TripleList> getProdutos(){return new HashMap<String, TripleList>(this.produtos);}
    public Map<String, TripleList> getClientes(){return new HashMap<String, TripleList>(this.clientes);}
    public Map<String, Map<String, Integer>> getClProds(){return new HashMap<String, Map<String, Integer>>(this.clProds);}
    
    //Setters
    public void setF1(Map<Integer, Pair> f1){
        this.f1.clear();
        this.f1 = new HashMap<Integer, Pair>(f1);
    }
    public void setF2(Map<Integer, Pair> f2){
        this.f2.clear();
        this.f2 = new HashMap<Integer, Pair>(f2);
    }
    public void setF3(Map<Integer, Pair> f3){
        this.f3.clear();
        this.f3 = new HashMap<Integer, Pair>(f3);
    }
    public void setProdutos(Map<String, TripleList> p){
        this.produtos.clear();
        this.produtos = new HashMap<String, TripleList>(p);
    }
    public void setClientes(Map<String, TripleList> c){
        this.clientes.clear();
        this.clientes = new HashMap<String, TripleList>(c);
    }
    public void setClProds(Map<String, Map<String, Integer>> cp){
        this.clProds.clear();
        this.clProds = new HashMap<String, Map<String, Integer>>(cp);
    }
    
    /**
     * Clone
     */
    public Filial clone(){return new Filial(this);}
    
    /**
     * Equals
     */
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
    
    public String toString(){return " ";}
    
    
    //Métodos
    
    
    
}
