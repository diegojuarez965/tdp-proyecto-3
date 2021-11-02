package Personajes;

import Entidad.Entidad;
import Laberinto.Laberinto;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Personaje extends Entidad{
	
	public Personaje(Posicion p, String skin) {
		super(p, skin);
	}
	protected Laberinto laberinto;
	private int velocidad = 10; //Cantidad de pixeles que se mueve el Personaje a la vez.
	
	public int obtenerVelocidad() {
		return velocidad;
	}
	public void aumentarVelocidad() {
		velocidad += 10;
	}
	public void disminuirVelocidad() {
		velocidad -=10;
	}
}
