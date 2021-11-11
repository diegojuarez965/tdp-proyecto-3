package Builder;

import Comportamiento.Ataque;
import Estado.Normal;
import Factory.FactoryTemas;
import Juego.Juego;
import Laberinto.Laberinto;
import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.Enemigo;
import Personajes.Enemigo1;
import Personajes.Enemigo2;
import Personajes.Enemigo3;
import Personajes.Enemigo4;
import Personajes.PersonajePrincipal;

public class ConstructorNivel3 implements ConstructorLaberinto{
	
	private FactoryTemas Tema;
	private Laberinto lab;
	
	public ConstructorNivel3(FactoryTemas t) {
		Tema = t;
	}

	@Override
	public void construirParedes() {
		crearParedesX(0,19,0);
		crearParedesX(0,19,19);
		crearParedesY(1,18,0);
		crearParedesY(1,18,19);
		crearParedesX(4,15,2);
		crearParedesX(4,15,17);
		crearParedesY(2,17,2);
		crearParedesY(2,17,17);
		crearParedesX(4,8,4);
		crearParedesX(10,16,4);
		crearParedesX(3,6,6);
		crearParedesX(12,15,6);
		crearParedesX(4,6,8);
		crearParedesX(12,15,8);
		crearParedesX(8,10,12);
		crearParedesX(8,10,13);
		crearParedesX(3,8,15);
		crearParedesX(10,15,15);
		crearParedesY(7,10,8);
		crearParedesY(7,10,10);
		crearParedesY(9,13,4);
		crearParedesY(9,13,15);
		crearParedesY(10,13,12);
		crearParedesY(10,13,13);
		crearParedesY(10,14,6);
		crearParedesX(8,8,5);
		crearParedesX(10,10,5);
		crearParedesX(9,9,10);
		crearParedesX(10,10,14);
	}
	private void crearParedesX(int desdeX, int hastaX, int Y) {
		for(int X = desdeX; X<=hastaX; X++) {
			Pared paredTemp = Tema.nuevoPared();
			paredTemp.obtenerPosicion().setX(X*paredTemp.obtenerPosicion().obtenerAncho());
			paredTemp.obtenerPosicion().setY(Y*paredTemp.obtenerPosicion().obtenerAlto());
			lab.agregarPared(paredTemp);
		}
	}
	private void crearParedesY(int desdeY, int hastaY, int X) {
		for(int Y = desdeY; Y<=hastaY; Y++) {
			Pared paredTemp = Tema.nuevoPared();
			paredTemp.obtenerPosicion().setX(X*paredTemp.obtenerPosicion().obtenerAncho());
			paredTemp.obtenerPosicion().setY(Y*paredTemp.obtenerPosicion().obtenerAlto());
			lab.agregarPared(paredTemp);
		}
	}
	
	@Override
	public void construirLoot() {
		//Loot1
		crearLoot1X(1,18,1);
		crearLoot1X(1,17,18);
		crearLoot1Y(2,17,1);
		crearLoot1Y(2,17,18);
		crearLoot1X(3,16,3);
		crearLoot1Y(5,17,16);
		crearLoot1Y(5,14,7);
		crearLoot1Y(5,14,11);
		crearLoot1Y(7,14,3);
		crearLoot1Y(9,14,5);
		crearLoot1X(4,15,16);
		crearLoot1X(12,15,14);
		crearLoot1X(12,15,7);
		crearLoot1X(12,15,5);
		crearLoot1X(3,6,5);
		crearLoot1X(8,10,6);
		crearLoot1X(4,6,7);
		crearLoot1X(12,13,9);
		crearLoot1Y(10,13,14);
		crearLoot1X(8,9,14);
		crearLoot1X(3,3,2);
		crearLoot1X(16,16,2);
		crearLoot1X(3,3,4);
		crearLoot1Y(4,5,9);
		crearLoot1X(6,6,9);
		crearLoot1X(8,8,11);
		crearLoot1X(10,10,11);
		crearLoot1X(4,4,14);
		crearLoot1X(9,9,15);
		crearLoot1X(3,3,17);
		//Loot2
		crearLoot2(9,11);
		//LootEspecial1
		crearLootEspecial1(18,18);
		//PocionVelocidad
		crearPocionVelocidad(3,16);
		//Explosivo
		crearExplosivo(14,9);
	}
	
