
import java.util.TreeSet; //ou hash later
import java.io.Serializable;
import java.io.*; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;

import java.util.*;

/**
* 
**/

public class CatalogoProdutos implements ICatProdutos, Serializable
{
   public TreeSet<String> cprod; //ou hash
   private File file;
   private BufferedReader br;
   
   
   /**Main da coisa que é para sair no fim
   public static void main(String[] args)throws IOException
   { 
      long startTime = System.currentTimeMillis();
      CatalogoProdutos test = new CatalogoProdutos("../Dados/Produtos.txt");
      long total = 0;
      for (int i = 0; i < 10000000; i++) 
      {
         total += i;
      }
      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println("Demorei: " + elapsedTime + " ms");
   }
   **/
   
   public CatalogoProdutos()
   {
        this.cprod = new TreeSet<String>();
   }

   public CatalogoProdutos(TreeSet<String> cprod)
   {
       this.cprod = cprod; 
   }
   
   /**
   public CatalogoProdutos(CatalogoProdutos cp)
   {
       this.cprod = cp.getCProd(); 
   }
    
   public TreeSet<String> getCProd() 
   {
       Set<CatalogoProdutos> aux = new TreeSet<CatalogoProdutos>();
       for(CatalogoProdutos cp: this.cprod){aux.add(cp.clone());}
       return aux;
   }
   **/
   public CatalogoProdutos(String fileName) throws IOException  
   {
        this.cprod = new TreeSet<>();
        readFile("../Dados/Produtos.txt");
   }
    
   /** 
   **  Faz load do ficheiro no TreeSet 
   **  Retorna o número de codigos válidos
   **/
   private int readFile(String fileName) throws IOException 
   {
      int v = 0; //válidos
      try 
      {
           br = new BufferedReader(new FileReader(fileName));
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               if(validateP(line))
               {
                   cprod.add(line); 
                   v++;
               }
           }
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
      return v;
   }
   
   /**Validação do Codigo **/
   public boolean validateP(String c)
   {
       boolean v = true;
       String[] part = c.split("(?<=\\D)(?=\\d)");
       boolean isNumeric = false;
       if(part[1].chars().allMatch(Character::isDigit) && Integer.parseInt(part[1]) > 1000 && Integer.parseInt(part[1]) < 9999) {isNumeric = true;}       
       char fst = c.charAt(0);
       char snd = c.charAt(2);
       if(c.length() == 6 && Character.isLetter(fst) && Character.isLetter(snd) && isNumeric) {v = true;}
       return v;      
   }
 
   
   /** Procurar um Produto **/
   public boolean isItThereP(String c)
   {
       Iterator<String> it = this.cprod.iterator();
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
   
   public CatalogoProdutos clone()
   {
        return new CatalogoProdutos(this);
   }
}
