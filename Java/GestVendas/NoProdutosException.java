import java.io.Serializable;

/**
* Classe NoProdutosException que devolve uma mensagem caso não exista determinado produto
**/
public class NoProdutosException extends Exception implements Serializable
{
    public NoProdutosException()
    {
        super();
    }
    
    public NoProdutosException(String message)
    {
        super(message);
    }
}