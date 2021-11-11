package Personajes;

import Comportamiento.AtaqueEnemigo1;
import Comportamiento.Huida;
import Posicion.Posicion;
import Visitor.Visitor;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Posicion p, String skin, String skinHuida) {
		super(p, skin, skinHuida);
	}

	@Override
	public void setEstrategia(int comportamiento) {
		switch (comportamiento) {
			case ATAQUE:{
				estrategia = new AtaqueEnemigo1(this, skin);
				break;
			}
			case HUIDA:{
				estrategia = new Huida(this, skinHuida);
				break;
			}
		}
	}
}
