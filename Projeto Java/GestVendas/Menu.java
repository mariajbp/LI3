import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
* Classe que implementa o menu
**/
public class Menu implements Screen<Integer> 
{
    private final String name; //menu name
    private final List<String> options;
    private int op;

    Menu(String name, List<String> options)
    {
        this.name = name;
        this.options = options;
        this.op = 0;
    }
   
    public Menu execute()
    {
        do
        {
            showMenu();
            this.op = readOption();
        }
        while(this.op == -1);
        return this;
    }
    
    public Integer getResult()
    {
        return this.op;
    }

    //printa menu
    private void showMenu()
    {
        System.out.println(UNDERLINE(RED("\n *** " + this.name + " Menu *** ")));
        for(int i = 0; i < this.options.size(); i++)
        {
            System.out.print(BOLD(String.valueOf(i + 1)));
            System.out.print(" - ");
            System.out.println(this.options.get(i));
        }
        System.out.println(BOLD("0") + " - Sair");
    }

    private int readOption()
    {
        int op;
        Scanner is = new Scanner(System.in);
        System.out.print("Opção: ");
        try
        {
            op = is.nextInt();
        }catch(InputMismatchException e){ op = -1;} //not int
        if(op < 0 || op > this.options.size())
        {
            System.out.println("Opçao Invalida");
            op = -1;
        }
        return op;
    }
}