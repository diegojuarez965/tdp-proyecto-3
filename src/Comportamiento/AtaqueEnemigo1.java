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
			case Enemigo.ARRIBA:{
				if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverArriba();
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX())
					moverIzq();
				else 
					moverDer();
				break;
			}
			case Enemigo.DERECHA:{
				if(posPersonajeP.obtenerX() > posEnemigo.obtenerX()) 
					moverDer();
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverArriba();
				else 
					moverAbajo();
				break;
			}
			case Enemigo.ABAJO:{
				if(posPersonajeP.obtenerY() > posEnemigo.obtenerY()) 
					moverAbajo();
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) 
					moverIzq();
				else 
					moverDer();
				break;
			}
			case Enemigo.IZQUIERDA:{
				if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) 
					moverIzq();
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverArriba();
				else 
					moverAbajo();
				break;
			}
			
		}
		
	}
	

}
