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
		Random r = new Random();
		Integer direccion = r.nextInt(4);
		switch (direccion) {
		case 0: {
			moverAbajo();
			break;
		}
		case 1: {
			moverArriba();
			break;
		}
		case 2: {
			moverDer();
			break;
		}
		case 3: {
			moverIzq();
			break;
		}
		}
	}
	private void moverDer() {
		Posicion posicion = this.obtenerPosicion();
		Entidad entidadTemp = laberinto.obtenerEntidad((posicion.obtenerX()/posicion.obtenerAncho())+1,posicion.obtenerY()/posicion.obtenerAlto());
		if(posicion.obtenerY()%posicion.obtenerAlto()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(this.obtenerVisitor())) {
					posicion.setX(posicion.obtenerX()+this.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setX(posicion.obtenerX()+this.obtenerVelocidad());
				checkearColision();
			}
		} 	
	}
	private void moverIzq() {
		Posicion posicion = this.obtenerPosicion();
		Entidad entidadTemp = laberinto.obtenerEntidad((int) Math.round(Math.ceil((double)posicion.obtenerX()/posicion.obtenerAncho()))-1,posicion.obtenerY()/posicion.obtenerAlto());
		if(posicion.obtenerY()%posicion.obtenerAlto()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(this.obtenerVisitor())) {
					posicion.setX(posicion.obtenerX()-this.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setX(posicion.obtenerX()-this.obtenerVelocidad());
				checkearColision();
			}
		}
	}
	private void moverArriba() {
		Posicion posicion = this.obtenerPosicion();
		Entidad entidadTemp = laberinto.obtenerEntidad(posicion.obtenerX()/posicion.obtenerAncho(),(int) Math.round(Math.ceil((double)posicion.obtenerY()/posicion.obtenerAlto()))-1);
		if(posicion.obtenerX()%posicion.obtenerAncho()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(this.obtenerVisitor())) {
					posicion.setY(posicion.obtenerY()-this.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setY(posicion.obtenerY()-this.obtenerVelocidad());
				checkearColision();
			}
		}
	}
	private void moverAbajo() {
		Posicion posicion = this.obtenerPosicion();
		Entidad entidadTemp = laberinto.obtenerEntidad(posicion.obtenerX()/posicion.obtenerAncho(),(posicion.obtenerY()/posicion.obtenerAlto())+1);
		if(posicion.obtenerX()%posicion.obtenerAncho()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(this.obtenerVisitor())) {
					posicion.setY(posicion.obtenerY()+this.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setY(posicion.obtenerY()+this.obtenerVelocidad());
				checkearColision();
			}
		}
	}
	private void checkearColision() {
		laberinto.actualizarEntidadVisual(this);
		if(laberinto.obtenerPersonajePrincipal().obtenerPosicion().colisionan(this.obtenerPosicion()))
			this.accept(laberinto.obtenerPersonajePrincipal().obtenerVisitor());
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
