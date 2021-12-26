package As4.lkj.ass4;

/** From Head First Design Patterns, Freeman & Robson et al. */ 

public class Hottub {
    boolean on;
    int temperature;
     String Location;
     
    public Hottub(String l) {
        Location=l;
    }

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public void bubblesOn() {
        if (on) {
            System.out.println(Location+" Hottub is bubbling!");
        }
    }

    public void bubblesOff() {
        if (on) {
            System.out.println(Location+" Hottub is not bubbling");
        }
    }

    public void jetsOn() {
        if (on) {
            System.out.println(Location+" Hottub jets are on");
        }
    }

    public void jetsOff() {
        if (on) {
            System.out.println(Location+" Hottub jets are off");
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void heat() {
        temperature = 105;
        System.out.println(Location+" Hottub is heating to a steaming 105 degrees");
    }

    public void cool() {
        temperature = 98;
        System.out.println(Location+" Hottub is cooling to 98 degrees");
    }

}
