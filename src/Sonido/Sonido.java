package Sonido;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	
	private String musica;
	private Clip clip;
	
	public Sonido(String musica) {
		this.musica=musica;
	}
	
	public void play() {
		try {
			clip=AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(musica)));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public void stop() {
		clip.stop();
	}
	
}
