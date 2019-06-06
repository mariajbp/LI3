import java.io.Serializable;


import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.Set;

import java.lang.System;
/**
* Classe Faturação que contém estruturas com dados de uma faturação
**/
public class Faturacao implements Serializable, IFaturacao   
{  
    /** Faturação total **/
    private double ftrTotal;
    
    /** Array da faturação mensal **/
    private double[][] ftrMensal; //por filial
    
     
    /** 
    * Construtor vazio que cria uma instância Faturacao
    **/
    public Faturacao()
    {
        this.ftrTotal = 0.0;
        this.ftrMensal = new double[3][12];
    }
    
    /** 
    * Construtor que cria uma nova Faturacao a partir dos parâmetros dados 
    **/
    public Faturacao(double ftr, double[][] ftrmes)
    {
        this.ftrTotal = ftr;
        int i = 0;
        
        while(i < 3)
        {
            System.arraycopy(ftrmes[i], 0, this.ftrMensal[i], 0, ftrmes.length);
        }
    }
    
    /** 
    * Construtor de cópia que cria uma nova instância Faturacao a partir de uma Faturacao passado como parâmetro 
    **/
    public Faturacao(Faturacao f) 
    {
       this.ftrTotal = f.getFtrTotal();
       this.ftrMensal = f.getFtrMensal();
    }
    
    /**
    * Método que devolve a fatuação total global
    * @return Fatuação total global
    **/
    public double getFtrTotal(){ return this.ftrTotal;}
    
    /**
    * Método que devolve a fatuação total mnsal
    * @return Fatuação total mensal
    **/
    public double[][] getFtrMensal(){ return this.ftrMensal.clone();}
    
    public double getFtrMensal(int mes, int filial){return this.ftrMensal[filial][mes-1];}
    
    /** 
    * Método que cria uma cópia de uma identificação de uma Faturação
    **/ 
    public Faturacao clone(){return new Faturacao(this);}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    {
      if(this == o) return true;
      if(o == null || this.getClass() != o.getClass()) return false;
      Faturacao f  = (Faturacao) o;     
      return this.ftrTotal == f.getFtrTotal() && this.ftrMensal.equals(f.getFtrMensal());
             
    }
    
    /**
    * Método que converte uma identificação numa string 
    **/
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append("Total global faturado:").append(ftrTotal).append("\n");
       return sb.toString();
    }
    
    public void updateFtrTotal(double preco, int unidades)
    {
        this.ftrTotal += (preco*unidades);
    }
    
    public void updateFtrMensal(int mes, int filial, int unidades, double preco)
    {
        double tmp = this.ftrMensal[filial-1][mes-1];
        tmp+= (preco*unidades);
        this.ftrMensal[filial-1][mes-1] = tmp;
    }
    
    /**
    * Método que divide as carateristicas de uma venda pelos Maps da classe
    * @param Venda a adicionar
    **/
    public void addVenda(Venda v)
    {
       updateFtrTotal(v.getPreco(), v.getUnidades());
       updateFtrMensal(v.getMes(), v.getFilial(), v.getUnidades(), v.getPreco());
    } 
}