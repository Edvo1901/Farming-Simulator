package students.items;

//Create constructor for Soil that inherited from Item
public class Soil extends Item {

	//Soil will have infinite deathAge, mutationAge, 0 value
	public Soil() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0);
	}
	
	//Return the symbol of this item
	public String toString() {
		this.itemName = ".";
		return this.itemName;
	}
	
}
