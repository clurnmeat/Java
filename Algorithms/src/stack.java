import java.util.Arrays;
import java.util.Stack;

public class stack {
    public static void main(String[]args){
        Stack<String> pars = new Stack<>();

        pars.push(")");
        pars.push("(");
        System.out.println(stackCheck(pars));
    }

    public static int stackCheck(Stack<String> stringStack){
        int counter = 0;
            for(int i=0; i<stringStack.size(); i++){
                if (stringStack.iterator() == balancePar.s.get(i)) {
                    counter++;
                }
            }
        return counter;
    }
}
