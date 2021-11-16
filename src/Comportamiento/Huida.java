package Comportamiento;

import Laberinto.Laberinto;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;
import Posicion.Posicion;

public class Huida extends Comportamiento{
	
	public Huida(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		velocidad = 1;
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
					moverAbajo();
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX())
					moverDer();
				else 
					moverIzq();
				break;
			}
			case Enemigo.DERECHA:{
				if(posPersonajeP.obtenerX() > posEnemigo.obtenerX()) 
					moverIzq();
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverAbajo();
				else 
					moverArriba();
				break;
			}
			case Enemigo.ABAJO:{
				if(posPersonajeP.obtenerY() > posEnemigo.obtenerY()) 
					moverArriba();
				else if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) 
					moverDer();
				else 
					moverIzq();
				break;
			}
			case Enemigo.IZQUIERDA:{
				if(posPersonajeP.obtenerX() < posEnemigo.obtenerX()) 
					moverDer();
				else if(posPersonajeP.obtenerY() < posEnemigo.obtenerY()) 
					moverAbajo();
				else 
					moverArriba();
				break;
			}
			
		}
	}

	@Override
	public boolean esVulnerable() {
		return true;
	}
	
}
