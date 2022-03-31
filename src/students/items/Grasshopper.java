/**
This is a part of additional feature.
It has nothing related to the orginal assignment.

For more information about how this is work, please read the Readme file.

Developed by Vi Dong (Edward) Vo.
 */
package students.items;

import java.util.Random;
import java.util.Scanner;

import students.Farm;

//Create constructor for Grasshopper that inherited from Item
public class Grasshopper extends Item{
	//Set death and mutation age for Grasshopper
	public Grasshopper () {
		super(1, 1, 0);
		
	}
	
	//Return the symbol of this item
	public String toString() {
		this.itemName = "*";
		return this.itemName;
	}
	
	/**
	This is basic minigame Rock, Paper, Scissor
	Player need to win this game in order to defeat the Grasshopper and protect the plant
	Function will return the results which will be use in another class.
	 */
	public static boolean miniGame() {
		//Set while loop condition
		boolean isPlaying = true;
		
		//Declear variable to return
		boolean isWin = false;
		Scanner playGame = new Scanner(System.in);
		while (isPlaying) {
			System.out.print("\n===Welcome to RPS MiniGame==="
					+ "\nMake your move and let see if you can protect your land"
					+ "\nEnter your choice: "
					+ "\n1. Rock: r"
					+ "\n2. Paper: p"
					+ "\n3. Scissor: s"
					+ "\nYour choice: ");
			String gameChoice = playGame.nextLine();
			
			//List of available choice for computer
			String[] availableChoice = {"r", "p", "s"};  
			Random computerChoice = new Random();
			
			//Random the choice from giving list
			int randomComputerChoice = computerChoice.nextInt(availableChoice.length);
			
			//Show a message if player enter invalid value
			if (!gameChoice.toLowerCase().equals("s") 
					&& !gameChoice.toLowerCase().equals("p") 
					&& !gameChoice.toLowerCase().equals("r")){
				System.out.println("Please only choose either Rock (r), Paper (p) or Scissor (s).");
				isPlaying = true;
			
			} else {
				//Draw result
				if (gameChoice.equals(availableChoice[randomComputerChoice])) {
					System.out.println("Draw!!! You will win next round. :) \n");
					isPlaying = true;
					
				//Win result
				} else if (availableChoice[randomComputerChoice].equals("r") && gameChoice.equals("p")) {
					System.out.println("You won! Yohoooo :)\n");
					isPlaying = false;
					isWin = true;
				} else if (availableChoice[randomComputerChoice].equals("p") && gameChoice.equals("s")) {
					System.out.println("You won! Yohoooo :)\\n");
					isPlaying = false;
					isWin = true;
				} else if (availableChoice[randomComputerChoice].equals("s") && gameChoice.equals("r")) {
					System.out.println("You won! Yohoooo :)\\n");
					isPlaying = false;
					isWin = true;
				
				//Lose result
				} else {
					System.out.println("Well, you lose! Better luck next time :(\n");
					isPlaying = false;
					isWin = false;
				}
			}
		}
		//Return the result of this game
		return isWin;
	}
}
