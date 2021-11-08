package Laberinto;

import java.math.MathContext;
import java.util.LinkedList;
import java.util.List;
import Entidad.Entidad;
import Estado.Normal;
import Hilo.Hilo;
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
	private Hilo controladorEnemigos;
	
	public static final int MOVER_ABAJO = 0;
	public static final int MOVER_ARRIBA = 1;
	public static final int MOVER_DERECHA = 2;
	public static final int MOVER_IZQUIERDA = 3;
	
	public Laberinto(Juego j) {
		juego = j;
		lootRestante = 0;
		entidades = new Entidad[20][20];
		enemigos = new LinkedList<Enemigo>();
		controladorEnemigos = new Hilo(this);
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
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[(posicion.obtenerX()/posicion.obtenerAncho())+1][posicion.obtenerY()/posicion.obtenerAlto()];
		if(posicion.obtenerY()%posicion.obtenerAlto()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor())) {
					posicion.setX(posicion.obtenerX()+personaje.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setX(posicion.obtenerX()+personaje.obtenerVelocidad());
				checkearColision();
			}
		} 	
	}
	private void moverIzq() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[(int) Math.round(Math.ceil((double)posicion.obtenerX()/posicion.obtenerAncho()))-1][posicion.obtenerY()/posicion.obtenerAlto()];
		if(posicion.obtenerY()%posicion.obtenerAlto()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor())) {
					posicion.setX(posicion.obtenerX()-personaje.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setX(posicion.obtenerX()-personaje.obtenerVelocidad());
				checkearColision();
			}
		}
	}
	private void moverArriba() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[posicion.obtenerX()/posicion.obtenerAncho()][(int) Math.round(Math.ceil((double)posicion.obtenerY()/posicion.obtenerAlto()))-1];
		if(posicion.obtenerX()%posicion.obtenerAncho()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor())) {
					posicion.setY(posicion.obtenerY()-personaje.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setY(posicion.obtenerY()-personaje.obtenerVelocidad());
				checkearColision();
			}
		}
	}
	private void moverAbajo() {
		Posicion posicion = personaje.obtenerPosicion();
		Entidad entidadTemp = entidades[posicion.obtenerX()/posicion.obtenerAncho()][(posicion.obtenerY()/posicion.obtenerAlto())+1];
		if(posicion.obtenerX()%posicion.obtenerAncho()==0) {
			if(entidadTemp!=null) {
				if(entidadTemp.accept(personaje.obtenerVisitor())) {
					posicion.setY(posicion.obtenerY()+personaje.obtenerVelocidad());
					checkearColision();
				}
			}
			else {
				posicion.setY(posicion.obtenerY()+personaje.obtenerVelocidad());
				checkearColision();
			}
		}
	}
	private void checkearColision() {
		juego.actualizarEntidadVisual(personaje);
		for(Enemigo e : enemigos) 
			if(e.obtenerPosicion().colisionan(personaje.obtenerPosicion())) {
				e.accept(personaje.obtenerVisitor());
				break;
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
	public PersonajePrincipal obtenerPersonajePrincipal() {
		return personaje;
	}
	public Iterable<Enemigo> obtenerEnemigos(){
		return enemigos;
	}
	public int obtenerLootRestante() {
		return lootRestante;
	}
	public void pasarNivel() {
		controladorEnemigos.parar();
		for(int i = 0; i<20; i++)
			for(int j = 0; j<20; j++) 
				if(entidades[i][j]!=null) 
					juego.eliminarEntidadVisual(entidades[i][j]);
		for(Enemigo e : enemigos) 
			juego.eliminarEntidadVisual(e);
		juego.eliminarEntidadVisual(personaje);
		juego.pasarNivel();
	}
	public void iniciar() {
		controladorEnemigos.start();
	}
	public void restarVida() {
		for(Enemigo e : enemigos)
			juego.eliminarEntidadVisual(e);
		enemigos = new LinkedList<Enemigo>();
		juego.eliminarEntidadVisual(personaje);
		juego.restarVida();
	}
	public void sumarExplosivo() {
		juego.sumarExplosivo();
	}
	public void eliminarLoot(Loot l) {
		juego.eliminarEntidadVisual(l);
		lootRestante--;
		entidades[l.obtenerPosicion().obtenerX()/l.obtenerPosicion().obtenerAncho()][l.obtenerPosicion().obtenerY()/l.obtenerPosicion().obtenerAlto()] = null;
		if(lootRestante==0)
			pasarNivel();
	}
	public void sumarPuntos(int puntos) {
		juego.sumarPuntos(puntos);
	}
	
}
