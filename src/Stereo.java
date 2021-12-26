package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */ 

public class Stereo {
    private String location;
    public String type="";
    private int volume=6;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " stereo is on");
    }

    public void off() {
        System.out.println(location + " stereo is off");
    }

    public void setCD() {
        type="CD";
        System.out.println(location + " stereo is set for CD input");
    }

    public void setDVD() {
        type="DVD";
        System.out.println(location + " stereo is set for DVD input");
    }

    public void setRadio() {
        type="RADIO";
        System.out.println(location + " stereo is set for Radio");
    }
    
    public int getVolume(){
        return volume;}
        

    public void setVolume(int volume) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        volume=this.volume;
        System.out.println(location + " Stereo volume set to " + volume);
    }
}
