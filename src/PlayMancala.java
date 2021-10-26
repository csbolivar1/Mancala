import java.util.Scanner;

public class PlayMancala extends Board {
	
	private static Scanner player1_input; 		 // Takes Player 1's input to see which index to pick up shells from
	private static Scanner player2_input; 		 // Takes Player 2's input to see which index to pick up shells from
	private static int index; 					 // Keeps track of the index during Player 1's turn
	private static int index2; 					 // Keeps track of the index during Player 2's turn
	private static int hand = 0; 				 // Keeps track of how many shells are currently at hand; used for both Players' turns
	private static boolean player1_turn = false; // Determines who's turn it currently is;
	private static boolean player2_turn = false; // both start out false.
	private static Board board;
	
	// Player 1's movements
	public static void play() {
		
		// Ask Player 1 which non-zero index to pick.
		player1_input = new Scanner(System.in);
		board.displayBoard();
	
		
		if(player1_turn == true) { 
			
			// Go here if there aren't any more shells in Player 1's pockets. Occurs towards the end of the game
			if(gameboard[0] == 0 && gameboard[1] == 0 && gameboard[2] == 0 && 
					gameboard[3] == 0 && gameboard[4] == 0 && gameboard[5] == 0 && gameboard[6] == 0) {
				System.out.println("There are no more shells on Player 1's side!");
				
				// Add any remaining shells on Player 1's side to their collection
				gameboard[15] = gameboard[15] + gameboard[8] + gameboard[9] + gameboard[10] + gameboard[11] + gameboard[12] + gameboard[13] + gameboard[14];
				
				gameboard[8] = 0;
				gameboard[9] = 0;
				gameboard[10] = 0;
				gameboard[11] = 0;
				gameboard[12] = 0;
				gameboard[13] = 0;
				gameboard[14] = 0;
				
				end();
			} 
			
			else { // Play the rest of the game
			
			// Choose a pocket
			System.out.println("Player 1, choose one of your pockets (1 through 7)");
			index = player1_input.nextInt() - 1; // index is where Player 1 picks up the shells
			
			if(index == 0 || index == 1 || index == 2 ||
			   index == 3 || index == 4 || index == 5 || index == 6 && gameboard[index] != 0) {
				
				System.out.println("I have selected: " + index);
				
				// Continue to loop while there are shells to be picked up
				while(gameboard[index] != 0) {
					
					System.out.println("You picked up " + gameboard[index] + " shells from pocket " + index);
					
					// Get shells from selected index to hand
					hand = gameboard[index];
					gameboard[index] = 0;
					// Index that's selected now has 0 shells in its pocket (b/c you just picked them up)
			
					// Distribute the shells to the next pockets
					while(hand >= 1 && index <= 14) {
						
						index++;
						gameboard[index] = gameboard[index] + 1;
						System.out.println("You dropped 1 shell in index " + index);
						
						// Skip Player 2's store, go back to Player 1's side (index 0)
						if(index == 14) {
							index = 0;
							gameboard[0] = gameboard[0] + 1;
							System.out.println("You dropped 1 shell in index 0");
							hand--;
							
						}
						
						// Player 1 goes again if the last shell lands in index 7 (AKA their own store)
						if(index == 7 && hand == 1) {
							System.out.println("You landed in your own store! Go again!");
							play();
						}
						
						// Decrement the amount of shells in hand by 1 b/c you're placing shells in each pocket.
						hand--;
						board.displayBoard();
						System.out.println("You have " + hand + " shells left in your hand");
				}
					
					// Breaks from loop if you place your last shell on an empty pocket; capturing starts to occur
					if(index != 7 && gameboard[index] == 1) {
						break;
					}
					
			}	
		}	
				
			else { // Supposed to occur if you pick an index w/o any shells
				System.out.println("That pocket doesn't have any shells in it");
				System.out.println("Choose one of your pockets (0 through 6)");
				play();
			}
			
			// Capture opponent's shells; Player 2's turn afterwards
			if(gameboard[0] == 1 && hand == 0) {
				
				System.out.println("You have collected " + gameboard[14] + " shells from Player 2. It is now Player 2's turn.");
				
				
				gameboard[7] = gameboard[7] + gameboard[14];
				gameboard[14] = 0;
				gameboard[7] = gameboard[7] + gameboard[0];
				gameboard[0] = 0;
				
				player1_turn = false;
				player2_turn = true;
				play2();
			}
			
			if(gameboard[1] == 1 && hand == 0) {
				System.out.println("You have collected " + gameboard[13] + " shells from Player 2. It is now Player 2's turn.");
				
				
				gameboard[7] = gameboard[7] + gameboard[13];
				gameboard[13] = 0;
				gameboard[7] = gameboard[7] + gameboard[1];
				gameboard[1] = 0;
				
				player1_turn = false;
				player2_turn = true;
				play2();
			}
			
			if(gameboard[2] == 1 && hand == 0) {
				System.out.println("You have collected " + gameboard[12] + " shells from Player 2. It is now Player 2's turn.");
				
				
				gameboard[7] = gameboard[7] + gameboard[12];
				gameboard[12] = 0;
				gameboard[7] = gameboard[7] + gameboard[2];
				gameboard[2] = 0;
				
				player1_turn = false;
				player2_turn = true;
				play2();
			}
			
			if(gameboard[3] == 1 && hand == 0) {
				
				System.out.println("You have collected " + gameboard[11] + " shells from Player 2. It is now Player 2's turn.");
				
				gameboard[7] = gameboard[7] + gameboard[11];
				gameboard[11] = 0;
				gameboard[7] = gameboard[7] + gameboard[3];
				gameboard[3] = 0;
				
				player1_turn = false;
				player2_turn = true;
				
			}
			
			if(gameboard[4] == 1 && hand == 0) {
				System.out.println("You have collected " + gameboard[10] + " shells from Player 2. It is now Player 2's turn.");
				
			
				gameboard[7] = gameboard[7] + gameboard[10];
				gameboard[10] = 0;
				gameboard[7] = gameboard[7] + gameboard[4];
				gameboard[4] = 0;
				
				player1_turn = false;
				player2_turn = true;
				play2();
			}
			
			if(gameboard[5] == 1 && hand == 0) {
				System.out.println("You have collected " + gameboard[9] + " shells from Player 2. It is now Player 2's turn.");
				
				
				gameboard[7] = gameboard[7] + gameboard[9];
				gameboard[9] = 0;
				gameboard[7] = gameboard[7] + gameboard[5];
				gameboard[5] = 0;
				
				player1_turn = false;
				player2_turn = true;
				play2();
			}
			
			if(gameboard[6] == 1 && hand == 0) {
				System.out.println("You have collected " + gameboard[8] + " shells from Player 2. It is now Player 2's turn.");
				
			
				gameboard[7] = gameboard[7] + gameboard[6];
				gameboard[6] = 0;
				gameboard[7] = gameboard[7] + gameboard[8];
				gameboard[8] = 0;
				
				player1_turn = false;
				player2_turn = true;
				play2();
			}
			
			// End Player 1's turn if Player 1 lands on an empty pocket on Player 2's side
			if(gameboard[8] == 1 || gameboard[9] == 1 || gameboard[10] == 1 || gameboard[11] == 1 || gameboard[12] == 1 || gameboard[13] == 1
					|| gameboard[14] == 1 && hand == 1);
				System.out.println("I have " + hand + " shells in my hand");
				System.out.println("You have landed on an empty space on your opponent's side. It's now Player 2's turn.");
				player1_turn = false;
				player2_turn = true;
			
		}
			
		System.out.println("Player 1's turn is over. It's now Player 2's turn.");
		
		player1_turn = false;
		player2_turn = true;
		play2();
		
		}
	}
	
