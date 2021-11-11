package Loot;

import Posicion.Posicion;
import Visitor.Visitor;

public class Explosivo extends LootEspecial2{

	public Explosivo(Posicion p, String skin) {
		super(p, skin);
	}
	
	public void accept(Visitor v) {
		v.visitExplosivo(this);
	}
	
}
