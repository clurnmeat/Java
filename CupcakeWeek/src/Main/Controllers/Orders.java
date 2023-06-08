package Main.Controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Orders {
    public static void Orders(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){
        System.out.println("Hello customer. Would you like to place an order? (Y/N)");
        Scanner placeOrder = new Scanner(System.in);
        String userOrder = placeOrder.nextLine().toLowerCase();
        ArrayList<Object> order = new ArrayList<>();
        if(userOrder == "y"){
            Object date = LocalDate.now();
            order.add(date);
            Object time = LocalTime.now();
            order.add(time);
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES: ");
            System.out.println();
            int itemNumber = 0;
            for(int i=0; i< cupcakeMenu.size(); i++){
                cupcakeMenu.get(i).type();
                System.out.println("Price: ");
                cupcakeMenu.get(i).type();
                System.out.println();
                System.out.println(itemNumber);
                System.out.println("Drinks: ");
                drinkMenu.get(i).type();
                System.out.println("Price: ");
                drinkMenu.get(i).getPrice();
                System.out.println();
                itemNumber++;
            }
        } else {
            System.out.println("Have a nice day!");
        }
    }
}
