/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.packages;

import java.util.ArrayList;
import smarthome.log.EventLog;
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
    public EventLog log = new EventLog();

    
    public SmartHomeApp() {
        super("Smart Home Controller", "1.0");
        this.devices = new ArrayList<>();
    }
    public SmartHomeApp(MyPhone phone) {
        super("Smart Home Controller", "1.0");
        this.devices = new ArrayList<>();
        this.phone = phone;
    }

    public SmartHomeApp setPhone(MyPhone phone) { // Adds phone so i can reference it when i want battery to be used when using it methods from here.
        this.phone = phone;
        log.addLog("Phone added = " + phone.getBrand() + " - " + phone.getmodel());
        return this;
    }

    public SmartHomeApp addDevice(SmartDevice d) {  // This allows chaining
        if (phone.tryUsePhone(phone)) { 
            devices.add(d);
            log.addLog("Device added = " + d.toString());
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp listDevices() {
        if (phone.tryUsePhone(phone)) { 
            int i = 0;
            for (SmartDevice d : devices) {
                System.out.println(i++ + "): " + d.toString());

            }
            System.out.println(); // For space between outputs
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp turnOnDevice(int index) { 
        if (phone.tryUsePhone(phone)) { 
            devices.get(index).turnOn();
            log.addLog("Device turned on = " + devices.get(index).toString());
            return this;
        } 
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }

    public SmartHomeApp turnOffDevice(int index) {
        if (phone.tryUsePhone(phone)) { 
            devices.get(index).turnOff();
            log.addLog("Device turned off = " + devices.get(index).toString());
            return this;
        }
        return this;
    }

    public SmartHomeApp setLightBrightness(int index, int level) {
        if (phone.tryUsePhone(phone)) { 
            if (devices.get(index) instanceof Light) { // Sjekker om objektet er et lys før den utførrer
                Light light = (Light) devices.get(index); // trygg typetvang/cast
                light.setBrightness(level);
                log.addLog("Device adjusted = " + devices.get(index).toString());
            } else { // Sender error melding viss det ikke er gjeldene objekt
                System.out.println("ERROR: This is not a light!");
            }
            return this;
        }
        return this;
    }

    // Reprise av forrige metode bare annet objekt.
    public SmartHomeApp setThermostatTemperature(int index, double t) {
        if (phone.tryUsePhone(phone)) { 
            if (devices.get(index) instanceof Thermostat) {
                Thermostat thermo = (Thermostat) devices.get(index);
                thermo.setTemperature(t);
                log.addLog("Device adjusted = " + devices.get(index).toString());
            } else {
                System.out.println("Error: This is not a thermostat!");
            }
            return this;
        }
        return this;
    }

    public SmartHomeApp scheduleDevice(int index, String time) {
        if (phone.tryUsePhone(phone)) { // Checks if phone has battery
                devices.get(index).schedule(time);
                log.addLog("Device scheduled = " + devices.get(index).toString());
            return this;
        }
        System.out.println("\n" + RED + "Battery is dead, charge phone!" + RESET);
        return this;
    }
    public SmartHomeApp sortDevices() {
        if (phone.tryUsePhone(phone)) {     
            devices.sort(null);
            int i = 0;
            for (SmartDevice list : devices)
                System.out.println(i++ + "): " +list.toString());

            System.out.println(); // For space between outputs
        }
        return this;
    }
}
