package Comportamiento;

import Personajes.Enemigo;
import Personajes.PersonajePrincipal;
import Posicion.Posicion;
import Laberinto.Laberinto;

public class AtaqueEnemigo1 extends Ataque {

	public AtaqueEnemigo1(Enemigo enemigo, String skin) {
		super(enemigo, skin);
	}

	@Override
	public void moverSiguientePos() {
		Posicion posPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerPosicion();
		moverHacia(posPersonaje.obtenerX(), posPersonaje.obtenerY());
	}

}
