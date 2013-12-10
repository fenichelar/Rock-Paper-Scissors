import java.util.Random;

/**
 * This class handles the logic for the Rock, Paper Scissors game.
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked alone on this homework
 */

public class RPSThrow {
    
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
	
	private Random generator = new Random();
	private int choice;
	
	/**
	 * This constructor takes in a choice of either 0,1,2 corresponding to an option and assigns to choice
	 * @param choice a choice that the user can make.
	 */
	
	public RPSThrow(int choice) {
		this.choice = choice;
	}
	
	/**
	 * This constructor assigns a random number 0,1,2 to choice.
	 */
	
	public RPSThrow() {
		choice = generator.nextInt(3);
	}
	
	/**
	 * This method checks to see who won a game of Rock, Paper, Scissors.
	 * @param choice that the opponent uses.
	 * @return true if the current user wins, else false.
	 */
	
	public boolean beats(RPSThrow other) {
		
        boolean myChoice;
		
        if(choice == ROCK) {
			if (other.getChoice() == SCISSORS)
				myChoice = true;
			else
				myChoice = false;
		}
		else if (choice == PAPER) {
			if (other.getChoice() == ROCK) 
				myChoice = true;
			else
				myChoice = false;
		}
		else {
			if(other.getChoice() == PAPER)
				myChoice = true;
			else
				myChoice = false;
		}
		
		return myChoice;
			
	}
	
	/**
	 * Returns the current choice by this Object
	 * @return rock, paper, scissors as String.
	 */
	
	public int getChoice() {
		return choice;
	}
	
	/**
	 * Returns a string representation of this object's current choice 
	 * @return rock, paper, scissors as a String.
	 */
	
	public String toString() {
		
        String myChoice;
		
        if (choice == ROCK)
			myChoice = "rock";
		else if(choice == PAPER)
			myChoice = "paper";
		else
			myChoice = "scissors";
		
        return myChoice;
	}
	
}

