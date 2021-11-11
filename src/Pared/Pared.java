package Pared;

import Entidad.Entidad;
import Posicion.Posicion;
import Visitor.Visitor;

public class Pared extends Entidad{

	public Pared(Posicion p, String skin) {
		super(p, skin);
	}

	public void accept(Visitor v) {
		v.visitPared(this);
	}
	
	public String obtenerSkin() {
		return skin;
	}
	
}
