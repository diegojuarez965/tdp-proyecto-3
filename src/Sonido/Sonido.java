package Sonido;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {
	
	private Clip clip;
	
	public Sonido(String musica) {
		try {
			clip=AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(musica)));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {	e.printStackTrace();}
	}
	
	public void play() {
		clip.start();
	}
	
	public void stop() {
		clip.stop();
	}
	
}
