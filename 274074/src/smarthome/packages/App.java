package smarthome.packages;

public abstract class App {
    private String appName;
    private String version;
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public App(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }

    public static void runApp() {
        System.out.println(GREEN + "App kjører" + RESET);
    }
    public static void closeApp() {
        System.out.println(RED + "App lukket" + RESET);
    }
    public String getApp() {
        return this.appName + " - " + this.version;
    }
    public String getVersion() {
        return this.version;
    }

}