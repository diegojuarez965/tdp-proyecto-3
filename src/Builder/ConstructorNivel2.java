package Builder;

import Factory.FactoryTemas;
import Juego.Juego;
import Laberinto.Laberinto;
import Loot.Loot1;
import Loot.Loot2;
import Loot.LootEspecial1;
import Pared.Pared;

public class ConstructorNivel2 implements ConstructorLaberinto{
	
	private FactoryTemas Tema;
	private Laberinto lab;
	
	public ConstructorNivel2(FactoryTemas t) {
		Tema = t;
	}

	@Override
	public void construirParedes() {
		for(int x = 0; x<20; x++) {
			Pared paredTemp = Tema.nuevoPared();
			paredTemp.obtenerPosicion().setX(x*paredTemp.obtenerPosicion().obtenerAncho());
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
		//Explosivo
	}

	@Override
	public void construirEnemigos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void construirPersonaje() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Laberinto obtenerLaberinto() {
		return lab;
	}

	@Override
	public void resetBuilder(Juego j) {
		lab = new Laberinto(j);
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
    
    private void crearLoot1X(int desdeX, int hastaX, int Y) {
        for(int X = desdeX; X<=hastaX; X++) {
            Loot1 loot1Temp = Tema.nuevoLoot1();
            loot1Temp.obtenerPosicion().setX(X*loot1Temp.obtenerPosicion().obtenerAncho());
            loot1Temp.obtenerPosicion().setY(Y*loot1Temp.obtenerPosicion().obtenerAlto());
            lab.agregarLoot(loot1Temp);;
        }
    }
    
    private void crearLoot1Y(int desdeY, int hastaY, int X) {
        for(int Y = desdeY; Y<=hastaY; Y++) {
            Loot1 loot1Temp = Tema.nuevoLoot1();
            loot1Temp.obtenerPosicion().setX(X*loot1Temp.obtenerPosicion().obtenerAncho());
            loot1Temp.obtenerPosicion().setY(Y*loot1Temp.obtenerPosicion().obtenerAlto());
            lab.agregarLoot(loot1Temp);
        }
    }
    
    private void crearLoot2(int X, int Y) {
            Loot2 loot2Temp = Tema.nuevoLoot2();
            loot2Temp.obtenerPosicion().setX(X*loot2Temp.obtenerPosicion().obtenerAncho());
            loot2Temp.obtenerPosicion().setY(Y*loot2Temp.obtenerPosicion().obtenerAlto());
            lab.agregarLoot(loot2Temp);;
        }
    
    private void crearLootEspecial1(int X, int Y) {
        LootEspecial1 lootEspecial1Temp = Tema.nuevoLootEspecial1();
        lootEspecial1Temp.obtenerPosicion().setX(X*lootEspecial1Temp.obtenerPosicion().obtenerAncho());
        lootEspecial1Temp.obtenerPosicion().setY(Y*lootEspecial1Temp.obtenerPosicion().obtenerAlto());
        lab.agregarLoot(lootEspecial1Temp);;
    }
    
}
