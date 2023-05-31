public class Game {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner getName = new Scanner(System.in);
        String userName = getName.nextLine();
        System.out.println("Hello, "+ userName + ", I am thinking of a number between 1 and 10");


    }
}
