package students.items;

public class Soil extends Item {
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public Soil() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
	}
	
	public String toString() {
		this.itemName = ".";
		return this.itemName;
	}
	
}
