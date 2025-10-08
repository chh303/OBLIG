package smarthome.app;

import java.util.ArrayList;
import smarthome.model.Light;
import smarthome.model.Thermostat;
import smarthome.packages.App;
import smarthome.packages.MyPhone;
import smarthome.packages.SmartHomeApp;

/**
 *
 * @author ch.h
 */
public class SmartHomeTest3 {
    public static void main(String[] args) {

        ArrayList<App> apps = new ArrayList<>();
        MyPhone mobil = new MyPhone("Nokia", "8.0.1", 4, apps);

        System.out.println("\nInstallerer SmartHomeApp ... ... \n");
        SmartHomeApp homeApp = new SmartHomeApp();
        apps.add(homeApp);

        System.out.println("\nEnheter i appen:"); // Method chaining.
        homeApp.addDevice(new Light("Stuelys", 0))
                .addDevice(new Thermostat("Baderom", 0))
                .listDevices();

        System.out.println("\nSlår på enhetene... ..."); // Method chaining like this, using index can be dangerous, it wont catch where it failed.
        homeApp.turnOnDevice(0) 
                .turnOnDevice(1)
                .listDevices();

        System.out.println("\nOppdatert liste:"); // Safer when using index
        homeApp.setLightBrightness(0, 100);
        homeApp.setThermostatTemperature(1, 25);
        homeApp.listDevices();
    }
}