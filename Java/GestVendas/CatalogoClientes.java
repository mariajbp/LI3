import java.util.TreeSet; //ou hash later
import java.io.Serializable;
import java.io.*; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
* 
**/
public class CatalogoClientes implements ICatClientes, Serializable
{
   public TreeSet<String> catC; //ou hash
   private File file;
   private BufferedReader br;
    
   /*** Leitura do ficheiro para o treeset ***/
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
      System.out.println("Demorei: " + elapsedTime + " ms");
   }
  
   public CatalogoClientes(String fileName) throws IOException 
   {
        this.catC = new TreeSet<>();
        readFile("../Dados/Clientes.txt");
   }
    
   private void readFile(String fileName) throws IOException 
   {
      try 
      {
           br = new BufferedReader(new FileReader(fileName));
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               catC.add(line);
               System.out.println(line);
           }
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
   }
   
   /*** Validar os codigos ***/
   public boolean validateC(String c)
   {
       String fstLetter;
       
       
   }
}
