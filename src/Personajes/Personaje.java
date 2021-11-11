package Personajes;

import Entidad.Entidad;
import Laberinto.Laberinto;
import Posicion.Posicion;

public abstract class Personaje extends Entidad{
	
	protected Laberinto laberinto;
	private int velocidad = 5; //Cantidad de pixeles que se mueve el Personaje a la vez.
	
	public Personaje(Posicion p, String skin) {
		super(p, skin);
	}
	
	public int obtenerVelocidad() {
		return velocidad;
	}
	
	public void aumentarVelocidad() {
		velocidad = 10;
	}
	
	public void disminuirVelocidad() {
		velocidad = 5;
	}
	
	public void quitarVelocidad() {
		velocidad=0;
	}
	
	public Laberinto obtenerLaberinto() {
		return laberinto;
	}
	
	public void setLaberinto(Laberinto lab) {
		laberinto = lab;
	}
	
}
