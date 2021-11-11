package Entidad;
import Posicion.Posicion;
import Visitor.Visitor;

public abstract class Entidad {
	
	protected Posicion p;
	protected String skin;
	protected Visitor visitor;
	
	public Entidad(Posicion p,String skin) {
		this.p=p;
		this.skin=skin;
	}
	
	public Visitor obtenerVisitor() {
		return visitor;
	}
	public Posicion obtenerPosicion() {
		return p;
	}
	public void setVisitor(Visitor v) {
		visitor=  v;
	}
	
	public abstract String obtenerSkin();
	
	public abstract void accept(Visitor v);
	
}
