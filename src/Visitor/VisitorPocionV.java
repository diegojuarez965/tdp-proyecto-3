package Visitor;

import Loot.PocionVelocidad;

public class VisitorPocionV implements Visitor{
	
	private PocionVelocidad pocionVelocidad;
	
	public VisitorPocionV(PocionVelocidad pV) {
		pocionVelocidad = pV;
	}
	
}
