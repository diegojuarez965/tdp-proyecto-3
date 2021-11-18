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
		Posicion posEnemigo = enemigo.obtenerPosicion();
		int personajeX = posPersonaje.obtenerX();
		int personajeY = posPersonaje.obtenerY();
		int enemigoX = posEnemigo.obtenerX();
		int enemigoY = posEnemigo.obtenerY();
		double distancia = Math.sqrt(Math.pow(enemigoX - personajeX, 2) + Math.pow(enemigoY - posPersonaje.obtenerY(), 2));
		if(distancia/40 <= 4)
			moverHacia(personajeX, personajeY);
		else
			moverHacia(0, 18);
	}

}
