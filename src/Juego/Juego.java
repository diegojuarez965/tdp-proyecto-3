package Juego;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Timer;

import Builder.ConstructorLaberinto;
import Builder.ConstructorNivel1;
import Builder.ConstructorNivel2;
import Builder.ConstructorNivel3;
import Builder.Director;
import Entidad.Entidad;
import Factory.FactoryTemas;
import GUI.GUI;
import Hilo.ControladorMovimiento;
import Laberinto.Laberinto;
import Loot.Explosivo;
import Personajes.Enemigo;
import Posicion.Posicion;
import Ranking.Ranking;
import Sonido.Efectos;
import Sonido.Musica;
import Sonido.ReproductorSonido;

public class Juego {
	
	private GUI gui;
	private FactoryTemas tema;
	private Director director;
	private Laberinto laberinto;
	private int nivel, puntos, vidas, explosivos;
	private boolean efectosActivados;
	private Musica musica;
	private Efectos efectos;
	private ConstructorLaberinto constructor;
	private HashMap<Timer, Entidad> TimersExplosivos;
	private Ranking ranking;
	private String jugador;
	
	public Juego() {
		nivel = 1;
		puntos = 0;
		vidas = 3;
		explosivos = 0;
		efectosActivados = true;
		TimersExplosivos = new HashMap<Timer, Entidad>();
		efectos = new Efectos();
		ranking = new Ranking();
	}
	public void setGUI(GUI g) {
		gui = g;
	}
	public void setTema(FactoryTemas tema) {
		this.tema = tema;
	}
	public void setMusica(Musica sonido) {
		musica=sonido;
	}
	public void mover(int direccion) {
		ControladorMovimiento.moverPersonaje(laberinto.obtenerPersonajePrincipal(), direccion);
	}
	public void actualizarEntidadVisual(Entidad e) {
		gui.actualizarEntidadVisual(e);
	}
	public void mostrarEntidadVisual(Entidad e) {
		gui.mostrarEntidadVisual(e);
	}
	public void eliminarEntidadVisual(Entidad e) {
		gui.eliminarEntidadVisual(e);
	}
	public void pasarNivel() {
		for(Entry<Timer, Entidad> e : TimersExplosivos.entrySet()) {
			e.getKey().cancel();
			gui.eliminarEntidadVisual(e.getValue());
		}
		TimersExplosivos = new HashMap<Timer, Entidad>();
		if(nivel>3)
			finalizarJuego();
		else {
			if(nivel==1)
				constructor = new ConstructorNivel1(tema);
			else if(nivel==2)
				constructor = new ConstructorNivel2(tema);
			else if(nivel==3)
				constructor = new ConstructorNivel3(tema);
			nivel++;
			director = new Director(constructor);
			director.nuevoNivel(this);
			laberinto = constructor.obtenerLaberinto();
			laberinto.iniciar();
			gui.resetProgreso();
			gui.setMaxProgreso(laberinto.obtenerLootRestante());
		}
	}
	public void reproducirMusica() {
		musica.play();
	}
	public void reproducirSonido(String efecto) {
		if(efectosActivados)
			efectos.playEfecto(efecto);
	}
	public void pararMusica() {
		musica.stop();
	}
	public void pararEfectos() {
		efectosActivados = false;
	}
	public void activarEfectos() {
		efectosActivados = true;
	}
	public FactoryTemas obtenerTema() {
		return tema;
	}
	public int obtenerPuntos() {
		return puntos;
	}
	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
		gui.setPuntaje(this.puntos);
		gui.incrementarProgreso();
	}
	public void restarVida() {
		vidas--;
		gui.setVidas(vidas);
		if(vidas==0)
			finalizarJuego();
		else {
			constructor.construirEnemigos();
			constructor.construirPersonaje();
		}
	}
	public void sumarExplosivo() {
		explosivos++;
		gui.setExplosivos(explosivos);
	}
	public void restarExplosivo() {
		explosivos--;
		gui.setExplosivos(explosivos);
	}
	public void ponerExplosivo() {
		if(explosivos>0) {
			restarExplosivo();
			Entidad explosivo = tema.nuevoExplosivo();
			Posicion p = explosivo.obtenerPosicion();
			Posicion pPersonaje = laberinto.obtenerPersonajePrincipal().obtenerPosicion();
			p.setX(pPersonaje.obtenerX());
			p.setY(pPersonaje.obtenerY());
			gui.mostrarEntidadVisual(explosivo);
			p.setAncho(200);
			p.setAlto(200);
			p.setX(p.obtenerX()-p.obtenerAncho()/2);
			p.setY(p.obtenerY()-p.obtenerAlto()/2);
			ReproductorSonido.obtenerInstancia().reproducirExplosivoInicio();
			Timer t = new Timer();
			TimersExplosivos.put(t, explosivo);
	        t.schedule( 
	                new java.util.TimerTask() {
	                    @Override
	                    public void run() {
	                    	
	                        for(Enemigo e: laberinto.obtenerEnemigos()) {
	                        	Posicion pE = e.obtenerPosicion();
	                        	if(pE.colisionan(p)) {
	                        		pE.setX(pE.obtenerAncho()*9);
	                        		pE.setY(pE.obtenerAlto()*9);
	                        		gui.actualizarEntidadVisual(e);
	                        	}
	                        }
	                        ReproductorSonido.obtenerInstancia().reproducirExplosivoFin();
	                        gui.eliminarEntidadVisual(explosivo);
	                        TimersExplosivos.remove(t);
	                        t.cancel();
	                    }
	                }, 
	                4000 
	        );
		}
		
	}
	public void finalizarJuego() {
		pararMusica();
		laberinto.finalizar();
		gui.finalizarJuego();
	}
	public void reiniciarJuego() {
		nivel = 1;
		puntos = 0;
		vidas = 3;
		explosivos = 0;
		laberinto.finalizar();
		pasarNivel();
	}
	public void cargarRanking() {
	    ranking.cargarRanking();
	}
	public void guardarRanking() {
		ranking.agregarJugador(jugador, puntos);
		ranking.guardarRanking();
	}
	public void agregarJugador(String nombre) {
		jugador = nombre;
	}
	public String obtenerRanking() {
		return ranking.toString();
	}
}
