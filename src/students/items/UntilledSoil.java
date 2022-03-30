package students.items;

public class UntilledSoil extends Item {
	//Declare variable of the class

	public UntilledSoil() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -1);
	}
	
	public String toString() {
		this.itemName = "/";
		return this.itemName;
	}


}
