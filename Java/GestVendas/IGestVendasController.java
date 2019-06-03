import java.io.Serializable;

/**
* 
**/
public interface IGestVendasController extends Serializable
{
    public void mainMenu();
    public void setModel(IGestVendasModel m);
    public void setView(IGestVendasView v);
}