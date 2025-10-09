package smarthome.model;

public class Light extends SmartDevice { // I dont want to use implements schedulable, because it already inherits it from the superclass.
    private int brightness;
    private String scheduledTime;

    public Light(String name, int brightness) {
        super(name); // Kaller SmartDevice konstruktøren først
        this.brightness = brightness;
        if (brightness > 0)
            turnOn();
    }
    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }
    public void setBrightness(int value) {
        this.brightness = value; // Sets brightness
        if (brightness > 0) // Checks if its over 0
            turnOn(); // Turns light on if so
        else 
            turnOff(); // Turns off if set to 0
        }
    @Override
    public String toString() {
        if (scheduledTime == null)  // Checks if it has a scheduledTime before returning and includes scheduled if it has one.Retry
            return "Light             " + super.toString().replace("]", ", Brightness: "  + brightness + "]"); // Modifies from the superclass.
        else 
            return "Light             " + super.toString().replace("]", ", Brightness: "  + brightness + "] Planlagt start:  " + scheduledTime);
    }
}