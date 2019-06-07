import java.io.Serializable;

/**
* Classe NoVendasException que devolve uma mensagem caso não exista determinada venda
**/
public class InputInvalidoException extends Exception implements Serializable
{
    public InputInvalidoException()
    {
        super();
    }
    
    public InputInvalidoException(String message)
    {
        super(message);
    }
}
