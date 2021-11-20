package Sonido;

import Juego.Juego;

public class ReproductorSonido {

	private Juego juego;
	private static ReproductorSonido rp = new ReproductorSonido();

	private ReproductorSonido() {
	}

	public void setJuego(Juego j) {
		juego = j;
	}

	public static ReproductorSonido obtenerInstancia() {
		return rp;
	}

	public void reproducirLoot1() {
		juego.reproducirSonido(juego.obtenerTema().efectoDot());
	}

	public void reproducirLoot2() {
		juego.reproducirSonido(juego.obtenerTema().efectoFruit());
	}

	public void reproducirLootEspecial1() {
		juego.reproducirSonido(juego.obtenerTema().efectoPower());
	}

	public void reproducirPocionVelocidad() {
		juego.reproducirSonido(juego.obtenerTema().efectoPocionVelocidad());
	}

	public void reproducirExplosivo() {
		juego.reproducirSonido(juego.obtenerTema().efectoExplosivo());
	}

	public void reproducirMuertePersonaje() {
		juego.reproducirSonido(juego.obtenerTema().efectoMuertePersonaje());
	}

	public void reproducirMuerteEnemigo() {
		juego.reproducirSonido(juego.obtenerTema().efectoMuerteEnemigo());
	}

	public void reproducirExplosivoInicio() {
		juego.reproducirSonido(juego.obtenerTema().efectoExplosionInicio());
	}

	public void reproducirExplosivoFin() {
		juego.reproducirSonido(juego.obtenerTema().efectoExplosionFin());
	}

}
