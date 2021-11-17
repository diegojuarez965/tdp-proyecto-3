package Comportamiento;

import Entidad.Entidad;
import Laberinto.Laberinto;
import Personajes.Enemigo;
import Posicion.Posicion;

public abstract class Comportamiento {

	protected Enemigo enemigo;
	protected String skin;
	protected int velocidad;
	
	public Comportamiento(Enemigo enemigo, String skin) {
		this.enemigo = enemigo;
		this.skin = skin;
	}
	
	public String obtenerSkin() {
		return skin;
	}
	
	public int obtenerVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public abstract void moverSiguientePos();
	
	public abstract boolean esVulnerable();
	
	protected boolean moverDer() {
		boolean pudoMoverse = true;
		Posicion posicion = enemigo.obtenerPosicion();
		Laberinto lab =  enemigo.obtenerLaberinto();
		Entidad entidadTemp = lab.obtenerEntidad((posicion.obtenerX()/posicion.obtenerAncho())+1, posicion.obtenerY()/posicion.obtenerAlto());
		if(posicion.obtenerY()%posicion.obtenerAlto()==0) {
			if(entidadTemp!=null) {
				int velocidadTemp = enemigo.obtenerVelocidad();
				entidadTemp.accept(enemigo.obtenerVisitor());
				posicion.setX(posicion.obtenerX()+enemigo.obtenerVelocidad());
				if(enemigo.obtenerVelocidad()==0) {
					enemigo.setVelocidad(velocidadTemp);
					pudoMoverse = false;
				}
				else 
					enemigo.setDireccion(Enemigo.DERECHA);
				checkearColision();
			}
			else {
				enemigo.setDireccion(Enemigo.DERECHA);
				posicion.setX(posicion.obtenerX()+enemigo.obtenerVelocidad());
				checkearColision();
			}
		}
		else {
			pudoMoverse = false;
		}
		return pudoMoverse;
	}
	protected boolean moverIzq() {
		boolean pudoMoverse = true;
		Posicion posicion = enemigo.obtenerPosicion();
		Laberinto lab =  enemigo.obtenerLaberinto();
		Entidad entidadTemp = lab.obtenerEntidad((int) Math.round(Math.ceil((double)posicion.obtenerX()/posicion.obtenerAncho()))-1, posicion.obtenerY()/posicion.obtenerAlto());
		if(posicion.obtenerY()%posicion.obtenerAlto()==0) {
			if(entidadTemp!=null) {
				int velocidadTemp = enemigo.obtenerVelocidad();
				entidadTemp.accept(enemigo.obtenerVisitor());
				posicion.setX(posicion.obtenerX()-enemigo.obtenerVelocidad());
				if(enemigo.obtenerVelocidad()==0) {
					enemigo.setVelocidad(velocidadTemp);
					pudoMoverse = false;
				}
				else
					enemigo.setDireccion(Enemigo.IZQUIERDA);
				checkearColision();
			}
			else {
				enemigo.setDireccion(Enemigo.IZQUIERDA);
				posicion.setX(posicion.obtenerX()-enemigo.obtenerVelocidad());
				checkearColision();
			}
		}
		else {
			pudoMoverse = false;
		}
		return pudoMoverse;
	}
	protected boolean moverArriba() {
		boolean pudoMoverse = true;
		Laberinto lab =  enemigo.obtenerLaberinto();
		Posicion posicion = enemigo.obtenerPosicion();
		Entidad entidadTemp = lab.obtenerEntidad(posicion.obtenerX()/posicion.obtenerAncho(), (int) Math.round(Math.ceil((double)posicion.obtenerY()/posicion.obtenerAlto()))-1);
		if(posicion.obtenerX()%posicion.obtenerAncho()==0) {
			if(entidadTemp!=null) {
				int velocidadTemp = enemigo.obtenerVelocidad();
				entidadTemp.accept(enemigo.obtenerVisitor());
				posicion.setY(posicion.obtenerY()-enemigo.obtenerVelocidad());
				if(enemigo.obtenerVelocidad()==0) {
					enemigo.setVelocidad(velocidadTemp);
					pudoMoverse = false;
				}
				else
					enemigo.setDireccion(Enemigo.ARRIBA);
				checkearColision();
			}
			else {
				enemigo.setDireccion(Enemigo.ARRIBA);
				posicion.setY(posicion.obtenerY()-enemigo.obtenerVelocidad());
				checkearColision();
			}
		}
		else {
			pudoMoverse = false;
		}
		return pudoMoverse;
	}
	protected boolean moverAbajo() {
		boolean pudoMoverse = true;
		Posicion posicion = enemigo.obtenerPosicion();
		Laberinto lab =  enemigo.obtenerLaberinto();
		Entidad entidadTemp = lab.obtenerEntidad(posicion.obtenerX()/posicion.obtenerAncho(), (posicion.obtenerY()/posicion.obtenerAlto())+1);
		if(posicion.obtenerX()%posicion.obtenerAncho()==0) {
			if(entidadTemp!=null) {
				int velocidadTemp = enemigo.obtenerVelocidad();
				entidadTemp.accept(enemigo.obtenerVisitor());
				posicion.setY(posicion.obtenerY()+enemigo.obtenerVelocidad());
				if(enemigo.obtenerVelocidad()==0) {
					enemigo.setVelocidad(velocidadTemp);
					pudoMoverse = false;
				}
				else
					enemigo.setDireccion(Enemigo.ABAJO);
				checkearColision();
			}
			else {
				enemigo.setDireccion(Enemigo.ABAJO);
				posicion.setY(posicion.obtenerY()+enemigo.obtenerVelocidad());
				checkearColision();
			}
		}
		else {
			pudoMoverse = false;
		}
		return pudoMoverse;
	}
	private void checkearColision() {
		Laberinto lab =  enemigo.obtenerLaberinto();
		lab.actualizarEntidadVisual(enemigo);
		if(lab.obtenerPersonajePrincipal()!=null && enemigo.obtenerPosicion().colisionan(lab.obtenerPersonajePrincipal().obtenerPosicion())) 
			enemigo.accept(lab.obtenerPersonajePrincipal().obtenerVisitor());
	}
}
