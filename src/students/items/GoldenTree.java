/**
This is a part of additional feature.
It has nothing related to the orginal assignment.

For more information about how this is work, please read the Readme file.

Developed by Vi Dong (Edward) Vo.
 */

package students.items;

import java.util.Random;

public class GoldenTree extends Food{
	//Create an variable that count up when the class is called
	public static int getCall=0;
	
	//Constructor of the class
	public GoldenTree() {
		super(1, 3, randomValue(), 0);
		
		//Increase the getCall variable when constructor is called
		getCall++;
	}
	
	//Return symbol of plant based on the age
	public String toString() {
		if (this.age < this.maturationAge) {
			this.itemName = "@";
		} else {
			this.itemName = "@";
		}
		return this.itemName;
	}
	
	//Return how many time this class is called
	public static int getGenerationCount() {
		return getCall;
	}
	
	//Return a random montery value for this plant
	public static int randomValue() {
		Random random = new Random();
		int value = random.nextInt(5) + 1;
		return value;
	}

}