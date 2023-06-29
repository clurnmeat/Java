import java.util.ArrayList;
import java.util.List;

public class numCheck {
    public static void main(String[]args){
       List<Integer> numList = new ArrayList<>();
       for(int i=0; i<11; i++){
           numList.add(i);
       }
       numList.remove(6);
       System.out.println(missingNumber(numList, 11));

    }

    public static int missingNumber(List<Integer> numList, int maxNum) {
        int num = 0;
        for (int i = 0; i < maxNum; i++) {
            if (numList.get(i) != i) {
                num = i;
                break;
            }
        }
        return num;
    }

}
