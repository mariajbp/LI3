import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
* 
**/
public interface IFaturacao extends Serializable
{
   /**
   * Método que devolve a fatuação total global
   **/
   public double getFtrTotal();
   
   /**
   * Método que devolve a fatuação total mnsal
   **/
   public double[][] getFtrMensal();
  
   public double getFtrMensal(int mes, int filial);
   
   /**
   * Método que divide as carateristicas de uma venda pelos Maps da classe
   **/
    public void addVenda(Venda v);
<<<<<<< HEAD
}
   
=======
   
   /**
   * Método que determina o total de certo produto vendido anualmente
   **/
   public HashMap<Produto, Integer>  prodsVendidosAnual(); 
}
>>>>>>> 7983450e89200a61de372548c941f8176d73b888
