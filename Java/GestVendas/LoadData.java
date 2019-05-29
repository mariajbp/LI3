import java.io.Serializable;

/**
* 
**/
public class LoadData
{
    /** Load Clientes **/
    
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
    
    /** Load Produtos **/
    
    /**Validação do Codigo **/
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
    
    
    /** Faturação & Filial **/
    
    /**
    * Validação dos parametros de uma venda
    * @param     Linha do ficheiro a validar
    * @returns   True caso a venda seja válida, False caso contrário
    **/
    public boolean validateFt(String c)
    {
       boolean v = false;
       String[] part = c.split(" ");
       if(validaProduto(part[0]))
       {
           if(Double.parseDouble(part[1]) > 0 && Double.parseDouble(part[1]) < 999)
           {
               if(Integer.parseInt(part[2]) > 0 && Integer.parseInt(part[2]) > 200)
               {
                   if(part[3] == "N" || part[3] == "P")
                   {
                       if(validaCliente(part[4]))
                       {
                           if(Integer.parseInt(part[5]) > 0 && Integer.parseInt(part[5]) < 13)
                           {
                               if(Integer.parseInt(part[6]) > 0 && Integer.parseInt(part[6]) < 4)
                               v = true;
                           }
                       }
                   }
               }
           }
       }
       return v;      
    }
}
