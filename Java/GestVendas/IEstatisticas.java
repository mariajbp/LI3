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
    * Método que devolve o número total de compras por mês
    **/
    public int[] getCompras();
    
    /**
    * Método que devolve a faturação total por mês e por filial
    **/
    public double[][] getftrMF();
    
    /**
    * Método que devolve o número de clientes distintos por mês e por filial
    **/
    public int[][] getClientesMF();

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
    
    /**
    * Método que define o número de compras por mês
    **/
    public void setCompras(int[12] c);
    
    /**
    * Método que define a faturação total por mês e por filial
    **/
    public void setftrMF(double[12][3] f);
    
    /**
    * Método que define o número de clientes por mês e por filial
    **/
    public void setClientesMF(int[12][3] c);

}
