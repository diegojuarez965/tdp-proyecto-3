package Entidad;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Entidad {
	
	private Posicion p;
	private String skin;
	private Visitor visitor;
	private int alto= 40;
	private int ancho= 40;
	
	public Entidad(Posicion p,String skin,Visitor visitor) {
		this.p=p;
		this.skin=skin;
		this.visitor=visitor;
	}
	
	public Posicion obtenerPosicion() {
		return p;
	}
	
	public String obtenerSkin() {
		return skin;
	}
	
	public Visitor obtenerVisitor() {
		return visitor;
	}
	
	public int obtenerAlto() {
		return alto;
	}
	
	public int obtenerAncho() {
		return ancho;
	}
	
	public abstract void accept(Visitor v);
	
}
