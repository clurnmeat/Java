import Main.Controllers.*;

import java.util.ArrayList;
import java.util.Scanner;


public class main {

    public void main(String[] args) {
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        ArrayList<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink();
        drink.type();
        Scanner input = new Scanner(System.in);
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        drink.setPrice(price);
        Drink soda = new Soda();
        soda.type();
        input = new Scanner(System.in);
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);
        Drink milk = new Milk();
        milk.type();
        input = new Scanner(System.in);
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);
        drinks.add(drink);
        drinks.add(soda);
        drinks.add(milk);

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        Cupcake cupcake = new Cupcake();
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        cupcake.type();
        input = new Scanner(System.in);
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        System.out.println("We are deciding on the price for our redvelvet cupcake. Here is the description:");
        redVelvet.type();
        input = new Scanner(System.in);
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        input = new Scanner(System.in);
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);
        cupcakeMenu.add(chocolate);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(cupcake);
f

    }









}