package students.items;

public class Apples extends Food{
	public Apples() {
		super(3, 5, 3, 2);
		
		getCall++;
	}
	
	public static int getGenerationCount() {
		return getCall;
	}
	
	public String toString() {
		if (this.age < this.maturationAge) {
			this.itemName = "a";
		} else {
			this.itemName = "A";
		}
		return itemName;
	}
	
	public static int getCall=0;
	

}
