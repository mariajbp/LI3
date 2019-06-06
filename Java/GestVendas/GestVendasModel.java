import java.io.Serializable;
import java.io.IOException;
import java.io.*;  
import java.util.TreeSet; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;


import static java.lang.System.out;

/**
* 
**/
public class GestVendasModel implements Serializable, IGestVendasModel   
{ 
    /** Instancia da interface CatalogoProdutos **/
    private ICatProdutos cprod; 
    
    /** Instancia da interface CatalogoClientes **/
    private ICatClientes ccl;
    
    /** Instancia da interface Filial, que representa a filial 1 **/
    private IFilial f1;
    
    /** Instancia da interface Filial, que representa a filial 2 **/
    private IFilial f2;
    
    /** Instancia da interface Filial, que representa a filial 3 **/
    private IFilial f3;
    
    /** Instancia da interface Faturacao **/
    private IFaturacao ftr;
    
    /** Instancia da interface Estatisticas **/
    private IEstatisticas e;

    /** 
    * Construtor vazio que cria uma instância GestVendasModel
    **/
    public GestVendasModel()
    {
        this.cprod = new CatalogoProdutos();
        this.ccl = new CatalogoClientes();
        this.f1 = new Filial();
        this.f2 = new Filial();
        this.f3 = new Filial();
        this.ftr = new Faturacao();
        this.e = new Estatisticas();
    }
    
    /**
    * Método que carrega o ficheiro de dados default da aplicação
    **/
    public void carregamentoDefault()
    {
        try
        { 
            preencheCl("../../../Clientes.txt"); 
            preencheProds("../../../Produtos.txt");
            preencheVendas("../../../Vendas1M.txt");
        } catch (IOException e) {e.printStackTrace();}
    }
    
