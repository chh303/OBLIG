/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.model;

/**
 *
 * @author ch.h
 */
public class TemperaturSensor extends Sensor {

    public final double X = Math.random() * (25.0 - 10.0) + 10.0;

    public TemperaturSensor(String name) {
        super(name);
        turnOn();
    }

    @Override
    public double readValue() {
        return Math.round(X * 10) / 10;
    }
    @Override
    public String toString() {
        if (this.isOn == true)
            return " TemperatureSensor " + super.toString() + "C";
        return " TemperatureSensor " + super.toString();
    }


}
