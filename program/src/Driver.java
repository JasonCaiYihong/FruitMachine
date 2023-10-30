import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Driver
{
    int qty = 0;//The quantity of users
    int size = 10;//The maximum of users
    int currUser = 0;//The current user
    String transCoin = "0";//Use String to avoid bug in the Scanner class
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
        //System.out.println(storedID[qty] + " " + storedPwd[qty] + " " + qty);
        qty++;
    }

    private String mainMenu()
    {
        System.out.print("""
        Fruit Machine Menu
        ------------------
        a) Login
        b) Register
        c) Ranking List
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
                    case "c" -> rankingList();
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
        System.out.println("One coin can be used for one round. Please enter the number of coins: ");
        transCoin = sc.nextLine();
        int coin = Integer.parseInt(transCoin);//Transfer String to int
        //System.out.println(coin);
        storedPlays[currUser] += coin;
        //System.out.println(storedPlays[currUser]);
        int score = 0;
        for(int i = 0; i < coin; i++)
        {
            score += game();
        }
        storedScore[currUser] += score;
        System.out.println(storedScore[currUser]);
        System.out.println("You get " + score + " !");
    }

    private void rankingList()
    {
        //bubble sort
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = 0; j < size - 1 - i; j++)
            {
                if(storedScore[j] < storedScore[j + 1])
                {
                    int temp1 = storedScore[j];
                    int temp2 = storedPlays[j];
                    String temp3 = storedID[j];
                    String temp4 = storedPwd[j];
                    storedScore[j] = storedScore[j + 1];
                    storedPlays[j] = storedPlays[j + 1];
                    storedID[j] = storedID[j + 1];
                    storedPwd[j] = storedPwd[j + 1];
                    storedScore[j + 1] = temp1;
                    storedPlays[j + 1] = temp2;
                    storedID[j + 1] = temp3;
                    storedPwd[j + 1] = temp4;
                }
            }
        }
        System.out.println("    Ranking List");
        System.out.println("-------------------");
        System.out.println("ID      Plays Score");
        for(int t = 0; t < size; t++)
        {
            System.out.printf("%-8s", storedID[t]);
            System.out.printf("%-6d", storedPlays[t]);
            System.out.printf("%-6d", storedScore[t]);
            System.out.println();
        }
    }
}


