package Main.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order{
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinks) {
        System.out.println("Hello customer. Would you like to place an order? (Y/N)");
        Scanner placeOrder = new Scanner(System.in);
        ArrayList<Object> order = new ArrayList<>();
        String userOrder = placeOrder.nextLine().toLowerCase();


        switch (userOrder) {
            case "y":
                getMenuItems(cupcakeMenu, drinks);
                break;
            default:
                System.out.println("Have a good day");
        }
        Boolean ordering = true;
        while (ordering) {
            System.out.println("What would you like to order? Please use the number associated with each item to order.");
            Scanner input = new Scanner(System.in);
            int orderChoice = input.nextInt();
            switch (orderChoice) {
                case 1:
                    addToOrder(cupcakeMenu, order, orderChoice - 1);
                    break;
                case 2:
                    addToOrder(cupcakeMenu, order, orderChoice - 1);
                    break;
                case 3:
                    addToOrder(cupcakeMenu, order, orderChoice - 1);
                    break;
                case 4:
                    addToDrinks(drinks, order, orderChoice - 4);
                    break;
                case 5:
                    addToDrinks(drinks, order, orderChoice - 4);
                    break;
                case 6:
                    addToDrinks(drinks, order, orderChoice - 4);
                    break;
                default:
                    System.out.println("Sorry we do not have that item.");
            }
            System.out.println("Would you like to continue ordering?(Y/N) ");
            Scanner textInput = new Scanner(System.in);
            String text = textInput.nextLine();
            String continueOrder = text.toLowerCase();
            if (continueOrder.equalsIgnoreCase("N")) {
                ordering = false;
            }
        }
        System.out.println(order.get(0));
        System.out.println(order.get(1));
        double subtotal = 0.0;
        for (int i = 2; i < order.size(); i++) {
            for (int j = 0; j < cupcakeMenu.size(); j++) {
                if (j > 2) {
                    j = 0;

                }
                if (order.get(i) == drinks.get(j)) {
                    drinks.get(j).type();
                    subtotal += drinks.get(j).getPrice();

                }
                if (order.get(i) == cupcakeMenu.get(j)) {
                    cupcakeMenu.get(j).type();
                    subtotal += cupcakeMenu.get(j).getPrice();

                }


            }
        }
        System.out.println(subtotal);
        new CreateFile();
        new WriteToFile(order);

    }

        public static void addToOrder(ArrayList<Cupcake> cupcakeMenu, ArrayList<Object> order, int orderChoice){
            Object date = LocalDate.now();
            order.add(date);
            Object time = LocalTime.now();
            order.add(time);
            order.add(cupcakeMenu.get(orderChoice));
            System.out.println("Item added");
        }

        public static void addToDrinks(ArrayList<Drink> drinks, ArrayList<Object> order, int orderChoice){
            Object date = LocalDate.now();
            order.add(date);
            Object time = LocalTime.now();
            order.add(time);
            order.add(drinks.get(orderChoice));
            System.out.println("Drink added");
        }
        public static void getMenuItems(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinks){
            System.out.println("Here is the menu.");
            int itemNumber = 0;
            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                System.out.println("CUPCAKES: ");
                cupcakeMenu.get(i).type();
                System.out.println("Price: "+ cupcakeMenu.get(i).getPrice());

            }
            for (int j = 0; j < drinks.size(); j++) {
                itemNumber++;
                System.out.println(itemNumber);
                System.out.println("Drinks: ");
                drinks.get(j).type();
                System.out.println("Price: " +  drinks.get(j).getPrice());
            }


        }
    }
