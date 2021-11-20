package Personajes;

import Comportamiento.AtaqueEnemigo2;
import Comportamiento.Huida;
import Posicion.Posicion;

public class Enemigo2 extends Enemigo {

	public Enemigo2(Posicion p, String skin, String skinHuida) {
		super(p, skin, skinHuida);
	}

	@Override
	public void setEstrategia(int comportamiento) {
		switch (comportamiento) {
		case ATAQUE: {
			estrategia = new AtaqueEnemigo2(this, skin);
			break;
		}
		case HUIDA: {
			estrategia = new Huida(this, skinHuida);
			break;
		}
		}
	}

}
