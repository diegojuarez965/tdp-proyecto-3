package Posicion;

import java.awt.Rectangle;

public class PosicionLogica implements Posicion{
	
	private int x, y, alto, ancho;
	
	public PosicionLogica(int x,int y) {
		this.x=x;
		this.y=y;
		alto = 40;
		ancho = 40;
	}
	
    public synchronized int obtenerX() {
    	return x;
    }
	
	public synchronized int obtenerY() {
		return y;
	}
	
	public int obtenerAncho() {
		return ancho;
	}
	
	public int obtenerAlto() {
		return alto;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public boolean colisionan(Posicion p) {
		Rectangle primero = new Rectangle(x, y, ancho, alto);
		Rectangle posChequear = new Rectangle(p.obtenerX(),p.obtenerY(),p.obtenerAncho(),p.obtenerAlto());
		return primero.intersects(posChequear);
	}

	@Override
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
}
	
	
