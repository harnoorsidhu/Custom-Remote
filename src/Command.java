package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */  
import java.io.*;
public abstract class Command implements Cloneable{
    public abstract void execute();
    
     public abstract void undo();
     
    public Object clone() throws CloneNotSupportedException{
            try {
            Command comm = (Command) super.clone();
            return comm;
            
            }
            catch (CloneNotSupportedException e){
                System.out.println("clone is not supported "+e.getMessage());
                return null;
            }
        }
        void logCommand(String s) throws IOException{
            Logger log= Logger.getInstance();
            log.log(s);
        }
        void executeWithLog() throws IOException{
            this.execute();
            logCommand(this.getClass().getName());
          }
        void undoWithLog() throws IOException{
            this.undo();
            logCommand(this.getClass().getName());
        }
            
}
