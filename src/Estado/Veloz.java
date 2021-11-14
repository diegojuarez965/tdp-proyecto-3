package Estado;

import Personajes.PersonajePrincipal;

public class Veloz extends Estado {

	public Veloz(PersonajePrincipal p, String skin) {
		super(p, skin);
		velocidad = 10;
	}


}
