package Builder;

import Factory.FactoryTemas;
import Juego.Juego;
import Laberinto.Laberinto;
import Pared.Pared;

public class ConstructorNivel1 implements ConstructorLaberinto{
	
	private FactoryTemas Tema;
	private Laberinto lab;
	
	public ConstructorNivel1(FactoryTemas t) {
		Tema = t;
	}

	@Override
	public void construirParedes() {
		for(int x = 0; x<20; x++) {
			Pared paredTemp = Tema.nuevoPared();
			paredTemp.obtenerPosicion().setX(x*paredTemp.obtenerPosicion().obtenerAncho());
			lab.agregarPared(paredTemp);
			
			Pared paredTemp2 = Tema.nuevoPared();
			paredTemp2.obtenerPosicion().setY(19*paredTemp2.obtenerPosicion().obtenerAlto());
			paredTemp2.obtenerPosicion().setX(x*paredTemp2.obtenerPosicion().obtenerAncho());
			lab.agregarPared(paredTemp2);
		}
		for(int y = 1; y<19; y++) {
			Pared paredTemp = Tema.nuevoPared();
			paredTemp.obtenerPosicion().setY(y*paredTemp.obtenerPosicion().obtenerAlto());
			lab.agregarPared(paredTemp);
			
			Pared paredTemp2 = Tema.nuevoPared();
			paredTemp2.obtenerPosicion().setY(19*paredTemp2.obtenerPosicion().obtenerAlto());
			paredTemp2.obtenerPosicion().setX(y*paredTemp2.obtenerPosicion().obtenerAncho());
			lab.agregarPared(paredTemp2);
		}
	}

	@Override
	public void construirLoot() {
		// TODO Auto-generated method stub
		
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

}
