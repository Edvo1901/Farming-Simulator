package students.items;

public class Grain extends Food{
	private int age = 0;
	private int maturationAge;
	private int deathAge;
	private int monteryValue;
	private String itemName = " ";
	int grainObject = 0;
	

	public Grain(int maturationAge, int deathAge, int monteryValue) {
		super(maturationAge, deathAge, monteryValue);
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
