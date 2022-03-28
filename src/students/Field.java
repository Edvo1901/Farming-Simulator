package students;

import students.items.Apples;
import students.items.Food;
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
	protected String newField = new String();
	
	
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
		for (int i = 0; i <= this.width; i ++) {
			if (i == 0) {
				this.newField += " " + "\t";
			} else {
				this.newField += i + "\t";
			}
    	}
		
		this.newField += "\n" + "\n";
		for (int i = 0; i < this.height; i ++) {
			this.newField += i + 1 +"\t";
			for (int j = 0; j < this.width; j ++) {
				this.newField += this.spot[i][j].toString() + "\t";
			}
			this.newField += "\n" + "\n";
		}
		
		return this.newField;
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
		this.spot[y - 1][x - 1] = item;
	}
	
	public void till(int x, int y) {
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				Soil newSoil = new Soil();
				this.spot[y-1][x-1] = newSoil;
			}
		}
			
	}
	
	public String get(int x, int y) {
		return this.spot[y - 1][x - 1].getName();
	}
	
	public int getValue() {
		
		int totalValue = 0;
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				this.spot[i][j].getValue();
				
				if (this.spot[i][j].toString().equals("A")) {
					totalValue += this.spot[i][j].getValue();
				} else if (this.spot[i][j].toString().equals("G")) {
					totalValue += this.spot[i][j].getValue();
					
				}
			}
		}
		return totalValue;
	}
	
	public void getSummary() {
		System.out.printf("%-30.30s  %-30.30s%n", "Apples:", 1);
		System.out.printf("%-30.30s  %-30.30s%n", "Grains:", 6);
		System.out.printf("%-30.30s  %-30.30s%n", "Soil:", 5);
		System.out.printf("%-30.30s  %-30.30s%n", "Untilled:", 4);
		System.out.printf("%-30.30s  %-30.30s%n", "Weed:", 3);
		System.out.println("For total of");
		System.out.printf("%-30.30s  %-30.30s%n", "Total apples created: ", 1);
		System.out.printf("%-30.30s  %-30.30s%n", "Total grain created: ", 0);
		
	}
	
	public static void main(String[] args) {
		Field a = new Field(5, 10);
		System.out.println(a);
	}


	

}
