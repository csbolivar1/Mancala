/*Mancala Glossary:
	Stores - location of each players' total count
	Shells - the 'gamepieces', represented by numbers in each index
	Pockets - location where 'shells' are stored for players to obtain and add to their store
*/

import java.util.Random;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MancalaMain extends Board {

	private static Board board;
	
	public void start(Stage primaryStage) {
		try {
			// BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
		/*
		 * int num = 0; Random coin_flip = new Random();
		 * 
		 * board.fillBoard(); board.configurePlayerSides();
		 * 
		 * System.out.println("Lets Play Mancala!!!");
		 * 
		 * // Flip a coin to see who will go first. num = coin_flip.nextInt(2);
		 * 
		 * if (num == 0) { PlayMancala.player1_turn = true; PlayMancala.player2_turn =
		 * false; System.out.println("Player 1 will go first."); PlayMancala.play(); }
		 * 
		 * if (num == 1) { PlayMancala.player2_turn = true; PlayMancala.player1_turn =
		 * false; System.out.println("Player 2 will go first."); PlayMancala.play();
		 * 
		 * }
		 */

	}

}