	// Player 2's movements; alot of the same as Player 1's movements except for one extra if statement while distributing shells
	public static void play2() {
		
		player2_input = new Scanner(System.in);
		board.displayBoard();
		
		if(player2_turn == true) {
			
			if(gameboard[8] == 0 && gameboard[9] == 0 && gameboard[10] == 0 && 
					gameboard[11] == 0 && gameboard[12] == 0 && gameboard[13] == 0 && gameboard[14] == 0) {
				System.out.println("There are no more shells on Player 2's side!");
				
				// Add any remaining shells on Player 1's side to their collection
				gameboard[7] = gameboard[7] + gameboard[0] + gameboard[1] + gameboard[2] + gameboard[3] + gameboard[4] + gameboard[5] + gameboard[6];
				
				gameboard[0] = 0;
				gameboard[1] = 0;
				gameboard[2] = 0;
				gameboard[3] = 0;
				gameboard[4] = 0;
				gameboard[5] = 0;
				gameboard[6] = 0;
				
				end();
			}
			
			// Choose a pocket
			System.out.println("Player 2, choose one of your pockets (1 through 7)");
			index2 = player2_input.nextInt() + 7;
			
			if(index2 == 8 || index2 == 9 || index2 == 10 ||
			   index2 == 11 || index2 == 12 || index2 == 13 || index2 == 14) {
				System.out.println("Player 2 chose " + index2);
				
				while(gameboard[index2] != 0) {
					
					System.out.println("You picked up " + gameboard[index2] + " shells from pocket " + index2);
					hand = gameboard[index2];
					gameboard[index2] = 0;
					
					// Distribute the shells to the next pockets
					while(hand >= 1 && index2 <= 15) {
						
						index2++;
						gameboard[index2] = gameboard[index2] + 1;
						System.out.println("You dropped a shell in index " + index2);
						
						
						// Player 2 goes again if they land in their own store
						if(index2 == 15 && hand == 1) {
							System.out.println("You landed in your own store! Go again!");
							play2();
						}
						
						// Loop back to the 'beginning' of array/board (index 0) if Player 2 still has more than 1 shell in hand
						// This is the only significant difference between Play() and Play2().
						if(index2 == 15 && hand != 1) {
							index2 = 0;
							gameboard[0] = gameboard[0] + 1;
							System.out.println("You dropped a shell in index 0");
							hand--;
							
						}
						
						// Skip Player 1's store
						if(index2 == 6) {
							index2 = 8;
							gameboard[8] = gameboard[8] + 1;
							System.out.println("You dropped a shell in index 8");
							hand--;
						}
						
						board.displayBoard();
						
						hand--;
						System.out.println("There are " + hand + " shells left in my hand");
					}
					
					if(index2 != 15 && gameboard[index2] == 1) {
						break;
					}
					
				}
				
			}
			else {
				System.out.println("Please choose another index");
				play2();
			}
			
			// Capturing shells; Player 1's turn afterwards
			if(gameboard[8] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[6] + " shells! It is now Player 1's turn");
				
				gameboard[15] = gameboard[15] + gameboard[8];
				gameboard[8] = 0;
				gameboard[15] = gameboard[15] + gameboard[6];
				gameboard[6] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			if(gameboard[9] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[5] + " shells! It is now Player 1's turn.");
				
				gameboard[15] = gameboard[15] + gameboard[9];
				gameboard[9] = 0;
				gameboard[15] = gameboard[15] + gameboard[5];
				gameboard[5] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			if(gameboard[10] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[4] + " shells! It is now Player 1's turn.");
				
				gameboard[15] = gameboard[15] + gameboard[10];
				gameboard[10] = 0;
				gameboard[15] = gameboard[15] + gameboard[4];
				gameboard[4] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			if(gameboard[11] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[3] + " shells! It is now Player 1's turn.");
				
				gameboard[15] = gameboard[15] + gameboard[11];
				gameboard[11] = 0;
				gameboard[15] = gameboard[15] + gameboard[3];
				gameboard[3] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			if(gameboard[12] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[2] + " shells! It is now Player 1's turn.");
				
				gameboard[15] = gameboard[15] + gameboard[12];
				gameboard[12] = 0;
				gameboard[15] = gameboard[15] + gameboard[2];
				gameboard[2] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			
			if(gameboard[13] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[1] + " shells! It is now Player 1's turn.");
				
				gameboard[15] = gameboard[15] + gameboard[13];
				gameboard[13] = 0;
				gameboard[15] = gameboard[15] + gameboard[1];
				gameboard[1] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			if(gameboard[14] == 1 && hand == 0) {
				
				System.out.println("You have captured " + gameboard[0] + " shells! It is now Player 1's turn.");
				
				gameboard[15] = gameboard[15] + gameboard[14];
				gameboard[14] = 0;
				gameboard[15] = gameboard[15] + gameboard[0];
				gameboard[0] = 0;
				
				player1_turn = true;
				player2_turn = false;
				play();
				
			}
			
			// End turn if you land on an empty pocket on your Player 1's side
			if(gameboard[0] == 1 || gameboard[1] == 1 || gameboard[2] == 1 || gameboard[3] == 1 || gameboard[4] == 1 || gameboard[5] == 1
					|| gameboard[6] == 1 && hand == 1); {
				System.out.println("You have landed on an empty space on your opponent's side. It's now Player 1's turn.");
				player1_turn = true;
				player2_turn = false;
				play();
			}
			
					
		}
		
	}
	
	// Display final results
	private static void end() {
	
		
		System.out.println("Player 1 has " + gameboard[7] + " shells.");
		System.out.println("Player 2 has " + gameboard[15] + " shells.");
		
		// If player 1 has more shells, player 1 wins
		if(gameboard[7] > gameboard[15]) {
			board.displayBoard();
			System.out.println("Player 1 wins!");
		}
		
		// If player 2 has more shells, player 2 wins
		if(gameboard[7] < gameboard[15]) {
			board.displayBoard();
			System.out.println("Player 2 wins!");

		}
		
		// If player 1 and player 2 are tied (46 shells each)
		if(gameboard[7] == gameboard[15]) {
			board.displayBoard();
			System.out.println("Tie Game!");

		}
		
		player1_turn = false;
		player2_turn = false;
		System.out.println("Thanks for playing!");
	}

}
