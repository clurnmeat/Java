package Main.Controllers;

public class Drink {
    public double price;

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;

    }

    public void type(){
        System.out.println("A generic drink. (Water)");
    }
}
