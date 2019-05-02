import java.io.Serializable;

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
