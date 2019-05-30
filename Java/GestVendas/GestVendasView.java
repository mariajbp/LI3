import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import static java.lang.System.out;
import java.awt.event.KeyEvent; 


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
   public void queryORestatisticasMenu()
   {
       String s[] = {"Consultar Queries", "Consultar Estatisticas"};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           switch(op)
           {
               case 1: queryMenu();
                       break;
               case 2: estatisticasMenu();
           } 
       }
       while(op != 0);
   }
   
   public void outroFicheiro()
   {
       Scanner input = new Scanner(System.in);
       int op;
       String filename;
       out.println("Indique o tipo de ficheiro que pretende ler: \n");
       out.println("1 - Clientes \n 2 - Produtos \n 3 - Vendas");
       op = input.nextInt();
       out.println("Indique o nome do ficheiro a ler: \n");
       filename = input.nextLine();
       if(op == 1)
       {
          //clientes 
       }
       if(op == 2)
       {
           //produtos
       }
       if(op == 3)
       {
           //vendas
       }
       input.close();
   }
   
   /** 
   * Método que inicia o menu de queries 
   **/
   public void queryMenu()
   {
       String s[] = {"Query 1", "Query 2", "Query 3", "Query 4", "Query 5", "Query 6", "Query 7", "Query 8", "Query 9",
                     "Query 10", "Query 11", "Query 12"};
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
               case 4: query4();
                       break;
           } **/
       }
       while(op != 0);
   }
   
   public void query1()
   {}
   
   public void query2()
   {}
   
   public void query3()
   {}
   
   public void query4()
   {}
   
   public void query5()
   {}
   
   public void query6()
   {}
   
   public void query7()
   {}
   
   public void query8()
   {}
   
   public void query9()
   {}
   
   public void query10()
   {}
   
   public void query11()
   {}
   
   public void query12()
   {}
   
   /** 
   * Método que inicia o menu de queries e estatisticas interativas 
   **/
   public void estatisticasMenu()
   {
       String s[] = {};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           /**
           switch(op)
           {
               case 1: comprasPorMes();
                       break;
               case 2: 
                       break;
               case 3: 
                       break;
           } **/
       }
       while(op != 0);
   }
   
   public void comprasPorMes(){}
   
   public void navegador()
   {
       
   }
   
   public void keyPressed (KeyEvent e) 
   {
        int c = e.getKeyCode (); 
        if(c==KeyEvent.VK_LEFT) {} 
        else if(c==KeyEvent.VK_RIGHT) {}

    }
}