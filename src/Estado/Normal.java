package Estado;

import Personajes.PersonajePrincipal;

public class Normal extends Estado{

	public Normal(PersonajePrincipal p, String skin) {
		super(p, skin);
		velocidad = 5;
	}

	
}
