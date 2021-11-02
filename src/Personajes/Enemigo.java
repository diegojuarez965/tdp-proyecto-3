package Personajes;

import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Enemigo extends Personaje{

	protected boolean vulnerable;
	protected String skinHuida;
	
	public Enemigo(Posicion p, String skin, String skinHuida) {
		super(p, skin);
		vulnerable = false;
		this.skinHuida = skinHuida;
	}
	
	
	public void accept(Visitor v) {
		
	}
}
