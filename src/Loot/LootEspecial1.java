package Loot;

import Posicion.Posicion;
import Sonido.ReproductorSonido;
import Visitor.Visitor;

public class LootEspecial1 extends Loot{

	public LootEspecial1(Posicion p, String skin) {
		super(p, skin);
		puntaje = 0;
	}

	public int obtenerPuntaje() {
		return puntaje;
	}
	
	public boolean accept(Visitor v) {
		v.visitLootEspecial1(this);
		return true;
	}
}
