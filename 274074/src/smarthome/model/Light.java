package smarthome.model;

public class Light extends SmartDevice {
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
        return " Light             " + super.toString().replace("]", ", Brightness: "  + brightness + "] Planlagt start:  " + scheduledTime); // Modifiserer fra superklassen.
    }
}