import java.util.ArrayList;

import smarthome.packages.SmartHomeApp;
import smarthome.packages.App;
import smarthome.model.*;

/**
 *
 * @author ch.h
 */
public class MyPhone {

    public static void main(String[] args) {
        SmartHomeApp smartHome = new SmartHomeApp();
        ArrayList<App> apps = new ArrayList<App>();
        apps.add(smartHome);
        MyPhone mobil = new MyPhone("Nokia", "8.0.1", 4, 100, apps);
    }
}
