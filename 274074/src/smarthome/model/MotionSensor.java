/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.model;

/**
 *
 * @author ch.h
 */
public class MotionSensor extends Sensor {

    private final double X = Math.random() > 0.5 ? 0.0 : 1.0; // Flyttet variabelen ut av readValue() for å sørge for at den ikke er tilfeldig vær gang en kalles på.

    public MotionSensor(String name) {
        super(name);
        turnOn();
    }
    @Override
    public double readValue() {
        return X;
    }
    public String movement() {
        String value = "Ingen bevegelse";
        if (readValue() == 1.0)
            value = "Bevegelse";

        return value;
    }
    @Override
    public String toString() {
        if (!"ON".equals(status())) 
            return "Device is off!";
        return " MotionSensor      " + super.toString() + " " + movement();
    }
}
