package students.items;

import java.util.Random;
import java.util.Scanner;

import students.Farm;

public class Grasshopper extends Item{

	
	public Grasshopper () {
		super(1, 1, 4);
		
	}

	public String toString() {
		this.itemName = "*";
		return this.itemName;
	}
	
	public static boolean miniGame() {
		boolean isPlaying = true;
		boolean isWin = false;
		Scanner playGame = new Scanner(System.in);
		while (isPlaying) {
			System.out.println("\nEnter your choice: "
					+ "\n Rock: r"
					+ "\n Paper: p"
					+ "\n Scissor: s");
			String gameChoice = playGame.nextLine();
			
			String[] availableChoice = {"r", "p", "s"};  
			Random computerChoice = new Random();
			int randomComputerChoice = computerChoice.nextInt(availableChoice.length);
			if (!gameChoice.toLowerCase().equals("s") 
					&& !gameChoice.toLowerCase().equals("p") 
					&& !gameChoice.toLowerCase().equals("r")){
				System.out.println("Your choice is invalid.");
				isPlaying = true;
			} else {
				if (gameChoice.equals(availableChoice[randomComputerChoice])) {
					System.out.println("Draw!!! Good luck next time.");
					isPlaying = true;
				} else if (availableChoice[randomComputerChoice].equals("r") && gameChoice.equals("p")) {
					System.out.println("You win! Congrastulation");
					isPlaying = false;
					isWin = true;
				} else if (availableChoice[randomComputerChoice].equals("p") && gameChoice.equals("s")) {
					System.out.println("You win! Congrastulation");
					isPlaying = false;
					isWin = true;
				} else if (availableChoice[randomComputerChoice].equals("s") && gameChoice.equals("r")) {
					System.out.println("You win! Congrastulation");
					isPlaying = false;
					isWin = true;
				} else {
					System.out.println("You lose! Better luck next time!");
					isPlaying = false;
					isWin = false;
				}
			}
		}
		return isWin;
	}
}
