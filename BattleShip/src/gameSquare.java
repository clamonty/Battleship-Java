//-----------------------------------------------------------
// Assignment # 4 - BattleShip
// Written By: Connor Lamont, Student ID 40169486
// For COMP 248 Section EC Fall 2020
//-----------------------------------------------------------

/*
 * This class contains the attributes and methods used with each gameSquare object that make up the game board
 */

// Class of gameSquare to fill the gameGrid array
public class gameSquare {
	// Attribute to track if element is a ship, grenade, or empty
	// Default value of '*' for empty
	private char type = '*';
	// Attribute to set the display value of a gameSquare object when called with the displayBoard method
	// Default value of '_' for uncalled
	private char display = '_';
	// Attribute to track if square is neutral (0), players (1), or computers (2)
	// Default value of 0 for neutral
	private int owner = 0;
	// Attribute to track if the gameSquare has been called/shot yet
	// Default value of false as no square has been shot at the start of game
	private boolean called = false;
	
    //////////////////// ACCESSOR METHODS ////////////////////
	// Get the type attribute value of gameSquare
	public char getType() {
		return this.type;
	}
	// Get the owner attribute value of gameSquare
	public int getOwner() {
		return this.owner;
	}
	// Get the display attribute value of gameSquare
	public char getDisplay() {
		return this.display;
	}
	// Get the called attribute value of gameSquare
	public boolean getCalled() {
		return this.called;
	}
	
    //////////////////// MUTATOR METHODS ////////////////////
	// Set the type attribute value of gameSquare using character argument
	public void setType(char ch) {
		this.type = ch;
	}
	// Set the owner attribute value of gameSquare using integer argument
	public void setOwner(int i) {
		this.owner = i;
	}
	// Set the called attribute value of gameSquare to true or false
	public void setCalled(boolean shot) {
		this.called = shot;
	}
	// Set the display attribute value of gameSquare using character argument
	public void setDisplay(char ch) {
		this.display = ch;
	}
}