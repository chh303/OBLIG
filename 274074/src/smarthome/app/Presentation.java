/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthome.app;

import java.util.Scanner;

/**
 *
 * @author ch.h
 */
public class Presentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean x = true;
        while (true) {
            System.out.println("\n\nWhould you like to see SmartHomeTest - [1], [2], [3] or [4].    ... [0] for exit.");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    Presentation.clearScreen();
                    SmartHomeTest1.main(args);
                    break;
                case 2:
                    Presentation.clearScreen();
                    SmartHomeTest2.main(args);
                    break;
                case 3:
                    Presentation.clearScreen();
                    SmartHomeTest3.main(args);
                    break;
                case 4:
                    Presentation.clearScreen();
                    SmartHomeTest4.main(args);
                    break;
                case 0:
                    x = false;
                    System.exit(0);
                    break;
            }
        }
    }
    private static void clearScreen() {
        for(int i = 0; i<20; i++)
        System.out.println();
    }

}
