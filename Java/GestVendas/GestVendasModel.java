import java.io.Serializable;
import java.io.IOException;
import java.io.*; 

/**
* 
**/
public class GestVendasModel implements Serializable
{
    private ICatProdutos cprod;
    private ICatClientes ccl;
    //...
    
    public void createData()
    {
        //PreencheProds();
        //PreencheCl();
        //PreencheFtr();
        //PreencheFilial();
    }
    
    public void preencheProds()
    {
    }
    
    public void preencheCl()
    {
    }
    
    public void preencheFtr()
    {
    }
    
    public void preencheFilial()
    {
    }
    
    /** 
    * Query1: Lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total.
    * 
    * @param 
    * @returns
    **/
    
    /** 
    * Query 2:  Dado um mês válido, determinar o número total global de vendas realizadas e o número total de clientes distintos que as fizeram; 
    * Fazer o mesmo mas para cada uma das filiais.
    * 
    * @param 
    * @returns
    **/ 
    
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
    * Método que guarda o estado de uma instância num ficheiro de texto
    **/
    public void writeToTxt(String fileName) throws IOException 
    {
       PrintWriter fich = new PrintWriter(fileName);
       fich.println("------- UMCJ --------");
       fich.println(this.toString());
       fich.flush();
       fich.close();
    }
   
    /** 
    * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem
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
   
    public static UMCarroJa loadStatus(String fileName) throws FileNotFoundException,IOException, ClassNotFoundException 
    {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      UMCarroJa umcj = (UMCarroJa) ois.readObject();
      ois.close();
      return umcj;
    } **/
}