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
    public Pair<Integer, Integer> comprasPorMes(Produto p, int mes) throws ProdutoInvalidoException;
    public Double faturadoPorMes(Produto p, int mes);
    public List<Produto> prodsNuncaComprados();
    public Pair<Integer,Integer> totalVendasRealizadas(int mes, int filial) throws InputInvalidoException;
    public List<Cliente> maioresCompradores(int filial); 
    public Pair<Integer,Double> totalComprasCliente(Cliente c, int mes);
    public int totalProdutosDistintos(Cliente c, int mes) throws ClienteInvalidoException;
    public List<Produto> prodsMaisVendidos(int x) throws InputInvalidoException;
    public List<Pair<Produto,Integer>> cldistintos(List<Produto> lp);
    public List<Pair<Cliente,Integer>> clientesMaisCompraram(int x) throws InputInvalidoException;
    public List<Pair<Cliente, Integer>> xClientesMaisCompraram(Produto p, int x) throws InputInvalidoException, ProdutoInvalidoException;
    public List<Pair<Produto,Integer>> prodsMaisComprados(Cliente c) throws ClienteInvalidoException;
    public Map<Produto, List<Double>> ftrTotal(int filial);

}
