import java.io.Serializable;

/**
* Classe NoProdutosException que devolve uma mensagem caso não exista determinado produto
**/
public class ProdutoInvalidoException extends Exception implements Serializable
{
    public ProdutoInvalidoException()
    {
        super();
    }
    
    public ProdutoInvalidoException(String message)
    {
        super(message);
    }
}