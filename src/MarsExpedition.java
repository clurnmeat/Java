import java.util.Random;
import java.util.Scanner;

public class MarsExpedition {
    public MarsExpedition(){
        bootExpedition();
        signIn();
        Scanner response = new Scanner(System.in);
        String text = response.nextLine();
        if(checkResponse(text)){
            System.out.println("I knew you would say that. That's why you are Team Leader.");
        } else {
            System.out.println("It is a shame that you are Team Leader, and Mission Critical. You jump after prep.");
        }
        groupFinder();


    }


    public void signIn(){
        System.out.println("Please enter your username: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, " + input + ", Welcome to the expedition prep program. Are you ready to head out? (Y/N)");
    }

    public void bootExpedition(){
        Random num = new Random();
        int text = num.nextInt(6000);
        System.out.print("Boot sequence initialized......................... " );
        System.out.println("Boot process took " + text + "ms.................");
    }

    public Boolean checkResponse(String response){
        if(response == "Y"){
            return true;
        } else {
            return false;
        }
    }

    public int groupFinder(){
        Scanner response = new Scanner(System.in);
        int text = response.nextInt();
        if(text > 2){
            System.out.println("That's too many people. Max Crew capacity: 2");
            return 2;
        } else {
            return 2;
        }
    }
}
