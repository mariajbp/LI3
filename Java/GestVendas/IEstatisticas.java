import java.io.Serializable;

/**
* 
**/
public interface IEstatisticas extends Serializable
{
    public String getNome();

    public int getVendasLidas();

    public int getVendasValidas();

    public int getProdutos();

    public int getTotalProdutosComprados();

    public int getClientes();

    public int getClientesCompraram();

    public int getCompras_0();

    public double getFaturacao();

    public void setNome(String n);

    public void setVendasLidas(int vl);

    public void setVendasValidas(int vv);

    public void setProdutos(int p);

    public void setTotalProdutosComprados(int tpc);

    public void setClientes(int c);

    public void setClientesCompraram(int cc);

    public void setCompras_0(int c0);

    public void setFaturacao(double f);
}
