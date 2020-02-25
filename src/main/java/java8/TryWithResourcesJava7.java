package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesJava7 {
    public static void main(String[] args){
        String filename = "/home/vera/IdeaProjects/Test/src/main/resources";
        oldWay(filename);
        newWay(filename);
    }

    public static void oldWay(String filename){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            // handle the exception(FileNotFoundException)
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                // handle the exception
            }
        }
    }

    public static void newWay(String filename){
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        }catch(IOException e){
            // handle the exception(FileNotFoundException)
        }
    }
}
