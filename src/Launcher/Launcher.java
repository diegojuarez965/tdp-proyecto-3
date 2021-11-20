package Launcher;

import GUI.GUI;
import Juego.Juego;
import Sonido.ReproductorSonido;

public class Launcher {

	public static void main(String[] args) {
		GUI gui = new GUI();
		Juego juego = new Juego();
		juego.setGUI(gui);
		gui.setJuego(juego);
		gui.cargarRanking();
		gui.mostrarMensajeNombre();
		gui.mostrarMensajeTemas();
		juego.pasarNivel();
		ReproductorSonido.obtenerInstancia().setJuego(juego);
	}

}
