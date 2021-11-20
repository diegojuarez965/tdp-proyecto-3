package Visitor;

import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.PersonajePrincipal;

public interface Visitor {

	public void visitPocionVelocidad(PocionVelocidad pV);

	public void visitExplosivo(Explosivo e);

	public void visitLootEspecial1(LootEspecial1 l);

	public void visitLoot1(Loot1 l);

	public void visitLoot2(Loot2 l);

	public void visitPared(Pared p);

	public void visitPersonajePrincipal(PersonajePrincipal p);

	public void visitEnemigo(Enemigo e);

}
