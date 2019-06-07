import java.io.Serializable;
import java.util.List;
import java.awt.event.KeyEvent; 
import java.util.Map; 

/**
* 
**/
public interface IGestVendasView extends Serializable
{
     /**
     * Método que define o menu 
     **/
     public void setMenu(String[] s);
     
     /** Método que imprimir o header inicial da aplicação **/
     public void init();
     
     /**
     * Método que imprime o menu
     **/
     public int printMenu();
     
     /**
     * Método que imprime a escolha de ficheiros
     **/
     public void outroFichOutputEscolha();
     
     /**
     * Método que imprime uma mensagem de suceso na gravação de dados
     **/
     public void saveMessage();
     
     /**
     * Método que imprime a lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total, através um navegador
     **/
     public void query1_Output(List<Produto> p);
     
     /**
     * Método que imprime um pedido de input
     **/
     public void query2_Input();
     
     /**
     * Método que dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram 
     **/
     public void query2_Output(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2, Pair<Integer,Integer> p3, int tp, int tc);
    
     /**
     * Método que imprime um pedido de input
     **/
     public void query3_Input();
     
     /**
     * Método que imprime para cada mês, quantas compras fez determinado cliente fez, quantos produtos distintos comprou e quanto gastou no total.
     **/
     public void query3_Output();
     
     /**
     * Método que imprime para cada mês, quantas compras fez determinado cliente fez, quantos produtos distintos comprou e quanto gastou no total.
     **/
     public void query3_Output(int c, double t, int p, int mes);
     
     /**
      * Método que imprime um pedido de input
     **/
     public void query4_Input();
     
     /**
     * Método que imprime mês a mês, quantas vezes foi comprado um produto fou comprado, por quantos clientes diferentes e o total facturado. 
     **/
     public void query4_Output();
     
     /**
     * Método que imprime mês a mês, quantas vezes foi comprado um produto fou comprado, por quantos clientes diferentes e o total facturado. 
     **/
     public void query4_Output(int i, Pair<Integer, Integer> p, double t);
     
     /**
     * Método que imprime um pedido de input
     **/
     public void query5_Input();
     
     /**
     * Método que imprime  a lista de códigos de produtos que um cliente mais comprou
     **/
     public void query5_Output(List<Pair<Produto,Integer>> l);
     
     /**
     * Método que imprime um pedido de input
     **/
     public void query6_Input(); 
     
     /**
     * Método que imprime o conjunto dos X produtos mais vendidos em todo o ano e o número total de distintos clientes que o compraram  
     **/
     public void query6_Output_Dados(List<Pair<Produto,Integer>> l);
     
     /**
     * Método que imprime para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado. 
     **/
     public void query7_Output(List<Cliente> c1 , List<Cliente> c2, List<Cliente> c3);
     
     /**
     * Método que imprime um pedido de input
     **/
     public void query8_Input();
     
     /**
     * Método que imprime os códigos dos X clientes que compraram mais produtos diferentes e indica quantos
     **/
     public void query8_Output( List<Pair<Cliente,Integer>> c1);
     
     /**
     * Método que imprime um pedido de input
     **/
     public void query9_Inputx();
     
     /**
     * Método que imprime um pedido de input
     **/
     public void query9_Inputp();
     
     /**
     * Método que imprime o conjunto dos X clientes que mais o compraram um produto e, para cada um, qual o valor gasto
     **/
     public void query9_Output(List<Pair<Cliente, Integer>> gasto);
     
     /**
     * Método que imprime  mês a mês, e para cada mês filial a filial, a facturação total com cada produto
     **/
     public void query10_Output(Map<Produto, List<Double>> c1, Map<Produto, List<Double>> c2, Map<Produto, List<Double>> c3);
     
     /**
     * Método que imprime o tempo que o programa demourou a correr, em segundos
     **/
     public void time(double t);
}
