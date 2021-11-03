package Visitor;

import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;

public class VisitorPersonajeP implements Visitor{
	
	private PersonajePrincipal personaje;
	
	public VisitorPersonajeP(PersonajePrincipal p) {
		personaje = p;
	}

	@Override
	public void visitPocionVelocidad(PocionVelocidad pV) {
		
	}

	@Override
	public void visitExplosivo(Explosivo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLootEspecial1(LootEspecial1 l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLoot1(Loot1 l) {
		
	}

	@Override
	public void visitLoot2(Loot2 l) {
		
	}

	@Override
	public void visitPersonajePrincipal(PersonajePrincipal p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPared(Pared p) {
		//No hago nada
	}
	
}
