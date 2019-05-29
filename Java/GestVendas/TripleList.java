import java.util.*;
/**
 * Write a description of class Triple here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TripleList 
{
   private List<Integer> left;
   private List<Integer> middle;
   private List<Integer> right;
   
   /**
    * Construtor Vazio 
    */
   public TripleList(){
       this.left = new ArrayList<Integer>(12);
       this.middle = new ArrayList<Integer>(12);
       this.right = new ArrayList<Integer>(12);
    }
    
   /**
    * Construtor parametrizado
    * @param listas de inteiros 
    */
   public TripleList(List<Integer> l, List<Integer> m, List<Integer> r){
       this.left = new ArrayList<Integer>(l);
       this.middle = new ArrayList<Integer>(m);
       this.right = new ArrayList<Integer>(r);
    }
    
   /**
    * Construtor de cópia
    * @param Triple
    */
   public TripleList(TripleList t){
       this.left = t.getLeft();
       this.middle = t.getMiddle();
       this.right = t.getRight();
    }
    
   //Getters
   public List<Integer> getLeft(){return new ArrayList<Integer>(this.left);} 
   public List<Integer> getMiddle(){return new ArrayList<Integer>(this.middle);} 
   public List<Integer> getRight(){return new ArrayList<Integer>(this.right);}
   public Integer getLeft(int index){
       if(this.left.size() <= index)
            return this.left.get(index);
       else 
            return -1;
    }
   public Integer getMiddle(int index){
       if(this.middle.size() <= index)
            return this.middle.get(index);
       else 
            return -1;
    }
   public Integer getRight(int index){
       if(this.right.size() <= index)
            return this.right.get(index);
       else 
            return -1;
    }
   
   //Setters
   public void setLeft(List<Integer> l){
       this.left.clear();
       this.left = new ArrayList<Integer>(l);
    }
   public void setMiddle(List<Integer> m){
       this.middle.clear();
       this.middle = new ArrayList<Integer>(m);
    }
   public void setRight(List<Integer> r){
       this.right.clear();
       this.right = new ArrayList<Integer>(r);
    }
    
   public void setLeft(int index, int value)
   {
       if(this.left.size() <= index)
             this.left.set(index, value);
   }
   
   public void setMiddle(int index, int value)
   {
       if(this.middle.size() <= index)
             this.middle.set(index, value);
   }
   
   
   public void setRight(int index, int value)
   {
       if(this.right.size() <= index)
             this.right.set(index, value);
   }
    
    
   /**
    * Clone
    * @param Triple 
    * @returns Triple
    */
   public TripleList clone(){return new TripleList(this);}
   
   
   /**
    * Equals
    * @param Object
    * @returns true se são iguais, false caso contrário
    */
   public boolean equals(Object o){
       if(o == this)
            return true;
       if(o == null || o.getClass() != this.getClass() )
            return false;
       TripleList t = (TripleList) o;
       return this.left.equals(t.getLeft()) && this.right.equals(t.getRight()) && this.middle.equals(t.getMiddle());
    }
   
   /**
    * Transforma um tripple numa string
    * @returns string
    */
   public String toString(){
       return "Left: " + this.left.toArray().toString() + 
              "\nMiddle: " +this.middle.toArray().toString() + 
              "\nRight: " + this.right.toArray().toString() + "\n";
   }
   
}