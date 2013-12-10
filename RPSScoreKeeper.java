/**
 * This class will be used to keep track of the number of wins, losses, and ties
 * in the Rock, Paper, Scissors game.
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked alone on this homework
 */

public class RPSScoreKeeper {

	private int wins;
	private int losses;
	private int ties;
	
	/**
	 * This method increments the win variable.
	 */
	
	public void addWin() {
		wins++;
	}
	
	/**
	 * This method increments the losses variable.
	 */
	
	public void addLoss() {
		losses++;
	}
	
	/**
	 * This method increments the ties variable.
	 */
	
	public void addTie() {
		ties++;
	}
	
	/**
	 * This method returns a String of all the variables.
	 * @return number of wins, losses, ties as String.
	 */
	
	public String toString() {
		return (wins+" wins, "+losses+" losses, "+ties+" ties");
	}
	
}
