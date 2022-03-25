package students.items;

public class UntilledSoil extends Item {
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public UntilledSoil(double maturationAge, double deathAge, double monteryValue) {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -1);
	}
	
	public String toString() {
		itemName = "/";
		return itemName;
	}


}
