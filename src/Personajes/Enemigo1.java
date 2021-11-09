package Personajes;

import Posicion.Posicion;
import Visitor.Visitor;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Posicion p, String skin, String skinHuida) {
		super(p, skin, skinHuida);
	}
	
	@Override
	public void moverSigPosAtaque() {
		
	}

	@Override
	public void moverSigPosHuida() {
		// TODO Auto-generated method stub
		
	}
}
