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
    * Método que preenche um Set de Produtos
    **/ 
    public void getProdutos(Set<Produto> p);
    
    /**
    * Método que preenche um Set de Clientes
    **/ 
    public void getClientes(Set<Cliente> c);
    
    /**
    * Método que preenche uma lista de clientes com o seu total faturado anualmente (query 7)
    **/
    public List<Pair<Cliente, Double>> getClientesFaturacao();

    /**
    * Método que calcula as unidades vendidas mensalmente de um produto
    **/
    public int getUnidadesMes(Produto p, int mes) throws ProdutoInvalidoException;
    
    /**
    * Método que calcula a faturação de um produto num determinado mês
    **/
    public double getFtrMensal(Produto p, int mes);
    
    /**
    * Método que devolve os clientes distintos de determinado produto, 
    * num mes
    **/
    public int getClientesDistintos(Produto p, int mes);
    
     /**
    * Método que calcula o número de clientes que efetuaram compras na filial, num determinado mês
    **/
    public int getClientesDistintosTotal(int mes);

    /**
    * Método que preenche um set com clientes distintos de um certo mes
    **/
    public void getClientesDistintosMes(int mes, Set<Cliente> cl);
    
    /**
    * Método que devolve o total de vendas num certo mês
    **/
    public int totalVendas(int mes) throws InputInvalidoException;
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    **/
    public void addVenda(Venda v);
    
    /**
    * Método que calcula o numero de compras totais e o total gasto por um cliente num mês
    **/
    public Pair<Integer,Double> comprasTotais(Cliente c, int mes);
    
    /**
    * Método que dado um Cliente preenche um conjunto que contém todos os produtos distintos comprados nesse mês
    **/
    public void ProdutosDistintos(Set<Produto> s, int mes, Cliente c) throws ClienteInvalidoException;

    /**
    * Método que preenche um Map de pares com as informações de um Produto e as unidades vendidas anualmente 
    **/
    public void getProdUnidades(Map<Produto, Integer> s);
    
     /**
    * Método que preenche um Map com as informações de um cliente e todos os Produtos comprados anualmente por este
    **/
    public void getClientesProdutosDistintos(Map<Cliente, Set<Produto>> m);

    /**
    * Preenche um Set com todos os Clientes que compraram um Produto
    **/
    public void getClientes(Produto p, Set<Cliente> s) throws ProdutoInvalidoException;

    /**
    * Método que calcula o gasto anual de um cliente
    **/
    public Pair<Cliente,Double> clienteGastoAnual(Cliente c);
    
    /**
    * Método que calcula a quantidade de unidades compradas por um cliente, anualmente
    **/
    public Pair<Cliente,Integer> clienteUnidadesAnual(Cliente c);

    /**
    * Método que preenche um Map com as informações associadas a um Cliente sobre os Produtos que comprou e o número de unidades 
    **/
    public void numCompradoProds(Cliente c, Map<Produto, Integer> s) throws ClienteInvalidoException;

    /**
     * Método que dado um produto, retorna  lista com o seu total faturado por mês 
     **/
    public List<Double> totalFtrProd(Produto p);

}
