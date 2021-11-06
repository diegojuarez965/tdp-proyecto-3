package Personajes;

import Posicion.Posicion;
import Visitor.Visitor;
import Estado.Estado;
import Laberinto.Laberinto;
import Loot.Loot;

public class PersonajePrincipal extends Personaje{

	protected String skinVeloz;
	protected int vidas;
	protected int explosivos;
	protected Estado estado;
	
	public PersonajePrincipal(Posicion p, String skin, String skinVeloz) {
		super(p, skin);
		this.skinVeloz = skinVeloz;
		vidas = 3;
		explosivos = 0;
	}
	
	public void moverVisual() {
		laberinto.actualizarEntidadVisual(this);
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
		return false;
	}
	public void sumarExplosivo() {
		explosivos++;
	}
	public void restarExplosivo() {
		explosivos--;
	}
	public int getExplosivos() {
		return explosivos;
	}
	public void sumarVidas() {
		vidas++;
	}
	public void restarVida() {
		vidas--;
	}
	public int getVidas() {
		return vidas;
	}
	public void sumarPuntos(int puntos) {
		//laberinto.sumarPuntos(puntos);
	}
	public void consumirLoot(Loot l) {
		//laberinto.eliminarLoot(l);
	}
	public void activarInvencible() {
		//laberinto.activarEnemigosVulnerables();
	}
	public void desactivarInvencible() {
		//laberinto.desactivarEnemigosVulnerables();
	}
	
}
