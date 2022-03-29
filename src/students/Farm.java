package students;

import java.util.Scanner;

public class Farm {
	protected int fieldWidth;
	protected int fieldHeight;
	protected int basicFunds;
	protected Field farming;
	boolean isRunning = true;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.fieldHeight = fieldHeight;
		this.fieldWidth = fieldWidth;
		this.basicFunds = startingFunds;
		
		Field originalField = new Field(fieldWidth, fieldHeight);
		this.farming = originalField;
	}
	
	public void run()
	{
		
		while (isRunning) {
			System.out.println(this.farming);
			System.out.println("Bank balance: $" + this.basicFunds);
			Scanner userInput = new Scanner(System.in);
			System.out.println("\nEnter your next action:"
					+ "\n  t x y: till"
					+ "\n  h x y: harvest"
					+ "\n  p x y: plant"
					+ "\n  s: field summary"
					+ "\n  w: wait"
					+ "\n  q: quit");
			String userChoice = userInput.nextLine();
			if (userChoice.replaceAll("\\s", "").replaceAll("\\d","").toLowerCase().equals("t")){
				while (userChoice.replaceAll("\\s", "").replaceAll("\\d","").toLowerCase().equals("t")) {
					if (Character.isDigit(userChoice.replaceAll("\\D+","").charAt(0)) && Character.isDigit(userChoice.replaceAll("\\D+","").charAt(1))) {
						till(userChoice.replaceAll("\\D+","").charAt(0), userChoice.replaceAll("\\D+","").charAt(1));
					} else {
						System.out.println("Sorry, your choice of Till is invalid. Please choose again!\n");
					}
				}
			} else if (userChoice.replaceAll("\\s", "").replaceAll("\\d","").toLowerCase().equals("h")) {
				System.out.print("1");
			} else if (userChoice.replaceAll("\\s", "").replaceAll("\\d","").toLowerCase().equals("p")) {
				while (userChoice.replaceAll("\\s", "").replaceAll("\\d","").toLowerCase().equals("p")) {
					Scanner plantInput = new Scanner(System.in);
					System.out.println("Enter:"
							+ "\n- \"a\" to buy an apple for $"
							+ "\n- \"g\" to buy an grain for $");
					String plantChoice = plantInput.nextLine();
					if (plantChoice.toLowerCase().equals("a")) {
						plant(userChoice.replaceAll("\\D+","").charAt(0), userChoice.replaceAll("\\D+","").charAt(1), "a");
						userChoice = "";
					} else if (plantChoice.toLowerCase().equals("g")) {
						plant(userChoice.replaceAll("\\D+","").charAt(0), userChoice.replaceAll("\\D+","").charAt(1), "g");
						userChoice = "";
					} else {
						System.out.println("Sorry, your choice of plant is invalid. Please choose again!\n");
					}
				}

			} else if (userChoice.toLowerCase().equals("s")){
				summary();
			} else if (userChoice.toLowerCase().equals("w")){
				waiting();
			} else if (userChoice.toLowerCase().equals("q")) {
				quit();
			} else {
				System.out.println("Sorry");
			}
		}
	}
	
	public void till(int x, int y) {
		this.farming.till(x - 1, y - 1);
	}
	
	public void plant(int x, int y, String fruit) {
		
	}
	
	public void waiting() {
		this.farming.tick();
	}
	
	public String summary() {
		return this.farming.getSummary();
	}
	
	public boolean quit() {
		return isRunning = false;
	}
	
	public static void main(String[] args) {
//		Farm abc = new Farm(5, 10, 10);
//		abc.run();
		String a = "t 1 4";
		System.out.println(a.replaceAll("\\D+",""));
		if (Character.isDigit(a.replaceAll("\\D+","").charAt(0)) && Character.isDigit(a.replaceAll("\\D+","").charAt(1))) {
			System.out.println("True");
		} else {
			System.out.println("Sorry, your choice of Till is invalid. Please choose again!\n");
		}
	}
	
}
