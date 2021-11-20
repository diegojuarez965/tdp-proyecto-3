package Factory;

import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo1;
import Personajes.Enemigo2;
import Personajes.Enemigo3;
import Personajes.Enemigo4;
import Personajes.PersonajePrincipal;
import Sonido.Musica;

public interface FactoryTemas {

	public Enemigo1 nuevoEnemigo1();

	public Enemigo2 nuevoEnemigo2();

	public Enemigo3 nuevoEnemigo3();

	public Enemigo4 nuevoEnemigo4();

	public PersonajePrincipal nuevoPersonajePrincipal();

	public Pared nuevoPared();

	public Loot1 nuevoLoot1();

	public Loot2 nuevoLoot2Nivel1();

	public Loot2 nuevoLoot2Nivel2();

	public Loot2 nuevoLoot2Nivel3();

	public LootEspecial1 nuevoLootEspecial1();

	public PocionVelocidad nuevoPocionVelocidad();

	public Explosivo nuevoExplosivo();

	public Musica nuevoMusica();

	public String efectoDot();

	public String efectoPower();

	public String efectoFruit();

	public String efectoPocionVelocidad();

	public String efectoExplosivo();

	public String efectoExplosionInicio();

	public String efectoExplosionFin();

	public String efectoMuertePersonaje();

	public String efectoMuerteEnemigo();

	public String toString();
	
}
