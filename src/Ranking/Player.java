package Ranking;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5566884611383241885L;
	private String jugador;
	private Integer puntaje;
	
	public Player(String nombre, Integer puntos) {
		jugador = nombre;
		puntaje = puntos;
	}
	
	public String getPlayer () {
		return jugador;
	}
	
	public Integer getScore() {
		return puntaje;
	}
	
	@Override
	public int compareTo(Player p) {
		return puntaje.compareTo(p.getScore());
	}
}