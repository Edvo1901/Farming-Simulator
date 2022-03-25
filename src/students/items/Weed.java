package students.items;

public class Weed extends Item {
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public Weed() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -1);
		
		this.itemName = "#";
	}
	
	public String toString() {
		this.itemName = "#";
		return this.itemName;
	}

}
