package Comportamiento;

import Personajes.Enemigo;

public class Huida implements Comportamiento{

	@Override
	public void moverSiguientePos(Enemigo e) {
		e.moverSigPosHuida();
	}

	@Override
	public String obtenerSkin(Enemigo e) {
		return e.obtenerSkinHuida();
	}

}
