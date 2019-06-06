import java.io.Serializable;

/**
* 
**/
public interface IEstatisticas extends Serializable
{
    /**
    * Método que devolve o Nome do ficheiro
    **/
    public String getNome();
    
    /**
    * Método que devolve o número de Vendas Lidas
    **/
    public int getVendasLidas();
    
    /**
    * Método que devolve o número de Vendas Válidas
    **/
    public int getVendasValidas();
    
    /**
    * Método que devolve o número de Produtos existentes
    **/
    public int getProdutos();
    
    /**
    * Método que devolve o número de Produtos comprados
    **/
    public int getTotalProdutosComprados();
    
    /**
    * Método que devolve o número de Clientes existentes
    **/
    public int getClientes();
    
    /**
    * Método que devolve o número de Clientes comprados
    **/
    public int getClientesCompraram();
    
    /**
    * Método que devolve o número de compras cuja faturação foi 0
    **/
    public int getCompras_0();
    
    /**
    * Método que devolve a faturação total
    **/
    public double getFaturacao();
    
    /**
    * Método que define o Nome do ficheiro
    **/
    public void setNome(String n);
    
    /**
    * Método que define o número de Vendas Lidas
    **/
    public void setVendasLidas(int vl);
    
    /**
    * Método que define o número de Vendas Válidas
    **/
    public void setVendasValidas(int vv);
    
    /**
    * Método que define o número de Produtos existentes
    **/
    public void setProdutos(int p);
    
    /**
    * Método que define o número de Produtos comprados
    **/
    public void setTotalProdutosComprados(int tpc);
    
    /**
    * Método que define o número de Clientes existentes
    **/
    public void setClientes(int c);
    
    /**
    * Método que define o número de Clientes comprados
    **/
    public void setClientesCompraram(int cc);
    
    /**
    * Método que define o número de compras cuja faturação foi 0
    **/
    public void setCompras_0(int c0);
    
    /**
    * Método que define a faturação total
    **/
    public void setFaturacao(double f);
}
