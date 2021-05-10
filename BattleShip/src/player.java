//-----------------------------------------------------------
// Assignment # 4 - BattleShip
// Written By: Connor Lamont, Student ID 40169486
// For COMP 248 Section EC Fall 2020
//-----------------------------------------------------------

/*
 * This class contains the attributes and methods used with the player object
 */

// Class of player for storing player information
public class player {
	// Attribute to track player ship count
	// Default value of 0 until player places ships
	private int ships = 0;
	// Attribute to track player grenade count
	// Default value of 0 until player places grenades
	private int grenades = 0;
	// Attribute to track how many turns player has left
	// Default value of 1 since player goes first
	private int turns = 1;
	// Attribute to track whether or not it is the players turn
	// Default value of true since player goes first
	private boolean isTurn = true; 
	
    //////////////////// MUTATOR METHODS ////////////////////
	// Increment player ship count by 1
	public void plusShips() {
		this.ships++;
	}
	// Decrement player ship count by 1
	public void minusShips() {
		this.ships--;
	}
	// Decrement player turn count by 1
	public void endTurn() {
		this.turns-- ;
	}
	// Set player turn count using integer argument
	public void setTurn(int i) {
		this.turns = i;
	}
	// Set player turn count to 0 if they hit grenade
	public void hitGrenade() {
		this.turns = 0;
	}
	// Set value of player turn status to true or false
	public void setisTurn(boolean bool) {
		this.isTurn = bool;
	}
	// Increment player grenade count by 1
	public void plusGrenades() {
		this.grenades++;
	}
	
	
    //////////////////// ACCESSOR METHODS ////////////////////
	// Return player ship count
	public int getShips() {
		return this.ships;
	}
	// Return player grenade count
	public int getGrenades() {
		return this.grenades;
	}
	// Return player turn count
	public int getTurns() {
		return this.turns;
	}
	// Return player turn status
	public boolean getisTurn() {
		return this.isTurn;
	}
}