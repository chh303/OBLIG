package smarthome.packages;
public class headset {
    private boolean connected;

    private void connect() {
        connected = true;
        System.out.println("Connection = " + connected);
    }
    private void disconnect() {
        connected = false;
        System.out.println("Connection = " + connected);
    }
}
