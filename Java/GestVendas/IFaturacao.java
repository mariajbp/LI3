import java.io.Serializable;
import java.util.List;


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

