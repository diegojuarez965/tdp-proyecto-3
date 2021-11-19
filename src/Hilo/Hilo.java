package Hilo;

import java.util.LinkedList;

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
		LinkedList<Enemigo> enemigos = new LinkedList<Enemigo>();
		int i;
		for(Enemigo e : lab.obtenerEnemigos()) {
			enemigos.add(e);
			i = 0;
			while(!parar && i<50) {
				for(Enemigo enemigoLista : enemigos) {
					ControladorMovimiento.moverPersonaje(enemigoLista, ControladorMovimiento.MOVER);
					lab.actualizarEntidadVisual(enemigoLista);
					if(parar)
						break;
				}
				if(!parar)
					try {
						Thread.sleep(25);
					} catch (InterruptedException e1) {e1.printStackTrace();}
				i++;
			}
			if(parar)
				break;
		}
		while(!parar) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e1) {e1.printStackTrace();}
			for(Enemigo e : lab.obtenerEnemigos()) {
				ControladorMovimiento.moverPersonaje(e, ControladorMovimiento.MOVER);
				lab.actualizarEntidadVisual(e);
				if(parar)
					break;
			}	
		}
	}
	public void parar() {
		parar = true;
		try {
			finalize();
		} catch (Throwable e) {e.printStackTrace();}
	}

}
