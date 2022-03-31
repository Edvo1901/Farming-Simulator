package students.items;

public class Grain extends Food{
	//Create an variable that count up when the class is called
	public static int getCall=0;
	
	//Constructor of the class
	public Grain() {
		super(2, 6, 2, 1);
		
		//Increase the getCall variable when constructor is called
		getCall++;
	}

	//Return symbol of plant based on the age
	public String toString() {
		if (this.age < this.maturationAge) {
			this.itemName = "g";
		} else {
			this.itemName = "G";
		}
		return this.itemName;
	}
	
	//Return how many time this class is called
	public static int getGenerationCount() {
		return getCall;
	}
}
