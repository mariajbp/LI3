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


}

