package Main.Controllers;

import java.util.*;

public class FindingsList {
    public FindingsList() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Welcome Back " + getUser() + "!");
        List<String> strings = new ArrayList<>();
        addRocks(strings, 1);
        addWeird(strings, 1);
        addSmooth(strings, 1);
        addNot(strings, 1);
        System.out.println(checkElement(strings));
        System.out.println("...Searching for fossils...");
        Thread.sleep(1000);
        HashMap<String, String> fossils = new HashMap<>();
        addFishFossil(fossils, 1);
        addBirdFossil(fossils, 1);
        addTeethFossil(fossils, 1);
        System.out.println("Fossils in inventory "+ fossils);
        System.out.println(getInfo(fossils));
        Thread.sleep(700);
        checkSupplies();

    }


    public void checkSupplies(){
        HashSet supplies = new HashSet();
        supplies.add("water");
        supplies.add("fuel");
        supplies.add("food");
        System.out.println("Supplies before departure: " + supplies);
        supplies.remove("food");
        System.out.println("Remaining supplies after departure: " + supplies);
    }
    public Object getInfo(HashMap map){
        System.out.println("Which fossil would you like to examine? (Fish, Teeth, Bird)");
        Scanner userChoice = new Scanner(System.in);
        String choice = userChoice.nextLine().toLowerCase();
        Object response = map.get(choice);
        return response;
    }

    public HashMap addBirdFossil(HashMap map, int amount){
        for(int i=0; i<amount; i++){
            System.out.println("...Bird Fossil found...");
            map.put("bird", "The fossil has wings, which indicate flight.");
        }
        return map;
    }
    public HashMap addFishFossil(HashMap map, int amount){
        for(int i = 0; i<amount; i++){
            System.out.println("....Fish Fossil found...");
            map.put("fish", "The fossil is vaguely fish shaped implies there was once water");

        }
        return map;
    }
    public HashMap addTeethFossil(HashMap map, int amount){
        for(int i=0; i<amount; i++){
            System.out.println("...Tooth Fossil found...");
            map.put("teeth", "The Tooth of an unknown Fossil");

        }
        return map;
    }

    public String getUser() {
        System.out.println("Please enter your User-Name: ");
        Scanner newUser = new Scanner(System.in);
        String user = newUser.nextLine();
        return user;

    }

    public String addRocks(List<String> list, int amount) {
        for (int i = 0; i <= amount; i++) {
            list.add("rock");
        }
        System.out.println(amount + " Rock(s) added");
        return list.toString();

    }

    public String addWeird(List<String> list, int amount) {
        for (int i = 0; i <= amount; i++) {
            list.add("weird rock");
        }
        System.out.println(amount + " Weird Rock(s) added");
        return list.toString();

    }

    public String addSmooth(List<String> list, int amount) {
        for (int i = 0; i <= amount; i++) {
            list.add("smooth rock");
        }
        System.out.println(amount + " Rock(s) added");
        return list.toString();

    }

    public String addNot(List<String> list, int amount) {
        for (int i = 0; i <= amount; i++) {
            list.add("not rock");
        }
        System.out.println(amount + " Not Rock(s) added");
        return list.toString();

    }

    public List checkElement(List list) {
        System.out.println(list);
        System.out.println("Scanning items... One Moment....");
        for (int i = 0; i < list.size(); i++) {
            list.remove("not rock");
        }
        System.out.println("All Not Rock(s) is removed.");
        return list;
    }
}
