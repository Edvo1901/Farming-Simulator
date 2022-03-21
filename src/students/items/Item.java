package students.items;

public class Item {
	
	private int age = 0;
	private int maturationAge;
	private int deathAge;
	private int monteryValue;
	private String itemName = " ";
	
	public Item(int age, int maturationAge, int deathAge, int monteryValue, String itemName) {
		this.age = 0;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monteryValue = monteryValue;
		this.itemName = itemName;
	}
	
	public void tick() {
		this.age++;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public boolean died() {
		if (this.age > this.deathAge) {
			return true;
		}
		return false;
	}
	
	public int getValue() {
		if (this.age > this.maturationAge) {
			return this.monteryValue;
		}
		return 0;
	}
	
	public boolean equals(Object compare) {
		if (compare instanceof Item) {
			Item otherItem = (Item) compare;
			if (this.age == otherItem.age) {
				if (this.deathAge == otherItem.deathAge) {
					if (this.maturationAge == otherItem.maturationAge) {
						if (this.monteryValue == otherItem.monteryValue) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public abstract String toString() {
		//Leave this for now
	}
}
