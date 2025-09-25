package smarthome.model;

public class Light extends SmartDevice implements Schedulable {
    private int brightness;
    private String scheduledTime;

    public Light(String name, int brightness) {
        super(name); // Kaller SmartDevice konstruktøren først
        this.brightness = brightness;
    }
    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }
    public void setBrightness(int value) {
        this.brightness = value;
    }
    @Override
    public String toString() {
        return super.toString().replace("]", ", Brightness: " + brightness + "] Planlagt start:  " + scheduledTime); // Modifiserer fra superklassen.
    }
}