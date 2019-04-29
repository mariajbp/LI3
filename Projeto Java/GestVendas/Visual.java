import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static java.util.Arrays.asList;

public class Visual
{
    private static final String RESET = "\033[0m"; /**  reset das cores **/
    private Menu mainMenu;
    private Menu pickQueryMenu;

    public int runMainMenu()
    {
        if(this.mainMenu == null) makeMainMenu();
        this.mainMenu.execute();
        return this.mainMenu.getResult();
    }
     //cria main menu
    private void createMainMenu()
    {
        this.mainMenu = new Menu("Main", asList("Run all queries","Pick one query (pick parameters)"));
    }
    
    
    public int runPickQueryMenu()
    {
        if(this.pickQueryMenu == null) makePickQueryMenu();
        this.pickQueryMenu.execute();
        return this.pickQueryMenu.getResult();
    }
    //cria menu de escolha da query
    private void createPickQueryMenu()
    {
        List<String> options = new ArrayList<>();
        for(int i = 1; i < 12; i++) options.add("Query " + i);
        this.pickQueryMenu = new Menu("Escolhe uma query", options);
    }
   

    /**
     * Apresenta os resultados da query
     * @param queryNum O número da query
     * @param parameters Os parâmetros da query
     * @param result Os resultados da query
     * @param time O tempo que a query demorou
     */
    public void showResults(int num, List parameters, Object result, long time)
    {
        System.out.print(BOLD(BLUE("Query " + num + ": ")));
        System.out.println(PURPLE(parameters.toString()));
        System.out.println(BLUE(result.toString()));
        System.out.println(PURPLE("Demorou: " + time + "segundos"));
    }

    //pede ao user caminho 
    public String requestPath()
    {
       
    }

    

   
    public void printsError(String bold, String normal)
    {
        System.out.println(RED(BOLD(bold)) + RED(normal));
    }
    
    public void requestContinue()
    {
        System.out.print("Prima ENTER para continuar: ");
        new Scanner(System.in).nextLine();
    }
    
    //String a vermelho
    static String RED(String s){return "\033[31m" + s + RESET;}
    //String a verde
    static String GREEN(String s){return "\033[32m" + s + RESET;}
    //String a azul
    static String BLUE(String s){return "\033[34m" + s + RESET;}
    //String a Roxo
    static String PURPLE(String s){return "\033[35m" + s + RESET;}
    //Negrito
    static String BOLD(String s){return "\033[1m" + s + RESET;}
    //sublinha
    static String UNDERLINE(String s){ return "\033[4m" + s + RESET;}
}
