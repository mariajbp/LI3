import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.Serializable;


/**
* Classe RegistoProduto que contém estruturas com dados de um registo de produtos
**/
public class RegistoProduto implements Serializable
{
   /** Set que contém quais os Clientes que o compraram **/
   private Set<Cliente> registo;
   
   /** Total faturado **/
   double faturado;
   
   /** Total de unidades compradas **/
   int unidades;
   
   /** 
   * Construtor vazio que cria uma instância CatalogoProduto
   **/
   public RegistoProduto()
   {    
       this.registo = new TreeSet<>();
       this.faturado = 0.0;
       this.unidades = 0;
   }
    
   /** 
   * Construtor que cria um novo RegistoProduto a partir dos parâmetros dados 
   **/
   public RegistoProduto(Set<Cliente> s, double f, int u){
       this.registo = new TreeSet<>(s);
       this.faturado = f;
       this.unidades = u;
    }
    
   /** 
   * Construtor de cópia que cria uma nova instância RegistoProduto a partir de um RegistoProduto passado como parâmetro 
   **/
   public RegistoProduto(RegistoProduto r) {
       this.registo = r.getRegisto();
       this.faturado = r.getFaturado();
       this.unidades = r.getUnidades();
    }
    
   /**
   * Método que devolve o registo
   * @returns  Set de Pares<Cliente, Integer>
   **/ 
   public Set<Cliente> getRegisto(){return new TreeSet<>(this.registo);}
    
   public double getFaturado(){return this.faturado;}
   
   public int getUnidades(){return this.unidades;}
   
   /**
   * Método que faz set de um registo
   * @param  Set de Pares<Cliente, Integer>
   **/
   public void setRegisto(Set<Cliente> s)
   {
       this.registo.clear();
       this.registo = new TreeSet<>(s);
   }
   
   public void setFaturado(double f){this.faturado = f;}
   public void setUnidades(int u){this.unidades = u;}
   
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
       return this.registo.equals(r.getRegisto()) && this.faturado == r.getFaturado()
              && this.unidades == r.getUnidades();
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
   public void updateRegProduto(Cliente c, int uni, double f)
   {
            this.registo.add(c);
            this.unidades += uni;
            this.faturado += f;
    }
   
   public void updateFat (double f)
   {
       this.faturado += f;
   }
   
   public void updateUnidades(int u)
   {
       this.unidades += u;
    }
    
   public int ClientesDistintos()
   {
       return this.registo.size();
    }
}
