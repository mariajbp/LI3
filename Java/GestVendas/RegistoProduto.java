import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.Serializable;


/**
* Classe RegistoProduto que contém estruturas com dados de um registo de produtos
**/
public class RegistoProduto implements Serializable
{
   /** Set que contém pares os quais a cada Cliente fazem corresponder o número de unidades compradas **/
   private Set<Pair<Cliente, Integer>> registo;
   
   /** 
   * Construtor vazio que cria uma instância CatalogoProduto
   **/
   public RegistoProduto()
   {    
       this.registo = new TreeSet<>();
   }
    
   /** 
   * Construtor que cria um novo RegistoProduto a partir dos parâmetros dados 
   **/
   public RegistoProduto(Set<Pair<Cliente, Integer>> s){this.registo = new TreeSet<>(s);}
    
   /** 
   * Construtor de cópia que cria uma nova instância RegistoProduto a partir de um RegistoProduto passado como parâmetro 
   **/
   public RegistoProduto(RegistoProduto r) {this.registo = r.getRegisto();}
    
   /**
   * Método que devolve o registo
   * @returns  Set de Pares<Cliente, Integer>
   **/ 
   public Set<Pair<Cliente, Integer>> getRegisto(){return new TreeSet<>(this.registo);}
    
   /**
   * Método que faz set de um registo
   * @param  Set de Pares<Cliente, Integer>
   **/
   public void setRegisto(Set<Pair<Cliente, Integer>> s)
   {
       this.registo.clear();
       this.registo = new TreeSet<>(s);
   }
    
   /**
   * Método que testa se um objeto é igual a uma determinada identificação
   * @param      Objeto a ser testado
   * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
   **/
   public boolean equals(Object o)
   {
       if(o == this)
            return true;
       if(o == null || o.getClass() != this.getClass() )
            return false;
       RegistoProduto r = (RegistoProduto) o;
       return this.registo.equals(r.getRegisto());
   }
    
   /** 
   * Método que cria uma cópia de um Registo de Produtos
   * @returns Registo de Produto
   **/
   public RegistoProduto clone(){return new RegistoProduto(this);}
    
   public String toString(){return " ";}
   
   /** 
    * Método que dado um par Cliente/Unidades compradas verifica se o Cliente já existe e faz o seu Registo atualizando as unidades.
    * @param Par<Cliente, Integer>
    **/
   public void updateRegProduto(Cliente c, int uni)
   {
       Pair<Cliente, Integer> pair = new Pair<>();
       Iterator it = this.registo.iterator();
       while(it.hasNext()){
           pair = (Pair) it.next();
           if(pair.getFst().equals(c)){
               Pair<Cliente, Integer> newPair = new Pair<Cliente, Integer>();
               int uniOld = (int) pair.getSnd();

               this.registo.remove(pair);
               newPair.setFst(c);
               newPair.setSnd(uniOld + uni);
               
               this.registo.add(newPair);
               break;
            }
        }
    }
    
   public  int ClientesDistintos()
   {
       return this.registo.size();
    }
}
