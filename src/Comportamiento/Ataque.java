package Comportamiento;

import Personajes.Enemigo;
import Posicion.Posicion;

public abstract class Ataque extends Comportamiento{
	
	public Ataque(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		velocidad = 2;
	}

	@Override
	public boolean esVulnerable() {
		return false;
	}
	
	@Override
	public abstract void moverSiguientePos();
	
	protected void moverHacia(int x, int y) {
		Posicion pos = enemigo.obtenerPosicion();
		int xE = pos.obtenerX();
		int yE = pos.obtenerY();
		int difX = Math.abs(xE-x);
		int difY = Math.abs(yE-y);
		switch(enemigo.obtenerDireccion()) {
			case Enemigo.ARRIBA:{
				if(difY>difX) {
					if(y>=yE) {
						if(x<xE) {
							if(!moverIzq())
								if(!moverDer())
									moverArriba();
						}
						else
							if(!moverDer())
								if(!moverIzq())
									moverArriba();
					}
					else 
						if(!moverArriba()) {
							if(x<xE) {
								if(!moverIzq())
									moverDer();
							}
							else
								if(!moverDer())
									moverIzq();
						}
				}
				else {
					if(x<xE) {
						if(!moverIzq())
							if(!moverDer()) 
								moverArriba();
					}
					else
						if(!moverDer())
							if(!moverIzq())
								moverArriba();
				}
				break;
			}
			case Enemigo.DERECHA:{
				if(difX>difY) {
					if(x>xE) {
						if(!moverDer()) {
							if(y<yE) {
								if(!moverArriba())
									moverAbajo();
							}
							else
								if(!moverAbajo())
									moverArriba();
						}
					}
					else {
						if(y<yE) {
							if(!moverArriba())
								if(!moverAbajo())
									moverDer();
						}
						else
							if(!moverAbajo())
								if(!moverArriba())
									moverDer();
					}
				}
				else {
					if(y<yE) {
						if(!moverArriba())
							if(!moverAbajo())
								moverDer();
					}
					else
						if(!moverAbajo())
							if(!moverArriba())
								moverDer();
				}
				break;
			}
			case Enemigo.ABAJO:{
				if(difY>difX) {
					if(y>yE) {
						if(!moverAbajo()) {
							if(x<xE) {
								if(!moverIzq())
									moverDer();
							}
							else
								if(!moverDer())
									moverIzq();
						}
					}
					else {
						if(x<xE) {
							if(!moverIzq())
								if(!moverDer())
									moverAbajo();
						}
						else
							if(!moverDer())
								if(!moverIzq())
									moverAbajo();
					}
				}
				else {
					if(x<xE) {
						if(!moverIzq())
							if(!moverDer())
								moverAbajo();
					}
					else
						if(!moverDer())
							if(!moverIzq())
								moverAbajo();
				}
				break;
			}
			case Enemigo.IZQUIERDA:{
				if(difX>difY) {
					if(x<xE) {
						if(!moverIzq()) {
							if(y<yE) {
								if(!moverArriba())
									moverAbajo();
							}
							else
								if(!moverAbajo())
									moverArriba();
						}
					}
					else {
						if(y<yE) {
							if(!moverArriba())
								if(!moverAbajo())
									moverIzq();
						}
						else
							if(!moverAbajo())
								if(!moverArriba())
									moverIzq();
					}
				} 
				else {
					if(y<yE) {
						if(!moverArriba())
							if(!moverAbajo())
								moverIzq();
					}
					else
						if(!moverAbajo())
							if(!moverArriba())
								moverIzq();
				}
				break;
			}
			
		}
	}
}
