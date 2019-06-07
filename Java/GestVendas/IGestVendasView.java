import java.io.Serializable;
import java.util.List;
import java.awt.event.KeyEvent; 
import java.util.Map; 

/**
* 
**/
public interface IGestVendasView extends Serializable
{
     public void setMenu(String[] s);
     public void init();
     public int printMenu();
     public void outroFichOutputEscolha();
     public void saveMessage();
     public void query1_Output(List<Produto> p);
     public void query2_Input();
     public void query2_Output(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2, Pair<Integer,Integer> p3, int tp, int tc);
     public void query3_Input();
     public void query3_Output();
     public void query3_Output(int c, double t, int p, int mes);
     public void query4_Input();
     public void query4_Output();
     public void query4_Output(int i, Pair<Integer, Integer> p, double t);
     public void query5_Input();
     public void query5_Output(List<Pair<Produto,Integer>> l);
     public void query6_Input(); 
     public void query6_Output_Dados(List<Pair<Produto,Integer>> l);
     public void query7_Output(List<Cliente> c1 , List<Cliente> c2, List<Cliente> c3);
     public void query8_Input();
     public void query8_Output( List<Pair<Cliente,Integer>> c1);
     public void query9_Inputx();
      public void query9_Inputp();
     public void query9_Output(List<Pair<Cliente, Integer>> gasto);
     public void query10_Output(Map<Produto, List<Double>> c1, Map<Produto, List<Double>> c2, Map<Produto, List<Double>> c3);
     public void time(double t);
}
