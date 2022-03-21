package students.items;

public class Apples extends Food{
	private int age = 0;
	private int maturationAge;
	private int deathAge;
	private int monteryValue;
	private String itemName = " ";
	int appleObject = 0;

	public Apples(int maturationAge, int deathAge, int monteryValue) {
		super(maturationAge, deathAge, monteryValue);
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
