package Personajes;

import Comportamiento.Comportamiento;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Enemigo extends Personaje {

	protected boolean vulnerable;
	protected String skinHuida;
	protected Comportamiento estrategia;

	public Enemigo(Posicion p, String skin, String skinHuida) {
		super(p, skin);
		vulnerable = false;
		this.skinHuida = skinHuida;
	}

	public String obtenerSkin() {
		return estrategia.obtenerSkin();
	}

	public int obtenerVelocidad() {
		return estrategia.obtenerVelocidad();
	}

	public abstract void setEstrategia(int comportamiento);

	public void setVelocidad(int v) {
		estrategia.setVelocidad(v);
	}

	public boolean esVulnerable() {
		return estrategia.esVulnerable();
	}

	public void mover(int d) {
		estrategia.moverSiguientePos();
	}

	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}

}
