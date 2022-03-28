package students.items;

public class Grain extends Food{
	public Grain() {
		super(2, 6, 2, 1);
		
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
