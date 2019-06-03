import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.List;

/**
* 
**/
public interface IGestVendasModel extends Serializable 
{
    public void carregamentoDefault();
    public GestVendasModel loadStatus(String filename) throws FileNotFoundException, IOException, ClassNotFoundException ;
    public void outroFicheiro(int op) throws IOException;
    public void saveStatus(String fileName) throws FileNotFoundException,IOException ;
    public Map<Produto, List<Double>> ftrTotal(int filial);
}
