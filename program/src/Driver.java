import java.util.Scanner;
public class Driver
{
    int qty = 0;//The quantity of users
    int size = 10;//The maximum of users
    String[] StoredID = new String[size];
    String[] StoredPwd = new String[size];
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
                if((ID.equals(StoredID[t]))&&(pwd.equals(StoredPwd[t])))
                {
                    match = true;
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

    }

    private void register()
    {
        System.out.println("Please set your ID: ");
        StoredID[qty] = sc.nextLine();
        System.out.println("Please set your password: ");
        StoredPwd[qty]  = sc.nextLine();
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
                System.out.println("\nPress enter key to continue...");
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

    /*private void runMenu()
    {
        String option = mainMenu();
        while(!option.equals("z"))
        {
            switch(option)
            {
                case "a" -> login();
                case "b" -> register();
                default -> System.out.println("Invalid option entered: "+option);
            }
            System.out.println("\nPress enter key to continue...");
            sc.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }*/
}


