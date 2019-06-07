import java.util.Objects;
import java.io.Serializable;

public class Pair<X extends Comparable<X>,Y extends Comparable<Y>> implements Comparable<Pair<X,Y>>, Serializable
{
    /** Primeiro elemento do par **/
    private X fst;
    
    /** Segundo elemento do par **/
    private Y snd;
    
    /** 
    * Construtor vazio que cria uma instância Pair
    **/
    public Pair()
    {
        this.fst = null;
        this.snd = null;
    }
    
    /** 
    * Construtor que cria um novo Pair a partir dos parâmetros dados  
    **/
    public Pair(X fst, Y snd)
    {
        this.fst = fst;
        this.snd = snd;
    }

    /** 
    * Método que calcula o hashcode da classe
    **/
    public int hashCode()
    {
        int hashFst = fst != null ? fst.hashCode() : 0;
        int hashSnd = snd != null ? snd.hashCode() : 0;
        return (hashFst + hashSnd) * hashSnd + hashFst;
    }
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      Objeto a ser testado
    * @returns     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
    public boolean equals(Object o)
    {
        if(o instanceof Pair)
        {
            Pair p = (Pair) o;
            return Objects.equals(this.fst, p.fst) && Objects.equals(snd, p.snd);
        }
        return false;
    }
    
    /**
    * Método que converte uma identificação numa string
    **/
    public String toString(){return "(" + fst + ", " + snd + ")";}
    
    /**
    * Método que devolve o primeiro elemento do par
    * @returns Primeiro elemento do par
    **/
    public X getFst(){return fst;}
    
    /**
    * Método que define o primeiro elemento do par
    * @param Primeiro elemento do par
    **/
    public void setFst(X fst){this.fst = fst;}
    
    /**
    * Método que devolve o segundo elemento do par
    * @returns Segundo elemento do par
    **/
    public Y getSnd(){return snd;}
    
    /**
    * Método que define o segundo elemento do par
    * @returns Segundo elemento do par
    **/
    public void setSnd(Y snd){this.snd = snd;}
    
    /**
    * Método que determina se um par está vazio
    * @returns True caso esteja vazio, False caso contrário
    **/
    public boolean isEmpty()
    {
        if(this.fst == null || this.snd == null)
            return true;
        else 
            return false;
    }
    
    /**
    * Método que implementa um comparador de Pair
    * @param Pair p 
    **/
    public int compareTo(Pair<X,Y> p)
    {
        int r = snd.compareTo(p.getSnd());
        return (r == 0) ? fst.compareTo(p.getFst()) : r;
    }
}
