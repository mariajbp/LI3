import java.io.*; 
import java.util.TreeSet; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestVendas
{
    private TreeSet<String> cod;
    private File file;
    private BufferedReader br;
    
  public static void main(String[] args)throws IOException
  { 
      long startTime = System.currentTimeMillis();
      TestVendas test = new TestVendas("../Dados/Vendas_1M.txt");
     
      long total = 0;
      for (int i = 0; i < 10000000; i++) 
      {
         total += i;
      }

      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("Demorei: " + elapsedTime);
   }
  

  public TestVendas(String fileName) throws IOException 
  {
    this.cod = new TreeSet<>();
    readFile("../Dados/Vendas_1M.txt");
  }
    
  private void readFile(String fileName) throws IOException 
  {
      try 
      {
           br = new BufferedReader(new FileReader(fileName));
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               String[] array = line.trim().split("\n,  ");
               for(String a : array)
               {
                   cod.add(a);
                   System.out.println(Arrays.toString(array));
               } 
           }  
      }catch (IOException e) {e.printStackTrace();} 
      finally {br.close();}
   }   
}
    
 


