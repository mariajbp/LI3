import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
* Classe agregadora do projeto
**/
public class GestVendasAppMVC
{
  private final Visual visual;
  private boolean loaded = false;
  private String path;

  public static void main(String[] args)
  {
        
  }

  private void run(String[] args)
  {
        boolean choices = true;
        while(choices)
        {
            int i = this.visual.runMainMenu();
            switch(i)
            {
                case 1:                
                    getPath(args);
                    pickQuery();
                    break;
                default:choices = false;
            }
        }
    }

  //runall queries
   private void pickQuery()
   {
      boolean choices = true;
      while(choices)
      {
            int i = this.visual.runPickQueryMenu();
            if(i != 0)
            {
                switch(i)
                {
                    case 1:
                        //run query 
                        break;
                    case 2:
                        //run query 
                        break;
                    case 3:
                        //run query 
                        break;
                    case 4:
                        //run query 
                        break;
                    case 5:
                        //run query 
                        break;
                    case 6:
                        //run query 
                        break;
                    case 7:
                        //run query 
                        break;
                    case 8:
                        //run query 
                        break;
                    case 9:
                        //run query 
                        break;
                    case 10:
                        //run query 
                        break;
                    case 11:
                        //run query 
                        break;
                }
                this.visual.requestContinue();
            }else{choices = false;}
      }
    }
   
   

   
   
   
   private void getPath(String[] args)
   {
       if(args.length == 0)
       {
            this.path = this.visual.requestPath();
       }else
       {
            this.path = args[0];
       }
   }
}

