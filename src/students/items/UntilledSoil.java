package students.items;

//Create constructor for UntilledSoil that inherited from Item
public class UntilledSoil extends Item {

	//UntilledSoil will have infinite deathAge, mutationAge, -1 value
	public UntilledSoil() {
		super(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, -1);
	}
	
	//Return the symbol of this item
	public String toString() {
		this.itemName = "/";
		return this.itemName;
	}


}
