package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Entidad.Entidad;
import Juego.Juego;
import Posicion.Posicion;

import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1017088708174674067L;
	private HashMap<Entidad,JLabel> mapeo;
	private Container contentPane;
	private JPanel panelInformacion;
	private JLabel labelVidas;
	private JLabel labelExplosivos;
	private JLabel labelPuntos;
	private JProgressBar barraProgreso;
	private Juego juego;
	private JToggleButton botonMusica;
	private JToggleButton botonEfectos;

	
	public GUI() {
		setResizable(false);
		setVisible(true);
		setTitle("Man-Pac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(1000,800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = getContentPane();
		
		mapeo = new HashMap<Entidad,JLabel>();
		
		panelInformacion = new JPanel();
		panelInformacion.setBackground(Color.GRAY);
		contentPane.add(panelInformacion);
		panelInformacion.setBorder(new LineBorder(Color.BLACK));
		panelInformacion.setBounds(800, 0, 184, 761);
		panelInformacion.setLayout(null);
		
		labelVidas = new JLabel("Vidas: ");
		labelVidas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelVidas.setForeground(Color.WHITE);
		labelVidas.setBounds(10, 36, 164, 14);
		panelInformacion.add(labelVidas);
		
		labelExplosivos = new JLabel("Explosivos: ");
		labelExplosivos.setForeground(Color.WHITE);
		labelExplosivos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelExplosivos.setBounds(10, 61, 164, 14);
		panelInformacion.add(labelExplosivos);
		
		labelPuntos = new JLabel("Puntos: ");
		labelPuntos.setForeground(Color.WHITE);
		labelPuntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPuntos.setBounds(10, 11, 164, 14);
		panelInformacion.add(labelPuntos);
		
		barraProgreso = new JProgressBar();
		barraProgreso.setToolTipText("Progreso");
		barraProgreso.setForeground(Color.GREEN);
		barraProgreso.setBounds(10, 151, 164, 14);
		panelInformacion.add(barraProgreso);
		
		JLabel lblNewLabel = new JLabel("Progreso");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(68, 137, 60, 14);
		panelInformacion.add(lblNewLabel);
		
		botonMusica = new JToggleButton("");
		panelInformacion.add(botonMusica);
		botonMusica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pararMusica();
			}
		});
		botonMusica.setBackground(Color.DARK_GRAY);
		botonMusica.setBounds(10, 312, 164, 23);
		botonMusica.setSelectedIcon(new ImageIcon(GUI.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaUnmute.png")));
		botonMusica.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		botonMusica.setContentAreaFilled(false);
		botonMusica.setOpaque(true);
		
		JLabel lblNewLabel_1 = new JLabel("Musica ON/OFF");
		panelInformacion.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(56, 296, 87, 14);
		
		botonEfectos = new JToggleButton("");
		panelInformacion.add(botonEfectos);
		botonEfectos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mutearEfectosSonido();
			}
		});
		botonEfectos.setBackground(Color.DARK_GRAY);
		botonEfectos.setBounds(10, 393, 164, 23);
		botonEfectos.setSelectedIcon(new ImageIcon(GUI.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaUnmute.png")));
		botonEfectos.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMute.png")));
		botonEfectos.setContentAreaFilled(false);
		botonEfectos.setOpaque(true);
		
		JLabel lblNewLabel_2 = new JLabel("Efectos ON/OFF");
		panelInformacion.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(56, 377, 87, 14);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_RIGHT: {
					juego.mover(juego.MOVER_DERECHA);
					break;
				}
				case KeyEvent.VK_LEFT: {
					juego.mover(juego.MOVER_IZQUIERDA);
					break;
				}
				case KeyEvent.VK_DOWN: {
					juego.mover(juego.MOVER_ABAJO);
					break;
				}
				case KeyEvent.VK_UP: {
					juego.mover(juego.MOVER_ARRIBA);
					break;
				}
				}
			}
		});
		
	}
	
	public void actualizarEntidadVisual(Entidad e) {
		JLabel grafico = mapeo.get(e);
		Posicion posEntidad = e.obtenerPosicion();
		grafico.setLocation(posEntidad.obtenerX(), posEntidad.obtenerY());
	}
	public void mostrarEntidadVisual(Entidad e) {
		JLabel temp = new JLabel("");
		contentPane.add(temp);
		Posicion posEntidad = e.obtenerPosicion();
		temp.setBounds(posEntidad.obtenerX(), posEntidad.obtenerY(), posEntidad.obtenerAncho(), posEntidad.obtenerAlto());
		temp.setIcon(new ImageIcon(GUI.class.getResource(e.obtenerSkin())));
		mapeo.put(e, temp);
	}
	public void eliminarEntidadVisual(Entidad e) {
		JLabel eliminar = mapeo.remove(e);
		contentPane.remove(eliminar);
		eliminar = null;
	}
	
	public void setJuego(Juego j) {
		juego = j;
	}
	
	public void setMaxProgreso(int progreso) {
		barraProgreso.setMaximum(progreso);
	}
	public void resetProgreso() {
		barraProgreso.setValue(0);
	}
	public void incrementarProgreso() {
		barraProgreso.setValue(barraProgreso.getValue()+1);
	}
	
	public void setPuntaje(int p) {
		labelPuntos.setText("Puntos: "+p);
	}
	public void setVidas(int v) {
		labelVidas.setText("Vidas: "+v);
	}
	public void setExplosivos(int e) {
		labelExplosivos.setText("Explosivos: "+e);
	}
	
	private void pararMusica() {
		juego.pararMusica();
	}
	private void mutearEfectosSonido() {
		juego.pararEfectos();
	}
}
