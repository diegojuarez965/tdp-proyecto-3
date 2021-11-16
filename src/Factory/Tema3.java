package Factory;

import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.Loot2Nivel1;
import Loot.Loot2Nivel2;
import Loot.Loot2Nivel3;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo1;
import Personajes.Enemigo2;
import Personajes.Enemigo3;
import Personajes.Enemigo4;
import Personajes.PersonajePrincipal;
import Posicion.Posicion;
import Posicion.PosicionLogica;
import Sonido.Musica;
import Visitor.VisitorEnemigo;
import Visitor.VisitorExplosivo;
import Visitor.VisitorLoot1;
import Visitor.VisitorLoot2;
import Visitor.VisitorLootEspecial1;
import Visitor.VisitorPared;
import Visitor.VisitorPersonajeP;
import Visitor.VisitorPocionV;

public class Tema3 implements FactoryTemas{
	
	@Override
	public Enemigo1 nuevoEnemigo1() {
		Enemigo1 enemigo;
		String skinNormal = "/images/amongBlinkyAtaque.png";
		String skinHuida = "/images/amongHuida.png";
		Posicion p = new PosicionLogica(0, 0);
		enemigo = new Enemigo1(p, skinNormal, skinHuida);
		enemigo.setVisitor(new VisitorEnemigo(enemigo));
		return enemigo;
	}

	@Override
	public Enemigo2 nuevoEnemigo2() {
		Enemigo2 enemigo;
		String skinNormal = "/images/amongInkyAtaque.png";
		String skinHuida = "/images/amongHuida.png";
		Posicion p = new PosicionLogica(0, 0);
		enemigo = new Enemigo2(p, skinNormal, skinHuida);
		enemigo.setVisitor(new VisitorEnemigo(enemigo));
		return enemigo;
	}

	@Override
	public Enemigo3 nuevoEnemigo3() {
		Enemigo3 enemigo;
		String skinNormal = "/images/amongPinkyAtaque.png";
		String skinHuida = "/images/amongHuida.png";
		Posicion p = new PosicionLogica(0, 0);
		enemigo = new Enemigo3(p, skinNormal, skinHuida);
		enemigo.setVisitor(new VisitorEnemigo(enemigo));
		return enemigo;
	}

	@Override
	public Enemigo4 nuevoEnemigo4() {
		Enemigo4 enemigo;
		String skinNormal = "/images/amongClydeAtaque.png";
		String skinHuida = "/images/amongHuida.png";
		Posicion p = new PosicionLogica(0, 0);
		enemigo = new Enemigo4(p, skinNormal, skinHuida);
		enemigo.setVisitor(new VisitorEnemigo(enemigo));
		return enemigo;
	}

	@Override
	public PersonajePrincipal nuevoPersonajePrincipal() {
		PersonajePrincipal personaje;
		String skinNormal = "/images/amongSkinNormal.png";
		String skinVeloz = "/images/amongSkinVeloz.png";
		Posicion p = new PosicionLogica(0, 0);
		personaje = new PersonajePrincipal(p, skinNormal, skinVeloz);
		personaje.setVisitor(new VisitorPersonajeP(personaje));
		return personaje;
	}

	@Override
	public Loot1 nuevoLoot1() {
		Loot1 loot1;
		String skinLoot1 = "/images/amongPacDot.png";
		Posicion p = new PosicionLogica(0, 0);
		loot1 = new Loot1(p,skinLoot1);
		loot1.setVisitor(new VisitorLoot1(loot1));
		return loot1;
	}

	@Override
	public Loot2 nuevoLoot2Nivel1() {
		Loot2 loot2;
		String skinLoot2 = "/images/amongFruit1.png";
		Posicion p = new PosicionLogica(0, 0);
		loot2 = new Loot2Nivel1(p,skinLoot2);
		loot2.setVisitor(new VisitorLoot2(loot2));
		return loot2;
	}
	
	@Override
	public Loot2 nuevoLoot2Nivel2() {
		Loot2 loot2;
		String skinLoot2 = "/images/amongFruit2.png";
		Posicion p = new PosicionLogica(0, 0);
		loot2 = new Loot2Nivel2(p,skinLoot2);
		loot2.setVisitor(new VisitorLoot2(loot2));
		return loot2;
	}
	
	@Override
	public Loot2 nuevoLoot2Nivel3() {
		Loot2 loot2;
		String skinLoot2 = "/images/amongFruit3.png";
		Posicion p = new PosicionLogica(0, 0);
		loot2 = new Loot2Nivel3(p,skinLoot2);
		loot2.setVisitor(new VisitorLoot2(loot2));
		return loot2;
	}

	@Override
	public LootEspecial1 nuevoLootEspecial1() {
		LootEspecial1 lootEspecial1;
		String skinLootEspecial1 = "/images/amongPowerPellet.png";
		Posicion p = new PosicionLogica(0, 0);
		lootEspecial1 = new LootEspecial1(p, skinLootEspecial1);
		lootEspecial1.setVisitor(new VisitorLootEspecial1(lootEspecial1));
		return lootEspecial1;
	}

	@Override
	public PocionVelocidad nuevoPocionVelocidad() {
		PocionVelocidad pV;
		String skinPocionVelocidad = "/images/amongPocionVelocidad.png";
		Posicion p = new PosicionLogica(0, 0);
		pV = new PocionVelocidad(p, skinPocionVelocidad);
		pV.setVisitor(new VisitorPocionV(pV));
		return pV;
	}

	@Override
	public Explosivo nuevoExplosivo() {
		Explosivo ex;
		String skinExplosivo = "/images/amongExplosivo.png";
		Posicion p = new PosicionLogica(0, 0);
		ex = new Explosivo(p, skinExplosivo);
		ex.setVisitor(new VisitorExplosivo(ex));
		return ex;
	}
	
	@Override
	public Pared nuevoPared() {
		Pared pared;
		String skinPared = "/images/amongPared.png";
		Posicion p = new PosicionLogica(0, 0);
		pared = new Pared(p,skinPared);
		pared.setVisitor(new VisitorPared(pared));
		return pared;
	}
	
	@Override
	public Musica nuevoMusica() {
		String musica= "/Musica/amongUsMusica.wav";
		Musica sonido= new Musica(musica);
		return sonido;
	}
	
	public String toString() {
		return "Tema Among Us";
	}

	@Override
	public String efectoDot() {
		return "/Musica/amongUsDot.wav";
	}
	
	@Override
	public String efectoPower() {
		return "/Musica/amongUsPower.wav";
	}

	@Override
	public String efectoFruit() {
		return "/Musica/amongUsFruit.wav";
	}

	@Override
	public String efectoPocionVelocidad() {
		return "/Musica/amongUsPocionVelocidad.wav";
	}

	@Override
	public String efectoExplosivo() {
		return "/Musica/amongUsExplosion.wav";
	}

	@Override
	public String efectoExplosionInicio() {
		return "/Musica/amongUsExplosionInicio.wav";
	}

	@Override
	public String efectoExplosionFin() {
		return "/Musica/amongUsExplosionFin.wav";
	}

	@Override
	public String efectoMuertePersonaje() {
		return "/Musica/amongUsMuertePersonaje.wav";
	}
	
	@Override
	public String efectoMuerteEnemigo() {
		return "/Musica/amongUsMuerteEnemigo.wav";
	}
}
