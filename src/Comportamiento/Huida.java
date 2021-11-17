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
		Posicion posPersonajeP = personajeP.obtenerPosicion(), posEnemigo = enemigo.obtenerPosicion();
		int xE = posEnemigo.obtenerX(), x = posPersonajeP.obtenerX();
		int yE = posEnemigo.obtenerY(), y = posPersonajeP.obtenerY();
		int difX = Math.abs(xE-x);
		int difY = Math.abs(yE-y);
		switch(enemigo.obtenerDireccion()) {
			case Enemigo.ARRIBA:{
				if(difY>difX) {
					if(x<xE) {
						if(!moverDer())
							if(!moverIzq())
								moverArriba();
					}
					else
						if(!moverIzq())
							if(!moverDer()) 
								moverArriba();
				}
				else {
					if(y>=yE) {
						if(!moverArriba()) {
							if(x<xE) {
								if(!moverDer())
									moverIzq();
							}
							else
								if(!moverIzq())
									moverDer();
						}
					}
					else 
						if(x<xE) {
							if(!moverDer())
								if(!moverIzq())
									moverArriba();
						}
						else
							if(!moverIzq())
								if(!moverDer())
									moverArriba();
				}
				break;
			}
			case Enemigo.DERECHA:{
				if(difX>difY) {
					if(y<yE) {
						if(!moverAbajo())
							if(!moverDer())
								moverArriba();
					}
					else
						if(!moverArriba())
							if(!moverDer())
								moverAbajo();
				}
				else {
					if(x>xE) {
						if(y<yE) {
							if(!moverAbajo())
								if(!moverDer())
									moverArriba();
						}
						else
							if(!moverArriba())
								if(!moverDer())
									moverAbajo();
					}
					else {
						if(!moverDer()) {
							if(y<yE) {
								if(!moverAbajo())
									moverArriba();
							}
							else
								if(!moverArriba())
									moverAbajo();
						}
					}
				}
				break;
			}
			case Enemigo.ABAJO:{
				if(difY>difX) {
					if(x<xE) {
						if(!moverDer())
							if(!moverAbajo())
								moverIzq();
					}
					else
						if(!moverIzq())
							if(!moverAbajo())
								moverDer();
				}
				else {
					if(y>yE) {
						if(x<xE) {
							if(!moverDer())
								if(!moverAbajo())
									moverIzq();						
						}
						else
							if(!moverIzq())
								if(!moverAbajo())
									moverDer();
					}
					else {
						if(!moverAbajo()) {
							if(x<xE) {
								if(!moverDer())
									moverIzq();
							}
							else
								if(!moverIzq())
									moverDer();
						}
					}
				}
				break;
			}
			case Enemigo.IZQUIERDA:{
				if(difX>difY) {
					if(y<yE) {
						if(!moverAbajo())
							if(!moverIzq())
								moverArriba();
					}
					else
						if(!moverArriba())
							if(!moverIzq())
								moverAbajo();
				} 
				else {
					if(x<xE) {
						if(y<yE) {
							if(!moverAbajo())
								if(!moverIzq())
									moverArriba();
						}
						else
							if(!moverArriba())
								if(!moverIzq())
									moverAbajo();
					}
					else {
						if(!moverIzq()) {
							if(y<yE) {
								if(!moverAbajo())
									moverArriba();
							}
							else
								if(!moverArriba())
									moverAbajo();
						}
					}
				}
				break;
			}
			
		}
	}

	@Override
	public boolean esVulnerable() {
		return true;
	}
	
}
