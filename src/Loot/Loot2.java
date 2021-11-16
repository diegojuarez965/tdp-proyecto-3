package Loot;

import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Loot2 extends Loot{

	public Loot2(Posicion p, String skin) {
		super(p, skin);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitLoot2(this);
	}
}
