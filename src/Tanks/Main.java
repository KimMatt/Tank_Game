package Tanks;

public class Main {

	/**
	 * Creates the game canvas and updates the game's data 
	 * and repaints constantly while the game is not over.
	 * @param args
	 */
	public static void main(String[] args) {
	Canvas window = new Canvas();
	while(window.gameStatus() == 0){
		window.getTanks().update();
		window.paint();
	}
	System.exit();
	}

}
