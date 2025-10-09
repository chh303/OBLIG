package smarthome.model;

public class Thermostat extends SmartDevice {
    private double temperature;
    private String scheduledTime;

    public Thermostat(String name, double temperature) {
        super(name); // Calls on SmartDevice constructor
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
    @Override // Get prioritised over method with same name in superclass
    public String toString() {
        if (scheduledTime == null) // Checks if it has a scheduledTime before returning and includes scheduled if it has one.Retry
            return "Thermostat        " + super.toString().replace("]", ", Temperature: " + temperature + "°C]");
        return "Thermostat        " + super.toString().replace("]", ", Temperature: " + temperature + "°C] Planlagt start:  " + scheduledTime); // Modifies from the superclass to also get the name.Retry
    }
}