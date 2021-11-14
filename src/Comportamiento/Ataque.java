package Comportamiento;

import Personajes.Enemigo;

public abstract class Ataque extends Comportamiento{
	
	public Ataque(Enemigo enemigo, String skin) {
		super(enemigo, skin);
		velocidad = 2;
	}

	@Override
	public boolean esVulnerable() {
		return false;
	}
	
	@Override
	public abstract void moverSiguientePos();
}
