package students.items;

public class Item {
	
	//Declare variable of the class
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = "default";
	
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
	
	//Return boolean to check if object meet the died condition
	public boolean died() {
		if (this.age > this.deathAge) {
			return true;
		}
		return false;
	}
	
	//Return value if the age is larger than maturationAge
	public double getValue() {
		if (this.age > this.maturationAge) {
			return this.monteryValue;
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
	
	
	public static void main(String[] args) {
		Apples apple = new Apples(4,1,1);
		Apples apple2 = new Apples(1,1,1);
		
		System.out.println(apple.getGenerationCount());
		
	}
	
}
