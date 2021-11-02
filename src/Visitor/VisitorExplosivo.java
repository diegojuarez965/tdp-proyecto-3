package Visitor;

import Loot.Explosivo;

public class VisitorExplosivo implements Visitor{

	private Explosivo explosivo;
	
	public VisitorExplosivo(Explosivo ex) {
		explosivo = ex;
	}
	
}
