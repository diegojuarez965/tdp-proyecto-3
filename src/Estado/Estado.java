package Estado;

import Personajes.PersonajePrincipal;

public abstract class Estado {
	
	private PersonajePrincipal personaje;
	private String skin;
	
	public Estado(PersonajePrincipal p, String skin) {
		personaje = p;
		this.skin = skin;
	}
	
	public String obtenerSkin() {
		return skin;
	}
	
}
