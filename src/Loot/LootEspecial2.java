package Loot;

import Posicion.Posicion;

public abstract class LootEspecial2 extends Loot{
	
	public LootEspecial2(Posicion p, String skin) {
		super(p, skin);
		puntaje = 0;
	}

	public int obtenerPuntaje() {
		return puntaje;
	}
	
}
