public class MarsLanding {

    public MarsLanding(){
            String colonyName = "Topia";
            int shipPopulation = 300;
            double meals = 4000.00;
            double leftovers = mealsAfterLanding(meals, 2);
            System.out.println("Food left: " + leftovers);
            shipPopulation = populationIncrease(shipPopulation, 5);
            System.out.println("A baby boom has happend. Population increased to :" + shipPopulation);
            leftovers += foodFound(meals, 0.5);
            System.out.println("Food was grown from hydro-farms. food increased to: " + leftovers);
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
}
