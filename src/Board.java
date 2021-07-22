
public class Board {
	public static int gameboard[] = new int[16];  // Array to store everything; indexes 7 and 15 are Player 1's and Player 2's stores, respectively
											  // Indexes 0 through 6 are Player 1's pockets, indexes 8 through 14 are Player 2's pockets
	
	public Board() {
		
	}
	
	// Refill the Board to its default state (7 shells per pocket, excluding stores)
	protected static int[] fillBoard() {
		for(int i = 0; i <= 6; i++) {
			gameboard[i] = 7;
		}
		for(int j = 8; j <= 14; j++) {
			gameboard[j] = 7;
		}
		return null;
	}
	
	// Show what the board looks like so the players know what's going on
	protected static int[] displayBoard() {
		
		System.out.println("===================================================");
		System.out.println("		  Player 2's Side		");
		System.out.print("    ");
		
		//Upper row is player 2's side
		for(int p = 14; p > 7; p--) {
			
			System.out.print( gameboard[p] + "       ");
		}
		
		//Displays player 2's store on the left, then player 1's store on the right
		System.out.println("\n" + gameboard[15]
				+ "\t" + "\t" + "\t" + "\t" +" \t" + "\t" +  "         " +  gameboard[7]);
		
		
		System.out.print("    ");
		
		
		//Lower row is player 1's side
		for(int p = 0; p < 7; p++) {
			
			System.out.print(gameboard[p] + "       ");
		}
		System.out.println("\n");
		System.out.println("	   	  Player 1's Side		");
		System.out.println("===================================================");
		
		return null;
		
	}	
}
