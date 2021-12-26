package As4.lkj.ass4;


/**
 * Write a description of class MacroOffCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MacroOffCommand extends Command
{
     CeilingFanOffCommand fanlow;
    LightOffCommand light;
    StereoOffCommand stereo;
    
    
    public MacroOffCommand(LightOffCommand l, StereoOffCommand s,  CeilingFanOffCommand f){
        light=l;
        stereo=s;
        fanlow=f;
    }
    public void execute() {
		fanlow.execute();
		light.execute();
		stereo.execute();
	}
	public void undo() {
	    fanlow.undo();
	    light.undo();
	    stereo.undo();
	   
    }
    
}