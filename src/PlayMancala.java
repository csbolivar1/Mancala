import java.util.Scanner;

public class PlayMancala extends Board {

	public static boolean player1_turn = false; // Determines who's turn it currently is;
	public static boolean player2_turn = false; // both start out false.
	private static int hand = 0; // Keeps track of how many shells are currently at hand; used for both Players' turns
	private static int index; // Keeps track of the index during Player 1's turn
	private static Board board;
	private static Scanner player_input;

	public static void play() {

		// Ask Player which non-zero index to pick.
		player_input = new Scanner(System.in);
		board.displayBoard();

		// Check if either players' sides are completely empty
		// if one of them is, game is over.
		if ((gameboard[0] == 0 && gameboard[1] == 0 && gameboard[2] == 0 && // Player 1 side
				gameboard[3] == 0 && gameboard[4] == 0 && gameboard[5] == 0 && gameboard[6] == 0)
				|| (gameboard[8] == 0 && gameboard[9] == 0 && gameboard[10] == 0 && // Player 2 side
						gameboard[11] == 0 && gameboard[12] == 0 && gameboard[13] == 0 && gameboard[14] == 0)) {
			System.out.println("There are no more shells on Player 1's side!");

			// Add any remaining shells on Player 1's side to their collection
			gameboard[15] = gameboard[15] + gameboard[8] + gameboard[9] + gameboard[10] + gameboard[11] + gameboard[12]
					+ gameboard[13] + gameboard[14];

			// Add any remaining shells on Player 2's side to their collection
			gameboard[7] = gameboard[7] + gameboard[0] + gameboard[1] + gameboard[2] + gameboard[3] + gameboard[4]
					+ gameboard[5] + gameboard[6];

			// TODO: Is there a need to empty out other pockets at the end of the game?
			/*
			 * gameboard[8] = 0; gameboard[9] = 0; gameboard[10] = 0; gameboard[11] = 0;
			 * gameboard[12] = 0; gameboard[13] = 0; gameboard[14] = 0; gameboard[0] = 0;
			 * gameboard[1] = 0; gameboard[2] = 0; gameboard[3] = 0; gameboard[4] = 0;
			 * gameboard[5] = 0; gameboard[6] = 0;
			 */

			end();
		}

		pickUpShells();
	}

	// PART 1: DISTRIBUTING SHELLS
	private static void pickUpShells() {

		// Choose a pocket
		if (player1_turn == true && player2_turn == false) {
			System.out.println("Player 1, choose one of your pockets (1 through 7)");
			index = player_input.nextInt() - 1;
		}

		if (player2_turn == true && player1_turn == false) {
			System.out.println("Player 2, choose one of your pockets (1 through 7)");
			index = player_input.nextInt() + 7;
		}

		System.out.println("I have selected: " + index);

		if (gameboard[index] == 0) {
			System.out.println("That pocket doesn't have any shells in it");
			pickUpShells();
		}

		// Continue distrubting shells if the player's last shell lands in a pocket that has shells in it. 
		distributeShells();

		if (player1_turn == true && index == 7) {
			System.out.println("Player 1 landed in own store, go again!");
			play();
		}

		if (player2_turn == true && index == 15) {
			System.out.println("Player 2 landed in own store, go again!");
			play();
		}

		System.out.println("No more shells in index " + index);
		System.out.println("Time to capture shells");
		captureShells();

	}

	private static void distributeShells() {

		System.out.println("You picked up " + gameboard[index] + " shells from pocket " + index);

		// Transfer shells from selected index to hand
		hand = gameboard[index];
		gameboard[index] = 0;

		// Continue distributing shells while the player has shells in their hand.
		while (hand > 0) {
			index++;

			// Loop back to beginning of array once end is reached.
			if (index == 16) {
				index = 0;
				System.out.println("You looped back to the beginning");
			}

			// Skip certain pockets depending on player turn.
			switch (index) {

			case 15:
				if (player2_turn == true) {

					gameboard[index] = gameboard[index] + 1;
					System.out.println("You dropped 1 shell in index " + index);
					hand--;

				}

				break;

			case 7:
				if (player1_turn == true) {

					gameboard[index] = gameboard[index] + 1;
					System.out.println("You dropped a shell in index " + index);
					hand--;
				}

				break;

			default:
				if (gameboard[index] == 0 && hand == 1) {
					gameboard[index] = gameboard[index] + 1;
					System.out.println("You dropped 1 shell in index " + index);
					hand--;
					System.out.println("Time to capture shells");
					captureShells();
				}
				gameboard[index] = gameboard[index] + 1;
				System.out.println("You dropped 1 shell in index " + index);
				hand--;

				break;
			}

			board.displayBoard();
			System.out.println("You have " + hand + " shells left in your hand");

		}
		if (gameboard[index] > 0 && index != 7 && index != 15) {
			System.out.println("There are still shells to be picked up.");
			distributeShells();
		}
	}

	private static void captureShells() {

		// Loop through player 1's hashmap keys, find corresponding player 2 pocket,
		// capture shells, end turn
		if (player1_turn == true) {
			for (Integer i : player1side.keySet()) {
				if (i == index) {
					gameboard[7] = gameboard[7] + gameboard[index] + gameboard[player1side.get(i)];
					System.out.println("Player 1 captured " + (gameboard[index] + gameboard[player1side.get(i)]) + " shells.");
					gameboard[index] = 0;
					gameboard[player1side.get(i)] = 0;
					displayBoard();

					// Switch to Player 2 after capturing
					player1_turn = false;
					player2_turn = true;

					break;
				}
			}

			// Execute if last shell lands on opposite side.
			System.out.println("Landed in Player 2's side; it's player 2's turn.");
			player1_turn = false;
			player2_turn = true;
			play();
		}

		// Loop through player 2's hashmap keys, find corresponding player 1 pocket,
		// capture shells, end turn
		if (player2_turn == true) {
			for (Integer i : player2side.keySet()) {
				if (i == index) {
					gameboard[15] = gameboard[15] + gameboard[index] + gameboard[player2side.get(i)];
					System.out.println("Player 2 captured " + (gameboard[index] + gameboard[player2side.get(i)]) + " shells.");
					gameboard[index] = 0;
					gameboard[player2side.get(i)] = 0;
					displayBoard();

					// Switch to Player 1 after capturing
					player2_turn = false;
					player1_turn = true;

					break;
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

		System.out.println("Player 1 has " + gameboard[7] + " shells.");
		System.out.println("Player 2 has " + gameboard[15] + " shells.");

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

		// If player 1 and player 2 are tied (49 shells each)
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
