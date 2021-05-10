//-----------------------------------------------------------
// Assignment # 4 - BattleShip
// Written By: Connor Lamont, Student ID 40169486
// For COMP 248 Section EC Fall 2020
//-----------------------------------------------------------

/*
 * This program simulates a game of battleship against a computer opponent.
 * 
 * An 8x8 game board of gameSquare objects is declared and initialized.
 * 
 * The player is then asked to place all of their ships and grenades across the board by entering a character
 * between 'A'/'a' and 'H'/'h followed by an integer between 1-8.
 * 
 * If the player enters a position outside the game board, or a position they have already placed a ship/grenade at,
 * they will receive an error message and be asked to enter a different position.
 * 
 * After the player has placed all of their ships and grenades, the computer will place all of its ships/grenades
 * at randomly generated positions on the game board.
 * 
 * After the board has been set, the player and computer take turns firing rockets at positions on the board,
 * with the updated game board displayed after each rocket is fired. 
 * 
 * If a rocket hits nothing or hits a ship, the results and updated game board are displayed to the user.
 * 
 * If a rocket hits a grenade, the one who fired that rocket loses their remaining turns and their opponent can
 * fire two rockets in a row. The results and updated game board are also displayed to the user.
 * 
 * The player and computer cannot fire rockets at positions that have already been called. They also cannot
 * fire rockets at their own positions. If a player attempts to do either, they will be prompted to choose another
 * position to fire at.
 * 
 * This will continue until all of the players ships or all of the computers ships have been hit. A message 
 * explaining the winner/loser will then display alongside the final updated game board.
 * 
 */

public class BattleShipDemo {
	public static void main(String[] args) {
		// Declare and initialize a new gameGrid object
		gameGrid game = new gameGrid();
		
		// Setup the game board using the setupGame method
		game.setupGame();
		
		// Play the game using the playGame method
		game.playGame();
	}
}