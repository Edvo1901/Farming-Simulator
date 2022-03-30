package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.Grain;

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
			System.out.println("---Welcome to Farming Simulator (2022)---"
					+ "\n# Developer: Vi Dong (Edward) Vo"
					+ "\n# Student ID: 110322027"
					+ "\n# Email ID: voyvy005@mymail.unisa.edu.au"
					+ "\n# This is my own work as defined by the University's "
					+ "Academic Misconduct policy.\n");
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
			if (userChoice.substring(0,1).toLowerCase().equals("t")){
				try {
					int xcoord = Integer.parseInt(userChoice.substring(2,3));
					int ycoord = Integer.parseInt(userChoice.substring(4,5));
					
					this.farming.till(xcoord - 1, ycoord - 1);
				} catch (Exception e){
					System.out.println("Your choice of Till location must be a in form \"t (int)x (int)y\"!\n");
				}
			} else if (userChoice.substring(0,1).toLowerCase().equals("h")) {
				System.out.print("1");
			} else if (userChoice.substring(0,1).toLowerCase().equals("p")) {
				try {
					int xcoord = Integer.parseInt(userChoice.substring(2,3));
					int ycoord = Integer.parseInt(userChoice.substring(4,5));
					while (userChoice.substring(0,1).toLowerCase().equals("p")) {
						Scanner plantInput = new Scanner(System.in);
						System.out.println("Enter:"
								+ "\n- \"a\" to buy an apple for $2"
								+ "\n- \"g\" to buy an grain for $1");
						String plantChoice = plantInput.nextLine();
						System.out.println(Apples.getCost());
						if (plantChoice.toLowerCase().equals("a") && this.basicFunds >= Apples.getCost()) {
							System.out.println(Apples.getCost());
							Apples apple = new Apples();
							System.out.println(Apples.getCost());
							this.basicFunds -= Apples.getCost();
							this.farming.plant(xcoord - 1 , ycoord - 1, apple);
							break;
						} else if (plantChoice.toLowerCase().equals("g") && this.basicFunds >= Grain.getCost()) {
							Grain grain = new Grain();
							this.basicFunds -= Grain.getCost();
							this.farming.plant(xcoord - 1, ycoord - 1, grain);
							break;
						} else if (this.basicFunds < Grain.getCost() || this.basicFunds < Apples.getCost()){
							System.out.println("You don\'t have enough money for plant that fruits.");
						} else {
							System.out.println("Sorry, your choice of plant is invalid. Please choose again!\n");
						}
					}
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Your choice of Plant location must be a in form \"p (int)x (int)y!\n");
				}
			} else if (userChoice.toLowerCase().equals("s")){
				System.out.println(this.farming.getSummary());
			} else if (userChoice.toLowerCase().equals("w")){
				this.farming.tick();
			} else if (userChoice.toLowerCase().equals("q")) {
				isRunning = false;
			} else {
				System.out.println("***There are something wrong with your choice! Please check the form and your choice again***\n");
			}
		}
	}
	
	public void till(int x, int y) {
		this.farming.till(x - 1, y - 1);
	}
	
	public static void main(String[] args) {
		Farm abc = new Farm(5, 10, 10);
		abc.run();
	}
	
}
