package Main;

import Main.*;
import Main.Controllers.FindingsList;
import Main.Controllers.GuessingGame;
import Main.Controllers.MarsExpedition;
import Main.Controllers.MarsLanding;

import java.util.Random;
public class Mars {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(MarsLanding.landingSpot("The Bridge"));
        System.out.println("Bzzzzzzzt... entering into Main.Mars atmosphere. Prepare for landing Sequence...");
        Random time = new Random();
        int timer = time.nextInt(60);
        landingCheck(timer);
        System.out.println("Landed");
        new MarsLanding();
        new MarsExpedition();
        new FindingsList();

    }




    private static boolean landingCheck(int minutesLeft) throws InterruptedException {
        for(int minute = 0; minute<minutesLeft; minute++){
            if((minute%2) == 0){
                System.out.println("Right");
            } else if (minute%3 == 0) {
                System.out.println("Left");
            } else if ((minute%2) == 0 && minute%3 ==0){
                System.out.println("Center");
            } else {

                System.out.println("Calculating");
            }
            Thread.sleep(250);

        }
        new GuessingGame();

        return false;
    }

}


