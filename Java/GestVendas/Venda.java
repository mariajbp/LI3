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
    private String codeP;
    private double price;
    private int units;
    private String codeC;
    private String np;
    private int month;
    private int filial;
    
    public Venda()
    {
        this.codeP = new String();
        this.price = 0.0;
        this.units = 0;
        this.codeC = new String();
        this.np = new String();
        this.month = 0;
        this.filial = 0;
    }
    
    public Venda(String codeP, double price, int units, String codC, String np, int month, int filial)
    {
        this.codeP = codeP;
        this.price = price;
        this.units = units;
        this.codeC = codeC;
        this.np = np;
        this.month = month;
        this.filial = filial; 
    }
    
    public Venda(Venda v)
    {
        this.codeP = v.getCodeP();
        this.price = v.getPrice();
        this.units = v.getUnits();
        this.codeC = v.getCodeC();
        this.np = v.getNP();
        this.month = v.getMonth();
        this.filial = v.getFilial(); 
    }
    
    public String getCodeP(){return this.codeP;}
    public double getPrice(){return this.price;}
    public int getUnits(){return this.units;}
    public String getCodeC(){return this.codeC;}
    public String getNP(){return this.np;}
    public int getMonth(){return this.month;}
    public int getFilial(){return this.filial;}
    
    public void setCodep(String newcp){this.codeP = newcp;}
    public void setPrice(double newp){this.price = newp;}
    public void setUnits(int newu){this.units = newu;}
    public void setCodeC(String newcc){this.codeP = newcc;}
    public void setNP(String newnp){this.codeP = newnp;}
    public void setMonth(int newm){this.month = newm;}
    public void setFilial(int newf){this.filial = newf;}
}