package students.items;

public class Soil extends Item {
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public Soil(double maturationAge, double deathAge, double monteryValue) {
		super(maturationAge, deathAge, monteryValue);
		maturationAge = Double.POSITIVE_INFINITY;
		deathAge = Double.POSITIVE_INFINITY;
		monteryValue = 0;
		
		itemName = ".";
	}
	
}
