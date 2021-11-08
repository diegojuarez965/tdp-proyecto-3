package Juego;

import java.util.Timer;

import Builder.ConstructorLaberinto;
import Builder.ConstructorNivel1;
import Builder.ConstructorNivel2;
import Builder.ConstructorNivel3;
import Builder.Director;
import Entidad.Entidad;
import Factory.FactoryTemas;
import GUI.GUI;
import Hilo.Hilo;
import Laberinto.Laberinto;
import Loot.Explosivo;
import Personajes.Enemigo;
import Posicion.Posicion;
import Sonido.Sonido;

public class Juego {
	
	private GUI gui;
	private FactoryTemas tema;
	private Director director;
	private Laberinto laberinto;
	private int nivel, puntos, vidas, explosivos;
	private boolean musica, efectos;
	private Sonido sonido;
	private ConstructorLaberinto constructor;
	private Hilo hilo;
	
	public Juego() {
		nivel = 1;
		puntos = 0;
		vidas = 3;
		explosivos = 0;
		musica = true;
		efectos = true;
		sonido = new Sonido();
	}
	
	public void setGUI(GUI g) {
		gui = g;
	}
	public void setTema(FactoryTemas tema) {
		this.tema = tema;
	}
	public void mover(int direccion) {
		laberinto.mover(direccion);
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
		if(hilo!=null)
			hilo.parar();
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
			hilo= new Hilo(laberinto);
			gui.resetProgreso();
			gui.setMaxProgreso(laberinto.obtenerLootRestante());
			hilo.start();
		}
	}
	public void reproducirMusica() {
		
	}
	public void reproducirSonido(String efecto) {
		
	}
	public void pararMusica() {
		
	}
	public void pararEfectos() {
		
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
			Timer t = new Timer();
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
	                        		//ver si hacemos una animacion que salen de la caja
	                        	}
	                        }
	                        gui.eliminarEntidadVisual(explosivo);
	                        t.cancel();
	                    }
	                }, 
	                4000 
	        );
		}
		
	}
	public void finalizarJuego() {
		
	}
}
