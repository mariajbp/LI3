import java.io.Serializable;

/**
* Classe NoVendasException que devolve uma mensagem caso não exista determinada venda
**/
public class NoVendasException extends Exception implements Serializable
{
    public NoVendasException()
    {
        super();
    }
    
    public NoVendasException(String message)
    {
        super(message);
    }
}
