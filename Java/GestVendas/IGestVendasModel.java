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
    /**
    * Método que carrega o ficheiro de dados default da aplicação
    **/
    public void carregamentoDefault(); 
    
    /**
    * Método que carrega outro ficheiro dado pelo utilizador
    **/
    public void outroFicheiro(int op) throws IOException;
    
    /**** Estatisticas ****/
    
    /**** QUERY 1 ****/
    public List<Produto> prodsNuncaComprados();
    
    /**** QUERY 2 ****/
    public Pair<Integer,Integer> totalVendasRealizadas(int mes, int filial) throws InputInvalidoException;
    
    /**** QUERY 3 ****/
    public Pair<Integer,Double> totalComprasCliente(Cliente c, int mes);
    public int totalProdutosDistintos(Cliente c, int mes) throws ClienteInvalidoException;
    
    /**** QUERY 4 ****/
    public Pair<Integer, Integer> comprasPorMes(Produto p, int mes) throws ProdutoInvalidoException;
    public Double faturadoPorMes(Produto p, int mes);
    
    /**** QUERY 5 ****/
    public List<Pair<Produto,Integer>> prodsMaisComprados(Cliente c) throws ClienteInvalidoException;
    
    /**** QUERY 6 ****/
    public List<Produto> prodsMaisVendidos(int x) throws InputInvalidoException;
    public List<Pair<Produto,Integer>> cldistintos(List<Produto> lp);
    
    /**** QUERY 7 ****/
    public List<Cliente> maioresCompradores(int filial); 
    
    /**** QUERY 8 ****/
    public List<Pair<Cliente,Integer>> clientesMaisCompraram(int x) throws InputInvalidoException;
    
    /**** QUERY 9****/
    public List<Pair<Cliente, Integer>> xClientesMaisCompraram(Produto p, int x) throws InputInvalidoException, ProdutoInvalidoException;
    
    
    /**** QUERY 10 ****/
    public Map<Produto, List<Double>> ftrTotal(int filial);
    
    /** 
    * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem
    **/
    public void saveStatus(String fileName) throws FileNotFoundException,IOException;
    
    /** 
    * Método que recupera uma instância de GestVendas de um ficheiro de objectos 
    **/
    public GestVendasModel loadStatus(String filename) throws FileNotFoundException, IOException, ClassNotFoundException;
}
