package Main;


import Main.Controllers.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public void main(String[] args) {

        Cupcake cupcake = new Cupcake();
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();
        Scanner input = new Scanner(System.in);
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
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


    }









}