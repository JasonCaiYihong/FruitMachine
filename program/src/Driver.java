import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Driver
{
    int qty = 0;//The quantity of users
    int size = 10;//The maximum of users
    int currUser = 0;//The current user
    String[] storedID = new String[size];
    String[] storedPwd = new String[size];
    int[] storedScore = new int[size];
    int[] storedPlays = new int[size];
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Driver driver = new Driver();
        driver.runMenu();
    }

    private void login()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Please enter your ID: ");
            String ID = sc.nextLine();
            System.out.println("Please enter your password: ");
            String pwd = sc.nextLine();
            //System.out.println(ID + pwd);
            boolean match = false;
            for(int t = 0; t < size; t++)
            {
                if((ID.equals(storedID[t]))&&(pwd.equals(storedPwd[t])))
                {
                    match = true;
                    currUser = t;
                    //System.out.println(t);
                }
            }
            if(match)
            {
                System.out.println("Login successfully!");
                break;
            }
            else if(2 - i == 0)
            {
                System.out.println("Your account has been locked.");
                while(true){}
            }
            else
            {
                System.out.println("The ID or password is incorrect.");
                System.out.println("You have " + (2 - i) + " more chances.");
            }
        }
        play();
    }

    private void register()
    {
        System.out.println("Please set your ID: ");
        storedID[qty] = sc.nextLine();
        System.out.println("Please set your password: ");
        storedPwd[qty]  = sc.nextLine();
        //System.out.println(StoredID[qty] + StoredPwd[Qty] + qty);
        qty++;
    }

    private String mainMenu()
    {
        System.out.print("""
        Fruit Machine Menu
        ------------------
        a) Login
        b) Register
        z) Exit     
        ==>>""");
        String option = sc.nextLine();
        return option;
    }

    private void runMenu()
    {
        String exit = "n";
        String option = mainMenu();
        while(!exit.equals("y"))
        {
            while(!option.equals("z")) {
                switch (option) {
                    case "a" -> login();
                    case "b" -> register();
                    default -> System.out.println("Invalid option entered: " + option);
                }
                System.out.println("\nPress enter to continue...");
                sc.nextLine();
                option = mainMenu();
            }
            System.out.println("Are you sure you want to exit?");
            System.out.println("All user data will be erased. y/n: ");
            exit = sc.nextLine();
            if(!exit.equals("y"))
            {
                option = mainMenu();
            }
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void FruitMachine()
    {

    }

    private String select()
    {
        Random rand = new Random();
        List<String> patterns = new ArrayList<>();
        patterns.add("apple");
        patterns.add("banana");
        patterns.add("grape");
        patterns.add("orange");
        patterns.add("lemon");
        patterns.add("cash");
        int index = rand.nextInt(patterns.size());
        String pattern = patterns.get(index);
        return pattern;
    }


    private int game()
    {
        int score = 0;
        String a = select();
        String b = select();
        String c = select();
        if((a.equals("cash"))&&(b.equals("cash"))&&(c.equals("cash")))
        {
            score = 5;
        }
        else if((a.equals(b))&&(a.equals(c)))
        {
            score = 3;
        }
        else if((a.equals(b))||(a.equals(c))||(b.equals(c)))
        {
            score = 1;
        }
        return score;
    }

    private void play()
    {
        System.out.println("Hello, " + storedID[currUser] + "! press enter to continue...");
        sc.nextLine();
        storedScore[currUser] = game();
        System.out.println("You get " + storedScore[currUser] + " in this round!");
    }
}


