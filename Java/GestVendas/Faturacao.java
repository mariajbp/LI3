import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
* 
**/
public class Faturacao implements Serializable 
{
    private double ftrTotal;
    private double[] ftrMensal;
    Map<Cliente, List<Integer>> clMes;
    Map<Produto, List<Integer>> prodMes;
    
    public Faturacao()
    {
        this.ftrTotal = 0.0;
        this. ftrMensal = new double[12];
        this.clMes = new HashMap<>();
        this.prodMes = new HashMap<>();
    }
    
    public Faturacao(double ftr, double ftmes, HashMap<Cliente, List<Integer>> cl, HashMap<Produto, List<Integer>> prod)
    {
        
    }
    
    public Faturacao(Faturacao f) 
    {
       this.ftrTotal = f.getFtrTotal();
       this.ftrMensal = f.getFtrMensal();
       this.clMes = f.getClMes();
       this.prodMes = f.getProdMes();
    }
    
    public double getFtrTotal(){ return this.ftrTotal;}
    public double[] getFtrMensal(){ return this.ftrMensal;}
    
    public Map<Cliente, List<Integer>> getClMes()
    {
       Map<Cliente, List<Integer>> c = new HashMap<Cliente, List<Integer>>();
       for(Map.Entry<> e : this.clMes.entrySet()) 
       {   
           Cliente cl = e.getValue().clone();
           c.put(e.getKey(), cl);
       }
       return c;
    }
    
    public Map<Produto, List<Integer>> getProdMes()
    {
    }
    
}
