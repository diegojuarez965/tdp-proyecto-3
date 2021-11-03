package Pared;

import Entidad.Entidad;
import Posicion.Posicion;
import Visitor.Visitor;

public class Pared extends Entidad{

	public Pared(Posicion p, String skin) {
		super(p, skin);
	}

	public boolean accept(Visitor v) {
		return false;
	}
	
	public String obtenerSkin() {
		return skin;
	}
}
