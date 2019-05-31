import java.io.Serializable;

/**
* Representação de um produto
**/
public class Produto implements Serializable
{
    private String codigo_produto;

    /** 
    * Construtor vazio que cria uma instância Produto 
    **/
    public Produto(){codigo_produto = "N/A";}
    
    /** 
    * Construtor que cria um novo Produto a partir dos parâmetros dados  
    **/
    public Produto(String c){codigo_produto = c;}
    
    /** 
    * Construtor vazio que cria uma instância produto 
    **/
    public Produto(Produto p){codigo_produto = p.getCodigo();}
    
    /**
    * Método que devolve o código de um produto
    * @returns Código de um produto
    **/
    public String getCodigo(){ return this.codigo_produto;}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @returns     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    { 
        if (o == this)return true;
        if (this != null && this.getClass() != o.getClass()) return false;
        Produto p = (Produto) o;        
        return this.codigo_produto.equals(p.codigo_produto);
    }

    /** 
    * Método que cria uma cópia de uma identificação de um Produto
    **/
    public Produto clone()
    {
        return new Produto(this);
    }
    
    /**
    * Método que converte uma identificação numa string
    * @returns 
    **/
    public String toString()
    {
        StringBuilder sb = new StringBuilder();  
        sb.append("Produto: " ).append(codigo_produto);    
        return sb.toString();
    }
    
    /**
    * Método que implementa um comparador de Produto alfabeticamente
    * @param Produto a comparar
    **/
    public int compareTo(Produto p)
    {
        return codigo_produto.compareTo(p.getCodigo()); 
    }
}