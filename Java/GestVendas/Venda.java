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
    private Cliente cl;
    private double preco;
    private int unidades;
    private String np;
    private int mes;
    private int filial;
    
    /** 
    * Construtor vazio que cria uma instância Venda
    **/
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
    
    /** 
    * Construtor que cria uma nova Venda a partir dos parâmetros dados  
    **/
    public Venda(String codP, double preco, int unidades, String codC, String np, int mes, int filial)
    {
        this.p = new Produto(codP);
        this.preco= preco;
        this.unidades = unidades;
        this.cl = new Cliente(codC);
        this.np = np;
        this.mes = mes;
        this.filial = filial; 
    }
    
    /** 
    * Construtor vazio que cria uma instância Venda
    **/
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
    
    /**
    * Método que devolve o código de um produto
    * @returns Código de um produto
    **/
    public Produto getProduto(){return this.p;}
    
    /**
    * Método que devolve o preço de um produto
    * @returns Preço de um produto
    **/
    public double getPreco(){return this.preco;}
    
    /**
    * Método que devolve o número de unidades de um produto
    * @returns Número de unidades de um produto
    **/
    public int getUnidades(){return this.unidades;}
    
    /**
    * Método que devolve o código de um cliente
    * @returns Código de um produto
    **/
    public Cliente getCliente(){return this.cl;}
    
    /**
    * Método que devolve o modo de compra de um produto
    * @returns Modo de compra de um produto
    **/
    public String getNP(){return this.np;}
    
    /**
    * Método que devolve o mes de compra de um produto
    * @returns Mes de compra de um produto
    **/
    public int getMes(){return this.mes;}
    
    /**
    * Método que devolve a filial onde foi comprado o produto
    * @returns A filial onde foi comprado o produto
    **/
    public int getFilial(){return this.filial;}
    
    /**
    * Método que devolve o código de um produto
    * @param Código de um produto
    **/
    public void setP(String newcp){this.p = new Produto(newcp);}
    
    /**
    * Método que define o preço de um produto
    * @param Preço de um produto
    **/
    public void setPreco(double newp){this.preco= newp;}
    
    /**
    * Método que define o número de unidades de um produto
    * @param Número de unidades de um produto
    **/
    public void setUnidades(int newu){this.unidades = newu;}
    
    /**
    * Método que define o código de um cliente
    * @param Código de um produto
    **/
    public void setCl(String newcc){this.cl = new Cliente(newcc);}
    
    /**
    * Método que define o modo de compra de um produto
    * @param Modo de compra de um produto
    **/
    public void setNP(String newnp){this.np = newnp;}
    
    /**
    * Método que define o mes de compra de um produto
    * @param Mes de compra de um produto
    **/
    public void setMes(int newm){this.mes = newm;}
    
    /**
    * Método que define a filial onde foi comprado o produto
    * @param A filial onde foi comprado o produto
    **/
    public void setFilial(int newf){this.filial = newf;}
} 