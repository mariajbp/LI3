import java.io.Serializable;

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
