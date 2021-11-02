package Laberinto;

import java.util.List;

import Entidad.Entidad;
import Juego.Juego;
import Loot.Loot;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;

public class Laberinto {
	
	private int lootRestante;
	private Juego juego;
	private Entidad[][] entidades;
	private List<Enemigo> enemigos;
	private PersonajePrincipal personaje;
	
	public static final int MOVER_ABAJO = 0;
	public static final int MOVER_ARRIBA = 1;
	public static final int MOVER_DERECHA = 2;
	public static final int MOVER_IZQUIERDA = 3;
	
	public Laberinto(Juego j) {
		juego = j;
		lootRestante = 0;
		entidades = new Entidad[20][20];
	}
	
	public synchronized void mover(int direccion) {
		switch (direccion) {
			case MOVER_ABAJO: {
				moverAbajo();
				break;
			}
			case MOVER_ARRIBA: {
				moverArriba();
				break;
			}
			case MOVER_DERECHA: {
				moverDer();
				break;
			}
			case MOVER_IZQUIERDA: {
				moverIzq();
				break;
			}
		}
	}
	private void moverDer() {
		
	}
	private void moverIzq() {
		
	}
	private void moverArriba() {
		
	}
	private void moverAbajo() {
		
	}
	
	public void agregarEnemigo(Enemigo e) {
		enemigos.add(e);
		juego.mostrarEntidadVisual(e);
	}
	public void agregarLoot(Loot e) {
		int x = e.obtenerPosicion().obtenerX();
		int y = e.obtenerPosicion().obtenerY();
		entidades[x][y] = e;
		juego.mostrarEntidadVisual(e);
	}
	public void agregarPared(Pared p) {
		int x = p.obtenerPosicion().obtenerX()/p.obtenerPosicion().obtenerAncho();
		int y = p.obtenerPosicion().obtenerY()/p.obtenerPosicion().obtenerAlto();
		entidades[x][y] = p;
		juego.mostrarEntidadVisual(p);
	}
	public void agregarPersonajeP(PersonajePrincipal p) {
		personaje = p;
		juego.mostrarEntidadVisual(p);
	}
}
