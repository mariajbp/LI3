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
    public Pair<Integer, Integer> comprasPorMes(Produto p, int mes);
    public Double faturadoPorMes(Produto p, int mes);
    public Map<Produto, List<Double>> ftrTotal(int filial);
    public List<Produto> prodsNuncaComprados();
    public Pair<Integer,Integer> totalVendasRealizadas(int mes, int filial);
    public List<Pair<Produto,Integer>> prodsMaisVendidos(int x);
    public int distintosProd(Produto p);
    public List<Cliente> maioresCompradores(int filial);
}
