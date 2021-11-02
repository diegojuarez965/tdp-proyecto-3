package Personajes;

import Posicion.Posicion;
import Visitor.Visitor;
import Estado.Estado;

public class PersonajePrincipal extends Personaje{

	protected String skinVeloz;
	protected int vidas;
	protected int explosivos;
	protected Estado estado;
	
	public PersonajePrincipal(Posicion p, String skin, String skinVeloz) {
		super(p, skin);
		this.skinVeloz = skinVeloz;
	}
	
	public void moverVisual() {
		
	}
	
	public void setEstado(Estado e) {
		estado = e;
	}
	
	public String obtenerSkinNormal() {
		return skin;
	}
	public String obtenerSkinVeloz() {
		return skinVeloz;
	}

	@Override
	public String obtenerSkin() {
		return estado.obtenerSkin(this);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
