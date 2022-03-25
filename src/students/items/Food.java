package students.items;

public abstract class Food extends Item {

	public Food(double maturationAge, double deathAge,double monteryValue) {
		super(maturationAge, deathAge, monteryValue);
		this.age = getAge();
	}
}