package Ranking;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ranking {

	private TopPlayers jugadores;
	private File CONFIG_HOME;
	
	public Ranking() {
	    String home = System.getenv("APPDATA");
	    if (home!=null && !home.isEmpty()) {
	        home = System.getProperty("user.home");
	    }
	    CONFIG_HOME = new File(home, "Man-Pac").getAbsoluteFile();
	    CONFIG_HOME.mkdir();
	}

	public void cargarRanking() {
		try {
			File r = new File(CONFIG_HOME.getAbsolutePath()+"/ranking.proyecto");
			r.getParentFile().mkdirs();
			r.createNewFile();
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(r));
			jugadores = (TopPlayers) objectInputStream.readObject();
			objectInputStream.close();
		} 
		catch(EOFException e) {
			jugadores = new TopPlayers();
		}
		catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarRanking() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(CONFIG_HOME.getAbsolutePath()+"/ranking.proyecto"));
			objectOutputStream.writeObject(jugadores);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
