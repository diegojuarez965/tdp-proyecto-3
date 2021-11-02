package Estado;

import Personajes.PersonajePrincipal;

public class Normal implements Estado{

	@Override
	public String obtenerSkin(PersonajePrincipal p) {
		return p.obtenerSkinNormal();
	}
	
}
