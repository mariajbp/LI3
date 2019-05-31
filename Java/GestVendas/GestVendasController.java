import java.io.Serializable;

/**
* 
**/
public class GestVendasController  implements Serializable, IGestVendasController
{
   private GestVendasModel model; //mudar para interface
   private GestVendasView view; //mudar para interface
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
   
   /** 
   * Método que inicia o menu de queries 
   **/
   public void queryMenu()
   {
       String s[] = {"Query 1", "Query 2", "Query 3", "Query 4", "Query 5", "Query 6", "Query 7", "Query 8", "Query 9",
                     "Query 10"};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           
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
   
   public void query1()
   {
       //model.prodsNuncaComprados(cp,ft); ??
       view.query1_Output();
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
        //..
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
        //..
        view.query10_Output();
    } 
    
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
