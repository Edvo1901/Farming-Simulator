package students.items;

public class Grain extends Food{
	int grainObject = 0;
	

	public Grain(int age, int maturationAge, int deathAge, int monteryValue, String itemName) {
		super(age, maturationAge, deathAge, monteryValue, itemName);
		maturationAge = 2;
		deathAge = 6;
		monteryValue = 2;
		
		if (age < maturationAge) {
			itemName = "g";
		} else {
			itemName = "G";
		}
		
		grainObject++;
	}
	
	public int getGenerationCount() {
		return grainObject;
	}
}
