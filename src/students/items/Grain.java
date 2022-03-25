package students.items;

public class Grain extends Food{
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";
	

	public Grain() {
		super(2, 6, 2);
		
		getCall++;
	}
	
	public static int getGenerationCount() {
		return getCall;
	}
	
	public String toString() {
		if (this.age < this.maturationAge) {
			this.itemName = "g";
		} else {
			this.itemName = "G";
		}
		return this.itemName;
	}
	
	public static int getCall=0;
}
