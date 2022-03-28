package students.items;

public abstract class Item {
	
	//Declare variable of the class
	protected double age = 0;
	protected double maturationAge;
	protected double deathAge;
	protected double monteryValue;
	protected double costValue;
	protected String itemName = ".";
	
	//Initialize variable
	public Item(double maturationAge, double deathAge, double monteryValue) {
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monteryValue = monteryValue;
	}
	
	//A method that will increase "age" variable by 1
	public void tick() {
		this.age++;
	}
	
	//Set another age for "age" method
	public void setAge(double newAge) {
		this.age = newAge;
	}
	
	public double getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.itemName;
	}
	
	public int getCost() {
		return (int)this.costValue;
	}
	
	//Return boolean to check if object meet the died condition
	public boolean died() {
		if (this.age > this.deathAge) {
			return true;
		}
		return false;
	}
	
	//Return value if the age is larger than maturationAge
	public int getValue() {
		if (this.age > this.maturationAge) {
			return (int)this.monteryValue;
		}
		//Return 0 as null by default
		return 0;
	}
	
	//Check 2 object if they have a same age, death, maturation and montery value
	public boolean equals(Object compare) {
		if (compare instanceof Item) {
			Item otherItem = (Item) compare;
			if (this.age == otherItem.age) {
				if (this.deathAge == otherItem.deathAge) {
					if (this.maturationAge == otherItem.maturationAge) {
						if (this.monteryValue == otherItem.monteryValue) {
							//Return true if all conditions meet
							return true;
						}
					}
				}
			}
		}
		//Return false by default
		return false;
	}
	
	public String toString() {
		return " ";
	}
	
}
