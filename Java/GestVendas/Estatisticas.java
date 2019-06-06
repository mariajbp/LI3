
public class Estatisticas implements IEstatisticas
{
    /** Nome do ficheiro **/
    private String nome;

    /** Número de Vendas Lidas **/
    private int num_VendasLidas;
    /** Número de Vendas Válidas**/
    private int num_VendasValidas;
    
    /** Número de Produtos existentes **/
    private int num_Produtos;
    /** Número de Produtos comprados **/
    private int num_totalProdutosComprados;

    /** Número de Clientes existentes **/
    private int num_Clientes;
    /** Número de Clientes comprados **/
    private int num_ClientesCompraram;

    /** Número de compras cuja faturação é 0 **/
    private int compras_0;
    /** Faturação Total **/
    private double faturacao;
    
    /**
    * Construtor Vazio
    **/
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

    /**
    * Construtor de Cópia
    **/
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


    /**
    * Método que dá Override ao equals
    **/
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

    /**
    * Método que dá Override ao clone
    **/
    public Estatisticas clone(){
        return new Estatisticas(this);
    }

    /**
    * Método que dá Override ao toString
    **/
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

    /**
    * Método que devolve o Nome do ficheiro
    **/
    public String getNome(){return this.nome;}
    
    /**
    * Método que devolve o número de Vendas Lidas
    **/
    public int getVendasLidas(){return this.num_VendasLidas;}
    
    /**
    * Método que devolve o número de Vendas Válidas
    **/
    public int getVendasValidas(){return this.num_VendasValidas;}
    
    /**
    * Método que devolve o número de Produtos existentes
    **/
    public int getProdutos(){return this.num_Produtos;}
    
    /**
    * Método que devolve o número de Produtos comprados
    **/
    public int getTotalProdutosComprados(){return this.num_totalProdutosComprados;}
    
    /**
    * Método que devolve o número de Clientes existentes
    **/
    public int getClientes(){return this.num_Clientes;}
    
    /**
    * Método que devolve o número de Clientes comprados
    **/
    public int getClientesCompraram(){return this.num_ClientesCompraram;}
    
    /**
    * Método que devolve o número de compras cuja faturação foi 0
    **/
    public int getCompras_0(){return this.compras_0;}
    
    /**
    * Método que devolve a faturação total
    **/
    public double getFaturacao(){return this.faturacao;}
    
    /**
    * Método que define o Nome do ficheiro
    **/
    public void setNome(String n){this.nome = n;}
    
    /**
    * Método que define o número de Vendas Lidas
    **/
    public void setVendasLidas(int vl){this.num_VendasLidas = vl;}
    
    /**
    * Método que define o número de Vendas Válidas
    **/
    public void setVendasValidas(int vv){this.num_VendasValidas = vv;}
    
    /**
    * Método que define o número de Produtos existentes
    **/
    public void setProdutos(int p){this.num_Produtos = p;}
    
    /**
    * Método que define o número de Produtos comprados
    **/
    public void setTotalProdutosComprados(int tpc){this.num_totalProdutosComprados = tpc;}
    
    /**
    * Método que define o número de Clientes existentes
    **/
    public void setClientes(int c){this.num_Clientes = c;}
    
    /**
    * Método que define o número de Clientes comprados
    **/
    public void setClientesCompraram(int cc){this.num_ClientesCompraram = cc;}
    
    /**
    * Método que define o número de compras cuja faturação foi 0
    **/
    public void setCompras_0(int c0){this.compras_0 = c0;}
    
    /**
    * Método que define a faturação total
    **/
    public void setFaturacao(double f){this.faturacao = f;}


}
