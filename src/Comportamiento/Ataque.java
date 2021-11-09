package Comportamiento;

import Personajes.Enemigo;

public class Ataque implements Comportamiento{

	@Override
	public void moverSiguientePos(Enemigo e) {
		
	}

	@Override
	public String obtenerSkin(Enemigo e) {
		return e.obtenerSkinAtaque();
	}

	@Override
	public boolean esVulnerable() {
		return false;
	}

}
