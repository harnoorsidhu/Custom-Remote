package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */  

public class StereoOffCommand extends Command {
    private Stereo stereo;
    
       String status="";
       int vol;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
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