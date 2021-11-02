package Visitor;

import Personajes.Enemigo;

public class VisitorEnemigo implements Visitor{
	
	private Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e) {
		enemigo =  e;
	}
	
}
