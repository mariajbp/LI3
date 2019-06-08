import java.io.Serializable;
import java.util.Map;
import java.util.List;
import java.util.Set;


/**
* 
**/
public interface IFilial extends Serializable
{
    /**
    * Método que associa um registo ao produto
    **/
    public Map<Produto, List<RegistoProduto>> getRegProd();

    /**
    * Método que devolve os clientes distintos de determinado produto, 
    * num mes
    **/
    public int getClientesDistintos(Produto p, int mes);
    
    /**
    * Método que preenche um set com clientes distintos de um certo mes
    **/
    public void getClientesDistintosMes(int mes, Set<Cliente> cl);
    
    /**
    * Método que preenche um Set de Produtos
    **/ 
    public void getProdutos(Set<Produto> p);
    
    /**
    * Método que calcula as unidades vendidas mensalmente de um produto
    **/
    public int getUnidadesMes(Produto p, int mes) throws ProdutoInvalidoException;
    

    /**
    * Método que preenche um Set de Clientes
    **/ 
    public void getClientes(Set<Cliente> c);



    /**
    * Método que calcula a faturação de um produto num determinado mês
    **/
    public double getFtrMensal(Produto p, int mes);
    
    /**
    * Método que devolve o total de vendas num certo mês
    **/
    public int totalVendas(int mes) throws InputInvalidoException;
    
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    **/
    public void addVenda(Venda v);
    
    
    public List<Pair<Cliente, Double>> getClientesFaturacao();
    
    /**
    * Método que calcula o numero de compras totais e o total gasto por um cliente num mês
    **/
    public Pair<Integer,Double> comprasTotais(Cliente c, int mes);
    
    
    /**
    * Método que calcula o número de clientes que efetuaram compras na filial, num determinado mês
    **/
    public int getClientesDistintosTotal(int mes);


    public void ProdutosDistintos(Set<Produto> s, int mes, Cliente c) throws ClienteInvalidoException;


    
    public void getProdUnidades(Map<Produto, Integer> s);
    
    
    public void clDistintos(Produto p, Set<Cliente> s);
    

    public void getClientesProdutosDistintos(Map<Cliente, Set<Produto>> m);


    public void getClientes(Produto p, Set<Cliente> s) throws ProdutoInvalidoException;

    public Pair<Cliente,Double> clienteGastoAnual(Cliente c);
    
    
    public Pair<Cliente,Integer> clienteUnidadesAnual(Cliente c);

    public void numCompradoProds(Cliente c, Map<Produto, Integer> s) throws ClienteInvalidoException;


    
    public List<Double> totalFtrProd(Produto p);

}
