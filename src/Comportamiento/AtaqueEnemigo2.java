package Comportamiento;

import Personajes.Enemigo;
import Posicion.Posicion;

public class AtaqueEnemigo2 extends Ataque {

	public AtaqueEnemigo2(Enemigo enemigo, String skin) {
		super(enemigo, skin);
	}

	@Override
	public void moverSiguientePos() {
		Posicion posPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerPosicion();
		Posicion posBlinky = enemigo.obtenerLaberinto().obtenerEnemigos().iterator().next().obtenerPosicion();
		int dirBlinky = enemigo.obtenerLaberinto().obtenerEnemigos().iterator().next().obtenerDireccion();
		int x= posPersonaje.obtenerX()-posBlinky.obtenerX();
		int y= posPersonaje.obtenerY()-posBlinky.obtenerY();
		int distancia= (int) Math.sqrt(x*x+y*y);
		int objetivoX=0,objetivoY=0;
		switch(dirBlinky) {
		case Enemigo.ARRIBA: {
			objetivoX= posPersonaje.obtenerX();
			objetivoY= posPersonaje.obtenerY() - distancia;
			break;
		}
		case Enemigo.ABAJO: {
			objetivoX= posPersonaje.obtenerX();
			objetivoY= posPersonaje.obtenerY() + distancia;
			break;
		}
		case Enemigo.DERECHA: {
			objetivoX= posPersonaje.obtenerX() + distancia;
			objetivoY= posPersonaje.obtenerY();
			break;
		}
		case Enemigo.IZQUIERDA: {
			objetivoX= posPersonaje.obtenerX() - distancia;
			objetivoY= posPersonaje.obtenerY();
			break;
		}
		}
		moverHacia(objetivoX,objetivoY);
	}

}
