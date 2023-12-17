import java.util.Scanner;

public class User {
    int qty = 0;//The quantity of users
    int size = 10;//The maximum of users
    int currUser = 0;//The current user
    String transCoin = "0";//Use String to avoid bug in the Scanner class
    String[] storedID = new String[size];
    String[] storedPw = new String[size];
    int[] storedScore = new int[size];
    int[] storedPlays = new int[size];
    Scanner sc = new Scanner(System.in);

    private void login() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter your ID: ");
            String ID = sc.nextLine();
            System.out.println("Please enter your password: ");
            String pwd = sc.nextLine();
            boolean match = false;
            for (int t = 0; t < size; t++) {
                if ((ID.equals(storedID[t])) && (pwd.equals(storedPw[t]))) {
                    match = true;
                    currUser = t;
                    break;
                }
            }
            if (match) {
                System.out.println("Login successfully!");
                break;
            } else if (2 - i == 0) {
                System.out.println("Your account has been locked.");
                while (true) {
                }
            } else {
                System.out.println("The ID or password is incorrect.");
                System.out.println("You have " + (2 - i) + " more chances.");
            }
        }
        play();
    }

    private void register() {
        while (true) {
            System.out.println("Please set your ID: ");
            String inputID = sc.nextLine();
            boolean exist = false;
            for (int t = 0; t < size; t++) {
                if ((inputID.equals(storedID[t]))) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                System.out.println("The ID is already exist. Please set another one.");
            } else {
                storedID[qty] = inputID;
                break;
            }
        }
        while (true) {
            System.out.println("Please set your password: ");
            storedPw[qty] = sc.nextLine();
            System.out.println("Please confirm your password: ");
            String checkPw = sc.nextLine();
            if (checkPw.equals(storedPw[qty])) {
                System.out.println("Register successfully!");
                break;
            } else {
                System.out.println("The two passwords you entered does not match. Please try again.");
            }
        }
        qty++;
    }

    private String mainMenu() {
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

    public void runMenu() {
        String exit = "n";
        String option = mainMenu();
        while (!exit.equals("y")) {
            while (!option.equals("z")) {
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
            if (!exit.equals("y")) {
                option = mainMenu();
            }
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }

        private void play() {
        FruitMachine fruitMachine = new FruitMachine();
        System.out.println("One coin can be used for one round. Please enter the number of coins: ");
        transCoin = sc.nextLine();
        int coin = Integer.parseInt(transCoin);//Transfer String to int
        storedPlays[currUser] += coin;
        int score = 0;
        for (int i = 0; i < coin; i++) {
            score += fruitMachine.game();
        }
        storedScore[currUser] += score;
        System.out.println("You get " + score + " !");
    }

    private void rankingList() {
        //bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (storedScore[j] < storedScore[j + 1]) {
                    int temp1 = storedScore[j];
                    int temp2 = storedPlays[j];
                    String temp3 = storedID[j];
                    String temp4 = storedPw[j];
                    storedScore[j] = storedScore[j + 1];
                    storedPlays[j] = storedPlays[j + 1];
                    storedID[j] = storedID[j + 1];
                    storedPw[j] = storedPw[j + 1];
                    storedScore[j + 1] = temp1;
                    storedPlays[j + 1] = temp2;
                    storedID[j + 1] = temp3;
                    storedPw[j + 1] = temp4;
                }
            }
        }
        System.out.println("    Ranking List");
        System.out.println("--------------------");
        System.out.println("ID       Plays Score");
        for (int t = 0; t < size; t++) {
            System.out.printf("%-9s", storedID[t]);
            System.out.printf("%-6d", storedPlays[t]);
            System.out.printf("%-6d", storedScore[t]);
            System.out.println();
        }
    }
}
