import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import static java.lang.System.out;
import java.util.Iterator;
import java.util.Map; 
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Set;
import java.util.Collection;


/**
* Classe que 
**/

public class GestVendasView implements Serializable, IGestVendasView  
{
   /** Instancia da classe Menu **/
   private Menu menu;
   
   /** Variavél que permite truncar um double para duas casas decimais **/
   private static DecimalFormat df = new DecimalFormat("#.##");
   
   /** Método que imprimir o header inicial da aplicação **/
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
   * Método que imprime a escolha de ficheiros
   **/
   public void outroFichOutputEscolha()
   {
     out.println("Indique o tipo de ficheiro que pretende ler: ");
     out.println("1 - Clientes \n2 - Produtos \n3 - Vendas");  
   }
   
   /**
   * Método que imprime uma mensagem de suceso na gravação de dados
   **/
   public void saveMessage()
   {
       out.println("Gravado com sucesso!");
   }
    
   /**
   * Método que imprime a lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total, através um navegador
   **/
   public void query1_Output(List<Produto> p)
   {      
       int i = 0;
       int pag = 1;
       int index = 0;
       int pos = 0;
       out.println("****************************** Página " + pag + " ***************************************** \n");
       
       Iterator<Produto> it = p.iterator();
       pos = index;
       while(it.hasNext() && pos <= index + 35)
       {
          Produto pd = p.get(index);
          pd = it.next();
          out.println(pd.toString());
          pos ++;
       }
       index += 35;
      
       out.println("\n1 - Próxima página" + "\t"+ "2 - Página anterior" + "\t"+ "0 - Sair\n"); 
       Scanner input = new Scanner(System.in);
       int in = input.nextInt();
       
       while(in != 0)
       { 
           if(in == 1)
           {
               pag++; 
               if(pag > 0)
               {
                   out.println("****************************** Página " + pag + " ***************************************** \n");
                   
                   while(pos <= p.size() && pos <= (index + 35))
                   {
                       Produto pd = p.get(pos);
                       out.println(pd.toString());
                       pos ++; 
                   }
                   index += 35;
                   out.println("\n1 - Próxima página" + "\t"+ "2 - Página anterior" + "\t"+ "0 - Sair\n"); 
                   in = input.nextInt();
                }
                else
                    break;
           }
           else if(in == 2)
           {
               pag--;  
               if(pag > 0 && pos > 0)
               {
                   out.println("****************************** Página " + pag + " ***************************************** \n");
                   pos -= 70;
                   index -= 70;
                   while(pos <= p.size() && pos <= (index + 35) && pos > 0)
                   {
                       Produto pd = p.get(pos);
                       out.println(pd.toString());
                       pos ++; 
                   }
                   index += 35;
                   out.println("\n1 - Próxima página" + "\t"+ "2 - Página anterior" + "\t"+ "0 - Sair\n"); 
                   in = input.nextInt();
                }
                else 
                    break;
           }
       }
   }
        
   /**
   * Método que imprime um pedido de input
   **/
   public void query2_Input()
   {
       out.println("Insira o mês que pretende consultar: \n");
   }
   
   /**
   * Método que dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram 
   **/
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
   /**
   * Método que imprime um pedido de input
   **/
   public void query3_Input()
   {
       out.println("Insira o código do cliente: \n");
   }
   
   /**
   * Método que imprime para cada mês, quantas compras fez determinado cliente fez, quantos produtos distintos comprou e quanto gastou no total.
   **/
   public void query3_Output()
   {
       out.println("*******************************************************************************");
       out.println("Mês " + "\t"+ "\tCompras  " + "\t"+ "Produtos  " + "\t"+  "Total Gasto" );
       out.println("*******************************************************************************");
    }
   
   /**
   * Método que imprime para cada mês, quantas compras fez determinado cliente fez, quantos produtos distintos comprou e quanto gastou no total.
   **/
   public void query3_Output(int c, double t, int p, int mes)
   {
       out.println( mes + "\t"+"\t"+ c + "\t"+"\t" + p + "\t"+ "\t" + df.format(t));
       out.println("*******************************************************************************");
   }
   
   /**
   * Método que imprime um pedido de input
   **/
   public void query4_Input()
   {
       out.println("Insira o código do produto: \n");
   }
   
   /**
   * Método que imprime mês a mês, quantas vezes foi comprado um produto fou comprado, por quantos clientes diferentes e o total facturado. 
   **/
   public void query4_Output(int i, Pair<Integer, Integer> p, double t)
   {
       out.println(i  +"\t" +"\t" +  p.getFst() +"\t" +"\t"+p.getSnd() +"\t" +"\t" + df.format(t));
       out.println("*******************************************************************************");
   }
   
   /**
   * Método que imprime mês a mês, quantas vezes foi comprado um produto fou comprado, por quantos clientes diferentes e o total facturado. 
   **/ 
   public void query4_Output()
   {
       out.println("*******************************************************************************");
       out.println("Mês" +"\t" + "Nº Compras" +"\t"+ "Clientes Distintos" +"\t"+ "Total Faturado");
       out.println("*******************************************************************************");
   }
   
  
   /**
   * Método que imprime um pedido de input
   **/
   public void query5_Input()
   {
       out.println("Insira o código do cliente: \n");
   } 
   
