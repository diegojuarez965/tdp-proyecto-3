package Personajes;

import Entidad.Entidad;
import Laberinto.Laberinto;
import Posicion.Posicion;
import Posicion.PosicionLogica;
import Visitor.Visitor;

public abstract class Personaje extends Entidad{
	
	protected Laberinto laberinto;
	
	public Personaje(Posicion p, String skin) {
		super(p, skin);
	}
	
	private int velocidad = 5; //Cantidad de pixeles que se mueve el Personaje a la vez.
	
	public int obtenerVelocidad() {
		return velocidad;
	}
	public void aumentarVelocidad() {
		velocidad = 10;
	}
	public void disminuirVelocidad() {
		velocidad = 5;
	}
	
	public Laberinto obtenerLaberinto() {
		return laberinto;
	}
}
