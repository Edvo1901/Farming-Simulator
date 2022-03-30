package students;

import students.items.Apples;
import students.items.Food;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

import java.lang.Math;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;


public class Field {
	Item[][] spot;
	protected int height;
	protected int width;

	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		
		this.spot = new Item[this.height][this.width];
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				Soil ground = new Soil();
				this.spot[i][j] = ground;
			}
		}
		
		this.spot.toString();
	}
	
	public String toString() {
		String newField = new String();
		
		for (int i = 0; i <= this.width; i ++) {
			if (i == 0) {
				newField += " " + "\t";
			} else {
				newField += i + "\t";
			}
    	}
		
		newField += "\n" + "\n";
		for (int i = 0; i < this.height; i ++) {
			newField += i + 1 +"\t";
			for (int j = 0; j < this.width; j ++) {
				newField += this.spot[i][j].toString() + "\t";
			}
			newField += "\n" + "\n";
		}
		
		return newField;
	}
	
	public void tick() {
	    
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				this.spot[i][j].tick();
				
				Random rnd = new Random();
				int chance = rnd.nextInt(5);
				if (chance == 1 && this.spot[i][j] instanceof Soil) {
					Weed rndWeed = new Weed();
					this.spot[i][j] = rndWeed;
				}
				
				if (this.spot[i][j].died()) {
					UntilledSoil deadPlant = new UntilledSoil();
					this.spot[i][j] = deadPlant;
				
				}
			}
		}
	}
	
	public void plant(int x, int y, Food item) {
		this.spot[y][x] = item;
	}
	
	public void till(int x, int y) {
		
		Soil newSoil = new Soil();
		this.spot[y][x] = newSoil;

			
	}
	
	public Item get(int x, int y) {
		return this.spot[y][x];
	}
	
	public int getValue() {
		
		int totalValue = 0;
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				if (this.spot[i][j].getValue() != 0) {
					totalValue += this.spot[i][j].getValue();
				}
			}
		}
		return totalValue;
	}
	
	public String getSummary() {
		String summaryStr = new String();
		int totalApple = 0;
		int totalGrain = 0;
		int totalSoil = 0;
		int totalUntilled = 0;
		int totalWeed = 0;
		
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				if (this.spot[i][j].toString() == "a" || this.spot[i][j].toString() == "A") {
					totalApple++;
				} else if (this.spot[i][j].toString() == "g" || this.spot[i][j].toString() == "G") {
					totalGrain++;
				} else if (this.spot[i][j].toString() == "." ) {
					totalSoil++;
				} else if (this.spot[i][j].toString() == "/" ) {
					totalUntilled++;
				} else if (this.spot[i][j].toString() == "#") {
					totalWeed++;
				}
			}
		}
		
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Apples:", totalApple);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Grain:", totalGrain);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Soil:", totalSoil);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Untilled:", totalUntilled);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Weed:", totalWeed);
		summaryStr += String.format("%-15.50s  %-15.50s%n", "For a total of ", "$" + this.getValue());
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Total apples created:", Apples.getGenerationCount());
		summaryStr += String.format("%-15.50s  %-15.50s%n", "Total grain created:", Grain.getGenerationCount());
		
		return summaryStr;
	}
}
