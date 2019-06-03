import java.io.Serializable;
import java.io.IOException;
import static java.lang.System.out;
/**
* Classe agregadora do projeto
**/
public class GestVendasAppMVC implements Serializable
{
  public static void main(String[] args) 
  {
        IGestVendasController controller = new GestVendasController();
        IGestVendasModel model = new GestVendasModel();
        IGestVendasView view = new GestVendasView();
        
        controller.setModel(model);
        controller.setView(view); 
        controller.mainMenu();
             
       
        System.exit(0); 
    }  
}

