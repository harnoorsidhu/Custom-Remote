package As4.lkj.ass4;


/**
 * Write a description of class Configuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Configuration{
    private int numberOfOptions;
    private int height;
    private static Configuration uniqueInstance;

    private Configuration() throws FileNotFoundException  {
         File text = new File("RemoteConfig.txt");
         Scanner scnr = new Scanner(text);
         numberOfOptions=scnr.nextInt();
         height=scnr.nextInt();
    }

    public static Configuration getInstance() throws FileNotFoundException {
        if (uniqueInstance == null) {
            
            uniqueInstance = new Configuration();
        }
        
        return uniqueInstance;
    }

    public int getOptions() {
        return numberOfOptions;
    }

    public int getHeight() {
        return height;
    }

    
}
