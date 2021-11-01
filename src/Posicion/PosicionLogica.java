package Posicion;

public class PosicionLogica {
	
	private int x,y;
	private int ancho= 40;
	private int alto= 40;
	
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
		boolean toReturn=false;
		if(p.obtenerX()==x && p.obtenerY()==y)
			toReturn=true;
		return toReturn;
	}
	
}
	
	
