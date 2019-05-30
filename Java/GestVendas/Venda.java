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
    private Produto codeP;
    private double price;
    private int units;
    private Cliente codeC;
    private String np;
    private int month;
    private int filial;

    public Venda()
    {
        this.codeP = new Produto();
        this.price = 0.0;
        this.units = 0;
        this.codeC = new Cliente();
        this.np = new String();
        this.month = 0;
        this.filial = 0;
    }
    
    public Venda(String codeP, double price, int units, String codC, String np, int month, int filial)
    {
        this.codeP = new Produto(codeP);
        this.price = price;
        this.units = units;
        this.codeC = new Cliente(codeC);
        this.np = np;
        this.month = month;
        this.filial = filial; 
    }
    
    public Venda(Venda v)
    {
        this.codeP = v.getProduto();
        this.price = v.getPrice();
        this.units = v.getUnits();
        this.codeC = v.getCliente();
        this.np = v.getNP();
        this.month = v.getMonth();
        this.filial = v.getFilial(); 
    }
    
    public Produto getProduto(){return new Produto(this.codeP);}
    public double getPrice(){return this.price;}
    public int getUnits(){return this.units;}
    public Cliente getCliente(){return new Cliente(this.codeC);}
    public String getNP(){return this.np;}
    public int getMonth(){return this.month;}
    public int getFilial(){return this.filial;}
    
    public void setCodep(Produto newcp){this.codeP = newcp;}
    public void setPrice(double newp){this.price = newp;}
    public void setUnits(int newu){this.units = newu;}
    public void setCodeC(Cliente newcc){this.codeC = newcc;}
    public void setNP(String newnp){this.np = newnp;}
    public void setMonth(int newm){this.month = newm;}
    public void setFilial(int newf){this.filial = newf;}
}