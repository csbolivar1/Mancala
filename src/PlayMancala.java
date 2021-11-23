import java.util.Scanner;

public class PlayMancala extends Board {

	public static boolean player1_turn = false; 
	public static boolean player2_turn = false; 
	private static int hand = 0; // Keeps track of how many shells are currently at hand; used for both Players' turns
	private static int index; // Keeps track of the index
	private static Board board;
	private static Scanner player_input;

	public static void play() {

		// Ask Player which pocket to pick.
		player_input = new Scanner(System.in);
		board.displayBoard();

		// If all selectable pockets are empty, game is over.
		if ((gameboard[0] == 0 && gameboard[1] == 0 && gameboard[2] == 0 && 
				gameboard[3] == 0 && gameboard[4] == 0 && gameboard[5] == 0 && gameboard[6] == 0)
				&& (gameboard[8] == 0 && gameboard[9] == 0 && gameboard[10] == 0 && 
						gameboard[11] == 0 && gameboard[12] == 0 && gameboard[13] == 0 && gameboard[14] == 0)) {
			System.out.println("All pockets are empty");
			end();
		}

		pickUpShells();
	}

	private static void pickUpShells() {
		
		// Choose a pocket
		if (player1_turn == true && player2_turn == false) {
			
			// Skip turn if all selectable pockets on current player's side are empty.
			if (gameboard[0] == 0 && gameboard[1] == 0 && gameboard[2] == 0 && 
					gameboard[3] == 0 && gameboard[4] == 0 && gameboard[5] == 0 && gameboard[6] == 0) {
				System.out.println("There are no more shells on Player 1's side. It's Player 2's turn");
				player1_turn = false;
				player2_turn = true;
				play();
			}
			System.out.println("Player 1, choose a pocket (1) through (7)");
			index = player_input.nextInt() - 1;
		}

		if (player2_turn == true && player1_turn == false) {
			
			// Skip turn if all selectable pockets on current player's side are empty.
			if (gameboard[8] == 0 && gameboard[9] == 0 && gameboard[10] == 0 && 
					gameboard[11] == 0 && gameboard[12] == 0 && gameboard[13] == 0 && gameboard[14] == 0) {
				System.out.println("There are no more shells on Player 2's side. It's Player 2's turn");
				player2_turn = false;
				player1_turn = true;
				play();
			}
			System.out.println("Player 2, choose a pocket (1) through (7)");
			index = player_input.nextInt() + 7;
		}
		
		// Cannot select pocket with 0 shells in it
		if (gameboard[index] == 0) {
			System.out.println("That pocket doesn't have any shells in it");
			pickUpShells();
		}

		// Continue distrubting shells if the player's last shell lands in a pocket that has shells in it. 
		distributeShells();

		// Current player has another turn if the last shell lands in their own store.
		if (player1_turn == true && index == 7) {
			System.out.println("Player 1 landed in own store, go again!");
			play();
		}

		if (player2_turn == true && index == 15) {
			System.out.println("Player 2 landed in own store, go again!");
			play();
		}

		System.out.println("No more shells in index " + index);
		captureShells();

	}

	private static void distributeShells() {

		// Transfer shells from selected index to hand
		hand = gameboard[index];
		gameboard[index] = 0;

		// Continue distributing shells while the player has shells in their hand.
		while (hand > 0) {
			index++;

			// Loop back to beginning of array.
			if (index == 16) {
				index = 0;
			}

			// Skip certain pockets depending on player turn.
			switch (index) {

			case 15:
				if (player2_turn == true) {
					gameboard[index] = gameboard[index] + 1;
					hand--;
				}

				break;

			case 7:
				if (player1_turn == true) {
					gameboard[index] = gameboard[index] + 1;
					hand--;
				}

				break;

			default:
				
				// Initiate capture sequence if last shell lands in an empty pocket
				if (gameboard[index] == 0 && hand == 1) {
					gameboard[index] = gameboard[index] + 1;
					hand--;
					captureShells();
				}
				
				// Default option, drop one shell in a pocket, move to next pocket
				gameboard[index] = gameboard[index] + 1;
				hand--;
				break;
			}
			
		}
		
		// Continue picking up and distruting shells
		if (gameboard[index] > 0 && index != 7 && index != 15) {
			distributeShells();
		}
	}

	private static void captureShells() {

		// Loop through player 1's hashmap keys, find corresponding player 2 pocket, capture shells, end turn
		if (player1_turn == true) {
			for (Integer i : player1side.keySet()) {
				if (i == index) {
					gameboard[7] = gameboard[7] + gameboard[index] + gameboard[player1side.get(i)];
					System.out.println("Player 1 captured " + (gameboard[index] + gameboard[player1side.get(i)]) + " shells.");
					gameboard[index] = 0;
					gameboard[player1side.get(i)] = 0;

					// Switch to Player 2 after capturing
					player1_turn = false;
					player2_turn = true;

					play();
				}
			}

			// Execute if last shell lands on opposite side.
			System.out.println("Landed in Player 2's side; it's player 2's turn.");
			player1_turn = false;
			player2_turn = true;
			play();
		}

		// Loop through player 2's hashmap keys, find corresponding player 1 pocket, capture shells, end turn
		if (player2_turn == true) {
			for (Integer i : player2side.keySet()) {
				if (i == index) {
					gameboard[15] = gameboard[15] + gameboard[index] + gameboard[player2side.get(i)];
					System.out.println("Player 2 captured " + (gameboard[index] + gameboard[player2side.get(i)]) + " shells.");
					gameboard[index] = 0;
					gameboard[player2side.get(i)] = 0;

					// Switch to Player 1 after capturing
					player2_turn = false;
					player1_turn = true;

					play();
				}
			}

			// Execute if last shell lands on opposite side.
			System.out.println("Landed in Player 1's side; it's player 1's turn.");
			player2_turn = false;
			player1_turn = true;
			play();

		}

		play();
	}

	// Display final results
	private static void end() {

		System.out.println("Player 1 total: " + gameboard[7]);
		System.out.println("Player 2 total: " + gameboard[15]);

		// If player 1 has more shells, player 1 wins
		if (gameboard[7] > gameboard[15]) {
			board.displayBoard();
			System.out.println("Player 1 wins!");
		}

		// If player 2 has more shells, player 2 wins
		if (gameboard[7] < gameboard[15]) {
			board.displayBoard();
			System.out.println("Player 2 wins!");
		}

		// If player 1 and player 2 are tied (49 each)
		if (gameboard[7] == gameboard[15]) {
			board.displayBoard();
			System.out.println("Tie Game!");

		}

		player1_turn = false;
		player2_turn = false;
		System.out.println("Thanks for playing!");
		System.exit(0);
	}

}
