import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class balancePar {
    public static String parString = "()()()()()()(a";
    public static void main(String[]args){
        if(checkPar(parString) % 2 == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static int checkPar(String pars) {
        int counter = 0;
        List<String> chars = new ArrayList<>();
        for(int i=0; i<pars.length();i++){
            chars.add(pars.charAt(i) + ")");
            if ( chars.get(i) == ")") {
                counter++;
            }
            if (chars.get(i) == "(") {
                counter++;
            }
        }
        return counter;
    }

}
