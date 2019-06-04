import java.io.Serializable;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;

/**
* 
**/
public class GestVendasController  implements Serializable, IGestVendasController
{
   /** Instancia da interface model **/
   private IGestVendasModel model; 
   
   /** Instancia da interface view **/
   private IGestVendasView view; 
   
   /** Instancia da classe crono **/
   private Crono crono;
   
   /**
   * Método que define uma instancia da interface IGestVendasModel
   * @param   GestVendasModel
   **/
   public void setModel(IGestVendasModel model){this.model = model;}
   
   /**
   * Método que define uma instancia da interface IGestVendasView
   * @param GestVendasView
   **/
   public void setView(IGestVendasView view){this.view = view;}
    
   /** 
   * Método que inicia o menu principal 
   **/
   public void mainMenu()
   {
       view.init(); 
       String s[] = { "Carregar ficheiros default", "Carregar outro ficheiro", "Carregar ultima gravação"};
       int op = 0;
       do
       {
           view.setMenu(s);
           op = view.printMenu();
           switch(op)
           {
               case 1: carregamentoDefault();
                       break;
               case 2: outroFicheiro();
                       break;
               case 3: loadStatus();
                       break;     
           } 
       }
       while(op != 0);
   }
   
   /**
   * Método que carrega o ficheiro de dados default da aplicação
   **/
   public void carregamentoDefault()
   {
       model.carregamentoDefault();
       queryORestatisticasMenu();
   }
   
   /**
   * Método que carrega outro ficheiro dado pelo utilizador
   **/
   public void outroFicheiro()
   {
       view.outroFichOutputEscolha();
       Scanner input = new Scanner(System.in);
       int op = input.nextInt();
       try 
       {
           model.outroFicheiro(op);
           queryORestatisticasMenu();
       } catch (IOException e) {e.printStackTrace();}
   }
   
   /**
   * Método que carrega o ficheiro de dados da ultima gravação
   **/
   public void loadStatus()
   {
      try
      {
              IGestVendasModel gvm = model.loadStatus("Gravacao");
              setModel(gvm);
              queryORestatisticasMenu();
      } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
   }
    
   /** 
   * Método que inicia o menu de queries e estatisticas interativas 
   **/
   public void queryORestatisticasMenu()
   {
       String s[] = {"Consultar Queries", "Consultar Estatisticas", "Gravar Estado"};
       int op = 0;
       do
       {
           view.setMenu(s);
           op = view.printMenu();
           switch(op)
           {
               case 1: queryMenu();
                       break;
               case 2: estatisticasMenu();
                       break;
               case 3: saveStatus();
                       break;
           } 
       }
       while(op != 0);
   }
   
   /** 
   * Método que grava o estado atual do ficheiro
   **/
   public void saveStatus()
   {
       try{model.saveStatus("Gravacao");}
       catch(IOException e){e.printStackTrace();};
   }
   
