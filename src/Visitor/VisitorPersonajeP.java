package Visitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

import Builder.ConstructorLaberinto;
import Builder.ConstructorNivel1;
import Comportamiento.Ataque;
import Comportamiento.Huida;
import Estado.Normal;
import Estado.Veloz;
import Laberinto.Laberinto;
import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;
import Posicion.Posicion;
import Sonido.ReproductorSonido;

public class VisitorPersonajeP implements Visitor{
	
	private PersonajePrincipal personaje;
	private Timer timerLootEspecial = null;
	private Timer timerPocionVelocidad = null;
	
	public VisitorPersonajeP(PersonajePrincipal p) {
		personaje = p;
	}

	@Override
	public void visitPocionVelocidad(PocionVelocidad pV) {
		if(timerPocionVelocidad!=null)
			timerPocionVelocidad.cancel();
		Laberinto lab = personaje.obtenerLaberinto();
		lab.eliminarLoot(pV);
		ReproductorSonido.obtenerInstancia().reproducirPocionVelocidad();
		PersonajePrincipal p = lab.obtenerPersonajePrincipal();
		p.setEstado(PersonajePrincipal.VELOZ);
		lab.actualizarEntidadVisual(p);
		p.aumentarVelocidad();
		timerPocionVelocidad = new Timer();
		timerPocionVelocidad.schedule( 
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        p.setEstado(PersonajePrincipal.NORMAL);
                        p.disminuirVelocidad();
                        lab.actualizarEntidadVisual(p);
                        timerPocionVelocidad.cancel();
                        timerPocionVelocidad=null;
                    }
                }, 
                10000 
        );
	}

	@Override
	public void visitExplosivo(Explosivo e) {
		Laberinto lab = personaje.obtenerLaberinto();
		lab.eliminarLoot(e);
		lab.sumarExplosivo();
		ReproductorSonido.obtenerInstancia().reproducirExplosivo();
	}

	@Override
	public void visitLootEspecial1(LootEspecial1 l) {
		if(timerLootEspecial!=null)
			timerLootEspecial.cancel();
		Laberinto lab = personaje.obtenerLaberinto();
		lab.eliminarLoot(l);
		ReproductorSonido.obtenerInstancia().reproducirLootEspecial1();
		for(Enemigo e : lab.obtenerEnemigos()) {
			e.setEstrategia(Enemigo.HUIDA);
			e.disminuirVelocidad();
			lab.actualizarEntidadVisual(e);
		}
		timerLootEspecial = new Timer();
		timerLootEspecial.schedule( 
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        for(Enemigo e: lab.obtenerEnemigos()) {
                        	e.setEstrategia(Enemigo.ATAQUE);
                        	e.aumentarVelocidad();
                        	lab.actualizarEntidadVisual(e);
                        }
                        timerLootEspecial.cancel();
                        timerLootEspecial = null;
                    }
                }, 
                15000 
        );
	}

	@Override
	public void visitLoot1(Loot1 l) {
		Laberinto lab = personaje.obtenerLaberinto();
		lab.sumarPuntos(l.obtenerPuntaje());
		lab.eliminarLoot(l);
		ReproductorSonido.obtenerInstancia().reproducirLoot1();
	}

	@Override
	public void visitLoot2(Loot2 l) {
		Laberinto lab = personaje.obtenerLaberinto();
		lab.sumarPuntos(l.obtenerPuntaje());
		lab.eliminarLoot(l);
		ReproductorSonido.obtenerInstancia().reproducirLoot2();
	}

	@Override
	public boolean visitPersonajePrincipal(PersonajePrincipal p) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized boolean visitEnemigo(Enemigo e) {
		boolean puedeMoverse;
		Laberinto lab = personaje.obtenerLaberinto();
		if(e.esVulnerable()) {
			ReproductorSonido.obtenerInstancia().reproducirMuerteEnemigo();
			Posicion posEnemigo = e.obtenerPosicion();
			posEnemigo.setX(posEnemigo.obtenerAncho()*9);
			posEnemigo.setY(posEnemigo.obtenerAlto()*9);
			lab.actualizarEntidadVisual(e);
			puedeMoverse = true;
		}
		else {
			ReproductorSonido.obtenerInstancia().reproducirMuertePersonaje();
			lab.restarVida();
			puedeMoverse = false;
		}
		
		return puedeMoverse;
	}

	@Override
	public void visitPared(Pared p) {
		//No hago nada
	}
	
}
