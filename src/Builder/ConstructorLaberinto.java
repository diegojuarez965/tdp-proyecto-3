package Builder;

import Juego.Juego;
import Laberinto.Laberinto;

public interface ConstructorLaberinto {

	public void resetBuilder(Juego j);

	public void construirParedes();

	public void construirLoot();

	public void construirEnemigos();

	public void construirPersonaje();

	public Laberinto obtenerLaberinto();

}
