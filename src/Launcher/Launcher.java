package Launcher;

import GUI.GUI;
import Juego.Juego;

public class Launcher {
	
	
	public static void main(String []args) {
		GUI gui = new GUI();
		Juego juego = new Juego();
		juego.setGUI(gui);
		gui.mostrarMensajeTemas();
		gui.setUpJuego(juego);
	}
}
