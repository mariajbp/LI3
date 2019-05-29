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
* 
**/
public class CatalogoClientes implements ICatClientes, Serializable
{
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
   * @return Catalogo de produtos válidos
   **/
   public Set<Cliente> getCatalogo()
   {
     Set<Cliente> cl = new TreeSet<Cliente>();
     for(Cliente c: this.catalogo){cl.add(c.clone());}
     return cl;
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
   * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
   **/
   public boolean equals(Object o)
   {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      CatalogoClientes c  = (CatalogoClientes) o;     
      return this.catalogo.equals(c.getCatalogo());
   }
   
   /**
   * Método que converte uma identificação numa string
   * @return  
   **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Catalogo de Clientes: \n").append(catalogo).append("\n");
       return sb.toString();
    }
   
   
   
   /**
   public CatalogoClientes(String fileName) throws IOException  
   {
        this.cclient = new TreeSet<>();
        readFile("../Dados/Clientes.txt");
   }
   
   /** 
   **  Faz load do ficheiro no TreeSet 
   **  Retorna o número de codigos válidos
  
   private void readFile(String fileName) throws IOException 
   {
      int v = 0;
      try 
      {
           br = new BufferedReader(new FileReader(fileName));
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               if(validateC(line))
               {
                   fillT(line);
                   v++;
               }
           }
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
      out.println(v + " Clientes Validos");
   }
   
   /**Validação do Codigo 
   public boolean validateClient(String c)
   {
       boolean v = true;
       String[] part = c.split("(?<=\\D)(?=\\d)");
       boolean isNumeric = false;
       if(part[1].chars().allMatch(Character::isDigit) && Integer.parseInt(part[1]) > 1000 && Integer.parseInt(part[1]) < 5000) {isNumeric = true;}   
       char fst = c.charAt(0);
       if(c.length() == 5 && Character.isLetter(fst) && isNumeric) {v = true;}
       return v;      
   }
   
   /** Adiciona um código ao TreeSet 
   private void fillT(String line) 
   {
      cclient.add(line); 
   }
        
   /** Procurar um Cliente 
   private boolean isItThereC(String c)
   {
       Iterator<String> it = this.cclient.iterator();
       String s = null;
       boolean v = false;
       while(it.hasNext() && v == false)
       {
         s = it.next();
         if (s.equals(c))
         {
             v = true;
         }
         else v = false;
       }
       return v;
   } **/ 
}
