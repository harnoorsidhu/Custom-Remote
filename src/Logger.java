package As4.lkj.ass4;


/**
 * Write a description of class Logger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
public class Logger{
    private LocalTime timeStamp;
    private LocalDate date;
    private String commandName;
    private static Logger uniqueInstance;
    private FileWriter fileWriter ;

    private Logger() throws IOException  {
        fileWriter = new FileWriter("Logs.txt");
         timeStamp=null;
         date=null;
         commandName=null;
    }

    public static Logger getInstance() throws IOException {
        if (uniqueInstance == null) {
            
            uniqueInstance = new Logger();
        }
        
        return uniqueInstance;
    }

    public void log(String Com) throws IOException  {
        commandName=Com;
        date=LocalDate.now();
        timeStamp=LocalTime.now();
        
        fileWriter.write(Com+" "+date+" "+timeStamp+"\n");
        
       
        
    }
    public FileWriter getFile(){
        return fileWriter;
    }
    

    
    
}
