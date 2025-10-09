/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.log;

import java.util.ArrayList;

/**
 *
 * @author ch.h
 */
public class EventLog {
    private ArrayList<String> log = new ArrayList<>();


    public void addLog(String message) {
        log.add(message);
    }
    public void printLog() {
        int i = 0;
        for(String list : log)
        System.out.println("["+ i++ + "] - " +list);

        System.out.println(); // For space between outputs
    }

}
