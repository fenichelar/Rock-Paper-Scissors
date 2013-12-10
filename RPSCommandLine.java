import java.util.Scanner;

/**
 * This class will ask the user how many games they would like to play then check who one each game, and print out the results.
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked alone on this homework
 */

public class RPSCommandLine {
	
	/**
	 * This main method creates all necessary objects to run the game then it will perform all the
	 * logic required to see who won and then print out who one each game.
	 * @param args unused
	 */

	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the number of games to run: ");
		int numGames = scan.nextInt();
		RPSScoreKeeper keeperRock = new RPSScoreKeeper();
		RPSScoreKeeper keeperPaper = new RPSScoreKeeper();
		RPSScoreKeeper keeperScissors = new RPSScoreKeeper();
		RPSThrow rockThrow = new RPSThrow(RPSThrow.ROCK);
		RPSThrow paperThrow = new RPSThrow(RPSThrow.PAPER);
		RPSThrow scissorsThrow = new RPSThrow(RPSThrow.SCISSORS);
		RPSThrow opponentThrow;
		
		for(int i = 0; i < numGames; i++) {
			
            opponentThrow = new RPSThrow();
			
            boolean check = rockThrow.beats(opponentThrow);
			
            if (check == true)
				keeperRock.addWin();
			else if (opponentThrow.beats(rockThrow))
				keeperRock.addLoss();
			else
				keeperRock.addTie();

		}
        
		System.out.println("When we are rock: " + keeperRock);
		
        for(int i = 0; i < numGames; i++) {
			
            opponentThrow = new RPSThrow();
			
            boolean check = paperThrow.beats(opponentThrow);
			
            if (check == true)
				keeperPaper.addWin();
			else if (opponentThrow.beats(paperThrow))
				keeperPaper.addLoss();
			else
				keeperPaper.addTie();
		}
        
		System.out.println("When we are paper: " + keeperPaper);
		
        for(int i = 0; i < numGames; i++) {
			
            opponentThrow = new RPSThrow();
			
            boolean check = scissorsThrow.beats(opponentThrow);
			
            if (check == true)
				keeperScissors.addWin();
			else if (opponentThrow.beats(scissorsThrow))
				keeperScissors.addLoss();
			else
				keeperScissors.addTie();
		}
        
		System.out.println("When we are scissors: " + keeperScissors);
		
	}
	
}
