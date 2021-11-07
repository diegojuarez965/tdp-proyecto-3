package Visitor;

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

public class VisitorPersonajeP implements Visitor{
	
	private PersonajePrincipal personaje;
	
	public VisitorPersonajeP(PersonajePrincipal p) {
		personaje = p;
	}

	@Override
	public void visitPocionVelocidad(PocionVelocidad pV) {
		Laberinto lab = personaje.obtenerLaberinto();
		lab.eliminarLoot(pV);
		PersonajePrincipal p = lab.obtenerPersonajePrincipal();
		p.setEstado(new Veloz());
		lab.actualizarEntidadVisual(p);
		p.aumentarVelocidad();
		Timer t = new Timer();
        t.schedule( 
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        p.setEstado(new Normal());
                        p.disminuirVelocidad();
                        lab.actualizarEntidadVisual(p);
                        t.cancel();
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
	}

	@Override
	public void visitLootEspecial1(LootEspecial1 l) {
		Laberinto lab = personaje.obtenerLaberinto();
		lab.eliminarLoot(l);
		for(Enemigo e : lab.obtenerEnemigos()) {
			e.setVulnerable(true);
			e.setEstrategia(new Huida());
			e.disminuirVelocidad();
			lab.actualizarEntidadVisual(e);
		}
		Timer t = new Timer();
        t.schedule( 
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        for(Enemigo e: lab.obtenerEnemigos()) {
                        	e.setVulnerable(false);
                        	e.setEstrategia(new Ataque());
                        	e.aumentarVelocidad();
                        	lab.actualizarEntidadVisual(e);
                        }
                        t.cancel();
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
	}

	@Override
	public void visitLoot2(Loot2 l) {
		Laberinto lab = personaje.obtenerLaberinto();
		lab.sumarPuntos(l.obtenerPuntaje());
		lab.eliminarLoot(l);
	}

	@Override
	public boolean visitPersonajePrincipal(PersonajePrincipal p) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		boolean puedeMoverse;
		Laberinto lab = personaje.obtenerLaberinto();
		if(e.esVulnerable()) {
			Posicion posEnemigo = e.obtenerPosicion();
			posEnemigo.setX(posEnemigo.obtenerAncho()*9);
			posEnemigo.setY(posEnemigo.obtenerAlto()*9);
			lab.actualizarEntidadVisual(e);
			puedeMoverse = true;
		}
		else {
			/*ConstructorLaberinto constructor = lab.obtenerConstructor();
			for(Enemigo enemigos : lab.obtenerEnemigos())
				lab.eliminarEntidadVisual(enemigos);
			lab.eliminarEntidadVisual(lab.obtenerPersonajePrincipal());
			constructor.construirEnemigos();
			constructor.construirPersonaje();*/
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
