/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.packages;

import java.util.ArrayList;
import smarthome.model.Light;
import smarthome.model.SmartDevice;
import smarthome.model.Thermostat;

/**
 *
 * @author ch.h
 */
public class SmartHomeApp extends App {

    private ArrayList<SmartDevice> devices;
    
    public SmartHomeApp() {
        super("Smart Home Controller", "1.0");
        this.devices = new ArrayList<>();
    }

    public SmartHomeApp addDevice(SmartDevice d) {  // This allows chaining
        devices.add(d);
        return this;
    }

    public SmartHomeApp listDevices() {
        int i = 0;
        for (SmartDevice d : devices) {
            System.out.println(i++ + "):" + d.toString());

        }
        return this;
    }

    public SmartHomeApp turnOnDevice(int index) { 
        devices.get(index).turnOn();
        return this; 
    }

    public SmartHomeApp turnOffDevice(int index) {
        devices.get(index).turnOff();
        return this;
    }

    public SmartHomeApp setLightBrightness(int index, int level) {
        if (devices.get(index) instanceof Light) { // Sjekker om objektet er et lys før den utførrer
            Light light = (Light) devices.get(index); // trygg typetvang/cast
            light.setBrightness(level);
        } else { // Sender error melding viss det ikke er gjeldene objekt
            System.out.println("ERROR: This is not a light!");
        }
        return this;
    }

    // Reprise av forrige metode bare annet objekt.
    public SmartHomeApp setThermostatTemperature(int index, double t) {
        if (devices.get(index) instanceof Thermostat) {
            Thermostat thermo = (Thermostat) devices.get(index);
            thermo.setTemperature(t);
        } else {
            System.out.println("Error: This is not a thermostat!");
        }
        return this;
    }
}
