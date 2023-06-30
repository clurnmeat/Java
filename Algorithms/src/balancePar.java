import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class balancePar {
    public static String parString = "((((((()))))))))))))))))(){{{{{{}}}}}}}}[][][][][][]}}}}[[[]]][[]]{asdf";
    public static List<String> s = Arrays.asList(")", "(", "{", "}","[", "]", "<", ">");
    public static void main(String[]args){
        if(checkPar(parString) % 2 == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static int checkPar(String pars) {
        int counter = 0;
        List<Character> chars = new ArrayList<>();
        for(int i=0; i<pars.length();i++){
            chars.add(pars.charAt(i));
            for (String s : Arrays.asList(")", "(", "{", "}","[", "]", "<", ">")) {
                if (chars.get(i) == s.charAt(0)) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
