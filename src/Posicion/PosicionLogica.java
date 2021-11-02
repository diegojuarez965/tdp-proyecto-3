package Posicion;

import java.awt.Rectangle;

public class PosicionLogica implements Posicion{
	
	private int x,y;
	private final int ancho = 40;
	private final int alto = 40;
	
	public PosicionLogica(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
    public int obtenerX() {
    	return x;
    }
	
	public int obtenerY() {
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
	
}
	
	
