package Visitor;

import Personajes.PersonajePrincipal;

public class VisitorPersonajeP implements Visitor{
	
	private PersonajePrincipal personaje;
	
	public VisitorPersonajeP(PersonajePrincipal p) {
		personaje = p;
	}
	
}
