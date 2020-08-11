package FileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class DemoFileWriter {
    public static void main(String[] args) {
        try(FileWriter fileWriter = new FileWriter("test.txt")){
            fileWriter.write("Hello this is line 1\n");
            fileWriter.write("Hello this is line2\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
