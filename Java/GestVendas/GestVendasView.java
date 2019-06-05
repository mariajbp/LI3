import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import static java.lang.System.out;
import java.util.Iterator;
import java.awt.event.KeyEvent;
import java.util.Map; 


/**
* Classe que 
**/

public class GestVendasView implements Serializable, IGestVendasView 
{
   private Menu menu;
   
   public void init()
   {
        out.println("   ******   ********  ******  ******** **          **********  **    ** ********     ***     ******  ");
        out.println("  **    **  **       **    *    **      **        ** **        ***   ** **     **   ** **   **    ** ");
        out.println(" **         **       **         **       **       ** **        ****  ** **     **  **   **  **     ");  
        out.println(" **   ****  ******    ******    **        **     ** ******     ** ** ** **     ** **     **  ****** "); 
        out.println(" **     **  **             **   **         **   **  **         **  **** **     ** *********       ** ");
        out.println("  **    **  **       **    **   **          ** **   **         **   *** **     ** **     ** **    ** ");
        out.println("  ******   ********  ******     **           ***    ********   **    ** ********  **     **  ******  ");
   }
   
   /**
   * Método que define o menu
   **/
   public void setMenu(String[] s){menu = new Menu(s);}
   
   /**
   * Método que imprime o menu
   **/
   public int printMenu()
   {
       menu.exec();
       return menu.getOption();
   }
   
   /**
   * Método que printa a escolha de ficheiros
   **/
   public void outroFichOutputEscolha()
   {
     out.println("Indique o tipo de ficheiro que pretende ler: \n");
     out.println("1 - Clientes \n 2 - Produtos \n 3 - Vendas");  
   }
   
   /**
   * Método que printa a lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total.
   **/
   public void query1_Output(List<Produto> p)
   {      
       int i = 0;
       int pag = 1;
       int index = 0;
       int pos = 0;
       out.println("****************************** Página " + pag + "***************************************** \n");
       if(pag == 1)
       {
           Iterator<Produto> it = p.iterator();
           pos = index;
           while(it.hasNext() && pos < index + 15)
           {
               Produto pd = p.get(index);
               pd = it.next();
               out.println(pd.toString());
               pos ++;
           }
           index += 15;
       }
       out.println("Próxima página - 1 \n" + "Página anterior - 2 \n" + "Sair - 0 \n");
       Scanner input = new Scanner(System.in);
       int in = input.nextInt();
       while(in != 0)
       {
           if(in == 1)
           {
               pag++;
               Iterator<Produto> it = p.iterator();
               pos = index;
               while(it.hasNext() && pos < index + 15)
               {
                   Produto pd = p.get(index);
                   pd = it.next();
                   out.println(pd.toString());
                   pos ++; 
               }
               index += 15;
           }
           else if (in == 2)
           {
               pag--;
               Iterator<Produto> it = p.iterator();
               pos = index - 30;
               while(it.hasNext() && pos < index - 15)
               {
                   Produto pd = p.get(index);
                   pd = it.next();
                   pd.toString();
                   pos ++;
               }
               index += 15;
           }
       }
       out.println("Próxima página - 1 \n" + "Página anterior - 2 \n" + "Sair - 0 \n");
   }
        
   
   
   
   
   //Dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram; 
   //Fazer o mesmo mas para cada uma das filiais.
   public void query2_Input()
   {
       out.println("Insira o mês que pretende consultar: \n");
   }
   
   public void query2_Output(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2, Pair<Integer,Integer> p3, int tp, int tc)
   {
       out.println("*******************************************************************************");
       out.println("Filial 1" +"\t"+"\t"+ "Filial 2" +"\t"+"\t"+ "Filial 3" +"\t"+"\t" + "Total");
       out.println("*******************************************************************************");
       out.println("Vendas: "+ p1.getFst() + "\t"+ "\t"+"Vendas: "+ p2.getFst() +"\t"+ "\t" +"Vendas: "+ p3.getFst() +"\t"+ "\t" + tp + "\n");
       out.println("Clientes: " + p1.getSnd() +"\t"+ "\t"+ "Clientes: " + p2.getSnd() +"\t"+ "\t"+"Clientes: " + p3.getSnd() +"\t"+ "\t" + tc);
       out.println("*******************************************************************************");
   }
    
   //Dado um código de cliente, determinar, para cada mês, quantas compras fez, 
   //quantos produtos distintos comprou e quanto gastou no total.
   public void query3_Input()
   {
       out.println("Insira o código do cliente: \n");
   }
   
   public void query3_Output()
   {
   }
   
   //Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes e o total facturado.
   public void query4_Input()
   {
       out.println("Insira o código do produto: \n");
   }
   
   public void query4_Output(int i, Pair<Integer, Integer> p, double t)
   {
       out.println(i + "       \t" + p.getFst() + "             \t" +p.getSnd() + "                \t" + t );
    }
    
   public void query4_Output()
   {
       out.println("*******************************************************************************");
       out.println("Mês" +"\t" + "Nº Compras" +"\t"+ "Clientes Distintos" +"\t"+ "Total Faturado");
       out.println("*******************************************************************************");
   }
   
   //Dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem 
   //decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos.
   public void query5_Input()
   {
       out.println("Insira o código do cliente: \n");
   }
   
   public void query5_Output()
   {
   }
   
   //Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de 
   //distintos clientes que o compraram (X é um inteiro dado pelo utilizador).
   public void query6_Input()
   { 
      out.println("Insira o número de produtos que quer determinar: \n");  
   }
   
   public void query6_Output()
   {
       out.println("*******************************************************************************");
       out.println("Produtos" +"\t"+"\t"+ "Clientes" + "\n");
       out.println("*******************************************************************************");
   }
   
   public void query6_Output_Dados(Pair<Produto,Integer> p)
   {
       out.println("\t"+ p.getFst() + "\t" + p.getSnd() + "\n");
   }

   //Determinar, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado.
   public void query7_Output()
   {
   }

   //Determinar os códigos dos X clientes (sendo X dado pelo utilizador) que compraram mais produtos diferentes 
   //(não interessa a quantidade nem o valor), indicando quantos, sendo o critério de ordenação a ordem decrescente do número de produtos.
   public void query8_Input()
   {
      out.println("Insira o número de produtos que quer determinar: \n");  
   }
   
   
   public void query8_Output()
   {}
   
   // Dado o código  de um produto que deve existir, determinar o conjunto dos X clientes que mais o compraram e, para cada um, 
   //qual o valor gasto (ordenação cf. 5).
   public void query9_Inputp() //vai haver aqui um throw qualquer
   {
       out.println("Insira o código do produto: \n");
   }
   
   public void query9_Inputx()
   {
      out.println("Insira o número de clientes que quer determinar: \n");  
   }
   
   public void query9_Output()
   {
   }
   
   //Determinar mês a mês, e para cada mês filial a filial, a facturação total com cada produto.
   public void query10_Output(Map<Produto, List<Double>> c1, Map<Produto, List<Double>> c2, Map<Produto, List<Double>> c3)
   {
       out.println("*******************************************************************************");
       out.println("Mês" +"\t" +"\t" + "Filial 1" +"\t"+ "Filial 2" +"\t"+ "Filial 3");
       out.println("*******************************************************************************");
       //out.println("Janeiro" + )
   }
   
   
}