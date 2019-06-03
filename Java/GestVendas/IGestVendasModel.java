import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
* 
**/
public interface IGestVendasModel extends Serializable 
{
    public void carregamentoDefault();
    public GestVendasModel loadStatus(String filename) throws FileNotFoundException, IOException, ClassNotFoundException ;
    public void outroFicheiro(int op) throws IOException;
    public void saveStatus(String fileName) throws FileNotFoundException,IOException ;
}
