import java.util.Scanner;
import java.util.Random;
public class GuessingGame {
    public static void main(String[] args) {

        System.out.println("Hello, "+ setUser() + ", I am thinking of a number between 1 and 100");

        int compInput = randomNumber();


        int userInput = userGuess();





    }

    public static int randomNumber(){
        Random num = new Random();
        int number = num.nextInt(100);
        return number;
    }

    public static String setUser(){
        System.out.print("What is your name?");
        System.out.println("(type in your name) ");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        return userName;
    }

    public static int userGuess(){
        Scanner guessNum = new Scanner(System.in);
        System.out.print("Guess the number: ");
        return guessNum.nextInt();

    }
}
