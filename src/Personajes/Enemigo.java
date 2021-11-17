package Personajes;

import Comportamiento.Comportamiento;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Enemigo extends Personaje{

	protected boolean vulnerable;
	protected String skinHuida;
	protected Comportamiento estrategia;
	
	public final static int ATAQUE = 0;
	public final static int HUIDA = 1;
	
	public final static int ARRIBA = 0;
	public final static int DERECHA = 1;
	public final static int ABAJO = 2;
	public final static int IZQUIERDA = 3;
	protected int direccion;
	
	public Enemigo(Posicion p, String skin, String skinHuida) {
		super(p, skin);
		vulnerable = false;
		this.skinHuida = skinHuida;
		direccion = ARRIBA;
	}
	
	public boolean esVulnerable() {
		return estrategia.esVulnerable();
	}
	
	public int obtenerDireccion() { 
		return direccion;
	}
	
	public void setDireccion(int d) {
		direccion = d;
	}
	
	public void moverSiguientePos() {
		estrategia.moverSiguientePos();
	}
	
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	
	public String obtenerSkin() {
		return estrategia.obtenerSkin();
	}
	
	public abstract void setEstrategia(int comportamiento);
	
	public void setVelocidad(int v) {
		estrategia.setVelocidad(v);
	}
	public int obtenerVelocidad() {
		return estrategia.obtenerVelocidad();
	}
	
}
