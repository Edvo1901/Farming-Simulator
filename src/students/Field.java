package students;

import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Grasshopper;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

import java.util.Optional;
import java.util.Random;


public class Field {
	//Declare parameter
	Item[][] spot;
	protected int height;
	protected int width;
	private int isTilledX = -1;
	private int isTilledY = -1;

	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		
		this.spot = new Item[this.height][this.width];
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				
				//Create Soil throughout the area of height and width
				Soil ground = new Soil();
				this.spot[i][j] = ground;
			}
		}
		
		this.spot.toString();
	}
	
	//Generate a random chance to have Weed and Grasshopper
	public void tick(String result) {
		
	    
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				this.spot[i][j].tick();
				
				/**
				This is a part of additional feature.
				It has nothing related to the original assignment.

				For more information about how this is work, please read the Readme file.

				Developed by Vi Dong (Edward) Vo.
				 */
				Optional<String> ln = Optional.ofNullable(result);
				String a = ln.isPresent() ? ln.get() : "Not Given";
				Random rnd = new Random();
				switch (a) {
				
				//Slower chance to get Weed when win minigame
				case "winner":
					int winnerChance = rnd.nextInt(10);
					if (winnerChance == 1 && this.spot[i][j] instanceof Soil) {
						Weed rndWeed = new Weed();
						this.spot[i][j] = rndWeed;
					}
					break;
					
				//Increase chance to get Weed when lose minigame
				case "loser":
					int loserChance = rnd.nextInt(3);
					if (loserChance == 1 && this.spot[i][j] instanceof Soil) {
						Weed rndWeed = new Weed();
						this.spot[i][j] = rndWeed;
					}
					break;
				
				//Default chance to get Weed throughout the game
				default:
					if (i == isTilledY && j == isTilledX) {
						isTilledY = -1;
						isTilledX = -1;
						continue;
					}
					int chance = rnd.nextInt(5);
					if (chance == 1 && this.spot[i][j] instanceof Soil) {
						Weed rndWeed = new Weed();
						this.spot[i][j] = rndWeed;
					}
					break;
				}
				
				//Check if the plant is died and turn it into UntilledSoil
				if (this.spot[i][j].died()) {
					UntilledSoil deadPlant = new UntilledSoil();
					this.spot[i][j] = deadPlant;
				
				}
				
				//Generate a random chance to get Grasshopper on player's plant
				if (this.spot[i][j] instanceof Apples || this.spot[i][j] instanceof Grain) {
					int spawnGrassChance = rnd.nextInt(10);
					if (spawnGrassChance == 1) {
						Grasshopper gs = new Grasshopper();
						this.spot[i][j] = gs;
						
						//Show this message to notify player
						System.out.println("!!! One of your plant got Grasshopper,"
								+ " fight it to protect your plant!!!\n"
								+ "\nWarning: You will lose your plant after 2 turn if ignore Grasshopper.");
					}
				}
			}
		}
	}
	
	//Return the field base on height and width
	public String toString() {
		String newField = new String();
		
		//Make the number for the row
		for (int i = 0; i <= this.width; i ++) {
			if (i == 0) {
				newField += " " + "\t";
			} else {
				newField += i + "\t";
			}
    	}
		
		//Make the number for the column
		newField += "\n" + "\n";
		for (int i = 0; i < this.height; i ++) {
			newField += i + 1 +"\t";
			for (int j = 0; j < this.width; j ++) {
				newField += this.spot[i][j].toString() + "\t";
			}
			newField += "\n" + "\n";
		}
		
		//Return the field
		return newField;
	}
	
	//Turn the current spot to Soil, no matter what it is
	public void till(int x, int y) {
		Soil newSoil = new Soil();
		this.spot[y][x] = newSoil;
	}
	
	//Return a copy of the item at that location
	public Item get(int x, int y) {
		return this.spot[y][x];
	}
	
	//Store the given Item at the set location
	public void plant(int x, int y, Food item) {
		this.spot[y][x] = item;
	}
	
	//Turn the set spot to UntilledSoil item
	public void turnUntilled(int x, int y) {
		UntilledSoil deadPlant = new UntilledSoil();
		this.spot[y][x] = deadPlant;
	}
	
	//Store the tilled spot avoid the weed grow again
	public void isTilled(int x, int y) {
		isTilledX = x;
		isTilledY = y;
	}

	//Return total value of all the plant in the field
	public int getValue() {
		
		int totalValue = 0;
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				if (this.spot[i][j].getValue() != 0) {
					totalValue += this.spot[i][j].getValue();
				}
			}
		}
		
		//Return total value
		return totalValue;
	}
	
	//Return a string that summary all the information in the field
	public String getSummary() {
		
		//Declare all variables
		String summaryStr = new String();
		int totalApple = 0;
		int totalGrain = 0;
		int totalSoil = 0;
		int totalUntilled = 0;
		int totalWeed = 0;
		int totalGrass = 0;
		int totalGolden = 0;
		
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				
				//Check each condition to find out the type of plant at current spot
				if (this.spot[i][j].toString() == "a" || this.spot[i][j].toString() == "A") {
					
					//Store it to the variable
					totalApple++;
				} else if (this.spot[i][j].toString() == "g" || this.spot[i][j].toString() == "G") {
					totalGrain++;
				} else if (this.spot[i][j].toString() == "." ) {
					totalSoil++;
				} else if (this.spot[i][j].toString() == "/" ) {
					totalUntilled++;
				} else if (this.spot[i][j].toString() == "#") {
					totalWeed++;
				} else if (this.spot[i][j].toString() == "*") {
					totalGrass++;
				} else if (this.spot[i][j].toString() == "#") {
					totalGolden++;
				}
			}
		}
		
		//Format of the information that should return
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Apples:", totalApple);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Grain:", totalGrain);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Soil:", totalSoil);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Untilled:", totalUntilled);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Weed:", totalWeed);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Grasshopper:", totalGrass);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Golden Tree:", totalGolden);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "For a total of ", "$" + this.getValue());
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Total apples created:", Apples.getGenerationCount());
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Total grain created:", Grain.getGenerationCount());
		
		//Return above format
		return summaryStr;
	}
}
