package smarthome.model;

public class Thermostat extends SmartDevice {
    private double temperature;
    private String scheduledTime;

    public Thermostat(String name, double temperature) {
        super(name); // Kaller SmartDevice konstruktøren først
        this.temperature = temperature;
        if (temperature > 0) 
            turnOn();
    }

    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }
    public void setTemperature(double temp) {
        this.temperature = temp; // Sets temp
        if (temperature > 0) // Checks if its over 0
            turnOn(); // If so it turns on
        else 
            turnOff(); // Or it turns off

    }
    @Override // Overkjører metoden med samme navn fra superklassen.
    public String toString() {
        return " Thermostat        " + super.toString().replace("]", ", Temperature: " + temperature + "°C] Planlagt start:  " + scheduledTime); // Modifiserer fra superklassen for å også få navn.
    }
}