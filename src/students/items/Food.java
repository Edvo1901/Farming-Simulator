package students.items;

public abstract class Food extends Item {
	
	//Constructor for Food
	public Food(double maturationAge, double deathAge, double monteryValue, double costValue) {
		super(maturationAge, deathAge, monteryValue);
		
		//Create cost value parameter
		this.costValue = costValue;
		
		//Get age of the plant
		this.age = getAge();
	}
}