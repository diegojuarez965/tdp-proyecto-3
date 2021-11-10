package Loot;

import Posicion.Posicion;
import Sonido.ReproductorSonido;
import Visitor.Visitor;

public class PocionVelocidad extends LootEspecial2{

	public PocionVelocidad(Posicion p, String skin) {
		super(p, skin);
	}

	public boolean accept(Visitor v) {
		v.visitPocionVelocidad(this);
		return true;
	}

}
