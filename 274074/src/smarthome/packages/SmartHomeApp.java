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

    public void addDevice(SmartDevice d) { 
        devices.add(d);
    }

    public void listDevices() {
        int i = 0;
        for (SmartDevice d : devices) {
            System.out.println(i++ + "):" + d.toString());

        }
    }

    public void turnOnDevice(int index) {
        devices.get(index).turnOn();
    }

    public void turnOffDevice(int index) {
        devices.get(index).turnOff();
    }

    public void setLightBrightness(int index, int level) {
        if (devices.get(index) instanceof Light) { // Sjekker om objektet er et lys før den utførrer
            Light light = (Light) devices.get(index); // trygg typetvang/cast
            light.setBrightness(level);
        } else { // Sender error melding viss det ikke er gjeldene objekt
            System.out.println("ERROR: This is not a light!");
        }
    }

    // Reprise av forrige metode bare annet objekt.
    public void setThermostatTemperature(int index, double t) {
        if (devices.get(index) instanceof Thermostat) {
            Thermostat thermo = (Thermostat) devices.get(index);
            thermo.setTemperature(t);
        } else {
            System.out.println("Error: This is not a thermostat!");
        }
    }
}
