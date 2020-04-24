import java.util.Random;
import java.util.Scanner;

public class MancalaMain extends Board {
	
	private static Scanner player1_input; // Takes Player 1's input to see which index to pick up shells from
	private static Scanner player2_input; // Takes Player 2's input to see which index to pick up shells from
	private static int index; // Keeps track of the index during Player 1's turn
	private static int index2; // Keeps track of the index during Player 2's turn
	private static int hand = 0; // Keeps track of how many shells are currently at hand; used for both Players' turns
	private static boolean Player1_turn = false; // Determines who's turn it currently is;
	private static boolean Player2_turn = false; // both start out false.
	private static Board board;


	// Player 1's movements
	private static String Play() {
		
		// Ask Player 1 which non-zero index to pick.
		player1_input = new Scanner(System.in);
		board.displayBoard();
		
		if(Player1_turn == true) { 
			
			// Go here if there aren't any more shells in Player 1's pockets. Occurs towards the end of the game
			if(Board[0] == 0 && Board[1] == 0 && Board[2] == 0 && 
					Board[3] == 0 && Board[4] == 0 && Board[5] == 0 && Board[6] == 0) {
				System.out.println("There are no more shells on Player 1's side!");
				
				// Add any remaining shells on Player 1's side to their collection
				Board[15] = Board[15] + Board[8] + Board[9] + Board[10] + Board[11] + Board[12] + Board[13] + Board[14];
				
				Board[8] = 0;
				Board[9] = 0;
				Board[10] = 0;
				Board[11] = 0;
				Board[12] = 0;
				Board[13] = 0;
				Board[14] = 0;
				
				EndGame();
			} 
			
			else { // Play the rest of the game
			
			// Choose a pocket
			System.out.println("Player 1, choose one of your pockets (1 through 7)");
			index = player1_input.nextInt() - 1; // index is where Player 1 picks up the shells
			
			if(index == 0 || index == 1 || index == 2 ||
			   index == 3 || index == 4 || index == 5 || index == 6 && Board[index] != 0) {
				
				System.out.println("I have selected: " + index);
				
				// Continue to loop while there are shells to be picked up
				while(Board[index] != 0) {
					
					System.out.println("You picked up " + Board[index] + " shells from pocket " + index);
					
					// Get shells from selected index to hand
					hand = Board[index];
					Board[index] = 0;
					// Index that's selected now has 0 shells in its pocket (b/c you just picked them up)
			
					// Distribute the shells to the next pockets
					while(hand >= 1 && index <= 14) {
						
						index++;
						Board[index] = Board[index] + 1;
						System.out.println("You dropped 1 shell in index " + index);
						
						// Skip Player 2's store, go back to Player 1's side (index 0)
						if(index == 14) {
							index = 0;
							Board[0] = Board[0] + 1;
							System.out.println("You dropped 1 shell in index 0");
							hand--;
							
						}
						
						// Player 1 goes again if the last shell lands in index 7 (AKA their own store)
						if(index == 7 && hand == 1) {
							System.out.println("You landed in your own store! Go again!");
							Play();
						}
						
						// Decrement the amount of shells in hand by 1 b/c you're placing shells in each pocket.
						hand--;
						board.displayBoard();
						System.out.println("You have " + hand + " shells left in your hand");
				}
					
					// Breaks from loop if you place your last shell on an empty pocket; capturing starts to occur
					if(index != 7 && Board[index] == 1) {
						break;
					}
					
			}	
		}	
				
			else { // Supposed to occur if you pick an index w/o any shells
				System.out.println("That pocket doesn't have any shells in it");
				System.out.println("Choose one of your pockets (0 through 6)");
				Play();
			}
			
			// Capture opponent's shells; Player 2's turn afterwards
			if(Board[0] == 1 && hand == 0) {
				
				System.out.println("You have collected " + Board[14] + " shells from Player 2. It is now Player 2's turn.");
				
				
				Board[7] = Board[7] + Board[14];
				Board[14] = 0;
				Board[7] = Board[7] + Board[0];
				Board[0] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				Play2();
			}
			
			if(Board[1] == 1 && hand == 0) {
				System.out.println("You have collected " + Board[13] + " shells from Player 2. It is now Player 2's turn.");
				
				
				Board[7] = Board[7] + Board[13];
				Board[13] = 0;
				Board[7] = Board[7] + Board[1];
				Board[1] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				Play2();
			}
			
			if(Board[2] == 1 && hand == 0) {
				System.out.println("You have collected " + Board[12] + " shells from Player 2. It is now Player 2's turn.");
				
				
				Board[7] = Board[7] + Board[12];
				Board[12] = 0;
				Board[7] = Board[7] + Board[2];
				Board[2] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				Play2();
			}
			
			if(Board[3] == 1 && hand == 0) {
				
				System.out.println("You have collected " + Board[11] + " shells from Player 2. It is now Player 2's turn.");
				
				Board[7] = Board[7] + Board[11];
				Board[11] = 0;
				Board[7] = Board[7] + Board[3];
				Board[3] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				
			}
			
			if(Board[4] == 1 && hand == 0) {
				System.out.println("You have collected " + Board[10] + " shells from Player 2. It is now Player 2's turn.");
				
			
				Board[7] = Board[7] + Board[10];
				Board[10] = 0;
				Board[7] = Board[7] + Board[4];
				Board[4] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				Play2();
			}
			
			if(Board[5] == 1 && hand == 0) {
				System.out.println("You have collected " + Board[9] + " shells from Player 2. It is now Player 2's turn.");
				
				
				Board[7] = Board[7] + Board[9];
				Board[9] = 0;
				Board[7] = Board[7] + Board[5];
				Board[5] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				Play2();
			}
			
			if(Board[6] == 1 && hand == 0) {
				System.out.println("You have collected " + Board[8] + " shells from Player 2. It is now Player 2's turn.");
				
			
				Board[7] = Board[7] + Board[6];
				Board[6] = 0;
				Board[7] = Board[7] + Board[8];
				Board[8] = 0;
				
				Player1_turn = false;
				Player2_turn = true;
				Play2();
			}
			
			// End Player 1's turn if Player 1 lands on an empty pocket on Player 2's side
			if(Board[8] == 1 || Board[9] == 1 || Board[10] == 1 || Board[11] == 1 || Board[12] == 1 || Board[13] == 1
					|| Board[14] == 1 && hand == 1);
				System.out.println("I have " + hand + " shells in my hand");
				System.out.println("You have landed on an empty space on your opponent's side. It's now Player 2's turn.");
				Player1_turn = false;
				Player2_turn = true;
			
		}
			
		System.out.println("Player 1's turn is over. It's now Player 2's turn.");
		
		Player1_turn = false;
		Player2_turn = true;
		Play2();
		
		}
		return null;

	}
	
