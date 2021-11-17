package Hilo;

import Personajes.Personaje;

public class ControladorMovimiento {
	
	public static final int MOVER = 0;
	public static final int MOVER_ABAJO = 1;
	public static final int MOVER_ARRIBA = 2;
	public static final int MOVER_DERECHA = 3;
	public static final int MOVER_IZQUIERDA = 4;

	public static synchronized void moverPersonaje(Personaje p, int direccion) {
		p.mover(direccion);
	}

}
