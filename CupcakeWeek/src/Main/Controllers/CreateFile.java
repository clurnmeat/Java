package Main.Controllers;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public CreateFile(){
        try{
            File salesData = new File("salesData.txt");
            if(salesData.createNewFile()){
                System.out.println("File Created: " + salesData.getName());
            }   else {
                System.out.println("ERROR: File already exists");
            }

        } catch(IOException e){
            System.out.println("An error has occurred");
        }
    }
}