	private void crearLoot1X(int desdeX, int hastaX, int Y) {
		for(int X = desdeX; X<=hastaX; X++) {
			Loot1 lootTemp = Tema.nuevoLoot1();
			lootTemp.obtenerPosicion().setX(X*lootTemp.obtenerPosicion().obtenerAncho());
			lootTemp.obtenerPosicion().setY(Y*lootTemp.obtenerPosicion().obtenerAlto());
			lab.agregarLoot(lootTemp);
		}
	}
	
	private void crearLoot1Y(int desdeY, int hastaY, int X) {
		for(int Y = desdeY; Y<=hastaY; Y++) {
			Loot1 lootTemp = Tema.nuevoLoot1();
			lootTemp.obtenerPosicion().setX(X*lootTemp.obtenerPosicion().obtenerAncho());
			lootTemp.obtenerPosicion().setY(Y*lootTemp.obtenerPosicion().obtenerAlto());
			lab.agregarLoot(lootTemp);
		}
	}
	
	private void crearLootEspecial1(int X, int Y) {
		LootEspecial1 lootEspecialTemp = Tema.nuevoLootEspecial1();
		lootEspecialTemp.obtenerPosicion().setX(X*lootEspecialTemp.obtenerPosicion().obtenerAncho());
		lootEspecialTemp.obtenerPosicion().setY(Y*lootEspecialTemp.obtenerPosicion().obtenerAlto());
		lab.agregarLoot(lootEspecialTemp);
	}
	
	private void crearPocionVelocidad(int X, int Y) {
		PocionVelocidad velocidadTemp = Tema.nuevoPocionVelocidad();
		velocidadTemp.obtenerPosicion().setX(X*velocidadTemp.obtenerPosicion().obtenerAncho());
		velocidadTemp.obtenerPosicion().setY(Y*velocidadTemp.obtenerPosicion().obtenerAlto());
		lab.agregarLoot(velocidadTemp);
	}
	
	private void crearExplosivo(int X, int Y) {
		Explosivo explosivoTemp = Tema.nuevoExplosivo();
		explosivoTemp.obtenerPosicion().setX(X*explosivoTemp.obtenerPosicion().obtenerAncho());
		explosivoTemp.obtenerPosicion().setY(Y*explosivoTemp.obtenerPosicion().obtenerAlto());
		lab.agregarLoot(explosivoTemp);
	}
	
	private void crearLoot2(int X, int Y) {
		Loot2 lootTemp = Tema.nuevoLoot2();
		lootTemp.obtenerPosicion().setX(X*lootTemp.obtenerPosicion().obtenerAncho());
		lootTemp.obtenerPosicion().setY(Y*lootTemp.obtenerPosicion().obtenerAlto());
		lab.agregarLoot(lootTemp);
	}
	@Override
	public void construirEnemigos() {
		Enemigo1 enemigo = Tema.nuevoEnemigo1();
		crearEnemigo(enemigo);
		Enemigo2 enemigo2 = Tema.nuevoEnemigo2();
		crearEnemigo(enemigo2);
		Enemigo3 enemigo3 = Tema.nuevoEnemigo3();
		crearEnemigo(enemigo3);
		Enemigo4 enemigo4 = Tema.nuevoEnemigo4();
		crearEnemigo(enemigo4);
	}
	private void crearEnemigo(Enemigo enemigo) {
		enemigo.obtenerPosicion().setX(9*enemigo.obtenerPosicion().obtenerAncho());
		enemigo.obtenerPosicion().setY(9*enemigo.obtenerPosicion().obtenerAlto());
		enemigo.setEstrategia(Enemigo.ATAQUE);
		enemigo.aumentarVelocidad();
		enemigo.setLaberinto(lab);
		lab.agregarEnemigo(enemigo);
	}

	@Override
	public void construirPersonaje() {
		PersonajePrincipal personajePrincipal = Tema.nuevoPersonajePrincipal();
		personajePrincipal.obtenerPosicion().setX(9*personajePrincipal.obtenerPosicion().obtenerAncho());
		personajePrincipal.obtenerPosicion().setY(5*personajePrincipal.obtenerPosicion().obtenerAlto());
		personajePrincipal.setEstado(PersonajePrincipal.NORMAL);
		personajePrincipal.setLaberinto(lab);
		lab.agregarPersonajeP(personajePrincipal);
	}

	@Override
	public Laberinto obtenerLaberinto() {
		return lab;
	}

	@Override
	public void resetBuilder(Juego j) {
		lab = new Laberinto(j);
	}

}
