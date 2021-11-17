package Hilo;

import Laberinto.Laberinto;
import Personajes.Enemigo;

public class Hilo extends Thread{
	
	private Laberinto lab;
	private boolean parar;
	
	public Hilo(Laberinto lab) {
		this.lab=lab;
		parar=false;
	}
	
	public void run() {
		while(!parar) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e1) {e1.printStackTrace();}
			for(Enemigo e : lab.obtenerEnemigos()) {
				ControladorMovimiento.moverPersonaje(e, ControladorMovimiento.MOVER);
				lab.actualizarEntidadVisual(e);
			}	
		}
	}
	public void parar() {
		parar = true;
	}

}
