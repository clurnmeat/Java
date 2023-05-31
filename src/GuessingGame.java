import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.print("What is your name?");
        System.out.println("(type in your name) ");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        System.out.println("Hello, "+ userName + ", I am thinking of a number between 1 and 100");

    }
}
