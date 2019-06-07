import java.util.Objects;
import java.io.Serializable;

public class Pair<X extends Comparable<X>,Y extends Comparable<Y>> implements Comparable<Pair<X,Y>>, Serializable
{
    private X fst;
    private Y snd;
    
    public Pair()
    {
        this.fst = null;
        this.snd = null;
    }
    
    public Pair(X fst, Y snd)
    {
        this.fst = fst;
        this.snd = snd;
    }

    public int hashCode()
    {
        int hashFst = fst != null ? fst.hashCode() : 0;
        int hashSnd = snd != null ? snd.hashCode() : 0;
        return (hashFst + hashSnd) * hashSnd + hashFst;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Pair)
        {
            Pair p = (Pair) o;
            return Objects.equals(this.fst, p.fst) && Objects.equals(snd, p.snd);
        }
        return false;
    }

    public String toString(){return "(" + fst + ", " + snd + ")";}

    public X getFst(){return fst;}
    public void setFst(X fst){this.fst = fst;}

    public Y getSnd(){return snd;}
    public void setSnd(Y snd){this.snd = snd;}
    
    public boolean isEmpty(){
        if(this.fst == null || this.snd == null)
            return true;
        else 
            return false;
    }
    
    public int compareTo(Pair<X,Y> p){
        int r = snd.compareTo(p.getSnd());
        return (r == 0) ? fst.compareTo(p.getFst()) : r;
    }
}
