package Main.Controllers;

import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    public GuessingGame() {
        System.out.println("Hello, " + setUser() + ", I am thinking of a number between 1 and 100");
        int compInput = randomNumber();
        int userInput = userGuess();

        if (userInput > 100 || userInput < 0) {
            System.out.println("You have entered too high or too low of a number, How ridiculous.");
            userInput = userGuess();
        }

        boolean check = checkAnswer(userInput, compInput);
        while (!check) {
            int guess = userGuess();
            check = checkAnswer(guess, compInput);
        }

    }
    public static int randomNumber() {
        Random num = new Random();
        return num.nextInt(100);
    }
    private static String setUser() {
        System.out.print("What is your name?");
        System.out.println("(type in your name) ");
        Scanner input = new Scanner(System.in);
        return  input.nextLine();
    }

    private static int userGuess() {
        System.out.print("Guess the number: ");
        Scanner guessNum = new Scanner(System.in);
        return guessNum.nextInt();

    }



    private static boolean checkAnswer(int usersGuess, int compGuess) {
        int tries = 0;

        if (usersGuess < compGuess) {
            System.out.println("Too Low.");
            return false;
        } else if(usersGuess > compGuess){
            System.out.println("Too High.");
            return false;
        } else {
            System.out.println("Correct! You have figured it out.");
            return true;
        }

    }
}