package smarthome.app;

import java.util.ArrayList;
import smarthome.model.Light;
import smarthome.model.SmartDevice;
import smarthome.model.Thermostat;
/**
 *
 * @author ch.h
 */
public class SmartHomeTest1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SmartDevice o = new Light("x", 2); // Example of implicit casting
        Light b = (Light) o; // Explicit casting


        ArrayList<SmartDevice> devices = new ArrayList<>();
        devices.add(new Light("Stue-lys", 0));
        devices.add(new Thermostat("Badrom", 0));

        System.out.println("\nTurning on all devices... ...");
        for (SmartDevice dev : devices) {
            if (dev instanceof Light lys) { // Downcast to light
                lys.setBrightness(100); // Turns on with setBrightness, because if brightness is 0 it would still be off in real life.
            } else if (dev instanceof Thermostat therm) { // Downcast to thermostat
                therm.setTemperature(20); // The same concept here.
            }
            System.out.println(dev.toString());
        }
        System.out.println("\nTurning off all devices... ...");
        for (SmartDevice dev : devices){
            dev.turnOff();
            System.out.println(dev.toString());
        }
    }
}