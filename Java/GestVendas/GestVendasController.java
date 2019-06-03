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
   private IGestVendasModel model; 
   private IGestVendasView view; 
   
   /**
    * Método que faz set de um model
    * @param GestVendasModel
    */
   public void setModel(IGestVendasModel model){
       this.model = model;
    }
   
   /**
    * Método que faz set de uma view
    * @param GestVendasView
    */
   public void setView(IGestVendasView view){
        this.view = view;
    }
    
   /** 
   * Método que inicia o menu principal 
   **/
   public void mainMenu()
   {
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
   
   public void carregamentoDefault(){
       model.carregamentoDefault();
       queryORestatisticasMenu();
    }
    
   public void outroFicheiro()
   {
       view.outroFichOutputEscolha();
       Scanner input = new Scanner(System.in);
       int op = input.nextInt();
       try {
           model.outroFicheiro(op);
           queryORestatisticasMenu();
        } catch (IOException e) {e.printStackTrace();}
   }
   
   public void loadStatus(){
      try{
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
           } 
       }
       while(op != 0);
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
       String s[] = {};
       
       int op = 0;
       do
       {
           view.setMenu(s);
           op = view.printMenu();
           switch(op)
           {
               case 1: stat1();
                       break;
               case 2: stat2();
                       break;
               case 3: stat3();
                       break;
           } 
       }
       while(op != 0);
    }
    
   public void saveStatus(){
    try{model.saveStatus("Gravacao");}
    catch(IOException e){e.printStackTrace();};
    }
    
   public void query1()
   {
       List<Produto> p = model.prodsNuncaComprados(); 
       view.query1_Output(p, p.size());
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
       //..
       view.query2_Output();
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
        String s = input.nextLine(); //fazer o cast para cliente
        //..
        view.query3_Output();
    } 
    
    /**
    * Query 4: Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes 
    * e o total facturado.
    * 
    * @param 
    * @returns
    * 
    * METADE VEM DA FATURACAO
    **/ 
    public void query4()
    {
        view.query4_Input();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        //fazer o cast para produto
        //totalFaturado(p,1);
        //totalFaturado(p,2);
        //totalFaturado(p,3);
        view.query4_Output();
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
        String s = input.nextLine(); //fazer o cast para cliente
        //..
        view.query5_Output();
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
        
        //..
        view.query6_Output();
    } 
    
    /**
    * Query 7: Determinar, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado.
    * 
    * @param 
    * @returns
    **/
    public void query7()
    {
        //..
        view.query7_Output();
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
        //..
        view.query8_Output();
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
        String s = input.nextLine(); //fazer o cast para produto
        //..
        view.query9_Output();
    } 
    
    /**
    * Query 10:  Determinar mês a mês, e para cada mês filial a filial, a facturação total com cada produto.
    * 
    * @param 
    * @returns
    **/
    public void query10()
    {
        model.ftrTotal(1);
        model.ftrTotal(2);
        model.ftrTotal(3);
        view.query10_Output();
    } 
    
    public void stat1()
    {
    }
    
    public void stat2()
    {
    }
    
    public void stat3()
    {
    }
    
}
