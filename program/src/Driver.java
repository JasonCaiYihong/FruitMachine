import java.util.Scanner;
public class Driver
{
    int Qty = 0;//The quantity of ID and password
    String[] StoredID = new String[10];
    String[] Storedpwd = new String[10];
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Driver driver = new Driver();
        driver.runMenu();
    }

    private void login()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Please enter your ID: ");
            String ID = sc.nextLine();
            System.out.println("Please enter your password: ");
            String pwd = sc.nextLine();
            //System.out.println(ID + pwd);
            boolean match = false;
            for (int t = 0; t < 10; t++)
            {
                if((ID.equals(StoredID[t]))&&(pwd.equals(Storedpwd[t])))
                {
                    match = true;
                }
            }
            if (match)
            {
                System.out.println("Login successfully!");
                break;
            }
            else if (2 - i == 0)
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

        StoredID[Qty] = sc.nextLine();
        System.out.println("Please set your password: ");
        Storedpwd[Qty]  = sc.nextLine();
        //System.out.println(StoredID[Qty] + Storedpwd[Qty] + Qty);
        Qty++;
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
    }
}


