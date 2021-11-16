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
		Laberinto lab = enemigo.obtenerLaberinto();
		PersonajePrincipal personajeP = lab.obtenerPersonajePrincipal();
		Posicion posPersonajeP, posEnemigo;
		posPersonajeP = personajeP.obtenerPosicion();
		posEnemigo = enemigo.obtenerPosicion();
		switch(enemigo.obtenerDireccion()) {
			case Enemigo.ARRIBA:{
				if(!moverArriba() || posPersonajeP.obtenerY() >= posEnemigo.obtenerY() ) {
				if(posPersonajeP.obtenerX() < posEnemigo.obtenerX())
					moverIzq();
				else 
					moverDer();
				}
				break;
			}
			case Enemigo.DERECHA:{
				if(!moverDer() || posPersonajeP.obtenerX() <= posEnemigo.obtenerX()) {
				if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverArriba();
				else 
					moverAbajo();
				}
				break;
			}
			case Enemigo.ABAJO:{
				if(!moverAbajo() || posPersonajeP.obtenerY() <= posEnemigo.obtenerY()) { 
			    if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) 
					moverIzq();
				else 
					moverDer();
				}
				break;
			}
			case Enemigo.IZQUIERDA:{
				if(!moverIzq() || posPersonajeP.obtenerX() >= posEnemigo.obtenerX()) { 
				if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverArriba();
				else 
					moverAbajo();
				}
				break;
			}
			
		}
	
	}
	

}
