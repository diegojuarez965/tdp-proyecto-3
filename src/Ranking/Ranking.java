package Ranking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ranking {
	
	private TopPlayers jugadores;
	
	public void cargarRanking() {
		try {
	    	ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ranking.proyecto"));
			jugadores = (TopPlayers) objectInputStream.readObject();
			objectInputStream.close();
		} catch (ClassNotFoundException | IOException e) {e.printStackTrace();}
	    if(jugadores==null)
	    	jugadores = new TopPlayers();
	}
	
	public void guardarRanking() {
		try {
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("ranking.proyecto"));
		    objectOutputStream.writeObject(jugadores);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarJugador(String nombre, int puntaje) {
		jugadores.addPlayer(new Player(nombre, puntaje));
	}
	
	public String toString() {
		return jugadores.toString();
	}
}
