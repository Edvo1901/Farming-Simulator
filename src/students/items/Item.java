package students.items;

public class Item {
	
	//Declare variable of the class
	private int age = 0;
	private int maturationAge;
	private int deathAge;
	private int monteryValue;
	private String itemName = " ";
	
	//Initialize variable
	public Item(int maturationAge, int deathAge, int monteryValue) {
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monteryValue = monteryValue;
	}
	
	//A method that will increase "age" variable by 1
	public void tick() {
		this.age++;
	}
	
	//Set another age for "age" method
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public int getAge() {
		return this.age;
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
	
	
//	public static void main(String[] args) {
//		Apples apple = new Apples(1, 1, 1);
//		apple.setAge(3);
//		
//		Grain grain = new Grain(1, 1, 1);
//		Grain grain2 = new Grain(1, 1, 1);
//		System.out.println(grain.equals(grain2));
//		
//	}
	
}
