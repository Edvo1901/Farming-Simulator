package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.Grain;
import students.items.Soil;

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
					this.farming.tick();
				} catch (NumberFormatException e) {
					System.out.println("Your choose of location is either invalid or out of range of the field\n");
				} catch (Exception e){
					System.out.println("Your choice of Till location must be a in form \"t (int)x (int)y\"!\n");
				}
			} else if (userChoice.substring(0,1).toLowerCase().equals("h")) {
				try {
					int xcoord = Integer.parseInt(userChoice.substring(2,3));
					int ycoord = Integer.parseInt(userChoice.substring(4,5));
					if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Apples) {
						this.basicFunds += this.farming.get(xcoord - 1, ycoord - 1).getValue();
						System.out.println("You have sold an Apple for $" + this.farming.get(xcoord - 1, ycoord - 1).getValue() + "\n");
						this.farming.till(xcoord - 1, ycoord - 1);
					} else if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Grain) {
						this.basicFunds += this.farming.get(xcoord - 1, ycoord - 1).getValue();
						System.out.println("You have sold a Grain for $%s" + this.farming.get(xcoord - 1, ycoord - 1).getValue() + "\n");
						this.farming.till(xcoord - 1, ycoord - 1);
					} else {
						System.out.println("There is no valuable plant at this spot.\n");
					}
					this.farming.tick();
				} catch (NumberFormatException e) {
					System.out.println("Your choose of location is either invalid or out of range of the field\n");
				} catch (Exception e) {
					System.out.println("Your choice of Harvest location must be a in form \"h (int)x (int)y!\n");
				}
			} else if (userChoice.substring(0,1).toLowerCase().equals("p")) {
				try {
					int xcoord = Integer.parseInt(userChoice.substring(2,3));
					int ycoord = Integer.parseInt(userChoice.substring(4,5));
					if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Soil) {
						while (userChoice.substring(0,1).toLowerCase().equals("p")) {
							Scanner plantInput = new Scanner(System.in);
							System.out.println("Enter:"
									+ "\n- \"a\" to buy an apple for $2"
									+ "\n- \"g\" to buy an grain for $1");
							String plantChoice = plantInput.nextLine();
							if (plantChoice.toLowerCase().equals("a") && this.basicFunds >= Apples.getCost()) {
								Apples apple = new Apples();
								this.farming.plant(xcoord - 1 , ycoord - 1, apple);
								this.basicFunds -= Apples.getCost();
								break;
							} else if (plantChoice.toLowerCase().equals("g") && this.basicFunds >= Grain.getCost()) {
								Grain grain = new Grain();
								this.basicFunds -= Grain.getCost();
								this.farming.plant(xcoord - 1, ycoord - 1, grain);
								break;
							} else if (this.basicFunds < Grain.getCost() || this.basicFunds < Apples.getCost()){
								System.out.println("You don\'t have enough money for plant that fruits.");
								break;
							} else {
								System.out.println("Sorry, your choice of plant is invalid. Please choose again!\n");
							}
						}
						this.farming.tick();
					} else {
						System.out.println("This spot is not available to plant.\n");
						this.farming.tick();
					}
				} catch (NumberFormatException e) {
					System.out.println("Your choose of location is either invalid or out of range of the field\n");
				} catch (Exception e) {
					System.out.println("Your choice of Plant location must be a in form \"p (int)x (int)y!\n");
				}
			} else if (userChoice.replaceAll(" ", "").toLowerCase().equals("s")){
				System.out.println(this.farming.getSummary());
			} else if (userChoice.replaceAll(" ", "").toLowerCase().equals("w")){
				this.farming.tick();
			} else if (userChoice.replaceAll(" ", "").toLowerCase().equals("q")) {
				isRunning = false;
				System.out.println("We are looking forward to seeing you again! - Developed by Vi Dong (Edward) Vo.");
			} else {
				System.out.println("***There are something wrong with your choice! Please check the form and your choice again***\n");
			}
		}
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm(5, 10, 10);
		farm.run();
	}
	
}
