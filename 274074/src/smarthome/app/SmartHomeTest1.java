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
        ArrayList<SmartDevice> ting = new ArrayList<>();
        ting.add(new Light("Stue-lys", 100));
        ting.add(new Thermostat("Badrom", 50));


        for (SmartDevice tingene : ting) {
            tingene.turnOn();
            tingene.schedule("14:00");
            System.out.println(tingene.toString());
        }
        ting.add(new Light("Stue-lyss", 100));
        System.out.println(ting.get(2));
        if (ting.get(2) instanceof Light light) {
            light.setBrightness(20);
        }
        System.out.println(ting.get(2));
        
    }
}