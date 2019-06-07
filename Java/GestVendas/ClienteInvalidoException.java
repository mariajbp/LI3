import java.io.Serializable;

/**
* Classe NoClientesException que devolve uma mensagem caso não exista determinado cliente
**/
public class ClienteInvalidoException extends Exception implements Serializable
{
    public ClienteInvalidoException()
    {
        super();
    }
    
    public ClienteInvalidoException(String message)
    {
        super(message);
    }
}
