import java.io.Serializable;
import java.util.TreeSet;
import java.util.Set;

/**
* Representação de um catalogo de produtos
**/

public class CatalogoProdutos implements ICatProdutos, Serializable 
{
   /** Catalogo de produtos **/
   private Set<Produto> catalogo; 
   
   /** 
   * Construtor vazio que cria uma instância Catalogoprodutos
   **/
   public CatalogoProdutos()
   {
        this.catalogo = new TreeSet<Produto>();
   }
   
   /** 
   * Construtor de cópia que cria uma nova instância Catalogoprodutos a partir de uma Catalogoprodutos passado como parâmetro 
   **/
   public CatalogoProdutos(Set<Produto> cprod)
   {
       this.catalogo = catalogo; 
   }
   
   /** 
   * Construtor que cria uma nova instância Catalogoprodutos a partir de uma Catalogoprodutos passado como parâmetro 
   **/
   public CatalogoProdutos(CatalogoProdutos c)
   {
       this.catalogo = c.getCatalogo(); 
   }
   
   /**
   * Método que devolve o catalogo de Produtos
   * @return Catalogo de produtos válidos
   **/
   public Set<Produto> getCatalogo()
   {
     return new TreeSet<Produto>(catalogo);
   }
   
   /**
   * Método que define o catalogo de Produtos
   * @param Catalogo de produtos válidos
   **/
   public void setCatalogo(Set<Produto> pp)
   {
      this.catalogo.clear();
      for(Produto p: pp){this.catalogo.add(p.clone());}
   }
   
   /** 
   * Método que cria uma cópia de uma identificação de um Produto
   **/
    public CatalogoProdutos clone(){return new CatalogoProdutos(this);}
   
   /** 
   * Método que testa se um objeto é igual a uma determinada identificação
   * @param      Objeto a ser testado
   * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
   **/
   public boolean equals(Object o)
   {
      if(this == o) return true;
      if(o == null || this.getClass() != o.getClass()) return false;
      CatalogoProdutos cp  = (CatalogoProdutos) o;     
      return this.catalogo.equals(cp.getCatalogo());
   }
   
   /**
   * Método que converte uma identificação numa string
   **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Catalogo de Produtos: \n").append(catalogo).append("\n");
       return sb.toString();
    }
   
   
   /**
   * Método que adiciona um produto a uma catalogo
   * @param   Produto a adicionar
   **/ 
   public void addProduto(Produto p)
   { 
      catalogo.add(p);  
   }
   
   /**
   * Método que verifica se um código existe no catalogo
   * @returns  True se existir, False caso contrário
   **/ 
   public boolean containsProduto(String codigo)
   { 
       Produto p = new Produto(codigo);
       return catalogo.contains(p);
   }
   
   public int CatalogoSize()
   {
       return this.catalogo.size();
    }
}
