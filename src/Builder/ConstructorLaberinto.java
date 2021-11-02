package Builder;

import Juego.Juego;
import Laberinto.Laberinto;

public interface ConstructorLaberinto {
	
	
	public void reset(Juego j);
	
	public void construirParedes();
	
	public void construirLoot();
	
	public void construirEnemigos();
	
	public void construirPersonaje();
	
	public Laberinto obtenerLaberinto();
	
	
}
