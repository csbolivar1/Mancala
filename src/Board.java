import java.util.HashMap;

/*Mancala Glossary:
	Stores - location of each players' total count
	Shells - the 'gamepieces', represented by numbers in each index
	Pockets - location where 'shells' are stored for players to obtain and add to their store
*/

public class Board {
	public static HashMap<Integer, Integer> player1side = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> player2side = new HashMap<Integer, Integer>();
	public static int gameboard[] = new int[16]; // Gameboard holds all gamepieces
													// Indexes 7 and 15 are Player 1's and Player 2's stores, respectively
													// Indexes 0 through 6 are Player 1's pockets, indexes 8 through 14 are Player 2's pockets

	public Board() {}

	// Hashmaps to pair opposite pockets for capturing shells
	protected static void configurePlayerSides() {
		player1side.put(0, 14);
		player1side.put(1, 13);
		player1side.put(2, 12);
		player1side.put(3, 11);
		player1side.put(4, 10);
		player1side.put(5, 9);
		player1side.put(6, 8);

		player2side.put(14, 0);
		player2side.put(13, 1);
		player2side.put(12, 2);
		player2side.put(11, 3);
		player2side.put(10, 4);
		player2side.put(9, 5);
		player2side.put(8, 6);
	}

	// Reset the gameboard to its default state (7 shells per pocket, 0 in stores)
	protected static void fillBoard() {
		for (int i = 0; i <= 6; i++) {
			gameboard[i] = 7;
		}
		for (int j = 8; j <= 14; j++) {
			gameboard[j] = 7;
		}
	}

	// Show the gameboard
	protected static void displayBoard() {

		System.out.println();
		System.out.println("=============================================================");
		System.out.println("		     Player 2's Side		");
		System.out.println();
		System.out.print("    ");
		
		// Upper row is player 2's side
		for (int p = 14; p > 7; p--) {

			System.out.print(gameboard[p] + "       ");
		}

		// Displays player 2's store on the left, then player 1's store on the right
		System.out.println("\n" + gameboard[15] + "\t" + "\t" + "\t" + "\t" + " \t" + "\t" + "         " + gameboard[7]);
		System.out.print("    ");

		// Lower row is player 1's side
		for (int p = 0; p < 7; p++) {
			System.out.print(gameboard[p] + "       ");
		}

		System.out.println("\n");
		System.out.println("	   	     Player 1's Side		");
		System.out.println("=============================================================");

	}
}
