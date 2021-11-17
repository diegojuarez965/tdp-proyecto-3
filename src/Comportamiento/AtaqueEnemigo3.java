package Comportamiento;

import Personajes.Enemigo;
import Posicion.Posicion;

public class AtaqueEnemigo3 extends Ataque {

	public AtaqueEnemigo3(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moverSiguientePos() {
		Posicion posPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerPosicion();
		moverHacia(posPersonaje.obtenerX(), posPersonaje.obtenerY());
	}

}
