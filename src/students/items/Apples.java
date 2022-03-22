package students.items;

public class Apples extends Food{
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";
	double appleObject = 0;

	public Apples(double maturationAge, double deathAge, double monteryValue) {
		super(maturationAge, deathAge, monteryValue);
		maturationAge = 3;
		deathAge = 5;
		monteryValue = 3;
		
		getCall++;
	}
	
	public double getGenerationCount() {
		return getCall;
	}
	
	public String getName() {
		if (age < maturationAge) {
			itemName = "a";
		} else {
			itemName = "A";
		}
		return itemName;
	}
	
	public static int getCall=0;
	

}
