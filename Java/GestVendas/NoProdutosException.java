import java.io.Serializable;

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