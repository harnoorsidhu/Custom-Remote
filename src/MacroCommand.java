package As4.lkj.ass4;


/**
 * Write a description of class MacroCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MacroCommand extends Command
{
    CeilingFanLowCommand fanlow;
    LightOnCommand light;
    StereoOnWithCDCommand stereo;
    
    
    public MacroCommand(LightOnCommand l, StereoOnWithCDCommand s, CeilingFanLowCommand f){
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
