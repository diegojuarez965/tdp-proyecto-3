package Loot;

import Posicion.Posicion;
import Visitor.Visitor;

public class LootEspecial1 extends Loot{

	public LootEspecial1(Posicion p, String skin) {
		super(p, skin);
		puntaje = 0;
	}

	public int obtenerPuntaje() {
		return puntaje;
	}
	
	public void accept(Visitor v) {
		
	}
}
