//-----------------------------------------------------------
// Assignment # 4 - BattleShip
// Written By: Connor Lamont, Student ID 40169486
// For COMP 248 Section EC Fall 2020
//-----------------------------------------------------------

/*
 * This class contains the attributes and methods used with the computer object
 */

// Class of computer for storing computer information
public class computer {
	// Attribute to store computer ship count
	// Default value of 0 until computer places ships
	private int ships = 0;
	// Attribute to store computer grenade count
	// Default value of 0 until computer places grenades
	private int grenades = 0;
	// Attribute to store computer turn count
	// Default value of 0 since player goes first
	private int turns = 0;
	// Attribute to store computer turn status
	// Default value of false since player goes first
	private boolean isTurn = false;
	
    //////////////////// MUTATOR METHODS ////////////////////
	// Increment computer ship count by 1
	public void plusShips() {
		this.ships++;
	}
	// Decrement computer ship count by 1
	public void minusShips() {
		this.ships--;
	}
	// Decrement computer turn count by 1
	public void endTurn() {
		this.turns-- ;
	}
	// Set computer turn count using integer argument
	public void setTurn(int i) {
		this.turns = i;
	}
	// Set computer turn count to 0 if they hit a grenade
	public void hitGrenade() {
		this.turns = 0;
	}
	// Set computer turn status to true or false
	public void setisTurn(boolean bool) {
		this.isTurn = bool;
	}
	// Increment computer grenade count by 1
	public void plusGrenades() {
		this.grenades++;
	}
	
    //////////////////// ACCESSOR METHODS ////////////////////
	// Return computer ship count
	public int getShips() {
		return this.ships;
	}
	// Return computer grenade count
	public int getGrenades() {
		return this.grenades;
	}
	// Return computer turn count
	public int getTurns() {
		return this.turns;
	}
	// Return computer turn status
	public boolean getisTurn() {
		return this.isTurn;
	}
	
    //////////////////// SUPPLEMENTARY METHODS ////////////////////
	// Method to generate computer guess
	public int guessInt() {
		// Return a random integer between 0 and board length
		return (int)(Math.random() * gameGrid.BOARD_LENGTH);
	}
	
	// Method to convert integers to characters
	// Used when displaying computer rocket positions to player
	public char intToChar(int i) {
		// Temporary character variable to store the character that corresponds to the computers integer guess
		char temp = ' ';
		// Store the character corresponding to the integer argument in temp variable
		switch(i) {
		case 0:
			temp = 'A';
			break;
		case 1:
			temp = 'B';
			break;
		case 2:
			temp = 'C';
			break;
		case 3:
			temp = 'D';
			break;
		case 4:
			temp = 'E';
			break;
		case 5:
			temp = 'F';
			break;
		case 6:
			temp = 'G';
			break;
		case 7:
			temp = 'H';
			break;
		default:
			break;
		}
		// Return the corresponding character
		return temp;
	}
}