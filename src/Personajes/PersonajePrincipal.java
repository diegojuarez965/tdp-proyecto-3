package Personajes;

import Posicion.Posicion;
import Visitor.Visitor;
import Estado.Estado;
import Laberinto.Laberinto;
import Loot.Loot;

public class PersonajePrincipal extends Personaje{

	protected String skinVeloz;
	protected Estado estado;
	
	public PersonajePrincipal(Posicion p, String skin, String skinVeloz) {
		super(p, skin);
		this.skinVeloz = skinVeloz;
	}
	
	public void setEstado(Estado e) {
		estado = e;
	}
	public void setLaberinto(Laberinto lab) {
		laberinto = lab;
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
	public boolean accept(Visitor v) {
		return v.visitPersonajePrincipal(this);
	}
}
