import java.io.Serializable;

/**
*  Representação de uma venda
**/
public class Venda implements Serializable
{
    /** Código do produto **/
    private Produto p;
    
    /** Cópdigo do cliente **/
    private Cliente cl;
    
    /** Preço da venda **/
    private double preco;
    
    /** Número de unidades **/
    private int unidades;
    
    /** Tipo: normal ou promoção **/
    private String np;
    
    /** Mês**/
    private int mes;
    
    /** Filial **/
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
    public Venda(String codP, double preco, int unidades, String np, String codC, int mes, int filial)
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
    public Produto getProduto(){return this.p.clone();}
    
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
    public Cliente getCliente(){return this.cl.clone();}
    
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
    
    /** 
    * Método que cria uma cópia de uma identificação de uma Venda
    **/
    public Venda clone()
    {
        return new Venda(this);
    }
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @returns     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    { 
        if (o == this)return true;
        if (this != null && this.getClass() != o.getClass()) return false;
        Venda v = (Venda) o;        
        return this.p.equals(v.getProduto()) && this.cl.equals(v.getCliente()) && this.preco == v.getPreco()
               && this.unidades == v.getUnidades() && this.np.equals(v.getNP()) && this.mes == v.getMes()
               && this.filial == v.getFilial();
    } 
   
   
    /**
    * Método que converte uma identificação numa string
    **/
    public String toString()
    {
        StringBuilder sb = new StringBuilder();  
        sb.append("Produto: " ).append(p).append("\n");  
        sb.append("Cliente: " ).append(cl).append("\n"); 
        sb.append("Preço: " ).append(preco).append("\n"); 
        sb.append("Unidades: " ).append(unidades).append("\n"); 
        sb.append("Tipo: " ).append(np).append("\n"); 
        sb.append("Mês: " ).append(mes).append("\n"); 
        sb.append("Filial: " ).append(filial).append("\n"); 
        return sb.toString();
    }
}