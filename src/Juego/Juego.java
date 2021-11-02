package Juego;

import Builder.ConstructorLaberinto;
import Builder.ConstructorNivel1;
import Builder.ConstructorNivel2;
import Builder.ConstructorNivel3;
import Builder.Director;
import Entidad.Entidad;
import Factory.FactoryTemas;
import GUI.GUI;
import Laberinto.Laberinto;

public class Juego {
	
	private GUI gui;
	private FactoryTemas tema;
	private Director director;
	private Laberinto laberinto;
	private int nivel;
	
	public Juego() {
		nivel = 1;
	}
	
	public void setGUI(GUI g) {
		gui = g;
	}
	public void setTema(FactoryTemas tema) {
		this.tema = tema;
	}
	public void mover(int direccion) {
		laberinto.mover(direccion);
	}
	
	public void actualizarEntidadVisual(Entidad e) {
		gui.actualizarEntidadVisual(e);
	}
	public void mostrarEntidadVisual(Entidad e) {
		gui.mostrarEntidadVisual(e);
	}
	public void eliminarEntidadVisual(Entidad e) {
		gui.eliminarEntidadVisual(e);
	}
	public void pasarNivel() {
		ConstructorLaberinto cl = null;
		if(nivel==1)
			cl = new ConstructorNivel1(tema);
		/*else if(nivel==2)
			cl = new ConstructorNivel2(tema);
		else if(nivel==3)
			cl = new ConstructorNivel3(tema);*/
		director = new Director(cl);
		director.nuevoNivel(this);
		laberinto = cl.obtenerLaberinto();
	}
	public void pararMusica() {
		
	}
	public void pararEfectos() {
		
	}
}
