package students.items;

public class Soil extends Item {
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public Soil(double maturationAge, double deathAge, double monteryValue) {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
	}
	
	public String toString() {
		itemName = ".";
		return itemName;
	}
	
}
