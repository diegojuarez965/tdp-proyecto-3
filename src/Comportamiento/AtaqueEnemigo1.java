package Comportamiento;

import Personajes.Enemigo;
import Personajes.PersonajePrincipal;
import Posicion.Posicion;
import Entidad.Entidad;
import Laberinto.Laberinto;

public class AtaqueEnemigo1 extends Ataque {

	public AtaqueEnemigo1(Enemigo enemigo, String skin) {
		super(enemigo, skin);
	}

	@Override
	public void moverSiguientePos() {
		Laberinto lab = enemigo.obtenerLaberinto();
		PersonajePrincipal personajeP = lab.obtenerPersonajePrincipal();
		Posicion posPersonajeP, posEnemigo;
		posPersonajeP = personajeP.obtenerPosicion();
		posEnemigo = enemigo.obtenerPosicion();
		switch(enemigo.obtenerDireccion()) {
			case 1:{//arriba
				if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) {
					//mover arriba
				}
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					//mover izquierda
				}
				else {
					//mover derecha
				}
			}
			case 2:{//derecha
				if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					//mover derecha
				}
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) {
					//mover arriba
				}
				else {
					//mover abajo
				}
			}
			case 3:{//abajo
				if(posPersonajeP.obtenerY() > posEnemigo.obtenerY()) {
					//mover abajo
				}
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					//mover izquierda
				}
				else {
					//mover derecha
				}
			}
			case 4:{//izquierda
				if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					//
				}
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) {
					//mover arriba
				}
				else {
					//mover abajo
				}
			}
			
		}
		
	}

}
