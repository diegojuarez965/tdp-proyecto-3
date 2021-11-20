package Personajes;

import Comportamiento.AtaqueEnemigo3;
import Comportamiento.Huida;
import Posicion.Posicion;

public class Enemigo3 extends Enemigo {

	public Enemigo3(Posicion p, String skin, String skinHuida) {
		super(p, skin, skinHuida);
	}

	@Override
	public void setEstrategia(int comportamiento) {
		switch (comportamiento) {
		case ATAQUE: {
			estrategia = new AtaqueEnemigo3(this, skin);
			break;
		}
		case HUIDA: {
			estrategia = new Huida(this, skinHuida);
			break;
		}
		}
	}

}
