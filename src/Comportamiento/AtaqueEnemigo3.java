package Comportamiento;

import Personajes.Enemigo;
import Personajes.Personaje;
import Posicion.Posicion;

public class AtaqueEnemigo3 extends Ataque {

	public AtaqueEnemigo3(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moverSiguientePos() {
		Posicion posPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerPosicion();
		int dirPersonaje = enemigo.obtenerLaberinto().obtenerPersonajePrincipal().obtenerDireccion();
		int objetivoX=0,objetivoY=0;
		switch(dirPersonaje) {
		case Personaje.ARRIBA: {
			objetivoX= posPersonaje.obtenerX() - posPersonaje.obtenerAncho()*2;
			objetivoY= posPersonaje.obtenerY() - posPersonaje.obtenerAlto()*4;
			break;
		}
		case Personaje.ABAJO: {
			objetivoX= posPersonaje.obtenerX();
			objetivoY= posPersonaje.obtenerY() + posPersonaje.obtenerAlto()*4;
			break;
		}
		case Personaje.DERECHA: {
			objetivoX= posPersonaje.obtenerX() + posPersonaje.obtenerAncho()*4;
			objetivoY= posPersonaje.obtenerY();
			break;
		}
		case Personaje.IZQUIERDA: {
			objetivoX= posPersonaje.obtenerX() - posPersonaje.obtenerAncho()*4;
			objetivoY= posPersonaje.obtenerY();
			break;
		}
		}
		moverHacia(objetivoX,objetivoY);
	}

}
