package students.items;

public class Soil extends Item {

	public Soil() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
	}
	
	public String toString() {
		this.itemName = ".";
		return this.itemName;
	}
	
}
