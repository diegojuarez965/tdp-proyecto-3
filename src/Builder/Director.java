package Builder;

import Juego.Juego;

public class Director {

	ConstructorLaberinto c;

	public Director(ConstructorLaberinto cL) {
		c = cL;
	}

	public void cambiarConstructor(ConstructorLaberinto cL) {
		c = cL;
	}

	public void nuevoNivel(Juego j) {
		c.resetBuilder(j);
		c.construirParedes();
		c.construirLoot();
		c.construirPersonaje();
		c.construirEnemigos();
	}
	
}