    /**
    * Método que carrega outro ficheiro dado pelo utilizador
    **/
    public void outroFicheiro(int op) throws IOException
    {
        String[] filename = new String[3];
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader("../config"));
        try
        {
           String line = null;
           while ((line = br.readLine()) != null && i < 3) 
           {
              filename[i] = line;
              i++;
           }     
           if(op == 1){preencheCl(filename[0]);}
           if(op == 2){preencheProds(filename[1]);}
           if(op == 3)
           {
              preencheProds(filename[1]); 
              preencheCl(filename[0]);
              preencheVendas(filename[2]);
           }
        }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
    }
    
    /**
    * Método que preenche o catalogo de produtos
    * @param    Nome do ficheiro a carregar
    * @returns  Número de produtos válidos
    **/
    private void preencheProds(String fileName) throws IOException 
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
                   Produto p = new Produto(line);
                   cprod.addProduto(p);   
                   v++;
               }
           }
           e.setProdutos(v);
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
      out.println("PRODUTOS DONE");
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
    private void preencheCl(String fileName) throws IOException 
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
                   Cliente c = new Cliente(line);
                   ccl.addCliente(c); 
                   v++;
               }
           }
           e.setClientes(v);
       }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
       out.println("CLIENTES DONE");
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
      int vValidas = 0, vLidas = 0, c0 = 0;
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
                       else if(venda.getFilial() == 2)
                              f2.addVenda(venda);
                             else
                                 f3.addVenda(venda);
                                
                   ftr.addVenda(venda);
                   if(venda.getPreco() == 0.0) c0++;
                   vValidas++;
               }
               vLidas++;
           }
           e.setVendasValidas(vValidas);
           e.setVendasLidas(vLidas);
           e.setCompras_0(c0);
           out.println(vValidas);
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
      out.println("VENDAS DONE");
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
       if(part.length == 7)
       {
           if(validaProduto(part[0]) && cprod.containsProduto(part[0]))
           {
               if(Double.parseDouble(part[1]) > 0 && Double.parseDouble(part[1]) < 999)
               {
                   if(Integer.parseInt(part[2]) > 0 && Integer.parseInt(part[2]) < 200)
                   {
                       if(part[3].equals("N") || part[3].equals("P"))
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
        }
       return validade;      
    }
    
    public int estatisticaProduto()
  {
    Set<Produto> todosProdutos = cprod.getCatalogo();
    Set<Produto> p = new TreeSet();

    f1.getProdutos(p);
    f2.getProdutos(p);
    f3.getProdutos(p);

    e.setTotalProdutosComprados(p.size());
    // assign do nr de produtos comprados

    return (todosProdutos.size() - p.size());
    // return do nr de produtos nao comprados
  }

  /* 
    public int estatisticaCliente()
  {
    Set<Cliente> todosClientes = cprod.getCalalogo();
    Set<Cliente> c = new TreeSet();

    f1.getClientes(c); // nao existe
    f2.getClientes(c); // nao existe
    f3.getClientes(c); // nao existe

    e.setClientesCompraram(c.size());

    return (todosClientes.size() - c.size());
  }
    */
    
    /**** QUERY1 ****/
    /** 
    * Metodo que devolve a lista ordenada alfabeticamente com os códigos dos produtos nunca comprados e o seu respectivo total.
    * @param      Catalogo de produtos
    * @returns    Instancia de uma faturação 
    **/  
    public List<Produto> prodsNuncaComprados()
    {
       List<Produto> lp = new ArrayList<>();
       Set<Produto> prodsAll = cprod.getCatalogo();
       Set<Produto> prods = new TreeSet<>();
       
       f1.getProdutos(prods);
       f2.getProdutos(prods);
       f3.getProdutos(prods);
       
       out.println(prods.size()+ " prods");

       
       Iterator<Produto> it = prodsAll.iterator();
       while(it.hasNext())
       {
          Produto p = it.next();
          if(!prods.contains(p))
          {
              lp.add(p);
          }
       } 
       
       out.println(lp.size() + " LP");
       
       return lp;
    } 
    

   
    
    /**** QUERY2 ****/
    /** 
    * Método que dado um mês válido, determina o número total global de vendas realizadas e o número total de clientes distintos que a realizaram
    * @param     Mês a calcular
    * @returns   Número total global de vendas realizadas e número distinto de clientes
    **/
    public Pair<Integer,Integer> totalVendasRealizadas(int mes, int filial)
    {
       int total = 0;
       int cl = 0;
       Set<Produto> prd;
       
       if(filial == 1)
       {
           total = f1.totalVendas(mes); 
           if(total > 0){
               prd = this.f1.getProdutos();
               Iterator it = prd.iterator(); 
               while(it.hasNext()){
                  Produto p = (Produto) it.next(); 
                  cl += f1.getClientesDistintos(p, mes);  
               }
            }
       }
       else{
           if(filial == 2)
           {
               total = f2.totalVendas(mes); 
               if(total > 0){
                   prd = this.f2.getProdutos();
                   Iterator it = prd.iterator();
                   while(it.hasNext()){
                      Produto p = (Produto) it.next(); 
                      cl += f2.getClientesDistintos(p, mes);  
                   }
                }
           }
           else{
               if(filial == 3)
               {
                   total = f3.totalVendas(mes); 
                   if(total > 0){
                       prd = this.f3.getProdutos();
                       Iterator it = prd.iterator();
                       while(it.hasNext()){
                          Produto p = (Produto) it.next(); 
                          cl += f3.getClientesDistintos(p, mes);  
                       }
                    }
               }
            }
       }
       
       Pair<Integer,Integer> pair = new Pair(total, cl);
       return pair;
    }
     
    
    
    /**** QUERY3 ****/
    /** 
    * Método que dado um código de cliente determina, para cada mês, quantas compras fez.
    * @param     Cliente introduzido pelo utilizador
    * @returns
    **/
    public Pair<Integer,Double> totalComprasCliente(Cliente c, int mes) 
    {
        Pair<Integer,Double> l = new Pair<>();
        int compras = 0;
        double total = 0;
        
        l = f1.comprasTotais(c, mes);
        compras += l.getFst();
        total += l.getSnd();
        
        l = f2.comprasTotais(c, mes);
        compras += l.getFst();
        total += l.getSnd();
        
        l = f3.comprasTotais(c, mes);
        compras += l.getFst();
        total += l.getSnd();
        
        l.setFst(compras);
        l.setSnd(total);
        
        return l;
    } 
    
    public int totalProdutosDistintos(Cliente c, int mes)
    {
        Set<Produto> s = new TreeSet<>();
        f1.ProdutosDistintos(s, mes, c);
        f2.ProdutosDistintos(s, mes, c);
        f3.ProdutosDistintos(s, mes, c);
        return s.size(); 
    }
    
    /** 
    * Método que dado um código de cliente determina, para cada mês, quantos produtos distintos comprou.
    * @param      Cliente introduzido pelo utilizador
    * @returns
    **/
    /*
    public List<Pair> totalComprasCliente(Cliente c)
    {
        Pair<Integer,Double> p;
        Filial f = new Filial();
        List<Pair> l = new ArrayList<>();
        Map<Cliente, List<Pair>> unidadesGasto = f.getCUnidadesGasto(); 
        
        for (Map.Entry<Cliente, List<Pair>> e : unidadesGasto.entrySet())
        {
            if(e.getKey() == c)
            {
                Iterator<Pair> it = e.getValue().iterator();  
                p = it.next();
                {
                    p.setFst(p.getFst());
                    p.setSnd(p.getSnd());
                }
            }
        }
        return l;
    }*/
    
    
    
    /**** QUERY4 ****/
    /**
    * Método que dado o código de um produto existente, determina, mês a mês, quantas vezes foi comprado
    * @param       Produto introduzido pelo utilizador
    * @returns
    **/ 
    
    public Pair<Integer, Integer> comprasPorMes(Produto p, int mes)
    {
        Pair<Integer, Integer> pair = new Pair<>();
        int quantos = f1.getUnidadesMes(p, mes);
        quantos += f2.getUnidadesMes(p, mes);
        quantos += f3.getUnidadesMes(p, mes);
        
        int cl = 0;
        
        cl += f1.getClientesDistintos(p, mes); 
        
        cl += f2.getClientesDistintos(p, mes);
        
        cl += f3.getClientesDistintos(p, mes);
        
        pair.setFst(quantos); 
        pair.setSnd(cl);
        return pair;
    }
    
    public Double faturadoPorMes(Produto p, int mes)
    {
        double f = 0;
        f += f1.getFtrMensal(p, mes);
        f += f2.getFtrMensal(p, mes);
        f += f3.getFtrMensal(p, mes);
        return f;
    }
   
    /**** QUERY5 ****/
    /** 
    * Método que dado o código de um cliente determinar a lista de códigos de produtos que mais comprou (e quantos), ordenada por ordem 
    * decrescente de quantidade e, para quantidades iguais, por ordem alfabética dos códigos.
    * @returns
    **/   
    //public ? prodsMaisComprados(){} + comparator 
    
    
    /**** QUERY 6 ****/
    /**
    * Método que determina o conjunto dos X produtos mais vendidos em todo o ano (em número de unidades vendidas) indicando o número total de 
    * distintos clientes que o compraram.
    * @param     Número de produtos a determinar, introduzido pelo utilizador
    * @returns
    **/

    public List<Produto> prodsMaisVendidos(int x, int filial)
    {
        int total = 0;
        int i = 0;
        List<Produto> list = new ArrayList<>();
        List<Pair<Produto, Integer>> cl;
        Set<Pair<Produto, Integer>> clOrder;
        if(filial == 1)
        {
            cl = f1.getProdUnidades();
            clOrder = new TreeSet<>(new MaisCompradosComparator());
            
            for(Pair<Produto, Integer> p: cl){clOrder.add(p);}
            
            Iterator<Pair<Produto, Integer>> it = clOrder.iterator();
            while(it.hasNext() && i < x)
            {
                Pair<Produto, Integer> pair = it.next();
                list.add(pair.getFst());
                i++;
            }            
            return list;
        } 
        else
        {
            if(filial == 2)
            {
                cl = f2.getProdUnidades();
                clOrder = new TreeSet<>(new MaisCompradosComparator());
                
                for(Pair<Produto, Integer> p: cl){clOrder.add(p);}
                out.println(clOrder.size());
                Iterator<Pair<Produto, Integer>> it = clOrder.iterator();
                while(it.hasNext() && i < x)
                {
                    Pair<Produto, Integer> pair = it.next();
                    list.add(pair.getFst());
                    i++;
                }
                return list;
            }
            else
            {
                if(filial == 3)
                {
                    cl = f3.getProdUnidades();
                    clOrder = new TreeSet<>(new MaisCompradosComparator());
                    
                    for(Pair<Produto, Integer> p: cl){clOrder.add(p);}
                    Iterator<Pair<Produto, Integer>> it = clOrder.iterator();
                    while(it.hasNext() && i < x)
                    {
                        Pair<Produto, Integer> pair = it.next();
                        list.add(pair.getFst());
                        i++;
                    }
                    return list;
                } 
            }
        }
        return list;
    }
    
    public List<Pair<Produto,Integer>> cldistintos(List<Produto> lp, int filial)
    {
        int total = 0;
        Produto prod = new Produto();
        List<Pair<Produto,Integer>> l = new ArrayList<>();
        
        Iterator<Produto> it = lp.iterator();
        while(it.hasNext())
        {
            Pair<Produto,Integer> pair = new Pair<>();
            prod = it.next();
            if(filial == 1)
            {
                   total = f1.clDistintos(prod);
                   pair.setFst(prod);
                   pair.setSnd(total);
                   l.add(pair);
            }
            else{
                if(filial == 2)
                {
                   total = f2.clDistintos(prod);
                   pair.setFst(prod);
                   pair.setSnd(total);
                   l.add(pair);
                }
                else{
                    if(filial == 3)
                    {
                       total = f3.clDistintos(prod);
                       pair.setFst(prod);
                       pair.setSnd(total);
                       l.add(pair);
                    }
                }
            }
        }
        return l;
    }
    
    public List<Pair<Produto,Integer>> prodsEcldistintos(List<Pair<Produto,Integer>> l1, List<Pair<Produto,Integer>> l2, List<Pair<Produto,Integer>> l3, int x)
    {
        int i = 0;
        
        Pair<Produto,Integer> p = new Pair();
        Pair<Produto,Integer> p2 = new Pair();
        Pair<Produto,Integer> p3 = new Pair();
        List<Pair<Produto,Integer>> l = new ArrayList<>();
        
        Set<Pair<Produto,Integer>> set = new TreeSet<>(new MaisCompradosComparator());
        set.addAll(l1);
        
        Iterator<Pair<Produto,Integer>> its = l2.iterator();
        while(its.hasNext())
        {
            p2 = its.next();
            if(!set.contains(p2.getFst()))
            {
                set.add(p2);
            }
        }

        Iterator<Pair<Produto,Integer>> it3 = l3.iterator();
        while(its.hasNext())
        {
            p3 = its.next();
            if(!set.contains(p3.getFst()))
            {
                set.add(p3);
            }
        }
        
        
        Iterator<Pair<Produto,Integer>> it = set.iterator();
        while(it.hasNext() && i<x)
        {
            p = it.next();
            l.add(p); 
            i++;
        }
        return l;
    }
    
    /**** QUERY7 ****/
    /**
    * Método que determina, para cada filial, a lista dos três maiores compradores em termos de dinheiro facturado.
    * @returns
    **/
    public List<Cliente> maioresCompradores(int filial)
    {
        int i = 0;
        List<Cliente> list = new ArrayList<>();
        List<Pair<Cliente, Double>> cl;
        Set<Pair<Cliente, Double>> clOrder;
        if(filial == 1)
        {
            cl = f1.getClientesFaturacao();
            clOrder = new TreeSet<>(new MaiorCompradorComparator());
            
            for(Pair<Cliente, Double> p: cl){clOrder.add(p);}
            
            Iterator<Pair<Cliente, Double>> it = clOrder.iterator();
            while(it.hasNext() && i < 3)
            {
                Pair<Cliente, Double> pair = it.next();
                list.add(pair.getFst());
                i++;
            }
            return list;
        } 
        else
        {
            if(filial == 2)
            {
                cl = f2.getClientesFaturacao();
                clOrder = new TreeSet<>(new MaiorCompradorComparator());
                
                for(Pair<Cliente, Double> p: cl){clOrder.add(p);}
                
                Iterator<Pair<Cliente, Double>> it = clOrder.iterator();
                while(it.hasNext() && i < 3)
                {
                    Pair<Cliente, Double> pair = it.next();
                    list.add(pair.getFst());
                    i++;
                }
                return list;
            }
            else
            {
                if(filial == 3)
                {
                    cl = f3.getClientesFaturacao();
                    clOrder = new TreeSet<>(new MaiorCompradorComparator());
                    
                    for(Pair<Cliente, Double> p: cl){clOrder.add(p);}
                    
                    Iterator<Pair<Cliente, Double>> it = clOrder.iterator();
                    while(it.hasNext() && i < 3)
                    {
                        Pair<Cliente, Double> pair = it.next();
                        list.add(pair.getFst());
                        i++;
                    }
                    return list;
                } 
            }
        }
        return list;
    }  
    
    
    /**** QUERY8 ****/
    /**
    * Método que determina os códigos dos X clientes (sendo X dado pelo utilizador) que compraram mais produtos diferentes 
    * (não interessa a quantidade nem o valor), indicando quantos, sendo o critério de ordenação a ordem decrescente do número de produtos.
    * @param       Número de clientes a determinar, introduzido pelo utilizador
    * @returns
    **/
    public List<Pair<Cliente,Integer>> clientesMaisCompraram(int x, int filial)
    {
        int total = 0;
        int i = 0;
        List<Pair<Cliente, Integer>> list = new ArrayList<>();
        List<Pair<Cliente, Integer>> cl;
        Set<Pair<Cliente, Integer>> clOrder;
        if(filial == 1)
        {
            cl = f1.getClientesProdutosDistintos();
            
            clOrder = new TreeSet<>(new ProdutosDiferentesComparator());
            
            for(Pair<Cliente, Integer> p: cl){clOrder.add(p);}
            
            Iterator<Pair<Cliente, Integer>> it = clOrder.iterator();
            while(it.hasNext() && i < x)
            {
                Pair<Cliente, Integer> pair = it.next();
                list.add(pair);
                i++;
            }         
            
            Collections.sort(list, new DecrescenteComparator());
            return list;
        } 
        else
        {
            if(filial == 2)
            {
                cl = f2.getClientesProdutosDistintos();
                
                clOrder = new TreeSet<>(new ProdutosDiferentesComparator());
                
                
                for(Pair<Cliente, Integer> p: cl){clOrder.add(p);}
                
                Iterator<Pair<Cliente, Integer>> it = clOrder.iterator();
                while(it.hasNext() && i < x)
                {
                    Pair<Cliente, Integer> pair = it.next();
                    list.add(pair);
                    i++;
                }   
                
                Collections.sort(list, new DecrescenteComparator());
                return list;
            }
            else
            {
                if(filial == 3)
                {
                    cl = f3.getClientesProdutosDistintos();
                    
                    clOrder = new TreeSet<>(new ProdutosDiferentesComparator());
                    
                    for(Pair<Cliente, Integer> p: cl){clOrder.add(p);}
                    
                    Iterator<Pair<Cliente, Integer>> it = clOrder.iterator();
                    while(it.hasNext() && i < x)
                    {
                        Pair<Cliente, Integer> pair = it.next();
                        list.add(pair);
                        i++;
                    }    
                    
                    Collections.sort(list, new DecrescenteComparator());
                    return list;
                } 
            }
        }
        return list;
    }
    
    
    /**** QUERY9****/
    /**
    * Método que dado o código de um produto que deve existir, determinar o conjunto dos X clientes que mais o compraram e, para cada um, 
    * qual o valor gasto (ordenação cf. 5).
    * @param       Código do produto a determinar, introduzido pelo utilizador
    * @returns
    **/ 
    
    public List<Pair<Cliente, Integer>> xClientesMaisCompraram(Produto p, int x, int filial)
    {
        List<Pair<Cliente, Integer>> l = new ArrayList<>();
        Pair<Cliente, Integer> pair;
        int i = 0;
        if(filial == 1)
        {
            Set<Cliente> sc = f1.getClientes(p);
            Iterator<Cliente> it = sc.iterator();
            while(it.hasNext() && i < x)
            {
                Cliente c = it.next();
                int snd = f1.clienteUnidadesAnual(c).getSnd(); 
                pair = new Pair(c, snd);
                l.add(pair);
                i++;
            }
            Collections.sort(l, new DecrescenteComparator());
            return l;
        }
        else
        {
            if(filial == 2)
            {
                Set<Cliente> sc = f2.getClientes(p);
                Iterator<Cliente> it = sc.iterator();
                while(it.hasNext() && i < x)
                {
                    Cliente c = it.next();
                    int snd = f2.clienteUnidadesAnual(c).getSnd(); 
                    pair = new Pair(c, snd);
                    l.add(pair);
                    i++;
                }
                Collections.sort(l, new DecrescenteComparator());
                return l;
            
            }
            else
            {
                if(filial == 1)
                {
                    Set<Cliente> sc = f3.getClientes(p);
                    Iterator<Cliente> it = sc.iterator();
                    while(it.hasNext() && i < x)
                    {
                        Cliente c = it.next();
                        int snd = f3.clienteUnidadesAnual(c).getSnd(); 
                        pair = new Pair(c, snd);
                        l.add(pair);
                        i++;
                    }
                    Collections.sort(l, new DecrescenteComparator());
                    return l;
                }
                   
            }
        }
        return l;
    }

    public List<Pair<Cliente, Double>> xClientes_valorGasto(Produto p, int x, int filial)
    {
        List<Pair<Cliente, Double>> l = new ArrayList<>();
        Pair<Cliente, Double> pair;
        if(filial == 1)
        {
            Set<Cliente> sc = f1.getClientes(p);
            Iterator<Cliente> it = sc.iterator();
            while(it.hasNext())
            {
                Cliente c = it.next();
                double fst = f1.clienteGastoAnual(c).getSnd();
                pair = new Pair(c, fst);
                l.add(pair);
            }
            return l;
        }
        else
        {
            if(filial == 2)
            {
                Set<Cliente> sc = f2.getClientes(p);
                Iterator<Cliente> it = sc.iterator();
                while(it.hasNext())
                {
                    Cliente c = it.next();
                    double fst = f2.clienteGastoAnual(c).getSnd();
                    
                    pair = new Pair(c, fst);
                    l.add(pair);
                }
                return l;
            
            }
            else
            {
                if(filial == 1)
                {
                    Set<Cliente> sc = f3.getClientes(p);
                    Iterator<Cliente> it = sc.iterator();
                    while(it.hasNext())
                    {
                        Cliente c = it.next();
                        double fst = f3.clienteGastoAnual(c).getSnd();
                        pair = new Pair(c, fst);
                        l.add(pair);
                    }
                    return l;
                }
                   
            }
        }
        return l;
    }

    
    /**** QUERY10 ****/
    /**
    * Método que determina mês a mês, e para cada mês filial a filial, a facturação total de cada produto.
    * @returns Mapa que contém mês a mês, e para cada mês filial a filial, a facturação total de cada produto
    **/
    /*
    public Map<Produto, List<Double>> ftrTotal(int filial)
    {
        Faturacao f = new Faturacao();
        Map<Produto, List<Double>> map = new HashMap<>();
        
        if(filial == 1){map = f.getProdPrecoMes1();}
        if(filial == 2){map = f.getProdPrecoMes2();}  
        if(filial == 3){map = f.getProdPrecoMes3();}
        
        return map;
    }
    
    */
   
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
    public GestVendasModel loadStatus(String fileName) throws FileNotFoundException,IOException, ClassNotFoundException 
    {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      GestVendasModel gvm = (GestVendasModel) ois.readObject();
      ois.close();
      return gvm;
    } 
}