	// Player 2's movements; alot of the same as Player 1's movements except for one extra if statement while distributing shells
	private static String Play2() {
		
		player2_input = new Scanner(System.in);
		board.displayBoard();
		
		if(Player2_turn == true) {
			
			if(Board[8] == 0 && Board[9] == 0 && Board[10] == 0 && 
					Board[11] == 0 && Board[12] == 0 && Board[13] == 0 && Board[14] == 0) {
				System.out.println("There are no more shells on Player 2's side!");
				
				// Add any remaining shells on Player 1's side to their collection
				Board[7] = Board[7] + Board[0] + Board[1] + Board[2] + Board[3] + Board[4] + Board[5] + Board[6];
				
				Board[0] = 0;
				Board[1] = 0;
				Board[2] = 0;
				Board[3] = 0;
				Board[4] = 0;
				Board[5] = 0;
				Board[6] = 0;
				
				EndGame();
			}
			
			// Choose a pocket
			System.out.println("Player 2, choose one of your pockets (1 through 7)");
			index2 = player2_input.nextInt() + 7;
			
			if(index2 == 8 || index2 == 9 || index2 == 10 ||
			   index2 == 11 || index2 == 12 || index2 == 13 || index2 == 14) {
				System.out.println("Player 2 chose " + index2);
				
				while(Board[index2] != 0) {
					
					System.out.println("You picked up " + Board[index2] + " shells from pocket " + index2);
					hand = Board[index2];
					Board[index2] = 0;
					
					// Distribute the shells to the next pockets
					while(hand >= 1 && index2 <= 15) {
						
						index2++;
						Board[index2] = Board[index2] + 1;
						System.out.println("You dropped a shell in index " + index2);
						
						
						// Player 2 goes again if they land in their own store
						if(index2 == 15 && hand == 1) {
							System.out.println("You landed in your own store! Go again!");
							Play2();
						}
						
						// Loop back to the 'beginning' of array/board (index 0) if Player 2 still has more than 1 shell in hand
						// This is the only significant difference between Play() and Play2().
						if(index2 == 15 && hand != 1) {
							index2 = 0;
							Board[0] = Board[0] + 1;
							System.out.println("You dropped a shell in index 0");
							hand--;
							
						}
						
						// Skip Player 1's store
						if(index2 == 6) {
							index2 = 8;
							Board[8] = Board[8] + 1;
							System.out.println("You dropped a shell in index 8");
							hand--;
						}
						
						board.displayBoard();
						
						hand--;
						System.out.println("There are " + hand + " shells left in my hand");
					}
					
					if(index2 != 15 && Board[index2] == 1) {
						break;
					}
					
				}
				
			}
			else {
				System.out.println("Please choose another index");
				Play2();
			}
			
			// Capturing shells; Player 1's turn afterwards
			if(Board[8] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[6] + " shells! It is now Player 1's turn");
				
				Board[15] = Board[15] + Board[8];
				Board[8] = 0;
				Board[15] = Board[15] + Board[6];
				Board[6] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			if(Board[9] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[5] + " shells! It is now Player 1's turn.");
				
				Board[15] = Board[15] + Board[9];
				Board[9] = 0;
				Board[15] = Board[15] + Board[5];
				Board[5] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			if(Board[10] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[4] + " shells! It is now Player 1's turn.");
				
				Board[15] = Board[15] + Board[10];
				Board[10] = 0;
				Board[15] = Board[15] + Board[4];
				Board[4] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			if(Board[11] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[3] + " shells! It is now Player 1's turn.");
				
				Board[15] = Board[15] + Board[11];
				Board[11] = 0;
				Board[15] = Board[15] + Board[3];
				Board[3] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			if(Board[12] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[2] + " shells! It is now Player 1's turn.");
				
				Board[15] = Board[15] + Board[12];
				Board[12] = 0;
				Board[15] = Board[15] + Board[2];
				Board[2] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			
			if(Board[13] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[1] + " shells! It is now Player 1's turn.");
				
				Board[15] = Board[15] + Board[13];
				Board[13] = 0;
				Board[15] = Board[15] + Board[1];
				Board[1] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			if(Board[14] == 1 && hand == 0) {
				
				System.out.println("You have captured " + Board[0] + " shells! It is now Player 1's turn.");
				
				Board[15] = Board[15] + Board[14];
				Board[14] = 0;
				Board[15] = Board[15] + Board[0];
				Board[0] = 0;
				
				Player1_turn = true;
				Player2_turn = false;
				Play();
				
			}
			
			// End turn if you land on an empty pocket on your Player 1's side
			if(Board[0] == 1 || Board[1] == 1 || Board[2] == 1 || Board[3] == 1 || Board[4] == 1 || Board[5] == 1
					|| Board[6] == 1 && hand == 1); {
				System.out.println("You have landed on an empty space on your opponent's side. It's now Player 1's turn.");
				Player1_turn = true;
				Player2_turn = false;
				Play();
			}
			
					
		}
		
		return null;
	}
	
