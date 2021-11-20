package Personajes;

import Entidad.Entidad;
import Laberinto.Laberinto;
import Posicion.Posicion;

public abstract class Personaje extends Entidad {

	protected Laberinto laberinto;

	public final static int ATAQUE = 0;
	public final static int HUIDA = 1;

	public final static int ARRIBA = 0;
	public final static int DERECHA = 1;
	public final static int ABAJO = 2;
	public final static int IZQUIERDA = 3;
	protected int direccion;

	public Personaje(Posicion p, String skin) {
		super(p, skin);
		direccion = ARRIBA;
	}

	public int obtenerDireccion() {
		return direccion;
	}

	public Laberinto obtenerLaberinto() {
		return laberinto;
	}

	public abstract int obtenerVelocidad();

	public void setDireccion(int d) {
		direccion = d;
	}

	public void setLaberinto(Laberinto lab) {
		laberinto = lab;
	}

	public abstract void setVelocidad(int v);

	public abstract void mover(int d);

}
