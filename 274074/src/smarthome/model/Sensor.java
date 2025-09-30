/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.model;

/**
 *
 * @author ch.h
 */
public abstract class Sensor extends SmartDevice {

    public Sensor(String name) {
        super(name);
    }
    // Én abstrakt metode: double readValue().
    public abstract double readValue();

    // toString() skal returnere kort info om sensoren, inkludert navn og eventuelt siste verdi.
    public String toString() {
        if (this.isOn == true)
            return super.toString() + ": " + readValue();
        return super.toString();
    }
}
