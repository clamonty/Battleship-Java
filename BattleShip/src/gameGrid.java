//-----------------------------------------------------------
// Assignment # 4 - BattleShip
// Written By: Connor Lamont, Student ID 40169486
// For COMP 248 Section EC Fall 2020
//-----------------------------------------------------------

/*
 * This class contains the methods and attributes used to setup and play the battleship game.
 */

// Import scanner to read in user input
import java.util.Scanner;
public class gameGrid {
	// Constant to determine board dimensions
	// Static and public to be accessed by computer.guessInt() method
	public static final int BOARD_LENGTH = 8;
	// Create a multidimensional array of gameSquare objects as our game board
	private gameSquare[][] gameBoard = new gameSquare[BOARD_LENGTH][BOARD_LENGTH];
	// Declare and initialize computer and player objects
	private computer computer = new computer();
	private player player = new player();
	// Declare and initialize a scanner to read user input
	private Scanner scan = new Scanner(System.in);
	
	//////////////////// GAME SETUP METHODS ////////////////////

	// Initialize the game board with default game square objects
	private void initBoard() {
		// Initialize a gameSquare object at every element of the game board
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = new gameSquare();
			}
		}
	}
	// Public method to place a players ships on the board
	private void placePlayerShips() {
		// Continue until player ship count is 6
		while (player.getShips() < 6) {
			// Ask for the coordinates player wants to place their ship
			System.out.print("Enter the coordinates of your ship #" + (player.getShips() + 1) + ": ");
			// Store the players input as a string
			String input = scan.next();
			// If the player does not enter a two character input, display an error message and ask for
			// new input
			if (input.length() != 2) {
				System.out.println("Unrecognized input length. Try again.");
				continue;
			}
			// Parse the players input string into its component character and integer
			char inputChar = input.charAt(0);
			int inputDigit = Integer.parseInt(input.substring(1)) - 1;
			// Convert the players character input to an integer 
			int charDigit = charToInt(inputChar); 
			// Check if the players input character or integer is outside the allowed range
			// Display an error and start next loop iteration if input is invalid
			if (!checkChar(inputChar) || (inputDigit < 0 || inputDigit >= BOARD_LENGTH)) {
				System.out.println("Sorry, the coordinates you entered are outside the grid. Try again.");
				continue;
			}
			// If player's chosen square is not owned, change the following:
			// Convert the gameSquare type attribute to 's' for player ship
			// Change ownership attribute from neutral to player
			// Increment player ship count by 1
			if (gameBoard[inputDigit][charDigit].getOwner() == 0) {
				gameBoard[inputDigit][charDigit].setType('s');
				gameBoard[inputDigit][charDigit].setOwner(1);
				player.plusShips();
			}
			// If player's guessed square is owned by player or computer 
			// display error message and continue to next loop iteration
			else {
				System.out.println("Sorry, those coordinates are already in use. Try again.");
				continue;
			}
		}
	}
	// Public method to place the players grenades
	private void placePlayerGrenades() {
		// Continue loop until player grenade count is 4
		while (player.getGrenades() < 4) {
			// Ask for the coordinates player wants to place their grenade
			System.out.print("Enter the coordinates of your grenade #" + (player.getGrenades() + 1) + ": ");
			// Store the players input as a string
			String input = scan.next();
			// If the player does not enter a two character input, display an error message and ask for
			// new input
			if (input.length() != 2) {
				System.out.println("Unrecognized input length. Try again.");
				continue;
			}
			// Parse the players input string into its component character and integer
			char inputChar = input.charAt(0);
			int inputDigit = Integer.parseInt(input.substring(1)) - 1;
			// Convert the players character input to an integer 
			int charDigit = charToInt(inputChar);
			// If the user's input is outside the input range, display error message and continue to next loop iteration
			if (!checkChar(inputChar) || (inputDigit < 0 || inputDigit >= BOARD_LENGTH)) {
				System.out.println("Sorry, the coordinates you entered are outside the grid. Try again.");
				continue;
			}
			// If player's chosen square is not owned, change the following:
			// Set the object attribute type to 'g' for player grenade
			// Change ownership attribute from neutral to player
			// Increment player grenade count by 1
			if (gameBoard[inputDigit][charDigit].getOwner() == 0) {
				gameBoard[inputDigit][charDigit].setType('g');
				gameBoard[inputDigit][charDigit].setOwner(1);
				player.plusGrenades();
			}
			// If player's guessed square is owned, display error message and continue to next loop iteration
			else {
				System.out.println("Sorry, those coordinates are already in use. Try again.");
			}
		}
	}
	// Private method to place the computers ships
	private void placeComputerShips() {
		// Perform loop until computer ship count is 6
		while (computer.getShips() < 6) {
			// Generate two random integers guesses for computer
			int i = computer.guessInt();
			int j = computer.guessInt();
			// If nobody owns guessed square, change the following:
			// Change type attribute to 'S' for computer ship
			// Change owner attribute to computer
			// Increment computer ship count by 1
			if (gameBoard[i][j].getOwner() == 0) {
				gameBoard[i][j].setType('S');
				gameBoard[i][j].setOwner(2);
				computer.plusShips();
			}
			// If square guessed is owned by player or computer, continue to next loop iteration
			else
				continue;
		}
	}
	// Private method to place the computers grenades
	private void placeComputerGrenades() {
		// Perform loop until computer grenade count is 4
		while (computer.getGrenades() < 4) {
			// Generate two random integer guesses for computer
			int i = computer.guessInt();
			int j = computer.guessInt();
			// If nobody owns guessed square, change the following:
			// Change type attribute to 'G' for computer grenade
			// Change owner attribute to computer
			// Increment computer grenade count by 1
			if (gameBoard[i][j].getOwner() == 0) {
				gameBoard[i][j].setType('G');
				gameBoard[i][j].setOwner(2);
				computer.plusGrenades();
			}
			// If square guessed is owned by player or computer, continue to next loop iteration
			else
				continue;
		}
	}
	// Public method to initialize and fill the game board. 
	public void setupGame() {
		// Display welcome message to player
		System.out.println("Hi! Let's play Battleship!");
		// Initialize the game board array
		initBoard();
		// Place all user and computer ships/grenades
		placePlayerShips();
		placePlayerGrenades();
		placeComputerShips();
		placeComputerGrenades();
		// Inform the user the board has been set and is ready to play
		System.out.println("Okay, the computer placed it's ships and grenades at random. Let's play!");
		// Display the empty game board for the player
		displayBoard();
	}
	
	//////////////////// GAME PLAY METHODS ////////////////////
	
	// Private method to display the game board
	private void displayBoard() {
		// Iterate over each object in the array
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				// If the object is the last of it's row, print the object followed by a new line
				if (j == gameBoard[i].length - 1)
					System.out.println(gameBoard[i][j].getDisplay());
				// If the object is not the last of it's row, print the object followed by a space
				else
					System.out.print(gameBoard[i][j].getDisplay() + " ");	
			}
		}
	}
	// Private method for the computer's turn
	private void computerTurn() {
		// Perform at least one iteration of the loop
		do {
			// Generate two random integers for computers guess
			int i = computer.guessInt();
			int j = computer.guessInt();
			// If guess square has already been called or belongs to the computer, guess again
			if (gameBoard[i][j].getCalled() || gameBoard[i][j].getOwner() == 2) 
				continue;			
			// Display computer's rocket position by converting it's first guess to the
			// corresponding character
			System.out.println("Position of my rocket: " + computer.intToChar(j) + (i + 1)); 			
			// If the computer hits an empty square
			if (gameBoard[i][j].getOwner() == 0) {
				// Inform the player that the computer hit nothing
				System.out.println("Nothing.");
				// Set status of that game square to called
				gameBoard[i][j].setCalled(true);
				// Change display of that game square from '_' to it's actual type
				gameBoard[i][j].setDisplay(gameBoard[i][j].getType());
				// Decrement computer turns by 1
				computer.endTurn();
				// If the computer has no turns remaining, change the truth values of
				// the player and computers turns
				// Increment the players turns by 1
				if (computer.getTurns() == 0) {
					computer.setisTurn(false);
					player.setisTurn(true);
					player.setTurn(1);
				}
			}
			// If the computer hits a player ship
			else if (gameBoard[i][j].getType() == 's') {
				// Inform the player the computer has hit their ship
				System.out.println("Ship hit.");
				// Set status of that game square to called
				gameBoard[i][j].setCalled(true);
				// Change display of that game square from '_' to it's actual type
				gameBoard[i][j].setDisplay(gameBoard[i][j].getType());
				// Decrement player ship count by 1
				player.minusShips();
				// Decrement computer turns by 1
				computer.endTurn();
				// If the computer has no turns remaining, change the truth values of
				// the player and computer turn status
				// Increment the players turns by 1
				if (computer.getTurns() == 0) {
					computer.setisTurn(false);
					player.setisTurn(true);
					player.setTurn(1);
				}
			}
			// If the computer hits a player grenade
			else if (gameBoard[i][j].getType() == 'g'){
				// Inform the player that the computer has hit a grenade
				System.out.println("Boom! Grenade hit.");
				// Set status of that game square to called
				gameBoard[i][j].setCalled(true);
				// Change display of that game square to it's actual type
				gameBoard[i][j].setDisplay(gameBoard[i][j].getType());
				// Set computer turns to 0 with hitGrenade method
				// Set player turns to 2
				// Change truth value of player and computer turn status
				computer.hitGrenade();
				player.setTurn(2);
				computer.setisTurn(false);
				player.setisTurn(true);
			}

			// If the player has no more ships, perform the following:
			// Display losing message
			// Display final game board
			// Close the scanner and exit the loop
			if (player.getShips() == 0) {
				System.out.println("You lose! Better luck next time");
				displayBoard();
				break;
			}
			// If player still has ships, just display the board
			else
				displayBoard();
		}
		// Perform loop as long as computer has a turn
		while (computer.getisTurn());
	}
	
	// Private method to perform a players turn
	private void playerTurn() {
		do {
			System.out.print("Position of your rocket: ");
			// Store the user's input as a string
			String input = scan.next();
			if (input.length() != 2) {
				System.out.println("Unrecognized input length. Try again.");
				continue;
			}
			// Parse the players input string into its component character and integer
			char inputChar = input.charAt(0);
			int inputDigit = Integer.parseInt(input.substring(1)) - 1;
			// Convert the players character input to an integer 
			int charDigit = charToInt(inputChar);
			// Check if player's input is valid
			if (!checkChar(inputChar) || (inputDigit < 0 || inputDigit >= BOARD_LENGTH)) {
				System.out.println("Sorry, the coordinates you entered are outside the grid. Try again.");
				continue;
			}
			// If player enters coordinates already entered, display error and ask for new input
			if (gameBoard[inputDigit][charDigit].getCalled()) {
				System.out.println("Sorry, those coordinates have already been called. Try again.");
				continue;
			}
			// If player targets their own ship by accident, display error and ask for new input
			if (gameBoard[inputDigit][charDigit].getOwner() == 1) {
				System.out.println("You can't fire on your own squares! Try again.");
				continue;
			}
			// If the player hits an empty square
			if (gameBoard[inputDigit][charDigit].getOwner() == 0) {
				// Inform player they hit nothing
				System.out.println("Nothing.");
				// Set status of that game square to called
				gameBoard[inputDigit][charDigit].setCalled(true);
				// Change display of that game square from '_' to it's actual type
				gameBoard[inputDigit][charDigit].setDisplay(gameBoard[inputDigit][charDigit].getType());
				// Decrement player turns by 1
				player.endTurn();
				// If the player has no turns remaining, change the truth values of
				// the player and computer turn status
				// Set the computers turn count to 1
				if (player.getTurns() == 0) {
					player.setisTurn(false);
					computer.setisTurn(true);
					computer.setTurn(1);
				}
			}
			// If the player hits a computer ship
			else if (gameBoard[inputDigit][charDigit].getType() == 'S') {
				// Inform player they hit one of the computers ship
				System.out.println("Ship hit.");
				// Set status of that game square to called
				gameBoard[inputDigit][charDigit].setCalled(true);
				// Change display of that game square to it's actual type
				gameBoard[inputDigit][charDigit].setDisplay(gameBoard[inputDigit][charDigit].getType());
				// Decrement computer ship count by 1
				computer.minusShips();
				// Decrement player turns by 1
				player.endTurn();
				// If the player has no turns remaining, change the truth values of
				// the player and computer turn status
				// Set the computers turn count to 1
				if (player.getTurns() == 0) {
					player.setisTurn(false);
					computer.setisTurn(true);
					computer.setTurn(1);
				}
			}
			// If the player hits a computer grenade
			else if (gameBoard[inputDigit][charDigit].getType() == 'G'){
				// Inform the player they have hit a grenade
				System.out.println("Boom! Grenade hit.");
				// Set status of that game square to called
				gameBoard[inputDigit][charDigit].setCalled(true);
				// Change display of that game square to it's actual type
				gameBoard[inputDigit][charDigit].setDisplay(gameBoard[inputDigit][charDigit].getType());
				// Set player turns to 0 with hitGrenade method
				// Set computers turn count to 2
				// Change truth values of player and computer turn status
				player.hitGrenade();
				computer.setTurn(2);
				player.setisTurn(false);
				computer.setisTurn(true);
			}
			// If the computer has no more ships, perform the following:
			// Display winning message
			// Display final game board
			// Close the scanner and exit the loop
			if (computer.getShips() == 0) {
				System.out.println("You win! Well played.");
				displayBoard();
				scan.close();
				break;
			}
			// If computer still has ships, display the board
			else
				displayBoard();
		}
		// Perform loop as long as player has a turn
		while (player.getisTurn());
	}
	
	// Public method to play a complete game of battleship
	public void playGame() {
		// Continue looping until player ship count or computer ship count reach 0
		while (player.getShips() > 0 && computer.getShips() > 0) {
			// If it's the players turn, call the playerTurn method
			if (player.getisTurn()) 
				playerTurn();
			// If it's the computers turn, call the computerTurn method
			else 
				computerTurn();
		}
	}
	
	//////////////////// SUPPLEMENTARY METHODS ////////////////////
	
	// Private method to check if character entered was within bounds of the array
	// Return true only if character was between 'A'/'a' and 'H'/'h'
		private boolean checkChar(char ch) {
			return (ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd' || ch == 'e' || ch == 'f' || ch == 'g' || ch == 'h' 
					|| ch == 'A' || ch == 'B' || ch == 'C' || ch == 'D' || ch == 'E' || ch == 'F' || ch == 'G' || ch == 'H');
		}
		
		// Private method to convert player's character input to the corresponding index integer of the gameBoard array
		private int charToInt(char ch) {
			// Temporary variable to store the corresponding integer value of the character
			int temp = 0;
			// Store integer corresponding to character in temp variable, ignoring case
			switch(ch) {
			case 'a':
			case 'A':
				temp = 0;
				break;
			case 'b':
			case 'B':
				temp = 1;
				break;
			case 'c':
			case 'C':
				temp = 2;
				break;
			case 'd':
			case 'D':
				temp = 3;
				break;
			case 'e':
			case 'E':
				temp = 4;
				break;
			case 'f':
			case 'F':
				temp = 5;
				break;
			case 'g':
			case 'G':
				temp = 6;
				break;
			case 'h':
			case 'H':
				temp = 7;
				break;
			}
			// Return the corresponding integer
			return temp;
		}
}