package students.items;

import java.util.Random;

public class GoldenTree extends Food{
	public static int getCall=0;
	
	public GoldenTree() {
		super(1, 3, randomValue(), 0);
		
		getCall++;
	}
	
	public static int getGenerationCount() {
		return getCall;
	}
	
	public String toString() {
		if (this.age < this.maturationAge) {
			this.itemName = "@";
		} else {
			this.itemName = "@";
		}
		return this.itemName;
	}
	
	public static int randomValue() {
		Random random = new Random();
		int value = random.nextInt(5) + 1;
		return value;
	}

}