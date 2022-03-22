package students.items;

public class Food extends Item {
	private double age = 0;
	private double maturationAge;
	private double deathAge;
	private double monteryValue;
	private String itemName = " ";

	public Food(double maturationAge, double deathAge,double monteryValue) {
		super(maturationAge, deathAge, monteryValue);
		this.age = getAge();
	}
}