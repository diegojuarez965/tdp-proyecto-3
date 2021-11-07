package Visitor;

import java.util.Timer;

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
                5000 
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
                        	e.setEstrategia(new Ataque());
                        	e.aumentarVelocidad();
                        	lab.actualizarEntidadVisual(e);
                        }
                        t.cancel();
                    }
                }, 
                8000 
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
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPared(Pared p) {
		//No hago nada
	}
	
}
