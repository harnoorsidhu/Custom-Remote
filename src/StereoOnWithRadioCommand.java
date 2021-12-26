package As4.lkj.ass4;


/**
 * Write a description of class ss here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StereoOnWithRadioCommand extends Command {
    private Stereo stereo;
    
       String status="";
       int vol;
    public StereoOnWithRadioCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        status=stereo.type;
        vol= stereo.getVolume();
        stereo.on();
        stereo.setRadio();
        stereo.setVolume(6);
    }
    public void undo() {
        
         if (status.equals("CD")) {
            stereo.setCD();
        } else if (status.equals("DVD")) {
            stereo.setDVD();
        } else if (status.equals("RADIO")) {
            stereo.setRadio();
        } 
        if (status.equals("")) {
            stereo.off();
        } 
        else{
        stereo.setVolume(vol);}
        
}
}
