package Comportamiento;

import Personajes.Enemigo;

public class Huida extends Comportamiento{
	
	public Huida(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		velocidad = 5;
	}
	
	@Override
	public void moverSiguientePos() {
		
	}

	@Override
	public boolean esVulnerable() {
		return true;
	}
	
}
