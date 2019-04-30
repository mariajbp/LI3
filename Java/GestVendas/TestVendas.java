import java.io.*; 
import java.util.TreeSet; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List; 

public class TestVendas
{
    private TreeSet<String> cod;
    private File file;
    private BufferedReader br;
    
  public static void main(String[] args)throws IOException
  { 
      TestProd test = new TestProd("../Dados/Vendas_1M.txt");

  } 

  public TestProd(String fileName) throws IOException 
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
               String[] array = line.split(" ");
               for (String a : array) 
                {
                    cod.add(a);
                    System.out.println(a);
                }
           }
      } catch (IOException e) {e.printStackTrace();} finally {br.close();}
  }
    
  
}

**/