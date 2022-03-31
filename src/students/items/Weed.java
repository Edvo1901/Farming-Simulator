package students.items;

//Create constructor for Weed that inherited from Item
public class Weed extends Item {

	//Weed will have infinite deathAge, mutationAge, -1 value
	public Weed() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -1);
	}
	
	//Return the symbol of this item
	public String toString() {
		this.itemName = "#";
		return this.itemName;
	}

}
