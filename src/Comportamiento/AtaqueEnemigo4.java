package Comportamiento;

import Personajes.Enemigo;
import Posicion.Posicion;

public class AtaqueEnemigo4 extends Ataque {

	public AtaqueEnemigo4(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moverSiguientePos() {
		Posicion posPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerPosicion();
	}

}
