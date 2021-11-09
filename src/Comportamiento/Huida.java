package Comportamiento;

import Personajes.Enemigo;

public class Huida implements Comportamiento{

	private String skin;
	
	
	@Override
	public void moverSiguientePos(Enemigo e) {
		
	}

	@Override
	public String obtenerSkin(Enemigo e) {
		return e.obtenerSkinHuida();
	}

	@Override
	public boolean esVulnerable() {
		return true;
	}

}
