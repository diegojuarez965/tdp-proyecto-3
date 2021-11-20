package Ranking;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {

	private static final long serialVersionUID = -5566884611383241885L;
	private String nombre;
	private Integer puntaje;

	public Player(String nombre, Integer puntos) {
		this.nombre = nombre;
		puntaje = puntos;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public Integer obtenerPuntaje() {
		return puntaje;
	}

	@Override
	public int compareTo(Player p) {
		return puntaje.compareTo(p.obtenerPuntaje());
	}

}