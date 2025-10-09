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

    private final double X = Math.random() > 0.5 ? 0.0 : 1.0; // Moved the variable out of readValue() to ensure it is not random each time it is called.Retry

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
            return "MotionSensor      " + super.toString();
        return "MotionSensor      " + super.toString() + " " + movement();
    }
}
