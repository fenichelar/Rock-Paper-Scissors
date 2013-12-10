import java.util.Scanner;
import java.io.*;

/**
 * This class will take in a text file of choices (rock, paper, or scissors),
 * and will play Rock, Paper Scissors for a total number of games equal
 * to the number of options.
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked alone on this homework
 */

public class RPSFromFile {
	
	/**
	 * This is the Driver for RPSFromFile class. It will perform all the logic to check who won the game by making the appropriate calls to the class
	 * @param args correspond to command-line input
	 * @throws IOException catch any IO errors from the user
	 */
	
	public static void main(String[] args) throws IOException{
		RPSScoreKeeper keeper = new RPSScoreKeeper();
		Scanner filePathScan = new Scanner(System.in);
		System.out.print("Enter the file to load: ");
		String fileName = filePathScan.nextLine();
		File myFile = new File(fileName);
		Scanner fileText = new Scanner(myFile);
		
		String nums = fileText.nextLine();
		RPSThrow myThrow;
		RPSThrow opponentThrow;
		int count  = 0;
		
		while(nums!=""){
			if(nums.equals("rock")) {				
				myThrow = new RPSThrow(RPSThrow.ROCK);
			} 
			else if(nums.equals("paper")) {
				myThrow = new RPSThrow(RPSThrow.PAPER);
			} 
			else {
				myThrow = new RPSThrow(RPSThrow.SCISSORS);
			}
			opponentThrow = new RPSThrow();
			
			boolean check = myThrow.beats(opponentThrow);
			if (check == true)
				keeper.addWin();
			else if (opponentThrow.beats(myThrow))
				keeper.addLoss();
			else
				keeper.addTie();
			count++;
			System.out.println(count+". Player: "+myThrow.toString()+" Computer: "
					+opponentThrow.toString()+", Score: "+keeper.toString());
			if(fileText.hasNextLine())
				nums = fileText.nextLine();
			else
				nums = "";
		}			
	}
}
