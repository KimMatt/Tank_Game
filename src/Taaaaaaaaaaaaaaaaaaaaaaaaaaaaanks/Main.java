package Taaaaaaaaaaaaaaaaaaaaaaaaaaaaanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

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
