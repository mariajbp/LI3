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
   
   public void init()
   {
        out.println("   ######   ########  ######  ######## ##          ##########  ##    ## ########     ###     ######  ");
        out.println("  ##    ##  ##       ##    #    ##      ##        ## ##        ###   ## ##     ##   ## ##   ##    ## ");
        out.println(" ##         ##       ##         ##       ##       ## ##        ####  ## ##     ##  ##   ##  ##     ");  
        out.println(" ##   ####  ######    ######    ##        ##     ## ######     ## ## ## ##     ## ##     ##  ###### "); 
        out.println(" ##     ##  ##             ##   ##         ##   ##  ##         ##  #### ##     ## #########       ## ");
        out.println("  ##    ##  ##       ##    ##   ##          ## ##   ##         ##   ### ##     ## ##     ## ##    ## ");
        out.println("  ######   ########  ######     ##           ###    ########   ##    ## ########  ##     ##  ######  ");
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
   public void query1_Output(List<Produto> p, int i)
   {      
       for(Produto pr: p)
            out.println(pr.toString());
       out.println(i);
   }
   
   //Dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram; 
   //Fazer o mesmo mas para cada uma das filiais.
   public void query2_Input()
   {
       out.println("Insira o mês que pretende consultar: \n");
   }
   
   public void query2_Output()
   {
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
       out.println(i + " \t" + p.getFst() + " \t" +p.getSnd() + " \t" + t + "\n");
    }
    
   public void query4_Output()
   {
       out.println("Mês |  Comprados |  Clientes | Total \n") ;
       
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
      out.println("Insira o númerode produtos que quer determinar: \n");  
   }
   
   public void query6_Output()
   {
       out.println("| Produtos |  Número de clientes | \n") ;
       
   }

   //Determinar, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado.
   public void query7_Output()
   {
   }

   //Determinar os códigos dos X clientes (sendo X dado pelo utilizador) que compraram mais produtos diferentes 
   //(não interessa a quantidade nem o valor), indicando quantos, sendo o critério de ordenação a ordem decrescente do número de produtos.
   public void query8_Input()
   {
      out.println("Insira o númerode produtos que quer determinar: \n");  
   }
   
   public void query8_Output()
   {}
   
   // Dado o código de um produto que deve existir, determinar o conjunto dos X clientes que mais o compraram e, para cada um, 
   //qual o valor gasto (ordenação cf. 5).
   public void query9_Input() //vai haver aqui um throw qualquer
   {
       out.println("Insira o código do produto: \n");
   }
   
   public void query9_Output()
   {
   }
   
   //Determinar mês a mês, e para cada mês filial a filial, a facturação total com cada produto.
   public void query10_Output()
   {
   }
   
   
}