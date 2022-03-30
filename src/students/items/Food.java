package students.items;

public abstract class Food extends Item {
	protected double costValue;

	public Food(double maturationAge, double deathAge, double monteryValue, double costValue) {
		super(maturationAge, deathAge, monteryValue);
		this.costValue = costValue;
		this.age = getAge();
	}
}