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
	private int height;
	private int width;
	
	
    public void printField() {
    	  
		for (int i = 0; i <= this.width; i ++) {
			if (i == 0) {
				System.out.print(" ");
				System.out.print("\t");
			} else {
				System.out.print(i);
				System.out.print("\t");
			}
    	}
		
		System.out.println("\n");
		for (int i = 0; i < this.height; i ++) {
			System.out.print(i + 1 + "\t");
			for (int j = 0; j < this.width; j ++) {
				System.out.print(this.spot[i][j].toString() + "\t");
			}
			System.out.println("\n");
		}
    }
	
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
		Dictionary<String, Integer> totalValue = new Hashtable<String, Integer>();
		
		int totalAppleValue = 0;
		int totalGrainValue = 0;
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
				this.spot[i][j].getValue();
				
				if (this.spot[i][j].toString().equals("A")) {
					totalAppleValue += this.spot[i][j].getValue();
				} else if (this.spot[i][j].toString().equals("G")) {
					totalGrainValue += this.spot[i][j].getValue();
					
				}
			}
		}
		return totalValue;
	}
	
	public String getSummary() {
		
	}
	
	public static void main(String[] args) {
		Field a = new Field(5, 10);
		a.printField();
		Apples apple = new Apples();
		a.plant(3, 4, apple);
		a.printField();
		a.tick();
		a.tick();
		a.tick();
		a.printField();
		System.out.println(a.getValue());
	}

	

}
