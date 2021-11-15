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
			case Enemigo.ARRIBA:{//arriba
				if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) {
					moverArriba();//mover arriba
				}
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					moverIzq();//mover izquierda
				}
				else {
					moverDer();//mover derecha
				}
			}
			case Enemigo.DERECHA:{//derecha
				if(posPersonajeP.obtenerX() > posEnemigo.obtenerX()) {
					moverDer();//mover derecha
				}
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) {
					moverArriba();//mover arriba
				}
				else {
					moverAbajo();//mover abajo
				}
			}
			case Enemigo.ABAJO:{//abajo
				if(posPersonajeP.obtenerY() > posEnemigo.obtenerY()) {
					moverAbajo();//mover abajo
				}
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					moverIzq();//mover izquierda
				}
				else {
					moverDer();//mover derecha
				}
			}
			case Enemigo.IZQUIERDA:{//izquierda
				if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) {
					moverIzq();//
				}
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) {
					moverArriba();//mover arriba
				}
				else {
					moverAbajo();//mover abajo
				}
			}
			
		}
		
	}

}
