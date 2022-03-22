package students.items;

public class Grain extends Food{
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";
	

	public Grain(double maturationAge, double deathAge, double monteryValue) {
		super(maturationAge, deathAge, monteryValue);
		maturationAge = 2;
		deathAge = 6;
		monteryValue = 2;
		
		getCall++;
	}
	
	public double getGenerationCount() {
		return getCall;
	}
	
	public String getName() {
		if (age < maturationAge) {
			itemName = "g";
		} else {
			itemName = "G";
		}
		return itemName;
	}
	
	public static int getCall=0;
}
