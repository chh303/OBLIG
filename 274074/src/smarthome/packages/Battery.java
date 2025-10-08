package smarthome.packages;
public class Battery {
	private int capacity;
	private int currentLevel;

	public Battery() {
		this.capacity = 100;
		this.currentLevel = 100;
	}
	public void use() {
		this.currentLevel -= 1;
	}
	public String getLevel() {
		return Integer.toString(this.currentLevel);
	}
	public int getBatteryLevel() {
		return currentLevel;
	}
	public boolean batteryCheck() {
		if (currentLevel > 0)
			return true;
		return false;
	}
	   public void charge() {
	   	if (this.currentLevel <= capacity) {
	   		this.currentLevel += 5;
	   		System.out.print(this.currentLevel + "% ... ");
	   	}
   }
}