package Visitor;

import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;

public class VisitorEnemigo implements Visitor{
	
	private Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e) {
		enemigo =  e;
	}

	@Override
	public void visitPocionVelocidad(PocionVelocidad pV) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitLoot2(Loot2 l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean visitPersonajePrincipal(PersonajePrincipal p) {
		return false;
	}

	@Override
	public boolean visitEnemigo(Enemigo e) {
		return false;
	}

	@Override
	public void visitPared(Pared p) {
		enemigo.quitarVelocidad();
	}
	
}
