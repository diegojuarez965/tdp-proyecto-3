package Builder;

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
import Personajes.Enemigo1;
import Personajes.Enemigo2;
import Personajes.Enemigo3;
import Personajes.Enemigo4;
import Personajes.PersonajePrincipal;

public class ConstructorNivel2 implements ConstructorLaberinto{
	
	private FactoryTemas Tema;
	private Laberinto lab;
	
	public ConstructorNivel2(FactoryTemas t) {
		Tema = t;
	}

	@Override
	public void construirParedes() {
		crearParedesX(0,19,0);
		crearParedesX(0,19,19);
		crearParedesY(1,18,0);
		crearParedesY(1,18,19);
		crearParedesX(2,8,2);
		crearParedesX(10,17,2);
		crearParedesX(2,8,17);
		crearParedesX(10,17,17);
		crearParedesX(6,13,4);
		crearParedesX(6,13,15);
		crearParedesY(3,9,2);
		crearParedesY(11,16,2);
		crearParedesY(3,9,17);
		crearParedesY(11,16,17);
		crearParedesY(6,13,4);
		crearParedesY(6,13,15);
		crearParedesY(6,9,6);
		crearParedesY(6,9,12);
		crearParedesY(6,9,13);
		crearParedesY(11,13,6);
		crearParedesY(11,13,12);
		crearParedesY(11,13,13);
		crearParedesY(8,11,8);
		crearParedesY(8,11,10);
		crearParedesX(7,8,6);
		crearParedesX(10,11,6);
		crearParedesX(7,8,13);
		crearParedesX(10,11,13);
		crearParedesX(4,4,4);
		crearParedesX(15,15,4);
		crearParedesX(4,4,15);
		crearParedesX(15,15,15);
		crearParedesX(9,9,11);
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
		crearLoot1X(1,17,1);
		crearLoot1X(4,16,3);
		crearLoot1X(3,16,5);
		crearLoot1X(3,16,14);
		crearLoot1X(3,15,16);
		crearLoot1X(2,17,18);
		crearLoot1Y(2,17,1);
		crearLoot1Y(6,13,3);
		crearLoot1Y(6,13,5);
		crearLoot1Y(6,13,14);
		crearLoot1Y(6,13,16);
		crearLoot1Y(2,18,18);
		crearLoot1X(8,11,7);
		crearLoot1Y(8,12,7);
		crearLoot1Y(8,11,11);
		crearLoot1X(9,9,2);
		crearLoot1X(3,3,4);
		crearLoot1X(5,5,4);
		crearLoot1X(14,14,4);
		crearLoot1X(16,16,4);
		crearLoot1X(9,9,6);
		crearLoot1X(2,2,10);
		crearLoot1X(6,6,10);
		crearLoot1X(12,13,10);
		crearLoot1X(17,17,10);
		crearLoot1X(8,8,12);
		crearLoot1X(10,10,12);
		crearLoot1X(9,9,13);
		crearLoot1X(3,3,15);
		crearLoot1X(5,5,15);
		crearLoot1X(14,14,15);
		crearLoot1X(16,16,15);
		crearLoot1X(9,9,17);
		//Loot2
		crearLoot2(9,12);
		//LootEspecial1
		crearLootEspecial1(18,1);
		crearLootEspecial1(1,18);
		//PocionVelocidad
		crearPocionVelocidad(3,3);
		crearPocionVelocidad(16,16);
		//Explosivo
		crearExplosivo(7,7);
		crearExplosivo(11,12);
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
		/*
		//Enemigo1
		Enemigo1 enemigo1 = Tema.nuevoEnemigo1();
		enemigo1.obtenerPosicion().setX(9*enemigo1.obtenerPosicion().obtenerAncho());
		enemigo1.obtenerPosicion().setY(10*enemigo1.obtenerPosicion().obtenerAlto());
		lab.agregarEnemigo(enemigo1);
		//Enemigo2
		Enemigo2 enemigo2 = Tema.nuevoEnemigo2();
	    enemigo2.obtenerPosicion().setX(9*enemigo2.obtenerPosicion().obtenerAncho());
	    enemigo2.obtenerPosicion().setY(10*enemigo2.obtenerPosicion().obtenerAlto());
		lab.agregarEnemigo(enemigo2);
		//Enemigo3
	    Enemigo3 enemigo3 = Tema.nuevoEnemigo3();
	    enemigo3.obtenerPosicion().setX(9*enemigo3.obtenerPosicion().obtenerAncho());
	    enemigo3.obtenerPosicion().setY(10*enemigo3.obtenerPosicion().obtenerAlto());
		lab.agregarEnemigo(enemigo3);
		//Enemigo4
		Enemigo4 enemigo4 = Tema.nuevoEnemigo4();
	    enemigo4.obtenerPosicion().setX(9*enemigo4.obtenerPosicion().obtenerAncho());
	    enemigo4.obtenerPosicion().setY(10*enemigo4.obtenerPosicion().obtenerAlto());
		lab.agregarEnemigo(enemigo4);
		*/
	}

	@Override
	public void construirPersonaje() {
		PersonajePrincipal personajePrincipal = Tema.nuevoPersonajePrincipal();
		personajePrincipal.obtenerPosicion().setX(17*personajePrincipal.obtenerPosicion().obtenerAncho());
		personajePrincipal.obtenerPosicion().setY(18*personajePrincipal.obtenerPosicion().obtenerAlto());
		personajePrincipal.setEstado(new Normal());
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
