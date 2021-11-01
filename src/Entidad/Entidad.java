package Entidad;

import Posicion.Posicion;

public abstract class Entidad {
	
	private Posicion p;
	private String skin;
	
	public Posicion obtenerPosicion() {
		return p;
	}
	public String obtenerSkin() {
		return skin;
	}
}
