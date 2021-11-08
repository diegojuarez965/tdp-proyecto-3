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
				Thread.sleep(200);
			} catch (InterruptedException e1) {e1.printStackTrace();}
			Iterable<Enemigo> enemigos= lab.obtenerEnemigos();
			for(Enemigo e : enemigos)
				e.moverSiguientePos();
		}
	}
	public void parar() {
		parar = true;
	}

}
