import java.io.Serializable;

/**
* Classe NoClientesException que devolve uma mensagem caso não exista determinado cliente
**/
public class NoClientesException extends Exception implements Serializable
{
    public NoClientesException()
    {
        super();
    }
    
    public NoClientesException(String message)
    {
        super(message);
    }
}
