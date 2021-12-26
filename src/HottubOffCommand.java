package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */  

public class HottubOffCommand extends Command {
    Hottub hottub;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.cool();
        hottub.off();
    }
     public void undo() {
          hottub.on();
        hottub.heat();
        hottub.bubblesOn();
        }
}
