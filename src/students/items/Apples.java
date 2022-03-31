package students.items;

public class Apples extends Food{
	//Create an variable that count up when the class is called
	public static int getCall=0;
	
	//Constructor of the class
	public Apples() {
		super(3, 5, 3, 2);
		
		//Increase the getCall variable when constructor is called
		getCall++;
	}
	
	//Return symbol of plant based on the age
	public String toString() {
		if (this.age < this.maturationAge) {
			this.itemName = "a";
		} else {
			this.itemName = "A";
		}
		return this.itemName;
	}
	
	//Return how many time this class is called
	public static int getGenerationCount() {
		return getCall;
	}
}
