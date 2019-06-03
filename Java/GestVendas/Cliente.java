import java.io.Serializable;

/**
* 
**/
public class Cliente implements Serializable, Comparable<Cliente>
{
    private String codigo_cl;

    /** 
    * Construtor vazio que cria uma instância Cliente  
    **/
    public Cliente(){codigo_cl = "N/A";}
    
    /** 
    * Construtor que cria um novo Cliente a partir dos parâmetros dados  
    **/
    public Cliente(String c){codigo_cl = c;}
    
    /** 
    * Construtor vazio que cria uma instância Cliente
    **/
    public Cliente(Cliente c){codigo_cl = c.getCodigo();}
    
    /**
    * Método que devolve o código de um cliente
    * @returns Código de um cliente
    **/
    public String getCodigo(){ return this.codigo_cl;}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @returns     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    { 
        if (o == this)return true;
        if (this != null && this.getClass() != o.getClass()) return false;
        Cliente c = (Cliente) o;        
        return this.codigo_cl.equals(c.codigo_cl);
    }

    /** 
    * Método que cria uma cópia de uma identificação de um Cliente
    **/
    public Cliente clone()
    {
        return new Cliente(this);
    }
    
    /**
    * Método que converte uma identificação numa string
    * @returns 
    * */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();  
        sb.append("Cliente " ).append(codigo_cl);    
        return sb.toString();
    }
    
    /**
    * Método que implementa um comparador de Cliente alfabeticamente
    * @param Cliente a comparar
    **/
    public int compareTo(Cliente c)
    {
        return codigo_cl.compareTo(c.getCodigo()); 
    }
}
