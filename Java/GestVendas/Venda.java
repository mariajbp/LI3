import java.io.Serializable;
import java.util.TreeSet; 
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.out;

/**
* 
**/
public class Venda implements Serializable
{
    private Produto p;
    private double preco;
    private int unidades;
    private Cliente cl;
    private String np;
    private int mes;
    private int filial;
    
    public Venda()
    {
        this.p = new Produto();
        this.preco= 0.0;
        this.unidades = 0;
        this.cl = new Cliente();
        this.np = new String();
        this.mes = 0;
        this.filial = 0;
    }
    
    public Venda(String p, double preco, int unidades, String codC, String np, int mes, int filial)
    {
        this.p = new Produto(p);
        this.preco= preco;
        this.unidades = unidades;
        this.cl = new Cliente(cl);
        this.np = np;
        this.mes = mes;
        this.filial = filial; 
    }
    
    public Venda(Venda v)
    {
        this.p = v.getProduto();
        this.preco= v.getPreco();
        this.unidades = v.getUnidades();
        this.cl = v.getCliente();
        this.np = v.getNP();
        this.mes = v.getMes();
        this.filial = v.getFilial(); 
    }
    
    public Produto getProduto(){return this.p;}
    public double getPreco(){return this.preco;}
    public int getUnidades(){return this.unidades;}
    public Cliente getCliente(){return this.cl;}
    public String getNP(){return this.np;}
    public int getMes(){return this.mes;}
    public int getFilial(){return this.filial;}
    

    public void setP(String newcp){this.p = new Produto(newcp);}
    public void setPreco(double newp){this.preco= newp;}
    public void setUnidades(int newu){this.unidades = newu;}
    public void setCl(String newcc){this.cl = new Cliente(newcc);}
    public void setNP(String newnp){this.np = newnp;}
    public void setMes(int newm){this.mes = newm;}
    public void setFilial(int newf){this.filial = newf;}
} 