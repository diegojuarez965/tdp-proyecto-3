package Builder;

import Entidad.Entidad;
import Factory.FactoryTemas;
import Juego.Juego;
import Laberinto.Laberinto;
import Loot.Explosivo;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Loot.PocionVelocidad;
import Pared.Pared;
import Personajes.PersonajePrincipal;

public class ConstructorNivel1 implements ConstructorLaberinto{
	
	private FactoryTemas Tema;
	private Laberinto lab;
	
	public ConstructorNivel1(FactoryTemas t) {
		Tema = t;
	}

	@Override
	public void construirParedes() {
		crearParedesX(0, 19, 0);
		crearParedesX(0, 19, 19);
		crearParedesY(1, 18, 0);
		crearParedesY(1, 18, 19);
		crearParedesY(2, 5, 2);
		crearParedesY(2, 5, 17);
		crearParedesY(7, 11, 2);
		crearParedesY(7, 11, 17);
		crearParedesY(13, 17, 2);
		crearParedesY(13, 17, 17);
		crearParedesY(5, 9, 4);
		crearParedesY(5, 9, 15);
		crearParedesY(11, 14, 4);
		crearParedesY(11, 14, 15);
		crearParedesY(16, 17, 4);
		crearParedesY(16, 17, 15);
		crearParedesX(4, 6, 2);
		crearParedesX(4, 6, 3);
		crearParedesX(8, 9, 2);
		crearParedesX(8, 9, 3);
		crearParedesX(11, 12, 2);
		crearParedesX(11, 12, 3);
		crearParedesX(14, 15, 2);
		crearParedesX(14, 15, 3);
		crearParedesX(6, 13, 5);
		crearParedesY(7, 12, 6);
		crearParedesY(5, 9, 15);
		crearParedesY(14, 15, 6);
		crearParedesY(11, 14, 15);
		crearParedesY(16, 17, 15);
		crearParedesX(6, 7, 17);
		crearParedesX(9, 10, 17);
		crearParedesX(12, 13, 17);
		crearParedesY(14, 15, 13);
		crearParedesY(12, 15, 11);
		crearParedesX(8, 9, 15);
		crearParedesX(8, 9, 13);
		crearParedesX(8, 9, 12);
		crearParedesX(12, 12, 10);
		crearParedesY(10, 12, 13);
		crearParedesX(12, 13, 7);
		crearParedesX(12, 13, 8);
		crearParedesY(7, 10, 8);
		crearParedesY(7, 10, 10);
		crearParedesX(9, 9, 10);
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
		crearLoot1X(2, 9, 1);
		crearLoot1X(11, 17, 1);
		crearLoot1Y(2, 17, 1);
		crearLoot1Y(2, 18, 18);
		crearLoot1X(2, 10, 18);
		crearLoot1X(12, 17, 18);
		crearLoot1Y(2, 14, 3);
		crearLoot1Y(2, 10, 16);
		crearLoot1Y(16, 17, 3);
		crearLoot1Y(12, 17, 16);
		crearLoot1X(4, 15, 4);
		crearLoot1Y(7, 9, 5);
		crearLoot1Y(7, 17, 14);
		crearLoot1X(5, 13, 16);
		crearLoot1X(5, 13, 6);
		crearLoot1Y(11, 15, 5);
		crearLoot1Y(7, 15, 7);
		crearLoot1Y(7, 11, 11);
		crearLoot1Y(11, 15, 10);
		crearLoot1Y(11, 15, 12);
		crearLoot1Y(2, 3, 10);
		crearLoot1Y(2, 3, 13);
		crearLoot1X(12, 13, 9);
		crearLoot1X(8, 9, 14);
		crearLoot1X(2, 2, 6);
		crearLoot1X(2, 2, 12);
		crearLoot1X(4, 4, 10);
		crearLoot1X(4, 4, 15);
		crearLoot1X(5, 5, 5);
		crearLoot1X(5, 5, 17);
		crearLoot1X(6, 6, 13);
		crearLoot1X(7, 7, 3);
		crearLoot1X(8, 8, 11);
		crearLoot1X(8, 8, 17);
		crearLoot1X(11, 11, 17);
		crearLoot1X(13, 13, 13);
		crearLoot1X(14, 14, 5);
		crearLoot1X(15, 15, 10);
		crearLoot1X(15, 15, 15);
		crearLoot1X(17, 17, 6);
		crearLoot1X(17, 17, 12);
		crearPocionVelocidad(1, 1);
		crearPocionVelocidad(18, 1);
		crearPocionVelocidad(1, 18);
		crearLootEspecial1(10, 1);
		crearLootEspecial1(14, 6);
		crearLootEspecial1(5, 10);
		crearLootEspecial1(11, 18);
		crearExplosivo(7, 2);
		crearExplosivo(3, 15);
		crearExplosivo(16, 11);
		crearLoot2(9, 11);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void construirPersonaje() {
		PersonajePrincipal personajePrincipal = Tema.nuevoPersonajePrincipal();
		personajePrincipal.obtenerPosicion().setX(17*personajePrincipal.obtenerPosicion().obtenerAncho());
		personajePrincipal.obtenerPosicion().setY(18*personajePrincipal.obtenerPosicion().obtenerAlto());
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