   /**
   * Método que imprime  a lista de códigos de produtos que um cliente mais comprou
   **/
   public void query5_Output(List<Pair<Produto,Integer>> l)
   {
       out.println("*******************************************************************************\n");
       Pair<Produto,Integer> p = new Pair();
       Iterator<Pair<Produto,Integer>> it = l.iterator();
       while(it.hasNext())
       {
           p = it.next();
           out.println(p.getFst().toString() + "\t" + "\t" + "Quantidade: " + p.getSnd() + "\n");
       }
       out.println("*******************************************************************************");
   }
   
   //Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de 
   //distintos clientes que o compraram (X é um inteiro dado pelo utilizador).
   /**
   * Método que imprime um pedido de input
   **/
   public void query6_Input()
   { 
      out.println("Insira o número de produtos que quer determinar: \n");  
   }
   
   /**
   * Método que imprime o conjunto dos X produtos mais vendidos em todo o ano e o número total de distintos clientes que o compraram  
   **/
   public void query6_Output_Dados(List<Pair<Produto,Integer>> l)
   {
       out.println("******************************************************************************* \n");
       Pair<Produto,Integer> p = new Pair();
       Iterator<Pair<Produto,Integer>> it = l.iterator();
       while(it.hasNext())
       {
           p = it.next();
           out.println(p.getFst().toString() + "\t" + "\t" + " Número de clientes: " + p.getSnd() + "\n");
       }
       out.println("*******************************************************************************");       
   }
 
   /**
   * Método que imprime para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado. 
   **/
   public void query7_Output(List<Cliente> c1 , List<Cliente> c2, List<Cliente> c3)
   {
       out.println("*******************************************************************************\n");
       out.println("Filial 1" +"\t"+"\t"+ c1+"\n");
       out.println("Filial 2" +"\t"+"\t"+ c2+"\n");
       out.println("Filial 3" +"\t"+"\t"+ c3+"\n");
       out.println("*******************************************************************************");
   }

   /**
   * Método que imprime um pedido de input
   **/
   public void query8_Input()
   {
      out.println("Insira o número de clientes que quer determinar: \n");  
   }
    
   /**
   * Método que imprime os códigos dos X clientes que compraram mais produtos diferentes e indica quantos
   **/
   public void query8_Output( List<Pair<Cliente,Integer>> c1)
   {
       out.println("*******************************************************************************\n");
       Pair<Cliente, Integer> p = new Pair();
       Iterator<Pair<Cliente, Integer>> it = c1.iterator();
       while(it.hasNext())
       {
           p = it.next();
           out.println(p.getFst().toString() + "\t" + "\t" + "Valor gasto: " + df.format(p.getSnd()) + "\n");
       }
       out.println("*******************************************************************************");
   }
   
   /**
   * Método que imprime um pedido de input
   **/
   public void query9_Inputp()
   {
       out.println("Insira o código do produto: \n");
   }
   
   /**
   * Método que imprime um pedido de input
   **/
   public void query9_Inputx()
   {
      out.println("Insira o número de clientes que quer determinar: \n");  
   }
   
   /**
   * Método que imprime o conjunto dos X clientes que mais o compraram um produto e, para cada um, qual o valor gasto
   **/
   public void query9_Output(List<Pair<Cliente, Integer>> gasto)
   {
       out.println("*******************************************************************************\n");
       Pair<Cliente, Integer> p = new Pair();
       Iterator<Pair<Cliente, Integer>> it = gasto.iterator();
       while(it.hasNext())
       {
           p = it.next();
           out.println(p.getFst().toString() + "\t" + "\t" + "Valor gasto: " + df.format(p.getSnd()) + "\n");
       }
       out.println("*******************************************************************************");
   }
    
   /**
   * Método que imprime  mês a mês, e para cada mês filial a filial, a facturação total com cada produto
   **/
   public void query10_Output(Map<Produto, List<Double>> c1, Map<Produto, List<Double>> c2, Map<Produto, List<Double>> c3)
   {
       out.println("*******************************************************************************");
       out.println("Filial 1");
       out.println("*******************************************************************************");
       for(Map.Entry<Produto, List<Double>> e : c1.entrySet())
       {
           out.println("\t"+"\t"+ e.getKey().toString() + df.format(e.getValue()) );
       }
       out.println("*******************************************************************************");
       out.println("Filial 2");
       out.println("*******************************************************************************");
       for(Map.Entry<Produto, List<Double>> e : c2.entrySet())
       {
           out.println("\t"+"\t"+ e.getKey().toString() + df.format(e.getValue()) );
       }
       out.println("*******************************************************************************");
       out.println("Filial 3");
       out.println("*******************************************************************************");
       for(Map.Entry<Produto, List<Double>> e : c3.entrySet())
       {
           out.println("\t"+"\t"+ e.getKey().toString() + df.format(e.getValue()) );
       }
   }
    
   /**
   * Método que imprime as estatisticas
   **/
   public void printStats(Estatisticas e)
   {
      out.println(e.toString());
   }
   
   /**
   * Método que imprime o tempo que o programa demourou a correr, em segundos
   **/
   public void time(double t) {out.println("\nTempo demorado: " + df.format(t) + " segundos"); }
}
