# Mancala

![Mancala Board](https://github.com/csbolivar1/Mancala/blob/master/Images/MancalaBoard.jpg)

Mancala is a turn based count and capture board game. More information can be found [here](https://en.wikipedia.org/wiki/Mancala "Mancala Wiki").

To run, download as .zip file, extract and run the below command while in the bin directory

```
java MancalaMain
```
## Objective
The object of the game is to gather more shells than your opponent. Each player's total is the large pocket to their right side. Shells are gathered by capturing them.

## How to play 
```
===============================================Player 2 side================================================
                                  (7)   (6)   (5)   (4)   (3)   (2)   (1)                              
                                   7     7     7     7     7     7     7
             (Player 2 Total)  0                                            0  (Player 1 Total)
                                   7     7     7     7     7     7     7
                                  (1)   (2)   (3)   (4)   (5)   (6)   (7)
===============================================Player 1 side================================================
```
1. Either Player 1 or 2 will go first at random.

2. The player will be asked to select a pocket on their side via number input (1 through 7), indicated by the number in parenthesis.

3. Once a pocket number is selected, the pocket will be emptied and the shells picked up and distributed. One shell is distributed into each pocket counter-clockwise, including the player's own total but not the opponent's, until there are no more shells left to distribute.

4. The next action that occurs depends on where the land shell lands: 

    * If the last shell is dropped into a pocket with at least one shell, the player picks up all the shells from that pocket, and begins distributing again.
	* If the last shell is dropped into the player's own total, the player gets another turn.
	* If the last shell is dropped in an empty pocket on their own side, the player captures all the shells in the opposite pocket, as well as the one shell on their sides, and adds them to their total. The player's turn ends.
	* If the last shell is dropped in an empty hole on the opponent's side, the player's turn ends.
	
4. The game ends when all pockets are empty. The player with more shells wins.
