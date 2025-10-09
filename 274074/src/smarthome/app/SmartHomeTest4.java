/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
public class SmartHomeTest4 {

    public static void main(String[] args) {
        ArrayList<App> apps = new ArrayList<>();
        MyPhone phone = new MyPhone("Nokia", "3310", 4, apps);
        SmartHomeApp homeApp = new SmartHomeApp(phone); // Declair phone to make sure battery drains.

        apps.add(homeApp);
        homeApp.runApp();
        homeApp.addDevice(new Light("Stuelys", 0))
                .addDevice(new Light("Badlys", 0))
                .addDevice(new Thermostat("Baderom", 0));

        homeApp.setLightBrightness(0, 100);
        homeApp.setThermostatTemperature(2, 25);
        homeApp.scheduleDevice(2, "19:00");
        System.out.println("\nEvent-log:");
        homeApp.log.printLog();

        System.out.println("Devices before sorting:");
        homeApp.listDevices();

        System.out.println("Devices after sorting:");
        homeApp.sortDevices();
    }

}
