package Loot;

import Entidad.Entidad;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Loot extends Entidad{

	protected int puntaje;
	
	public Loot(Posicion p, String skin) {
		super(p, skin);
	}
	
	public String obtenerSkin() {
		return skin;
	}
	
	public abstract int obtenerPuntaje();
	
}
