package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.GoldenTree;
import students.items.Grain;
import students.items.Grasshopper;
import students.items.Soil;

public class Farm {
	//Declare all parameter
	protected int fieldWidth;
	protected int fieldHeight;
	protected int basicFunds;
	protected Field farming;
	
	//Set while loop condition
	boolean isRunning = true;
	
	//Create constructor for the class
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.fieldHeight = fieldHeight;
		this.fieldWidth = fieldWidth;
		this.basicFunds = startingFunds;
		
		//Pass these value to Field
		Field originalField = new Field(fieldHeight, fieldWidth);
		this.farming = originalField;
	}
	
	//Execute the code and interface of the programs
	public void run()
	{
		
		//Check while loop condition
		while (isRunning) {
			try {
				System.out.println("\n---Welcome to Farming Simulator (2022)---"
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
				//Get choice from player
				String userChoice = userInput.nextLine();

				//Cut player choice to smaller parts for comparation
				String tempChoice = userChoice.substring(0,1).trim();
				int xcoord = 0;
				int ycoord = 0;
				
				//Check choice from player
				if (userChoice.substring(0,1).toLowerCase().equals("t")){
					try {
						
						//Split the input
						String coord = userChoice.substring(2);
						String test[] = coord.split(" ");
						xcoord = Integer.parseInt(test[0]);
						ycoord = Integer.parseInt(test[1]);
						
						//Till the spot
						this.farming.till(xcoord - 1, ycoord - 1);
						
						//Progress to next turn
						this.farming.tick("default");
					} catch (NumberFormatException e) {
						System.out.println("Your choose of location is either invalid or out of range of the field\n");
					} catch (Exception e){
						System.out.println("Your choice of Till location must be a in form \"t (int)x (int)y\"!\n");
					}
				
				//Check choice from player
				} else if (userChoice.substring(0,1).toLowerCase().equals("h")) {
					try {
						
						//Split the input
						String coord = userChoice.substring(2);
						String test[] = coord.split(" ");
						xcoord = Integer.parseInt(test[0]);
						ycoord = Integer.parseInt(test[1]);
						
						//Check the type of plant
						if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Apples) {
							
							//Add money based on the value of current plant at the spot
							this.basicFunds += this.farming.get(xcoord - 1, ycoord - 1).getValue();
							
							//Print out the sale message
							System.out.println("You have sold an Apple for $" + this.farming.get(xcoord - 1, ycoord - 1).getValue() + "\n");
							
							//Turn that spot to UntilledSoild
							this.farming.turnUntilled(xcoord - 1, ycoord - 1);
						
						//Check the type of plant
						} else if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Grain) {
							//Add money based on the value of current plant at the spot
							this.basicFunds += this.farming.get(xcoord - 1, ycoord - 1).getValue();
							
							//Print out the sale message
							System.out.println("You have sold a Grain for $" + this.farming.get(xcoord - 1, ycoord - 1).getValue() + "\n");
							
							//Turn that spot to UntilledSoild
							this.farming.turnUntilled(xcoord - 1, ycoord - 1);
							
							//Check the type of plant
						} else if (this.farming.get(xcoord - 1, ycoord - 1) instanceof GoldenTree) {
							
							//Add money based on the value of current plant at the spot
							this.basicFunds += this.farming.get(xcoord - 1, ycoord - 1).getValue();
							
							//Print out the sale message
							System.out.println("You have sold a Golden Tree for $" + this.farming.get(xcoord - 1, ycoord - 1).getValue() + "\n");
							
							//Turn that spot to UntilledSoild
							this.farming.turnUntilled(xcoord - 1, ycoord - 1);
						
						//Return a message when no case is true
						} else {
							System.out.println("There is no valuable plant at this spot.\n");
						}
						
						//Turn to next round after every action
						this.farming.tick("default");
					} catch (NumberFormatException e) {
						System.out.println("Your choose of location is either invalid or out of range of the field\n");
					} catch (Exception e) {
						System.out.println("Your choice of Harvest location must be a in form \"h (int)x (int)y!\n");
					}
					
				//Check choice from player
				} else if (userChoice.substring(0,1).toLowerCase().equals("p")) {
					try {
						
						//Split the input
						String coord = userChoice.substring(2);
						String test[] = coord.split(" ");
						xcoord = Integer.parseInt(test[0]);
						ycoord = Integer.parseInt(test[1]);
						
						//Check if the current spot is Soil
						if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Soil) {
							
							while (userChoice.substring(0,1).toLowerCase().equals("p")) {
								Scanner plantInput = new Scanner(System.in);
								System.out.println("Enter:"
										+ "\n- \"a\" to buy an apple for $2"
										+ "\n- \"g\" to buy an grain for $1");
								
								//Take player choice input
								String plantChoice = plantInput.nextLine();
								
								//Check what kind of plant and money left
								if (plantChoice.toLowerCase().equals("a") && this.basicFunds >= this.farming.get(xcoord - 1, ycoord - 1).getCost()) {
									Apples apple = new Apples();
									
									//Plant the Apple at the given location
									this.farming.plant(xcoord - 1 , ycoord - 1, apple);
									
									//Take money from the bank balance
									this.basicFunds -= this.farming.get(xcoord - 1, ycoord - 1).getCost();
									break;
								
								//Check what kind of plant and money left
								} else if (plantChoice.toLowerCase().equals("g") && this.basicFunds >= this.farming.get(xcoord - 1, ycoord - 1).getCost()) {
									Grain grain = new Grain();
									
									//Plant the Grain at the given location
									this.farming.plant(xcoord - 1, ycoord - 1, grain);
									
									//Take money from the bank balance
									this.basicFunds -= this.farming.get(xcoord - 1, ycoord - 1).getCost();
									break;
								
								//Print this message when player running out of money
								} else if (this.basicFunds < this.farming.get(xcoord - 1, ycoord - 1).getCost()){
									System.out.println("You don\'t have enough money for plant that fruits.");
									break;
									
								//Print a message when get invalid input
								} else {
									System.out.println("Sorry, your choice of plant is invalid. Please choose again!\n");
								}
							}
							
							//Process next turn after every action
							this.farming.tick("default");
							
						//Print this message when this spot is not Soil
						} else {
							System.out.println("This spot is not available to plant.\n");
							
							//Process next turn after every action
							this.farming.tick("default");
						}
					} catch (NumberFormatException e) {
						System.out.println("Your choose of location is either invalid or out of range of the field\n");
					} catch (Exception e) {
						
						System.out.println("Your choice of Plant location must be a in form \"p (int)x (int)y!\n" + e);
					}
								
				/**
				This is a part of additional feature.
				It has nothing related to the orginal assignment.

				For more information about how this is work, please read the Readme file.

				Developed by Vi Dong (Edward) Vo.
				 */
				} else if (userChoice.substring(0,1).toLowerCase().equals("f")) {
					try {
						
						//Split the input
						String coord = userChoice.substring(2);
						String test[] = coord.split(" ");
						xcoord = Integer.parseInt(test[0]);
						ycoord = Integer.parseInt(test[1]);
						
						//Check if this spot is Grasshopper
						if (this.farming.get(xcoord - 1, ycoord - 1) instanceof Grasshopper) {
							Grasshopper grasshopper = new Grasshopper();
							
							//Check the game result
							if (Grasshopper.miniGame()) {
								
								//Winner
								GoldenTree goldenTree = new GoldenTree();
								
								//Add money reward
								this.basicFunds += grasshopper.getValue();
								
								//Giving out a free Golden Tree
								this.farming.plant(xcoord - 1, ycoord - 1, goldenTree);
								
								//Decrease the chance of getting Weed next round
								this.farming.tick("winner");
							} else {
								//Remove money as fine
								this.basicFunds -= grasshopper.getValue();
								
								//Turn the plant to UntilledSoil
								this.farming.turnUntilled(xcoord - 1, ycoord - 1);
								
								//Increase chance of getting Weed next round
								this.farming.tick("loser");
							}
						
						//Print out a message for player not to play if not Grasshopper spot
						} else {
							System.out.println("This spot does not have any Grasshopper. You just waste a turn :) !\n");
							this.farming.tick("default");
						}
					} catch (NumberFormatException e) {
						System.out.println("Your choose of location is either invalid or out of range of the field\n");
					} catch (Exception e) {
						System.out.println("Your choice of Fight location must be a in form \"f (int)x (int)y!\n");
					}
				
				//Check choice from player
				} else if (tempChoice.toLowerCase().equals("s")){
					//Print out summary table
					System.out.println(this.farming.getSummary());
					
				//Check choice from player
				} else if (tempChoice.toLowerCase().equals("w")){
					//Process to next round
					this.farming.tick("default");
				
				//Check choice from player
				} else if (tempChoice.toLowerCase().equals("q")) {
					//End the while loop/ Quit the game
					isRunning = false;
					System.out.println("We are looking forward to seeing you again! - Developed by Vi Dong (Edward) Vo.");
				
				//Print out message for failing all the check
				} else {
					System.out.println("***There are something wrong with your choice! Please check the form and your choice again***\n");
				}
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Your enter is invalid, please enter \"t\", \"h\", \"p\", \"f\", \"s\", \"w\", or \"q\"\n");
			}
		}
	}
	
	public static void main(String[] args) {
		//Create a farm with 10 unit width, 5 unit height and $10 bank balance
		Farm farm = new Farm(10, 5, 10);
		farm.run();
	}
	
}
