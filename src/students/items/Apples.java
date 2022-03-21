package students.items;

public class Apples extends Item{
	int appleObject = 0;

	public Apples(int age, int maturationAge, int deathAge, int monteryValue, String itemName) {
		super(age, maturationAge, deathAge, monteryValue, itemName);
		maturationAge = 3;
		deathAge = 5;
		monteryValue = 3;
		
		if (age < maturationAge) {
			itemName = "a";
		} else {
			itemName = "A";
		}
		
		appleObject++;
	}
	
	public int getGenerationCount() {
		return appleObject;
	}
}
