public class nlogn {
    public static void main(String[]args){
        for(int i=0; i<11; i++){
            numCheck.numList.add(i);
        }

        numCheck.numList.remove(5);

        System.out.println(numCheck.missingNumber(numCheck.numList, numCheck.numList.size()));

    }

}
