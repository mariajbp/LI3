import java.io.Serializable;

/**
* 
**/
public interface IGestVendasController extends Serializable
{
    /**
    * Método que define uma instancia da interface IGestVendasModel
    **/
    public void setModel(IGestVendasModel m);
    
    /**
    * Método que define uma instancia da interface IGestVendasView
    **/
    public void setView(IGestVendasView v);
    
    /** 
    * Método que inicia o menu principal 
    **/
    public void mainMenu();
}