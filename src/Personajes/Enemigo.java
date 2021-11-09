package Personajes;

import java.util.Random;

import Comportamiento.Comportamiento;
import Entidad.Entidad;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Enemigo extends Personaje{

	protected boolean vulnerable;
	protected String skinHuida;
	protected Comportamiento estrategia;
	
	public Enemigo(Posicion p, String skin, String skinHuida) {
		super(p, skin);
		vulnerable = false;
		this.skinHuida = skinHuida;
	}
	public void setEstrategia(Comportamiento e) {
		estrategia = e;
	}
	public boolean esVulnerable() {
		return estrategia.esVulnerable();
	}
	public synchronized void moverSiguientePos() {
		//estrategia.moverSiguientePos(this);
	}
	public boolean accept(Visitor v) {
		return v.visitEnemigo(this);
	}
	public String obtenerSkin() {
		return estrategia.obtenerSkin(this);
	}
	public String obtenerSkinAtaque() {
		return skin;
	}
	public String obtenerSkinHuida() {
		return skinHuida;
	}
	public abstract void moverSigPosAtaque();
	public abstract void moverSigPosHuida();
}
