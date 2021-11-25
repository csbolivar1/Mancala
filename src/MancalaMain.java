/*Mancala Glossary:
	Stores - location of each players' total count
	Shells - the 'gamepieces', represented by numbers in each index
	Pockets - location where 'shells' are stored for players to obtain and add to their store
*/

import java.util.Random;
import java.util.Scanner;

public class MancalaMain extends Board {

	private static Board board;
	
	private static void howToPlay() {
		
		System.out.println("\r\n=================================================================================\r\n");
		System.out.println("===================================HOW TO PLAY===================================\r\n");
		System.out.println("=================================================================================\r\n");
		System.out.println("Objective: "
				+ "\r\n"
				+ "\r\n"
				+ "The object of the game is to gather more shells than your opponent. \r\n"
				+ "Each player's total is the large pocket to their right side. \r\n"
				+ "Shells are primarily gathered by capturing them."
				+ "\r\n");
		
		System.out.println("Board Layout: \r\n");
		
		System.out.println("===============================================Player 2 side================================================\r\n"
				+ "                                  (7)   (6)   (5)   (4)   (3)   (2)   (1)                              \r\n"
				+ "                                   7     7     7     7     7     7     7\r\n"
				+ "             (Player 2 Total)  0                                            0  (Player 1 Total)\r\n"
				+ "                                   7     7     7     7     7     7     7\r\n"
				+ "                                  (1)   (2)   (3)   (4)   (5)   (6)   (7)\r\n"
				+ "===============================================Player 1 side================================================\r\n"
				+ "");
		
		System.out.println("Rules: \r\n");
		System.out.println("1. Either Player 1 or 2 will go first at random.\r\n"
				+ "\r\n"
				+ "2. The player will be asked to select a pocket on their side via number input (1 through 7), indicated by the number in parenthesis.\r\n"
				+ "\r\n"
				+ "3. Once a pocket number is selected, the pocket will be emptied and the shells picked up and distributed. "
				+ "\r\nOne shell is distributed into each pocket counter-clockwise, including the player's own total but not the opponent's, until there are no more shells left to distribute.\r\n"
				+ "\r\n"
				+ "4. The next action that occurs depends on where the land shell lands:\r\n"
				+ "\r\n"
				+ "If the last shell is dropped into a pocket with at least one shell, the player picks up all the shells from that pocket, and begins distributing again.\r\n"
				+ "If the last shell is dropped into the player's own total, the player gets another turn.\r\n"
				+ "If the last shell is dropped in an empty pocket on their own side, the player captures all the shells in the opposite pocket, as well as the one shell on their sides, and adds them to their total. The player's turn ends.\r\n"
				+ "If the last shell is dropped in an empty hole on the opponent's side, the player's turn ends.\r\n"
				+ "\r\n"
				+ "The game ends when all pockets are empty. The player with more shells wins."
				+ "\r\n");
		
		System.out.println("\r\n================================================================================\r\n");
		System.out.println("===================================GOOD LUCK!===================================\r\n");
		System.out.println("================================================================================\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n");
	}
	
	public static void main(String[] args) {
		int num = 0;
		Random coin_flip = new Random();

		board.fillBoard(); 
		board.configurePlayerSides();

		howToPlay();

		// Flip a coin to see who will go first.
		num = coin_flip.nextInt(2);

		if (num == 0) {
			PlayMancala.player1_turn = true;
			PlayMancala.player2_turn = false;
			System.out.println("Player 1 will go first.");
			PlayMancala.play();
		}

		if (num == 1) {
			PlayMancala.player2_turn = true;
			PlayMancala.player1_turn = false;
			System.out.println("Player 2 will go first.");
			PlayMancala.play();

		}

	}

}
