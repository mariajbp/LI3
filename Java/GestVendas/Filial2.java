import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
* Classe Filial que contém estruturas com dados de uma filial
*/
public class Filial2 implements Serializable
{
    /** Registo mensal de cada produto **/
    private Map<Produto,ArrayList<RegistoProduto>> regProd; 
    
    /** Registo mensal de cada cliente **/
    private Map<Cliente,ArrayList<RegistoCliente>> regCl;
    
    
    /** 
    * Construtor vazio que cria uma instância Filial
    **/
    public Filial()
    {
        this.regProd = new HashMap<Produto,ArrayList<RegistoProduto>>();
        this.regCl = new HashMap<Cliente,ArrayList<RegistoCliente>>();
    }
    
    /** 
    * Construtor que cria uma nova Filial a partir dos parâmetros dados  
    **/
    public Filial(Map<Produto,ArrayList<RegistoProduto>> regProd, Map<Cliente,ArrayList<RegistoCliente>> regCl )
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
    public Map<Produto,ArrayList<RegistoProduto>> getRegProd()
    {
        return new HashMap<Produto,ArrayList<RegistoProduto>>(this.regProd);
    }
    
    /**
    * Método que devolve 
    * @returns 
    **/
    public Map<Cliente,ArrayList<RegistoCliente>> getRegCl()
    {
        return new HashMap<Cliente,ArrayList<RegistoCliente>>(this.regCl);
    }
    
    /**
    * Método que define 
    * @param 
    **/
    public void setRegProd(Map<Produto,ArrayList<RegistoProduto>> regP)
    {
        
    }
    
    /**
    * Método que define 
    * @param 
    **/
    public void setRegCl(Map<Cliente,ArrayList<RegistoCliente>> regC)
    {
        return new HashMap<Produto,ArrayList<RegistoProduto>>(this.regProd);
    }
}
