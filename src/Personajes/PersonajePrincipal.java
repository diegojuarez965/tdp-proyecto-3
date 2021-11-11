package Personajes;

import Posicion.Posicion;
import Visitor.Visitor;
import Estado.Estado;
import Estado.Normal;
import Estado.Veloz;
import Laberinto.Laberinto;
import Loot.Loot;

public class PersonajePrincipal extends Personaje{

	protected String skinVeloz;
	protected Estado estado;
	
	public final static int NORMAL = 0;
	public final static int VELOZ = 1;
	
	public PersonajePrincipal(Posicion p, String skin, String skinVeloz) {
		super(p, skin);
		this.skinVeloz = skinVeloz;
	}
	
	public void setEstado(int estado) {
		switch (estado) {
			case NORMAL:{
				this.estado = new Normal(this,skin);
				break;
			}
			case VELOZ:{
				this.estado = new Veloz(this,skinVeloz);
				break;
			}
		}
	}
	public String obtenerSkinNormal() {
		return skin;
	}
	public String obtenerSkinVeloz() {
		return skinVeloz;
	}
	@Override
	public String obtenerSkin() {
		return estado.obtenerSkin();
	}
	@Override
	public boolean accept(Visitor v) {
		return v.visitPersonajePrincipal(this);
	}
}
