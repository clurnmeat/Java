package Main.Controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteToFile {
    public WriteToFile(ArrayList<Object> order){
        try{
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for(int i=0; i<order.size();i++){
                salesWriter.println(order.get(i));

            }
            salesWriter.close();
            System.out.print("Successfully wrote to the file.");
        } catch(IOException e){
            System.out.println("An error occurred");
        }

    }
}
