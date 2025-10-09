// 34, 355
package smarthome.packages;
import java.util.ArrayList;

public class MyPhone {
   private String brand;
   private String model;
   private int storageCapacity;
   public Battery battery;
   private ArrayList<App> app;
   static int madePhone = 0;


   public MyPhone() {
      madePhone++;
   }

   public MyPhone(String brand, String model, int storageCapacity, ArrayList<App> app) {
      this.brand = brand;
      this.model = model;
      this.storageCapacity = storageCapacity;
      this.battery = new Battery();
      this.app = app;
      madePhone++;
   }
   protected boolean tryUsePhone(MyPhone phone) {
        if (phone == null) return true; // Checks if there is a phone
        
        if (phone.getBattery().batteryCheck()) { // Checks if there is battery on phone
            phone.getBattery().use(); // Calls on battery class to drain battery from using.
            return true;
        }
        System.out.println("\nBattery is dead, charge phone!\n");
        return false;
    }
   public Battery getBattery() {
      return battery;
   }

   public static int getPhoneCount(){
      return madePhone;
   }
   public String getBrand() {
      return this.brand;
   }

   public String getmodel() {
      return this.model;
   }

   public int getStorage() {
      return this.storageCapacity;
   }

   public Battery getBatteryLevel() {
      return this.battery;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public void setStorage(int storageCapacity) {
      this.storageCapacity = storageCapacity;
   }

   public void setBatteryLevel(Battery battery) {
      this.battery = battery;
   }

   public String displayInfo() {
      if (getBattery().batteryCheck()) { // Checks if phone has battery
         battery.use();
         StringBuilder info = new StringBuilder();
         info.append("\nmyPhone: \nBrand - ").append(this.brand).append("\n");
         info.append("Model - ").append(this.model).append("\n");
         info.append("Storage capacity - ").append(this.storageCapacity).append("\n");
         info.append("Batterylevel - ").append(this.battery.getLevel()).append("%" + "\n");
         info.append("Apps: \n");


         for (App App : this.app) {
            info.append("  ").append(App.getApp()).append("\n");
         }
         return info.toString();
      }
      String error = "\n" + "\u001B[31m" + "Battery is dead, charge phone!" + "\u001B[0m";
      return error;
   }
}