   /** 
   * Método que inicia o menu de queries 
   **/
   public void queryMenu()
   {
       String s[] = {"Query 1", "Query 2", "Query 3", "Query 4", "Query 5", "Query 6", "Query 7", "Query 8", "Query 9",
                     "Query 10"};
       int op = 0;
       do
       {   view.setMenu(s);
           op = view.printMenu();
           
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
               case 5: query5();
                       break;
               case 6: query6();
                       break;
               case 7: query7();
                       break;
               case 8: query8();
                       break;
               case 9: query9();
                       break;
               case 10: query10();
                       break;
           } 
       }
       while(op != 0);
   }
   
   /** 
   * Método que inicia o menu de estatisticas interativas 
   **/
   public void estatisticasMenu()
   {
       String s[] = {"Ultimo ficheiro de vendas lido", "Número total de compras por mês", "Faturação total por mês", "Número distinto de clientes que fizeram compras em cada mês"};
       
       int op = 0;
       do
       {
           view.setMenu(s);
           op = view.printMenu();
           switch(op)
           {
               case 1: ultimoFichLido();
                       break;
               case 2: stat1();
                       break;
               case 3: stat2();
                       break;
               case 4: stat3();
                       break;
           } 
       }
       while(op != 0);
   }
   
   
   /** Query 1 **/ 
   public void query1()
   {
       crono.start();
       List<Produto> p = model.prodsNuncaComprados(); 
       view.query1_Output(p, p.size());
       crono.stop(); 
       crono.print(); 
   }
   
   /** 
   * Query 2:  Dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram; 
   * Fazer o mesmo mas para cada uma das filiais.
   * 
   * @param 
   * @returns
   **/
   public void query2()
   {
       view.query2_Input();
       Scanner input = new Scanner(System.in);
       int mes = input.nextInt();
       crono.start();
       //...
       view.query2_Output();
       crono.stop(); 
       crono.print();
   }
    
    /** 
    * Query 3: Dado um código de cliente, determinar, para cada mês, quantas compras fez, 
    * quantos produtos distintos comprou e quanto gastou no total.
    * 
    * @param 
    * @returns
    **/
    public void query3()
    {
        view.query3_Input();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        Cliente c = new Cliente(s);
        crono.start();
        //..
        view.query3_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /**
    * Query 4: Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes 
    * e o total facturado.
    * @param 
    * @returns
    **/ 
    public void query4()
    {
        view.query4_Input();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        Produto p = new Produto(s);
        Pair<Integer, Integer> pair = new Pair<>();
        view.query4_Output();
        crono.start();
        for(int i = 1; i <= 12; i++) 
        {
            pair = model.comprasPorMes(p, i);
            double t = model.faturadoPorMes(p, i);
            view.query4_Output(i, pair, t);
        }
        
        view.query4_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /** 
    * Query 5: Dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem 
    * decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos.
    * 
    * @param 
    * @returns
    **/    
    public void query5()
    {
        view.query5_Input();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        Cliente c = new Cliente(s);
        crono.start();
        //model....
        view.query5_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /**
    * Query 6: Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de 
    * distintos clientes que o compraram (X é um inteiro dado pelo utilizador).
    * 
    * @param 
    * @returns
    **/
    public void query6()
    {
        view.query6_Input();
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        crono.start();
        //..
        view.query6_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /**
    * Query 7: Determinar, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado.
    * 
    * @param 
    * @returns
    **/
    public void query7()
    {
        crono.start();
        //..
        view.query7_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /**
    * Query 8: Determinar os códigos dos X clientes (sendo X dado pelo utilizador) que compraram mais produtos diferentes 
    * (não interessa a quantidade nem o valor), indicando quantos, sendo o critério de ordenação a ordem decrescente do número de produtos.
    * 
    * @param 
    * @returns
    **/
    public void query8()
    {
        view.query8_Input();
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        crono.start();
        //..
        view.query8_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /**
    * Query 9: Dado o código de um produto que deve existir, determinar o conjunto dos X clientes que mais o compraram e, para cada um, 
    * qual o valor gasto (ordenação cf. 5).
    * 
    * @param 
    * @returns
    **/
    public void query9()
    {
        view.query9_Input();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        Produto p = new Produto(s);
        crono.start();
        //..
        view.query9_Output();
        crono.stop(); 
        crono.print();
    } 
    
    /**
    * Query 10:  Determinar mês a mês, e para cada mês filial a filial, a facturação total com cada produto.
    * 
    * @param 
    * @returns
    **/
    public void query10()
    {
        crono.start();
        model.ftrTotal(1);
        model.ftrTotal(2);
        model.ftrTotal(3);
        view.query10_Output();
        crono.stop(); 
        crono.print();
    } 
    
    public void ultimoFichLido()
    {
        crono.start();
        //..
        crono.stop(); 
        crono.print();
    }
    
    public void stat1()
    {
        crono.start();
        //...
        crono.stop(); 
        crono.print();
    }
    
    public void stat2()
    {
        crono.start();
        //..
        crono.stop(); 
        crono.print();
    }
    
    public void stat3()
    {
        crono.start();
        //...
        crono.stop(); 
        crono.print();
    }
    
}
