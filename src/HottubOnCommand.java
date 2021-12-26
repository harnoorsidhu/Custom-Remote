package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */  

public class HottubOnCommand extends Command {
    Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.on();
        hottub.heat();
        hottub.bubblesOn();
    }
     public void undo() {
         hottub.cool();
        
         hottub.off();
        }
    
}
