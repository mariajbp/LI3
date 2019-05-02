import java.util.TreeSet; //ou hash later
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
   public TreeSet<String> cclient; //ou hash
   private File file;
   private BufferedReader br;
    
   /**Main da coisa que é para sair no fim
   public static void main(String[] args)throws IOException
   { 
      long startTime = System.currentTimeMillis();
      CatalogoClientes test = new CatalogoClientes("../Dados/Clientes.txt");
      long total = 0;
      for (int i = 0; i < 10000000; i++) 
      {
         total += i;
      }
      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      out.println("Demorei: " + elapsedTime + " ms");
   }
   **/
   
   
   public CatalogoClientes()
    {
        this.cclient = new TreeSet<String>();
    }
   
   public CatalogoClientes(TreeSet<String> cprod)
   {
       this.cclient = cprod; 
   }
    
   public TreeSet<String> getCclientes() throws NoClientesException //needed???
   {
        if(this.cclient.isEmpty()) throw new NoClientesException("Não existem códigos disponiveis");
        else return this.cclient;
   }
   
   public CatalogoClientes(String fileName) throws IOException  
   {
        this.cclient = new TreeSet<>();
        readFile("../Dados/Clientes.txt");
   }
   
   /** 
   **  Faz load do ficheiro no TreeSet 
   **  Retorna o número de codigos válidos
   **/
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
   
   /**Validação do Codigo **/
   public boolean validateC(String c)
   {
       boolean v = true;
       String[] part = c.split("(?<=\\D)(?=\\d)");
       boolean isNumeric = part[1].chars().allMatch(Character::isDigit);
       char fst = c.charAt(0);
       if(c.length() == 5 && Character.isLetter(fst) && isNumeric) {v = true;}
       return v;      
   }
   
   /** Adiciona um código ao TreeSet **/
   private void fillT(String line) 
   {
      cclient.add(line); 
   }
        
   /** Procurar um Cliente **/
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
   }
   
   
 
   
}
