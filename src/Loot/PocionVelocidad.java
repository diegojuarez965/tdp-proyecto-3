package Loot;

import Posicion.Posicion;
import Visitor.Visitor;

public class PocionVelocidad extends LootEspecial2 {

	public PocionVelocidad(Posicion p, String skin) {
		super(p, skin);
	}

	public void accept(Visitor v) {
		v.visitPocionVelocidad(this);
	}

}
