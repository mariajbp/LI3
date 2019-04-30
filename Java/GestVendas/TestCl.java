import java.io.*; 
import java.util.TreeSet; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List; 

/**
public class TestCl
{
    private TreeSet<String> cod;
    private File file;
    private BufferedReader br;
    
  public static void main(String[] args)throws IOException
  { 
      long startTime = System.currentTimeMillis();
      TestCl test = new TestCl("../Dados/Clientes.txt");
     
      long total = 0;
      for (int i = 0; i < 10000000; i++) {
         total += i;
      }

      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("Demorei: " + elapsedTime);
   }
  

  public TestCl(String fileName) throws IOException 
  {
    this.cod = new TreeSet<>();
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
               cod.add(line);
               System.out.println(line);
           }
      }
       catch (IOException e) {e.printStackTrace();} finally {br.close();} 
  }
  }
    
  **/
