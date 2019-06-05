import java.util.TreeSet; 
import java.util.Set;
import java.io.Serializable;
import java.io.*; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.out;

/**
* Representação de um catalogo de clientes
**/
public class CatalogoClientes implements ICatClientes, Serializable
{
   /** Catalogo de clientes **/
   private Set<Cliente> catalogo; 
    
   /** 
   * Construtor vazio que cria uma instância CatalogoClientes
   **/
   public CatalogoClientes()
   {
        this.catalogo = new TreeSet<Cliente>();
   }
   
   /** 
   * Construtor de cópia que cria uma nova instância CatalogoClientes a partir de uma CatalogoClientes passado como parâmetro 
   **/
   public CatalogoClientes(Set<Cliente> catalogo)
   {
       this.catalogo = catalogo; 
   }
   
   /** 
   * Construtor que cria uma nova instância CatalogoCliente a partir de uma CatalogoCliente passado como parâmetro 
   **/
   public CatalogoClientes(CatalogoClientes c)
   {
       this.catalogo = c.getCatalogo(); 
   } 
   
   /**
   * Método que devolve o catalogo de Clientes
   * @returns Catalogo de produtos válidos
   **/
   public Set<Cliente> getCatalogo()
   {
       return new TreeSet<Cliente>(catalogo);
   }
   
   /**
   * Método que define o catalogo de Clientes
   * @param Catalogo de clientes válidos
   **/
   public void setCatalogo(Set<Cliente> cl)
   {
      this.catalogo.clear();
      for(Cliente c: cl){this.catalogo.add(c.clone());}
   }
   
   /** 
   * Método que cria uma cópia de uma identificação de um Cliente
   **/
   public CatalogoClientes clone(){return new CatalogoClientes(this);}
   
   /** 
   * Método que testa se um objeto é igual a uma determinada identificação
   * @param      Objeto a ser testado
   * @returns     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
   **/
   public boolean equals(Object o)
   {
      if(this == o) return true;
      if(o == null || this.getClass() != o.getClass()) return false;
      CatalogoClientes c  = (CatalogoClientes) o;     
      return this.catalogo.equals(c.getCatalogo());
   }
   
   /**
   * Método que converte uma identificação numa string
   * @returns  
   **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Catalogo de Clientes: \n").append(catalogo).append("\n");
       return sb.toString();
    }
   
   /**
   * Método que 
   **/ 
   public void addCliente(Cliente c)
   {
       catalogo.add(c);
   }
   
   public boolean containsCliente(String codigo)
   {  
       Cliente c = new Cliente(codigo);
       return catalogo.contains(c);
   }   
}
