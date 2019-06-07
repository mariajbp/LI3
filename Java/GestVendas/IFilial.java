import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


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
    * Método que associa um registo ao cliente
    * @returns 
    **/
    public Map<Cliente, List<RegistoCliente>> getRegCl();
    
    /**
    * Método que define um registo de determinado produto
    **/
    public void setRegProd(Map<Produto, List<RegistoProduto>> regP);
    
    /**
    * Método que define um registo de determinado cliente
    **/
    public void setRegCl(Map<Cliente, List<RegistoCliente>> regC);
    
    /**
    * Método que devolve os clientes distintos de determinado produto, 
    * num mes
    **/
    public int getClientesDistintos(Produto p, int mes);
    
    public void getClientesDistintosMes(int mes, Set<Cliente> cl);
    
    public void getProdutos(Set<Produto> p);
    
    public Set<Produto> getProdutos();
    
    public int getUnidadesMes(Produto p, int mes);
    
    public double getFtrMensal(Produto p, int mes);
    
    /**
    * Método que devolve o total de vendas num certo mês
    **/
    public int totalVendas(int mes);
    
    /**
    * Método que atualiza o registo de um produto
    **/
    public void updateRegProd(Produto p, Cliente c, int mes, double f, int u);
    
    /**
    * Método que atualiza o registo de um cliente
    **/
    public void updateRegCl(Cliente c, Produto p, int uni, double t, int mes);
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    **/
    public void addVenda(Venda v);
    
    public List<Pair<Cliente, Double>> getClientesFaturacao();
    
    public Pair<Integer,Double> comprasTotais(Cliente c, int mes);
    
    public int ProdutosDistintos(Cliente c, int mes);
    
    public int getClientesDistintosTotal(int mes);

    public void ProdutosDistintos(Set<Produto> s, int mes, Cliente c);

    public List<Pair<Produto, Integer>> getProdUnidades();
    
    public void getProdUnidades(List<Pair<Produto, Integer>> s);
    
    public void clDistintos(Produto p, Set<Cliente> s);
    
    public Set<Produto> comprasDistintasClientes(Cliente c);

    public List<Pair<Cliente, Integer>> getClientesProdutosDistintos();

    public Set<Cliente> getClientes(Produto p);
    public Pair<Cliente,Double> clienteGastoAnual(Cliente c);
    public Pair<Cliente,Integer> clienteUnidadesAnual(Cliente c);
    public List<Pair<Produto, Integer>> numCompradoProds(Cliente c);
    public List<Double> totalFtrProd(Produto p);
}
