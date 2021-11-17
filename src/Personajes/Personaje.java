package Personajes;

import Entidad.Entidad;
import Laberinto.Laberinto;
import Posicion.Posicion;

public abstract class Personaje extends Entidad{
	
	protected Laberinto laberinto;
	
	public Personaje(Posicion p, String skin) {
		super(p, skin);
	}
	
	public Laberinto obtenerLaberinto() {
		return laberinto;
	}
	
	public void setLaberinto(Laberinto lab) {
		laberinto = lab;
	}
	
	public abstract int obtenerVelocidad();
	
	public abstract void setVelocidad(int v);
	
	public abstract void mover(int d);
}
