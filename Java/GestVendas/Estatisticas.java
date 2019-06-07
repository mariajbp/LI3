
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
    
    /** Número de Clientes que realizaram compras **/
    private int num_ClientesCompraram;

    /** Número de compras cuja faturação é 0 **/
    private int compras_0;
    
    /** Faturação Total **/
    private double faturacao;
    
    /** Número de compras por mês **/
    private int[12] compras;
    
    /** Faturação por mês e por filial **/
    private double[12][3] ftrMF;
    
    /** Número de clientes distintos por mês e por filial **/
    private int[12][3] clientesMF;
    
    /** 
    * Construtor vazio que cria uma instância Estatisticas
    **/
    public Estatisticas()
    {
        nome = "N/A";
        num_VendasLidas = 0;
        num_VendasValidas = 0;
        num_Produtos = 0;
        num_totalProdutosComprados = 0;
        num_Clientes = 0;
        num_ClientesCompraram = 0;
        compras_0 = 0;
        faturacao = 0;
        
        for(int m = 0; m < 12; m++)
            compras[m] = 0;
        for(int m = 0; m < 12; m++)
            for(int f = 0; f < 3; f++)
                ftrMF[m][f] = 0;
        for(int m = 0; m < 12; m++)
            for(int f = 0; f < 3; f++)
                clientesMF[m][f] = 0; 
    }

    /** 
    * Construtor de cópia que cria uma nova instância Estatisticas a partir de uma Estatistica passado como parâmetro 
    **/
    public Estatisticas(Estatisticas e)
    {
        nome = e.getNome();
        num_VendasLidas = e.getVendasLidas();
        num_VendasValidas = e.getVendasValidas();
        num_Produtos = e.getProdutos();
        num_totalProdutosComprados = e.getTotalProdutosComprados();
        num_Clientes = e.getClientes();
        num_ClientesCompraram = e.getClientesCompraram();
        compras_0 = e.getCompras_0();
        faturacao = e.getFaturacao();
        
        compras = e.getCompras();
        ftrMF = e.getftrMF();
        clientesMF = e.getClientesMF();
    }


    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o) 
    {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Estatisticas e = (Estatisticas) o;
        return this.num_Clientes == e.num_Clientes && this.num_ClientesCompraram == e.num_ClientesCompraram
                        && this.num_Produtos == e.num_Produtos && this.num_VendasLidas == e.num_VendasLidas
                        && this.num_VendasValidas == e.num_VendasValidas
                        && this.num_totalProdutosComprados == e.num_VendasValidas
                        && this.compras_0 == e.compras_0 && this.faturacao == e.faturacao
                        && this.nome.equals(e.nome);
    }

    /** 
    * Método que cria uma cópia de uma identificação de uma Estatistica
    **/ 
    public Estatisticas clone(){return new Estatisticas(this);}

    /**
    * Método que converte uma identificação numa string 
    **/
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Nome do ficheiro ").append(nome).append("\n");
        s.append("Vendas Lidas: ").append(num_VendasLidas).append(". Vendas Validas: ").append(num_VendasValidas).append(". Vendas não Validas: ").append(num_VendasLidas - num_VendasValidas).append("\n");
        s.append("Numero Total de Produtos: ").append(num_Produtos).append(". Produtos comprados: ").append(num_totalProdutosComprados).append("\n");
        s.append("Produtos que nunca foram comprados: ").append(num_Produtos - num_totalProdutosComprados).append("\n");
        s.append("Numero Total de Clientes: ").append(num_Clientes).append(". Clientes que realizaram compras: ").append(num_ClientesCompraram).append("\n");
        s.append("Clientes que nunca realizaram compras: ").append(num_Clientes - num_ClientesCompraram).append("\n");
        s.append("Numero de Compras com 0 de faturacao: ").append(compras_0).append("\n");
        s.append("Faturaçao Total: ").append(faturacao).append("\n");
        
        s.append("Número de Compras em Janeiro: ").append(compras[0]).append("\n");
        s.append("Número de Compras em Fevereiro: ").append(compras[1]).append("\n");
        s.append("Número de Compras em Março: ").append(compras[2]).append("\n");
        s.append("Número de Compras em Abril: ").append(compras[3]).append("\n");
        s.append("Número de Compras em Maio: ").append(compras[4]).append("\n");
        s.append("Número de Compras em Junho: ").append(compras[5]).append("\n");
        s.append("Número de Compras em Julho: ").append(compras[6]).append("\n");
        s.append("Número de Compras em Agosto: ").append(compras[7]).append("\n");
        s.append("Número de Compras em Setembro: ").append(compras[8]).append("\n");
        s.append("Número de Compras em Outubro: ").append(compras[9]).append("\n");
        s.append("Número de Compras em Novembro: ").append(compras[10]).append("\n");
        s.append("Número de Compras em Dezembro: ").append(compras[11]).append("\n");

        s.append("Faturação em Janeiro: ").append("Filial 1 -").append(ftrMF[0][0]).append(". Filial 2 -").append(ftrMF[0][1])..append(". Filial 3 -").append(ftrMF[0][2]).append("\n");
        s.append("Faturação em Fevereiro: ").append("Filial 1 -").append(ftrMF[1][0]).append(". Filial 2 -").append(ftrMF[1][1])..append(". Filial 3 -").append(ftrMF[1][2]).append("\n");
        s.append("Faturação em Março: ").append("Filial 1 -").append(ftrMF[2][0]).append(". Filial 2 -").append(ftrMF[2][1])..append(". Filial 3 -").append(ftrMF[2][2]).append("\n");
        s.append("Faturação em Abril: ").append("Filial 1 -").append(ftrMF[3][0]).append(". Filial 2 -").append(ftrMF[3][1])..append(". Filial 3 -").append(ftrMF[3][2]).append("\n");
        s.append("Faturação em Maio: ").append("Filial 1 -").append(ftrMF[4][0]).append(". Filial 2 -").append(ftrMF[4][1])..append(". Filial 3 -").append(ftrMF[4][2]).append("\n");
        s.append("Faturação em Junho: ").append("Filial 1 -").append(ftrMF[5][0]).append(". Filial 2 -").append(ftrMF[5][1])..append(". Filial 3 -").append(ftrMF[5][2]).append("\n");
        s.append("Faturação em Julho: ").append("Filial 1 -").append(ftrMF[6][0]).append(". Filial 2 -").append(ftrMF[6][1])..append(". Filial 3 -").append(ftrMF[6][2]).append("\n");
        s.append("Faturação em Agosto: ").append("Filial 1 -").append(ftrMF[7][0]).append(". Filial 2 -").append(ftrMF[7][1])..append(". Filial 3 -").append(ftrMF[7][2]).append("\n");
        s.append("Faturação em Setembro: ").append("Filial 1 -").append(ftrMF[8][0]).append(". Filial 2 -").append(ftrMF[8][1])..append(". Filial 3 -").append(ftrMF[8][2]).append("\n");
        s.append("Faturação em Outubro: ").append("Filial 1 -").append(ftrMF[9][0]).append(". Filial 2 -").append(ftrMF[9][1])..append(". Filial 3 -").append(ftrMF[9][2]).append("\n");
        s.append("Faturação em Novembro: ").append("Filial 1 -").append(ftrMF[10][0]).append(". Filial 2 -").append(ftrMF[10][1])..append(". Filial 3 -").append(ftrMF[10][2]).append("\n");
        s.append("Faturação em Dezembro: ").append("Filial 1 -").append(ftrMF[11][0]).append(". Filial 2 -").append(ftrMF[11][1])..append(". Filial 3 -").append(ftrMF[11][2]).append("\n");
        
        s.append("Clientes Distintos em Janeiro: ").append("Filial 1 -").append(clientesMF[0][0]).append(". Filial 2 -").append(clientesMF[0][1])..append(". Filial 3 -").append(clientesMF[0][2]).append("\n");
        s.append("Clientes Distintos em Fevereiro: ").append("Filial 1 -").append(clientesMF[1][0]).append(". Filial 2 -").append(clientesMF[1][1])..append(". Filial 3 -").append(clientesMF[1][2]).append("\n");
        s.append("Clientes Distintos em Março: ").append("Filial 1 -").append(clientesMF[2][0]).append(". Filial 2 -").append(clientesMF[2][1])..append(". Filial 3 -").append(clientesMF[2][2]).append("\n");
        s.append("Clientes Distintos em Abril: ").append("Filial 1 -").append(clientesMF[3][0]).append(". Filial 2 -").append(clientesMF[3][1])..append(". Filial 3 -").append(clientesMF[3][2]).append("\n");
        s.append("Clientes Distintos em Maio: ").append("Filial 1 -").append(clientesMF[4][0]).append(". Filial 2 -").append(clientesMF[4][1])..append(". Filial 3 -").append(clientesMF[4][2]).append("\n");
        s.append("Clientes Distintos em Junho: ").append("Filial 1 -").append(clientesMF[5][0]).append(". Filial 2 -").append(clientesMF[5][1])..append(". Filial 3 -").append(clientesMF[5][2]).append("\n");
        s.append("Clientes Distintos em Julho: ").append("Filial 1 -").append(clientesMF[6][0]).append(". Filial 2 -").append(clientesMF[6][1])..append(". Filial 3 -").append(clientesMF[6][2]).append("\n");
        s.append("Clientes Distintos em Agosto: ").append("Filial 1 -").append(clientesMF[7][0]).append(". Filial 2 -").append(clientesMF[7][1])..append(". Filial 3 -").append(clientesMF[7][2]).append("\n");
        s.append("Clientes Distintos em Setembro: ").append("Filial 1 -").append(clientesMF[8][0]).append(". Filial 2 -").append(clientesMF[8][1])..append(". Filial 3 -").append(clientesMF[8][2]).append("\n");
        s.append("Clientes Distintos em Outubro: ").append("Filial 1 -").append(clientesMF[9][0]).append(". Filial 2 -").append(clientesMF[9][1])..append(". Filial 3 -").append(clientesMF[9][2]).append("\n");
        s.append("Clientes Distintos em Novembro: ").append("Filial 1 -").append(clientesMF[10][0]).append(". Filial 2 -").append(clientesMF[10][1])..append(". Filial 3 -").append(clientesMF[10][2]).append("\n");
        s.append("Clientes Distintos em Dezembro: ").append("Filial 1 -").append(clientesMF[11][0]).append(". Filial 2 -").append(clientesMF[11][1])..append(". Filial 3 -").append(clientesMF[11][2]).append("\n");
        
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
    * Método que devolve o número total de compras por mês
    **/
    public int[12] getCompras(){return this.compras;}
    
    /**
    * Método que devolve a faturação total por mês e por filial
    **/
    public double[12][3] getftrMF(){return this.ftrMF;}
    
    /**
    * Método que devolve o número de clientes distintos por mês e por filial
    **/
    public int[12][3] getClientesMF(){return this.clientesMF;}
    
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

    /**
    * Método que define o número de compras por mês
    **/
    public void setCompras(int[12] c){this.compras = c;}
    
    /**
    * Método que define a faturação total por mês e por filial
    **/
    public void setftrMF(double[12][3] f){this.ftrMF = f;}
    
    /**
    * Método que define o número de clientes por mês e por filial
    **/
    public void setClientesMF(int[12][3] c){this.clientesMF = c;}

}
