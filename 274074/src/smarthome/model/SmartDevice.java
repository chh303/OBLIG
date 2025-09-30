package smarthome.model;

public abstract class SmartDevice implements Schedulable {
    private final String name;
    protected boolean isOn;
    private String scheduledTime;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }
    public void turnOn() {
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }
    public String status() {
        return isOn ? "ON" : "OFF"; // Ternary if setning. return boolean ? "hvis sant" :  "hvis usant";
    }
    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }
    @Override
    public String toString() {
        return "[" + name + ": STATUS=" + status() + "]";
    }
}