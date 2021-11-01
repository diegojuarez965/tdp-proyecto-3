package Posicion;

public interface Posicion {
	
	public int obtenerX();
	
	public int obtenerY();
	
	public int obtenerAncho();
	
	public int obtenerAlto();
	
	public void setX(int x);
	
	public void setY(int y);
	
	public boolean colisionan(Posicion p);
	
}
