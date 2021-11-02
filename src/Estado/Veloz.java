package Estado;

import Personajes.PersonajePrincipal;

public class Veloz implements Estado {

	@Override
	public String obtenerSkin(PersonajePrincipal p) {
		return p.obtenerSkinVeloz();
	}

}
