package Estado;

import Personajes.PersonajePrincipal;

public abstract class Estado {

	@SuppressWarnings("unused")
	private PersonajePrincipal personaje;
	private String skin;
	protected int velocidad;

	public Estado(PersonajePrincipal p, String skin) {
		personaje = p;
		this.skin = skin;
	}

	public String obtenerSkin() {
		return skin;
	}

	public int obtenerVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int v) {
		velocidad = v;
	}

}
