import java.util.Scanner;
public class Driver
{
    int Qty = 0;//The quantity of ID and password
    String[] StoredID = new String[10];
    String[] Storedpwd = new String[10];
    Scanner sc = new Scanner(System.in);
    private void login()
    {

        for (int i = 0; i < 3; i++) {

            System.out.println("Please enter your ID: ");
            String ID = sc.nextLine();
            System.out.println("Please enter your password: ");
            String pwd = sc.nextLine();
            boolean match = false;
            for (int t = 0; t < 10; t++)
            {
                if((ID == StoredID[i])&&(pwd == Storedpwd[i]))
                {
                    match = true;
                }
            }
            if (match == true)
            {
                System.out.println("Login successfully!");
                break;
            }
            else if (2 - i == 0)
            {
                System.out.println("Your account has been locked.");
            }
            else
            {
                System.out.println("The ID or password is incorrect.");
                System.out.println("You have " + (2 - i) + " more chances.");
            }
            /*if (ID.equals(ID_I) && pwd.equals(pwd_I)) {
                System.out.println("Login successfully!");
                break;
            } else if (2 - i == 0) {
                System.out.println("Your account has been locked.");
            } else {
                System.out.println("The ID or password is incorrect.");
                System.out.println("You have " + (2 - i) + " more chances.");
            }*/
        }

    }

    public static void main(String[] args)
    {
        Driver driver = new Driver();
        driver.runMenu();
    }



    private void register()
    {
        System.out.println("Please set your ID: ");
        StoredID[Qty] = sc.nextLine();
        System.out.println("Please set your password: ");
        Storedpwd[Qty]  = sc.nextLine();
        Qty++;
    }




    private int mainMenu()
    {
        System.out.print("""
        Fruit Machine Menu
        ------------------
        1) Login
        2) Register
        0) Exit     
        ------------------""");
        //System.out.println("Enter 1 to sign in.");
        //System.out.println("If you are a new user, enter 2 to register.");
        int option = sc.nextInt();
        return option;
    }

    private void runMenu()
    {
        int option = mainMenu();
        while(option != 0)
        {
            switch(option)
            {
                case 1 -> login();
                case 2 -> register();
                default -> System.out.println("Invalid option entered: "+option);
            }
            System.out.println("\nPress enter key to continue...");
            sc.nextLine();
            sc.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }
}


