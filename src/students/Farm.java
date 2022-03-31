package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.Grain;
import students.items.Grasshopper;
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
		
		Field originalField = new Field(fieldHeight, fieldWidth);
		this.farming = originalField;
	}
	
	public void run()
	{
		while (isRunning) {
			try {
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
						+ "\n  f x y: fight grasshopper"
						+ "\n  s: field summary"
						+ "\n  w: wait"
						+ "\n  q: quit");
				String userChoice = userInput.nextLine();

				String tempChoice = userChoice.substring(0,2).trim();
				String coord = userChoice.substring(2);
				String test[] = coord.split(" ");
				int xcoord = Integer.parseInt(test[0]);
				int ycoord = Integer.parseInt(test[1]);
				
				if (userChoice.substring(0,1).toLowerCase().equals("t")){
					try {
						
						this.farming.till(xcoord - 1, ycoord - 1);
						this.farming.tick();
					} catch (NumberFormatException e) {
						System.out.println("Your choose of location is either invalid or out of range of the field\n");
					} catch (Exception e){
						System.out.println("Your choice of Till location must be a in form \"t (int)x (int)y\"!\n");
					}
				} else if (userChoice.substring(0,1).toLowerCase().equals("h")) {
					try {
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
						if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Soil) {
							while (userChoice.substring(0,1).toLowerCase().equals("p")) {
								Scanner plantInput = new Scanner(System.in);
								System.out.println("Enter:"
										+ "\n- \"a\" to buy an apple for $2"
										+ "\n- \"g\" to buy an grain for $1");
								String plantChoice = plantInput.nextLine();
								if (plantChoice.toLowerCase().equals("a") && this.basicFunds >= this.farming.get(xcoord - 1, ycoord - 1).getCost()) {
									Apples apple = new Apples();
									this.farming.plant(xcoord - 1 , ycoord - 1, apple);
									this.basicFunds -= this.farming.get(xcoord - 1, ycoord - 1).getCost();
									break;
								} else if (plantChoice.toLowerCase().equals("g") && this.basicFunds >= this.farming.get(xcoord - 1, ycoord - 1).getCost()) {
									Grain grain = new Grain();
									this.farming.plant(xcoord - 1, ycoord - 1, grain);
									this.basicFunds -= this.farming.get(xcoord - 1, ycoord - 1).getCost();
									break;
								} else if (this.basicFunds < this.farming.get(xcoord - 1, ycoord - 1).getCost()){
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
				} else if (userChoice.substring(0,1).toLowerCase().equals("f")) {
					try {
						if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Grasshopper) {
							if (Grasshopper.miniGame()) {
								System.out.println("win");
								this.basicFunds += 5;
							} else {
								System.out.println("lose");
								this.basicFunds -= 5;
							}
						} else {
							System.out.println("This spot does not have any Grasshopper. You just waste a turn :) !\n");
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
			} catch (Exception e) {
				System.out.println("Your enter is invalid, please enter \"t\", \"h\", \"p\", \"f\", \"s\", \"w\", or \"q\"\n");
			}
		}
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm(10, 5, 10);
		farm.run();
	}
	
}
