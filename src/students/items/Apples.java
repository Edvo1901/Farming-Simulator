package students.items;

public class Apples extends Food{
	double appleObject = 0;

	public Apples() {
		super(3, 5, 3);
		
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
		return this.itemName;
	}
	
	public static int getCall=0;
	

}
