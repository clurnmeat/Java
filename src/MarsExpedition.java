import java.util.Random;
import java.util.Scanner;

public class MarsExpedition {
    public MarsExpedition() throws InterruptedException {
        bootExpedition();
        signIn();
        Scanner response = new Scanner(System.in);
        String text = response.nextLine();
        if (!checkResponse(text)) {
            System.out.println("It is a shame that you are Team Leader, and Mission Critical. You jump after prep.");
        } else {
            System.out.println("I knew you would say that. That's why you are Team Leader.");
        }
        int crew = groupFinder();
        String vehicle = vehicleChoice();
        String snacks = snackChoice();
        System.out.println(vehicle + "is ready to depart loaded with: ");
        System.out.println("Snacks: " + snacks);
        System.out.println("Crew Amount: " + crew);
        int n = 10;
        while(n > 0){
            System.out.println("Jump in " + n);
            Thread.sleep(1000);
            n-=1;


        }
        System.out.println("....Expedition started...");
        Thread.sleep(10000);
        System.out.println("Item(s) found: ");
    }


    public void signIn(){
        System.out.println("Please enter your Username: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, " + input.nextLine() + ", Welcome to the expedition prep program. Are you ready to head out? (Y/N)");
    }

    public void bootExpedition(){
        Random num = new Random();
        int text = num.nextInt(6000);
        System.out.print("Boot sequence initialized......................... " );
        System.out.println("Boot process took " + text + "ms.................");
    }

    public Boolean checkResponse(String response){
        if(response.equals("Y")){
            return true;
        } else {
            return false;
        }
    }

    public int groupFinder(){
        System.out.println("Crew Amount: ");
        Scanner response = new Scanner(System.in);
        int text = response.nextInt();
        if(text > 2){
            System.out.println("That's too many people. Max Crew capacity: 2");
        }
        return 2;
    }

    public String snackChoice(){
        System.out.println("You are only allowed to bring one Snack. What is your choice?");
        Scanner response = new Scanner(System.in);
        String snack = response.nextLine();
        return ("You have chosen " + snack + ". Good luck Team Leader");


    }

    public String vehicleChoice(){
        System.out.println("Select a Vehicle: A: ThunderShock ATV, B: SuperRad SnowBoard, C: Seamangler Submarine");
        Scanner response = new Scanner(System.in);
        String choice = response.nextLine();
        switch (choice){
            case "B": return "SuperRad SnowBoard: ";
            case "C": return "Sea-mangler Submarine: ";
            default:return "ThunderShock ATV: ";

        }

    }
}
