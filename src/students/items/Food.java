package students.items;

public class Food extends Item {
	private int age = 0;
	private int maturationAge;
	private int deathAge;
	private int monteryValue;
	private String itemName = " ";

	public Food(int maturationAge, int deathAge, int monteryValue) {
		super(maturationAge, deathAge, monteryValue);
		this.age = getAge();
	}
}