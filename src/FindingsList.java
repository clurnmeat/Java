import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
