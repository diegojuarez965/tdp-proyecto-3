package Loot;

import Posicion.Posicion;
import Visitor.Visitor;

public class Loot1 extends Loot{

	public Loot1(Posicion p, String skin) {
		super(p, skin);
		puntaje = 50;
	}
	
	public int obtenerPuntaje() {
		return puntaje;
	}
	
	public boolean accept(Visitor v) {
		v.visitLoot1(this);
		return true;
	}
}
