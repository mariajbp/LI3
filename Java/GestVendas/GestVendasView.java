import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import static java.lang.System.out;

/**
* Classe que 
**/

public class GestVendasView implements Serializable, IGestVendasView
{
   private Menu menu;
   
   /** 
   * Método que inicia o menu principal 
   **/
   public void mainMenu()
   {
       int op = 0;
       do{
           menu.exec();
           op = menu.getOption();
           /**
           switch(op)
           {
               case 1: carregamentoDefault();
                       break;
               case 2: outroFicheiro();
                       break;
               case 3: ultimaGravacao();
                       break;     
           } **/
       }
       while(op != 0);
   }
   
   /** 
   * Método que inicia o menu de queries e estatisticas interativas 
   **/
   public void queryMenu()
   {
       String s[] = {"Query 1", "Query 2", "Query 3"};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
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
   }
}