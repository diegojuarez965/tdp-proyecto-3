package Personajes;

import Comportamiento.AtaqueEnemigo4;
import Comportamiento.Huida;
import Posicion.Posicion;

public class Enemigo4 extends Enemigo {

	public Enemigo4(Posicion p, String skin, String skinHuida) {
		super(p, skin, skinHuida);
	}

	@Override
	public void setEstrategia(int comportamiento) {
		switch (comportamiento) {
		case ATAQUE: {
			estrategia = new AtaqueEnemigo4(this, skin);
			break;
		}
		case HUIDA: {
			estrategia = new Huida(this, skinHuida);
			break;
		}
		}
	}

}
