package Comportamiento;

import Personajes.Enemigo;
import Posicion.Posicion;

public class AtaqueEnemigo2 extends Ataque {

	public AtaqueEnemigo2(Enemigo enemigo, String skin) {
		super(enemigo, skin);
	}

	@Override
	public void moverSiguientePos() {
		Posicion posPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerPosicion();
	}

}
