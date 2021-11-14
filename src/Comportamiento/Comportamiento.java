package Comportamiento;

import Personajes.Enemigo;

public abstract class Comportamiento {

	protected Enemigo enemigo;
	protected String skin;
	
	public Comportamiento(Enemigo enemigo, String skin) {
		this.enemigo = enemigo;
		this.skin = skin;
	}
	
	public String obtenerSkin() {
		return skin;
	}
	
	public abstract void moverSiguientePos();
	
	public abstract boolean esVulnerable();
	
}
