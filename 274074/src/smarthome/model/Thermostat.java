package smarthome.model;

public class Thermostat extends SmartDevice implements Schedulable {
    private double temperature;
    private String scheduledTime;

    public Thermostat(String name, double temperature) {
        super(name); // Kaller SmartDevice konstruktøren først
        this.temperature = temperature;
    }

    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }
    public void setTemperature(double temp) {
        this.temperature = temp;

    }
    @Override // Overkjører metoden med samme navn fra superklassen.
    public String toString() {
        return super.toString().replace("]", ", Temperature: " + temperature + "°C] Planlagt start:  " + scheduledTime); // Modifiserer fra superklassen for å også få navn.
    }
    
}