	// Display final results
	private static String EndGame() {
	
		
		System.out.println("Player 1 has " + Board[7] + " shells.");
		System.out.println("Player 2 has " + Board[15] + " shells.");
		
		// If player 1 has more shells, player 1 wins
		if(Board[7] > Board[15]) {
			board.displayBoard();
			System.out.println("Player 1 wins!");
			return null;
			
		}
		
		// If player 2 has more shells, player 2 wins
		if(Board[7] < Board[15]) {
			board.displayBoard();
			System.out.println("Player 2 wins!");
			
			return null;
		}
		
		// If player 1 and player 2 are tied (46 shells each)
		if(Board[7] == Board[15]) {
			board.displayBoard();
			System.out.println("Tie Game!");
			
			return null;
		}
		
		Player1_turn = false;
		Player2_turn = false;
		System.out.println("Thanks for playing!");
		return null;
	}
	
	public static void main(String[] args) {
		int num;
		Random coin_flip = new Random();
		
		board.fillBoard(); // Get the board's start state
		
		System.out.println("Lets Play Mancala!!!");
		
		// Flip a coin to see who will go first.
		num = coin_flip.nextInt(2);
		
		if(num == 0) {
			Player1_turn = true;
			Player2_turn = false;
			System.out.println("Player 1 will go first.");
			Play();
		}
		
		if(num == 1) {
			Player2_turn = true;
			Player1_turn = false;
			System.out.println("Player 2 will go first.");
			Play2();
			
		}
		
	}

}
