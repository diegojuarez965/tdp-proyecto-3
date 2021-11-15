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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Entidad.Entidad;
import Factory.FactoryTemas;
import Factory.Tema1;
import Factory.Tema2;
import Factory.Tema3;
import Juego.Juego;
import Posicion.Posicion;
import Ranking.Ranking;
import Laberinto.Laberinto;

import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e1) {e1.printStackTrace();}
		setResizable(false);
		setVisible(true);
		setTitle("Man-Pac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(1000,839);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setIconImage(new ImageIcon(getClass().getResource("/images/arabeSkinNormal.png")).getImage());
		
		contentPane = getContentPane();
		
		mapeo = new HashMap<Entidad,JLabel>();
		
		panelInformacion = new JPanel();
		panelInformacion.setBackground(Color.GRAY);
		contentPane.add(panelInformacion);
		panelInformacion.setBorder(new LineBorder(Color.BLACK));
		panelInformacion.setBounds(800, 0, 184, 800);
		panelInformacion.setLayout(null);
		
		labelVidas = new JLabel("Vidas: 3");
		labelVidas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelVidas.setForeground(Color.WHITE);
		labelVidas.setBounds(10, 36, 164, 14);
		panelInformacion.add(labelVidas);
		
		labelExplosivos = new JLabel("Explosivos: 0");
		labelExplosivos.setForeground(Color.WHITE);
		labelExplosivos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelExplosivos.setBounds(10, 61, 164, 14);
		panelInformacion.add(labelExplosivos);
		
		labelPuntos = new JLabel("Puntos: 0");
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
				requestFocus();
				if(botonMusica.isSelected())
				   pararMusica();
				else
					playMusica();
			}
		});
		botonMusica.setBackground(Color.DARK_GRAY);
		botonMusica.setBounds(10, 312, 164, 23);
		botonMusica.setSelectedIcon(new ImageIcon(GUI.class.getResource("/images/mediaUnmute.png")));
		botonMusica.setIcon(new ImageIcon(GUI.class.getResource("/images/mediaMute.png")));
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
				requestFocus();
				if(botonEfectos.isSelected())
					mutearEfectosSonido();
				else
					activarEfectosSonido();
			}
		});
		botonEfectos.setBackground(Color.DARK_GRAY);
		botonEfectos.setBounds(10, 393, 164, 23);
		botonEfectos.setSelectedIcon(new ImageIcon(GUI.class.getResource("/images/mediaUnmute.png")));
		botonEfectos.setIcon(new ImageIcon(GUI.class.getResource("/images/mediaMute.png")));
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
					juego.mover(Laberinto.MOVER_DERECHA);
					break;
				}
				case KeyEvent.VK_LEFT: {
					juego.mover(Laberinto.MOVER_IZQUIERDA);
					break;
				}
				case KeyEvent.VK_DOWN: {
					juego.mover(Laberinto.MOVER_ABAJO);
					break;
				}
				case KeyEvent.VK_UP: {
					juego.mover(Laberinto.MOVER_ARRIBA);
					break;
				}
				case KeyEvent.VK_SPACE: {
					juego.ponerExplosivo();
					break;
				}
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				guardarRanking();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				guardarRanking();
			}
		});
		repaint();
	}
	public void mostrarMensajeNombre() {
		String nombreJugador = (String) JOptionPane.showInputDialog(contentPane, "Ingrese su nombre", "Ingresar Nombre", JOptionPane.WARNING_MESSAGE, null, null, null);
		if(nombreJugador==null || nombreJugador.isEmpty() || nombreJugador.trim().isEmpty())
			nombreJugador = "Anonimo";
		juego.agregarJugador(nombreJugador);
	}
	public void mostrarMensajeTemas() {
		FactoryTemas[] temas = {new Tema1(), new Tema2(), new Tema3()};
		juego.setTema(temas[1]);
		juego.setMusica(temas[1].nuevoMusica());
		FactoryTemas temp = ((FactoryTemas) JOptionPane.showInputDialog(contentPane, "Seleccione un Tema grafico", "Seleccion de Tema", JOptionPane.INFORMATION_MESSAGE, null, temas, temas[0]));
		if(temp!=null) {
			juego.setTema(temp);
			juego.setMusica(temp.nuevoMusica());
		}
		if(!botonMusica.isSelected())
			juego.reproducirMusica();
	}
	public void actualizarEntidadVisual(Entidad e) {
		JLabel grafico = mapeo.get(e);
		Posicion posEntidad = e.obtenerPosicion();
		if(grafico!=null) {
			grafico.setLocation(posEntidad.obtenerX(), posEntidad.obtenerY());
			grafico.setIcon(new ImageIcon(GUI.class.getResource(e.obtenerSkin())));
		}
	}
	public void mostrarEntidadVisual(Entidad e) {
		JLabel temp = new JLabel("");
		Posicion posEntidad = e.obtenerPosicion();
		temp.setBounds(posEntidad.obtenerX(), posEntidad.obtenerY(), posEntidad.obtenerAncho(), posEntidad.obtenerAlto());
		temp.setIcon(new ImageIcon(GUI.class.getResource(e.obtenerSkin())));
		temp.setVisible(true);
		contentPane.add(temp);
		temp.repaint();
		mapeo.put(e, temp);
	}
	public void eliminarEntidadVisual(Entidad e) {
		JLabel eliminar = mapeo.remove(e);
		if(eliminar!=null) 
			contentPane.remove(eliminar);
		this.repaint();
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
	public void setJuego(Juego j) {
		this.juego = j;
	}
	public void finalizarJuego() {
		guardarRanking();
		if(JOptionPane.showConfirmDialog(contentPane, "Obtuviste "+juego.obtenerPuntos()+" puntos\nEl ranking es:\n"+juego.obtenerRanking()+"Desea reiniciar el juego?", null, JOptionPane.YES_NO_OPTION)==0)
			reiniciarJuego();
		else {
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		}
	}
	private void pararMusica() {
		juego.pararMusica();
	}
	private void playMusica() {
		juego.reproducirMusica();
	}
	private void mutearEfectosSonido() {
		juego.pararEfectos();
	}
	private void activarEfectosSonido() {
		juego.activarEfectos();
	}
	private void reiniciarJuego() {
		setPuntaje(0); 
		setVidas(3);
		setExplosivos(0);
		cargarRanking();
		mostrarMensajeNombre();
		mostrarMensajeTemas();
		juego.reiniciarJuego();
	}
	public void cargarRanking() {
	    juego.cargarRanking();
	}
	private void guardarRanking() {
		juego.guardarRanking();
	}
}
