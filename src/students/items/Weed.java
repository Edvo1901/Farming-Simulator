package students.items;

public class Weed extends Item {
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public Weed(double maturationAge, double deathAge, double monteryValue) {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -1);
		
		itemName = "#";
	}
	
	public String toString() {
		itemName = "#";
		return itemName;
	}

}
