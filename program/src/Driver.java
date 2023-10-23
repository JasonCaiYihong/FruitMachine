import java.util.Scanner;
public class Driver
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 3; i++)
        {
            String ID="admin";
            String pwd="123";

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your ID: ");
            String ID_I = sc.nextLine();
            System.out.println("Please enter your password: ");
            String pwd_I = sc.nextLine();

            if (ID.equals(ID_I) && pwd.equals(pwd_I))
            {
                System.out.println("Login successfully!");
                break;
            }
            else if (2-i == 0)
                {
                    System.out.println("Your account has been locked.");
                }
                else
                {
                    System.out.println("The ID or password is incorrect.");
                    System.out.println("You have " + (2-i) + " more chances.");
                }
        }
    }
}


