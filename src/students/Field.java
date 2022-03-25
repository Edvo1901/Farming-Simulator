package students;

import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

import java.lang.Math;
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
			}
		}
		
		Random rnd = new Random();
	    int chance = rnd.nextInt(5);
	    
		for (int i = 0; i < this.height; i ++) {
			for (int j = 0; j < this.width; j ++) {
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
	
	public static void main(String[] args) {
		Field a = new Field(5, 10);
		a.printField();
	}

	

}
