import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates the JPanel for a Rock, Paper, Scissors game and instantiates a JFrame and adds all the GUI components in the class to the Panel then added to the JFrame.
 * @author Alec Fenichel
 * @version awesome
 * Collaboration Statement:
 * I worked alone on this homework
 */

public class RPSPanel extends JPanel{
	
	private RPSThrow user;
	private RPSThrow computer;
	private JButton rock,paper,scissors;
	private JLabel opponentLabel,resultLabel,scoreLabel;
	private RPSScoreKeeper score = new RPSScoreKeeper();
	private String winLose;
	private Icon rockIcon = new ImageIcon("rock.png");
	private Icon paperIcon = new ImageIcon("paper.png");
	private Icon scissorIcon = new ImageIcon("scissors.png");
	
	/**
	 * This constructor assigns the GUI components to their respected local variables. 
	 * It also creates JButtons for each option (Rock, Paper, Scissors), and action listeners are added to the JButtons and adds the GUI components to the Panel.
	 */
	
	public RPSPanel() {
        
		rock = new JButton(rockIcon);
		paper = new JButton(paperIcon);
		scissors = new JButton(scissorIcon);
		
		rock.addActionListener(new ButtonListener(0));
		paper.addActionListener(new ButtonListener(1));
		scissors.addActionListener(new ButtonListener(2));
		
		opponentLabel = new JLabel("Choose a throw to run a game.");
		resultLabel = new JLabel("");
		scoreLabel = new JLabel(score.toString());
		
		add(rock);
		add(paper);
		add(scissors);
		
		add(opponentLabel);
		add(resultLabel);
		add(scoreLabel);
		
	}
	
	/**
	 * This main method creates a JFrame and add the RPSPanel to the frame.
	 * @param args not used
	 */
	
	public static void main(String[] args) {
        
		JFrame frame = new JFrame("Rock Paper Scissors");
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        RPSPanel panel = new RPSPanel();
		
        frame.add(panel);
		frame.setPreferredSize(new Dimension(300,175));
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * This private class will creats an Action Listener that will be used by the JButtons in the RPSPanel class and updates the JLabels in the RPSPanel panel, and performs the logic to see who won game.
	 */
	
	private class ButtonListener implements ActionListener {
		
        int choice;
		
        public ButtonListener(int choice) {
			this.choice = choice;
		}
		
		public void actionPerformed(ActionEvent event) {
			
            user = new RPSThrow(choice);
			computer = new RPSThrow();
			
			boolean check = user.beats(computer);
			
            if (check == true) {
				score.addWin();
				resultLabel.setText(" You win!");
			}
			else if (computer.beats(user)) {
				score.addLoss();
				resultLabel.setText(" You lose!");
			}
			else {
				score.addTie();
				resultLabel.setText("Tie!");
			}
            
			opponentLabel.setText("The computer chose "+computer.toString()+".");
			scoreLabel.setText(score.toString());
			
		}
		
	}
}
	

	

