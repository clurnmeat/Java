public class Mars {
    public static void main(String[] args) throws InterruptedException {
        String colonyName = "Topia";
        int shipPopulation = 300;
        double meals = 4000.00;
        boolean landing = true;
        String landingLocation = "The Plains";
       double leftovers = mealsAfterLanding(meals, 2);
        System.out.println(leftovers);

         leftovers += foodFound(leftovers, 0.5);
         shipPopulation = populationIncrease(shipPopulation, 5);
         System.out.println(landingSpot(landingLocation));
         System.out.println(landingCheck(23));
         landing = landingCheck(25);
    }

    public static double mealsAfterLanding(double amount, int days){
        double mealsLeft = (amount - 0.75) * days;
        return mealsLeft;
    }

    public static double foodFound(double meal, double amountFound){
        double amount = meal *= amountFound;
        return amount;
    }

    public static int populationIncrease(int population, int change){
        population += change;
        return population;
    }

    public static String landingSpot(String location){
        switch(location){
            case "The Plains": return "Bbzzz Landing in The Plain";
            default: return "ERROR! flightplan already set: The Plain";
        }
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
        System.out.println("Landed");

        return false;
    }
}
