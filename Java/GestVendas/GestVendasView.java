import java.io.Serializable;
import java.io.*; 
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import static java.lang.System.out;

/**
* 
**/
public class GestVendasView implements Serializable
{
   private static Menu menu;
   private GestVendasModel gvm;
   
   /** 
   * Método que inicia a aplicação no menu principal 
   **/
   public void run()
   {
       int op = 0;
       do{
           menu.exec();
           op = menu.getOption(); 
           /**
           switch(op)
           {
               case 1: query1();
                       break;
               case 2: query2();
                       break;
               case 3: query3();
                       break;     
           } **/
       }
       while(op != 0);
       
       try
       {
           gvm.writeToTxt("gestVendas");
           gvm.saveStatus("gestVendas");
       }
       catch(FileNotFoundException e){out.println(e.getMessage());}
       catch(IOException e){out.println(e.getMessage());}
   }
}