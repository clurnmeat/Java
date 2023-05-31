import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    public GuessingGame(){
        System.out.println("Hello, "+ setUser() + ", I am thinking of a number between 1 and 100");
        int compInput = randomNumber();
        int userInput = userGuess();
        while(!checkAnswer(userInput, compInput)){
            userGuess();
        }
    }



    private static int randomNumber(){
        Random num = new Random();
        return num.nextInt(100);
    }

    private static String setUser(){
        System.out.print("What is your name?");
        System.out.println("(type in your name) ");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        return userName;
    }

    private static int userGuess(){
        System.out.print("Guess the number: ");
        Scanner guessNum = new Scanner(System.in);
        return guessNum.nextInt();

    }

    private static boolean checkAnswer(int usersGuess, int compGuess){
            if(usersGuess<compGuess){
                System.out.println("Too Low.");
                return false;
            } else if (usersGuess > compGuess) {
                System.out.println("Too High.");
                return false;
            }
        {
                System.out.println("Correct!");
                return true;
            }

    }
}
