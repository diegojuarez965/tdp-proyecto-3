package Loot;

import Posicion.Posicion;
import Sonido.ReproductorSonido;
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
		v.visitLoot2(this);
		return true;
	}
}
