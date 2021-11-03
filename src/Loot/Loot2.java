package Loot;

import Posicion.Posicion;
import Visitor.Visitor;

public class Loot2 extends Loot{

	public Loot2(Posicion p, String skin) {
		super(p, skin);
		puntaje = 150;
	}

	
	public int obtenerPuntaje() {
		return puntaje;
	}
	
	public boolean accept(Visitor v) {
		
		return true;
	}
}
