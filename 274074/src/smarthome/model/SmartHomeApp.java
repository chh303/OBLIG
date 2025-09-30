/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.model;

import java.util.ArrayList;

/**
 *
 * @author ch.h
 */
public class SmartHomeApp {

    private ArrayList<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice d) { 
        devices.add(d);
    }

    public void listDevices() {
        int i = 0;
        for (SmartDevice d : devices) {
            System.out.println(i++ + "):" + d.toString());

        }
    }

    public void turnOnDevice(int i) {
        devices.get(i).turnOn();
    }

    public void turnOffDevice(int i) {
        devices.get(i).turnOff();
    }

    public void setLightBrightness(int i, int level) {
        if (devices.get(i) instanceof Light) { // Sjekker om objektet er et lys før den utførrer
            Light light = (Light) devices.get(i); // trygg typetvang/cast
            light.setBrightness(level);
        } else { // Sender error melding viss det ikke er gjeldene objekt
            System.out.println("ERROR: This is not a light!");
        }
    }

    // Reprise av forrige metode bare annet objekt.
    public void setThermostatTemperature(int i, double t) {
        if (devices.get(i) instanceof Thermostat) {
            Thermostat thermo = (Thermostat) devices.get(i);
            thermo.setTemperature(t);
        } else {
            System.out.println("Error: This is not a thermostat!");
        }
    }
}
