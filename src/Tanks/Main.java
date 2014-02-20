package Tanks;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Canvas window = new Canvas();
	while(window.gameStatus() == 0){
		window.getTanks().update();
		window.paint();
	}
	}

}
