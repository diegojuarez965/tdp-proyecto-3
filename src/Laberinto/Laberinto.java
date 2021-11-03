package Laberinto;

import java.math.MathContext;
import java.util.List;

import Entidad.Entidad;
import Estado.Normal;
import Juego.Juego;
import Loot.Loot;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;
import Posicion.Posicion;

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
		juego.actualizarEntidadVisual(personaje);
	}
	private void moverDer() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[(posicion.obtenerX()/40)+1][posicion.obtenerY()/40];
		if(posicion.obtenerY()%40==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor()))
					posicion.setX(posicion.obtenerX()+personaje.obtenerVelocidad());
			}
			else
				posicion.setX(posicion.obtenerX()+personaje.obtenerVelocidad());
		} 
			
	}
	private void moverIzq() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[(int) Math.round(Math.ceil((double)posicion.obtenerX()/40))-1][posicion.obtenerY()/40];
		if(posicion.obtenerY()%40==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor()))
					posicion.setX(posicion.obtenerX()-personaje.obtenerVelocidad());
			}
			else
				posicion.setX(posicion.obtenerX()-personaje.obtenerVelocidad());
		}
	}
	private void moverArriba() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[posicion.obtenerX()/40][(int) Math.round(Math.ceil((double)posicion.obtenerY()/40))-1];
		if(posicion.obtenerX()%40==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor()))
					posicion.setY(posicion.obtenerY()-personaje.obtenerVelocidad());
			}
			else
				posicion.setY(posicion.obtenerY()-personaje.obtenerVelocidad());
		}
	}
	private void moverAbajo() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[posicion.obtenerX()/40][(posicion.obtenerY()/40)+1];
		if(posicion.obtenerX()%40==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor()))
					posicion.setY(posicion.obtenerY()+personaje.obtenerVelocidad());
			}
			else
				posicion.setY(posicion.obtenerY()+personaje.obtenerVelocidad());
		}
	}
	
	public void agregarEnemigo(Enemigo e) {
		enemigos.add(e);
		juego.mostrarEntidadVisual(e);
	}
	public void agregarLoot(Loot e) {
		int x = e.obtenerPosicion().obtenerX()/e.obtenerPosicion().obtenerAncho();
		int y = e.obtenerPosicion().obtenerY()/e.obtenerPosicion().obtenerAlto();
		entidades[x][y] = e;
		juego.mostrarEntidadVisual(e);
		lootRestante++;
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
	public void actualizarEntidadVisual(Entidad e) {
		juego.actualizarEntidadVisual(e);
	}
}
