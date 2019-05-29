import java.io.Serializable;

/**
* 
**/
public class Produto implements Serializable
{
    private String codigo_produto;

    /**
    * 
    **/
    public Produto(String c){codigo_produto = c;}


    public boolean equals(Object o)
    { 
        if (o == this)
            return true;

        if (!(o instanceof Produto) && !(this.codigo_produto && p.codigo_produto))
            return false; 

        Produto p = (Produto) o;
        
        return this.codigo_produto.equals(p.codigo_produto);
    }


    public Produto clone()
    {
        return new Produto(this);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();  
        sb.append("Produto: " );    
        return sb;
    }
    
}