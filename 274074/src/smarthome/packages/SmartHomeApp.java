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
    private MyPhone phone;

    public SmartHomeApp setPhone(MyPhone phone) { // Adds phone so i can reference it when i want battery to be used when using it methods from here.
        this.phone = phone;
        return this;
    }
    
    public SmartHomeApp() {
        super("Smart Home Controller", "1.0");
        this.devices = new ArrayList<>();
    }

    public SmartHomeApp addDevice(SmartDevice d) {  // This allows chaining
        if (phone.getBattery().batteryCheck()) { // Checks if phone has battery
            phone.getBattery().use();
            devices.add(d);
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp listDevices() {
        if (phone.getBattery().batteryCheck()) { // Checks if phone has battery
            phone.getBattery().use();
            int i = 0;
            for (SmartDevice d : devices) {
                System.out.println(i++ + "):" + d.toString());

            }
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp turnOnDevice(int index) { 
        if (phone.getBattery().batteryCheck()) { // Checks if phone has battery
            phone.getBattery().use();
            devices.get(index).turnOn();
            return this;
        } 
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp turnOffDevice(int index) {
        if (phone.getBattery().batteryCheck()) { // Checks if phone has battery
            phone.getBattery().use();
            devices.get(index).turnOff();
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp setLightBrightness(int index, int level) {
        if (phone.getBattery().batteryCheck()) { // Checks if phone has battery
            phone.getBattery().use();
            if (devices.get(index) instanceof Light) { // Sjekker om objektet er et lys før den utførrer
                Light light = (Light) devices.get(index); // trygg typetvang/cast
                light.setBrightness(level);
            } else { // Sender error melding viss det ikke er gjeldene objekt
                System.out.println("ERROR: This is not a light!");
            }
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    // Reprise av forrige metode bare annet objekt.
    public SmartHomeApp setThermostatTemperature(int index, double t) {
        if (phone.getBattery().batteryCheck()) { // Checks if phone has battery
            phone.getBattery().use();
            if (devices.get(index) instanceof Thermostat) {
                Thermostat thermo = (Thermostat) devices.get(index);
                thermo.setTemperature(t);
            } else {
                System.out.println("Error: This is not a thermostat!");
            }
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }
}
