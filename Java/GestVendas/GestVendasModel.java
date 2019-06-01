import java.io.Serializable;
import java.io.IOException;
import java.io.*; 
import java.util.TreeSet; //ou hash later
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.*;

/**
* 
**/
public class GestVendasModel implements Serializable, IGestVendasModel
{
    private ICatProdutos cprod;
    private ICatClientes ccl;
    private IFilial f1;
    private IFilial f2;
    private IFilial f3;
    private IFaturacao ftr;
    
    public void createData() throws IOException
    {
        String[] filename = new String[2];
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader("../config.txt"));
        try
        {
           String line = null;
           while ((line = br.readLine()) != null && i < 3) 
           {
              line =  filename[i];
              i++;
           } 
        }catch (IOException e) {e.printStackTrace();} finally {br.close();} 

        preencheProds(filename[2]); 
        preencheCl(filename[1]);
        preencheVendas(filename[3]);
    }
    
    /**
    * Método que preenche o catalogo de produtos
    * @param    Nome do ficheiro a carregar
    * @returns  Número de produtos válidos
    **/
    private int preencheProds(String fileName) throws IOException 
    {
      int v = 0; //válidos
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      try 
      {
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               if(validaProduto(line))
               { 
                   Produto p = new Produto();
                   cprod.addProduto(p);   
                   v++;
               }
           }
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
      return v;
    }
    
    /**
    * Validação do código de um produto
    * @param     Linha do ficheiro a validar
    * @returns   True caso a venda seja válida, False caso contrário
    **/ 
    public boolean validaProduto(String c)
    {
       boolean v = true;
       String[] part = c.split("(?<=\\D)(?=\\d)");
       boolean isNumeric = false;
       if(part[1].chars().allMatch(Character::isDigit) && Integer.parseInt(part[1]) > 1000 && Integer.parseInt(part[1]) < 9999) {isNumeric = true;}       
       char fst = c.charAt(0);
       char snd = c.charAt(2);
       if(c.length() == 6 && Character.isLetter(fst) && Character.isLetter(snd) && isNumeric) {v = true;}
       return v;      
    }
    
    /**
    * Método que preenche o catalogo de clientes
    * @param    Nome do ficheiro a carregar
    * @returns  Número de vendas válidas
    **/
    private int preencheCl(String fileName) throws IOException 
    {
       int v = 0;
       BufferedReader br = new BufferedReader(new FileReader(fileName));
       try 
       {
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               if(validaCliente(line))
               {
                   Cliente c = new Cliente();
                   ccl.addCliente(c); 
                   v++;
               }
           }
       }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
       return v;
    }
    
    /**
    * Validação do código de um cliente
    * @param     Linha do ficheiro a validar
    * @returns   True caso a venda seja válida, False caso contrário
    **/ 
    public boolean validaCliente(String c)
    {
       boolean v = true;
       String[] part = c.split("(?<=\\D)(?=\\d)");
       boolean isNumeric = false;
       if(part[1].chars().allMatch(Character::isDigit) && Integer.parseInt(part[1]) > 1000 && Integer.parseInt(part[1]) < 5000) {isNumeric = true;}   
       char fst = c.charAt(0);
       if(c.length() == 5 && Character.isLetter(fst) && isNumeric) {v = true;}
       return v;      
    }
    
    /**
    * Método que carrega os dados de uma venda
    * @param    Nome do ficheiro a carregar
    * @returns  Número de vendas válidas
    **/
    private void preencheVendas(String fileName) throws IOException 
    {
      int v = 0;
      Map<Produto, ArrayList<Cliente>> p = new HashMap<Produto, ArrayList<Cliente>>();
      Map<Cliente, ArrayList<Produto>> c = new HashMap<Cliente, ArrayList<Produto>>();
      boolean prd, cl;
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      try 
      {
           String line = null;
           while ((line = br.readLine()) != null) 
           {
               if(validaVenda(line))
               {
                   String[] part = line.split(" ");
                   Venda venda = new Venda(part[0],Double.parseDouble(part[1]),Integer.parseInt(part[2]),part[3],part[4],Integer.parseInt(part[5]),Integer.parseInt(part[6]));
                   
                   if(venda.getFilial() == 1)
                        f1.addVenda(venda);
                   else
                   {
                        if(venda.getFilial() == 2)
                            f2.addVenda(venda);
                        else
                            f3.addVenda(venda);
                   }
                        
                   ftr.addVenda(venda); 
                   v++;
               }
           }
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
    }
    
    
    /**
    * Validação dos parametros de uma venda
    * @param     Linha do ficheiro a validar
    * @returns   True caso a venda seja válida, False caso contrário
    **/
    public boolean validaVenda(String c)
    {
       boolean validade = false;
       String[] part = c.split(" ");
       if(validaProduto(part[0]) && cprod.containsProduto(part[0]))
       {
           if(Double.parseDouble(part[1]) > 0 && Double.parseDouble(part[1]) < 999)
           {
               if(Integer.parseInt(part[2]) > 0 && Integer.parseInt(part[2]) > 200)
               {
                   if(part[3] == "N" || part[3] == "P")
                   {
                       if(validaCliente(part[4]) && ccl.containsCliente(part[4]))
                       {
                           if(Integer.parseInt(part[5]) > 0 && Integer.parseInt(part[5]) < 13)
                           {
                               if(Integer.parseInt(part[6]) > 0 && Integer.parseInt(part[6]) < 4)
                               validade = true;     
                           }
                       }
                   }
               }
           }
       }
       return validade;      
    }
    
    
    
    /**** QUERIES ****/
    /** 
    * Query1: Lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total.
    * @param 
    * @returns
    **/  
    public List<Produto> prodsNuncaComprados(CatalogoProdutos cp, Faturacao ft)
    {
       List<Produto> lp = new ArrayList<>();
       Set<Produto> prods = cp.getCatalogo();
       Map<Produto, List<Integer>> map = ft.getProdUnidadeMes();
       Set<Produto> keys = map.keySet();
       
       Iterator<Produto> it = prods.iterator();
       while(it.hasNext())
       {
          Produto p = it.next();
          if(!keys.contains(p))
          {
              lp.add(p);
          }
       }  
       return lp;
    } 

    /** 
    * Query 2:  Dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram; 
    * Fazer o mesmo mas para cada uma das filiais.
    * 
    * @param 
    * @returns
    
    public Pair totalVendasClientes()
    {
        
    } **/ 
    
    
    /** 
    * Query 3: Dado um código de cliente, determinar, para cada mês, quantas compras fez, 
    * quantos produtos distintos comprou e quanto gastou no total.
    * 
    * @param 
    * @returns
    **/
    
    
    /**
    * Query 4: Dado o código de um produto existente, determinar, mês a mês, quantas vezes foi comprado, por quantos clientes diferentes 
    * e o total facturado.
    * 
    * @param 
    * @returns
    * 
    * METADE VEM DA FATURACAO
    **/ 
    
    /** 
    * Query 5: Dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem 
    * decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos.
    * 
    * @param 
    * @returns
    **/    
    
    /**
    * Query 6: Determinar o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de 
    * distintos clientes que o compraram (X é um inteiro dado pelo utilizador).
    * 
    * @param 
    * @returns
    **/
    
    /**
    * Query 7: Determinar, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado.
    * 
    * @param 
    * @returns
    **/
    
    /**
    * Query 8: Determinar os códigos dos X clientes (sendo X dado pelo utilizador) que compraram mais produtos diferentes 
    * (não interessa a quantidade nem o valor), indicando quantos, sendo o critério de ordenação a ordem decrescente do número de produtos.
    * 
    * @param 
    * @returns
    **/
    
    /**
    * Query 9: Dado o código de um produto que deve existir, determinar o conjunto dos X clientes que mais o compraram e, para cada um, 
    * qual o valor gasto (ordenação cf. 5).
    * 
    * @param 
    * @returns
    **/
    
    /**
    * Query 10:  Determinar mês a mês, e para cada mês filial a filial, a facturação total com cada produto.
    * 
    * @param 
    * @returns
    **/
    
    
   
    /** 
    * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem
    * @param Nome do ficheiro 
    **/
    public void saveStatus(String fileName) throws FileNotFoundException,IOException 
    {
       FileOutputStream fos = new FileOutputStream(fileName);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(this); //guarda-se todo o objecto de uma só vez
       oos.flush();
       oos.close();
    }
   
    /** 
    * Método que recupera uma instância de GestVendas de um ficheiro de objectos 
    * @param Nome do ficheiro 
    **/
    public static GestVendasModel loadStatus(String fileName) throws FileNotFoundException,IOException, ClassNotFoundException 
    {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      GestVendasModel gvm = (GestVendasModel) ois.readObject();
      ois.close();
      return gvm;
    } 
}