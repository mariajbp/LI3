
public class Estatisticas implements IEstatisticas
{
    private String nome;

    private int num_VendasLidas;
    private int num_VendasValidas;

    private int num_Produtos;
    private int num_totalProdutosComprados;

    private int num_Clientes;
    private int num_ClientesCompraram;

    private int compras_0;
    private double faturacao;

    public Estatisticas(){
        nome = "N/A";
        num_VendasLidas = 0;
        num_VendasValidas = 0;
        num_Produtos = 0;
        num_totalProdutosComprados = 0;
        num_Clientes = 0;
        num_ClientesCompraram = 0;
        compras_0 = 0;
        faturacao = 0;
    }
    
    public Estatisticas(Estatisticas e){
        nome = e.getNome();
        num_VendasLidas = e.getVendasLidas();
        num_VendasValidas = e.getVendasValidas();
        num_Produtos = e.getProdutos();
        num_totalProdutosComprados = e.getTotalProdutosComprados();
        num_Clientes = e.getClientes();
        num_ClientesCompraram = e.getClientesCompraram();
        compras_0 = e.getCompras_0();
        faturacao = e.getFaturacao();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Estatisticas)) {
            return false;
        }
        Estatisticas e = (Estatisticas) o;
        return this.num_Clientes == e.num_Clientes && this.num_ClientesCompraram == e.num_ClientesCompraram
                        && this.num_Produtos == e.num_Produtos && this.num_VendasLidas == e.num_VendasLidas
                        && this.num_VendasValidas == e.num_VendasValidas
                        && this.num_totalProdutosComprados == e.num_VendasValidas
                        && this.compras_0 == e.compras_0 && this.faturacao == e.faturacao
                        && this.nome.equals(e.nome);
    }

    public Estatisticas clone(){
        return new Estatisticas(this);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Nome do ficheiro ").append(nome).append("\n");
        s.append("Vendas Lidas: ").append(num_VendasLidas).append(". Vendas Validas: ").append(num_VendasValidas).append("\n");
        s.append("Numero Total de Produtos: ").append(num_Produtos).append(". Produtos Comprados: ").append(num_totalProdutosComprados).append("\n");
        s.append("Numero Total de Clientes: ").append(num_Clientes).append(". Clientes que realizaram compras: ").append(num_ClientesCompraram).append("\n");
        s.append("Numero de Compras com 0 de faturacao: ").append(compras_0).append("\n");
        s.append("Faturaçao Total: ").append(faturacao).append("\n");

        return s.toString();
    }

    public String getNome(){return this.nome;}

    public int getVendasLidas(){return this.num_VendasLidas;}

    public int getVendasValidas(){return this.num_VendasValidas;}

    public int getProdutos(){return this.num_Produtos;}

    public int getTotalProdutosComprados(){return this.num_totalProdutosComprados;}

    public int getClientes(){return this.num_Clientes;}

    public int getClientesCompraram(){return this.num_ClientesCompraram;}

    public int getCompras_0(){return this.compras_0;}

    public double getFaturacao(){return this.faturacao;}

    public void setNome(String n){this.nome = n;}

    public void setVendasLidas(int vl){this.num_VendasLidas = vl;}

    public void setVendasValidas(int vv){this.num_VendasValidas = vv;}

    public void setProdutos(int p){this.num_Produtos = p;}

    public void setTotalProdutosComprados(int tpc){this.num_totalProdutosComprados = tpc;}

    public void setClientes(int c){this.num_Clientes = c;}

    public void setClientesCompraram(int cc){this.num_ClientesCompraram = cc;}

    public void setCompras_0(int c0){this.compras_0 = c0;}

    public void setFaturacao(double f){this.faturacao = f;}


}
