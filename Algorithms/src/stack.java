import java.util.Arrays;
import java.util.Stack;

public class stack {
    public static void main(String[]args){
        Stack<String> pars = new Stack<>();

        pars.add(")");
        pars.add("(");
        pars.add("(");
        pars.add("(");
        pars.add("(");
        pars.add("(");
        pars.add("(");
        pars.add("(");
        pars.add("(");
        pars.add(")");
        pars.add(")");
        pars.add(")");
        pars.add(")");
        pars.add(")");
        pars.add(")");
        pars.add(")");
        pars.add(")");

        System.out.println(stackCheck(pars));
        if(stackCheck(pars) % 2 == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static int stackCheck(Stack<String> stringStack){
        int counter = 0;
            for(int i=0; i<stringStack.size(); i++){
                if (stringStack.iterator().next() == balancePar.s.listIterator().next()) {
                    counter++;
                }
            }
        return counter;
    }
}
