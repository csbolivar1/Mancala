# Mancala

![Mancala Board](https://github.com/csbolivar1/Mancala/blob/master/Images/MancalaBoard.jpg)

Mancala is a turn based count and capture board game. More information can be found [here](https://en.wikipedia.org/wiki/Mancala "Mancala Wiki").

Open the game by running PlayMancala.bat, located in the PlayMancala folder

## Objective
The object of the game is to gather more "seeds" in your "store" than your opponent. Each player's store is the large hole to their right side. 
Seeds are gathered by capturing or "sowing" them.

## How to play 
```
===============================================Player 2 side================================================
                                  (7)   (6)   (5)   (4)   (3)   (2)   (1)                              
                                   7     7     7     7     7     7     7
             (Player 2 Store)  0                                           0  (Player 1 Store)
                                   7     7     7     7     7     7     7
                                  (1)   (2)   (3)   (4)   (5)   (6)   (7)
===============================================Player 1 side================================================
```
1. Game will select randomly if Player 1 or Player 2 goes first.

2. Once the game begins, the player will be asked to select a hole on their side via number input, indicated by the number in parenthesis.

3. The game will begin distributing the seeds into each hole counter-clockwise (except for the opponent's store) until one of the below conditions are met:

    * If the last seed is dropped into a hole with at least one seed, the player picks up all the seeds from that last hole, and begins distributing again.
	* If the last seed is dropped into the player's own store, the player plays again, and selects a hole
		occupied with seeds to distribute again.
	* If the last seed is placed in an empty hole on the player's side, the player takes all seeds in the opposite 
		hole, and the one seed on the player's side, and places them in their store. The player's turn ends.
	* If the last seed is placed in an empty hole on the opponent's side, the player's turn ends.
	
4. The game will continue to loop until all the holes are empty. The player with more seeds wins.
