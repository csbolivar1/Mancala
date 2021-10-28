/*Mancala Glossary:
	Stores - location of each players' total count
	Shells - the 'gamepieces', represented by numbers in each index
	Pockets - location where 'shells' are stored for players to obtain and add to their store
*/	

import java.util.Random;
import java.util.Scanner;

public class MancalaMain extends Board {
	
	//private static Scanner player1_input; 		 // Takes Player 1's input to see which index to pick up shells from
	//private static Scanner player2_input; 		 // Takes Player 2's input to see which index to pick up shells from
	//private static boolean player1_turn = false; // Determines who's turn it currently is;
	//private static boolean player2_turn = false; // both start out false.
	private static Board board;

	public static void main(String[] args) {
		int num;
		Random coin_flip = new Random();
		
		board.fillBoard(); // Get the board's start state
		board.configurePlayerSides();
		
		System.out.println("Lets Play Mancala!!!");
		
		// Flip a coin to see who will go first.
		num = coin_flip.nextInt(2);
		
		if(num == 0) {
			PlayMancala.player1_turn = true;
			PlayMancala.player2_turn = false;
			System.out.println("Player 1 will go first.");
			PlayMancala.play();
		}
		
		if(num == 1) {
			PlayMancala.player2_turn = true;
			PlayMancala.player1_turn = false;
			System.out.println("Player 2 will go first.");
			PlayMancala.play2();
			
		}
		
	}

}
