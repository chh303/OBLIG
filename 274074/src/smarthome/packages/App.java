package smarthome.packages;

public abstract class App {
    private String appName;
    private String version;
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public App(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }

    public void runApp() {
        System.out.println("\n" + GREEN + appName + " kjører" + RESET);
    }
    public void closeApp() {
        System.out.println("\n" + RED + appName + " lukket" + RESET);
    }
    public String getApp() {
        return this.appName + " - " + this.version;
    }
    public String getVersion() {
        return this.version;
    }

}