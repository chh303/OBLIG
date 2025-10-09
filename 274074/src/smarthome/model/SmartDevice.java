package smarthome.model;

public abstract class SmartDevice implements Schedulable, Comparable<SmartDevice> {
    private String name;
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
        return isOn ? "ON" : "OFF"; // Ternary if statement: return boolean ? "if true" : "if false";
    }
    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return (scheduledTime == null) ? "[" + name + ": STATUS=" + status() + "]" : "[" + name + ": STATUS=" + status() + "] Scheduled for: " + scheduledTime;
    }
    @Override
    public int compareTo(SmartDevice other) {
        if (this.getName() != null && other.getName() != null)
        return this.getName().compareToIgnoreCase(other.getName());
        else
        return 1; // puts devices with names before those without (null).
    }
}