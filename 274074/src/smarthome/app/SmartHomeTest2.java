/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.app;

import java.util.ArrayList;
import smarthome.model.Light;
import smarthome.model.MotionSensor;
import smarthome.model.Schedulable;
import smarthome.model.Sensor;
import smarthome.model.SmartDevice;
import smarthome.model.SmartHomeApp;
import smarthome.model.TemperaturSensor;
import smarthome.model.Thermostat;

/**
 *
 * @author ch.h
 */
public class SmartHomeTest2 {

    public static void main(String[] args) {
        Light lys = new Light("Utelys", 0);
        Thermostat temp = new Thermostat("Baderom", 0);
        ArrayList<Schedulable> liste = new ArrayList<>();
        liste.add(lys);
        liste.add(temp);
        System.out.println("""
                           
                           Planlegger enheter ... ...""");
        for (Schedulable list : liste) {
            list.schedule("07:00");
            System.out.println(list.toString());
        }

        MotionSensor mSens = new MotionSensor("Uteplass");
        TemperaturSensor tSens = new TemperaturSensor("Baderom");
        ArrayList<Sensor> sList = new ArrayList<>();
        sList.add(mSens);
        sList.add(tSens);
        System.out.println("""
                            
                            Leser av sensorer ... ... """);
        for (Sensor list : sList) {
            list.readValue();
            System.out.println(list.toString());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        
        SmartHomeApp app = new SmartHomeApp();
        app.addDevice(new Light("Stue-lys", 50));
        app.addDevice(new MotionSensor("Uteplass"));
        app.addDevice(new Thermostat("Bade-rom", 20.0));
        app.addDevice(new TemperaturSensor("Soverom"));
        app.listDevices();
    }
}