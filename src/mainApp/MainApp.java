package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.ControlTeclado;
import ui.MyButtonListener;
import ui.MySnakeFrame;
import ui.TableroJuego;

public class MainApp {

	static int speed = 0, maxCont = 0;
	static int width = 0, length = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO code application logic here

		long contador;
		JFrame external;
		MySnakeFrame frame;
		JPanel dificultad, center, centered1, centered2, centered3, centered4, centered5;
		JPanel mainPanel;
		TableroJuego tablero;
		JPanel botonera;
		JLabel puntos;
		JLabel puntosNum;
		JButton start;
		JButton pause;
		JLabel dif, tam;
		JButton facil, normal, dificil, imposible;
		JButton pequeno, mediano, grande;
		ControlTeclado miControlador;

		// 1. Crear el frame.
		frame = new MySnakeFrame();

		// asignamos el tamaño a nuestra ventana, y hacemos que se cierre cuando nos
		// pulsan
		// la X de cerrar la ventana
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. Ahora creamos los componentes y los ponemos en la frame (ventana).

		// El panel de fondo. Rellena el frame, y sirve de contenedor del tablero y de
		// la botonera.
		mainPanel = new JPanel(new BorderLayout());

		// Ahora creamos el tablero. Recordamos: no deja de ser un panel un poquito
		// "especial"
		tablero = new TableroJuego();

		// Les damos las propiedades a nuestro tablero. Su color, tamaño y borde
		tablero.setBorder(BorderFactory.createLineBorder(Color.black));
		tablero.setBackground(new java.awt.Color(0));
		tablero.setSize(600, 400);

		// Le damos un enlace al tablero para que sepa quién es su frame (ventana) y
		// así
		// sepa
		// quién contiene la serpiente y quién controla el juego...
		tablero.setSnakeFrame(frame);

		// Ahora el turno de la botonera. Tendrá los dos botones y las etiquetas de
		// texto
		botonera = new JPanel();
		botonera.setBorder(BorderFactory.createLineBorder(Color.black));
		botonera.setBackground(new java.awt.Color(150, 150, 150));

		// Ahora definimos las dos etiquetas para los puntos.
		puntos = new JLabel();
		puntos.setText("Puntos: ");
		puntos.setBackground(new java.awt.Color(190, 190, 190));

		puntosNum = new JLabel();
		puntosNum.setText("0");
		puntosNum.setBackground(new java.awt.Color(190, 190, 190));

		// turno de los botones de empezar y pausar/continuar
		start = new JButton();
		start.setSize(50, 20);
		start.setText("Start");
		start.addActionListener(new MyButtonListener(frame, tablero));

		pause = new JButton();
		pause.setSize(50, 20);
		pause.setText("Pause");
		pause.addActionListener(new MyButtonListener(frame, tablero));

		// Preparamos el control del teclado
		miControlador = new ControlTeclado();
		miControlador.setSnakeFrame(frame); // le damos al controlador de teclado un enlace el frame principal
		tablero.addKeyListener(miControlador); // le decimos al tablero que el teclado es cosa de nuestro controlador
		tablero.setFocusable(true); // permitimos que el tablero pueda coger el foco.

		// Añadimos los componentes uno a uno, cada uno en su contenedor, y al final el
		// panel principal
		// se añade al frame principal.
		botonera.add(start);
		botonera.add(pause);
		botonera.add(puntos);
		botonera.add(puntosNum);

		mainPanel.add(botonera, BorderLayout.PAGE_END);
		mainPanel.add(tablero, BorderLayout.CENTER);

		external = new JFrame();
		dificultad = new JPanel(new BorderLayout());
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

		centered1 = new JPanel();
		centered2 = new JPanel();
		centered3 = new JPanel();
		centered4 = new JPanel();
		centered5 = new JPanel();

		centered1.setLayout(new BoxLayout(centered1, BoxLayout.X_AXIS));
		centered2.setLayout(new BoxLayout(centered2, BoxLayout.X_AXIS));
		centered3.setLayout(new BoxLayout(centered3, BoxLayout.X_AXIS));
		centered4.setLayout(new BoxLayout(centered4, BoxLayout.X_AXIS));
		centered5.setLayout(new BoxLayout(centered5, BoxLayout.X_AXIS));

		dif = new JLabel("Elige la dificultad");
		tam = new JLabel("Elige las dimensiones del mapa");

		facil = new JButton();
		facil.setSize(50, 20);
		facil.setText("Facil");

		normal = new JButton();
		normal.setSize(50, 20);
		normal.setText("Normal");

		dificil = new JButton();
		dificil.setSize(50, 20);
		dificil.setText("Dificil");

		imposible = new JButton();
		imposible.setSize(50, 20);
		imposible.setText("Imposible");

		pequeno = new JButton();
		pequeno.setSize(50, 20);
		pequeno.setText("Pequeno");

		mediano = new JButton();
		mediano.setSize(50, 20);
		mediano.setText("Mediano");

		grande = new JButton();
		grande.setSize(50, 20);
		grande.setText("Grande");

		Component vg1 = Box.createVerticalGlue();
		Component vg2 = Box.createVerticalGlue();
		Component vg3 = Box.createVerticalGlue();
		Component vg4 = Box.createVerticalGlue();
		Component vg5 = Box.createVerticalGlue();
		Component vg6 = Box.createVerticalGlue();

		Component hg1 = Box.createHorizontalGlue();
		Component hg2 = Box.createHorizontalGlue();
		Component hg3 = Box.createHorizontalGlue();
		Component hg4 = Box.createHorizontalGlue();
		Component hg5 = Box.createHorizontalGlue();
		Component hg6 = Box.createHorizontalGlue();
		Component hg7 = Box.createHorizontalGlue();
		Component hg8 = Box.createHorizontalGlue();
		Component hg9 = Box.createHorizontalGlue();
		Component hg10 = Box.createHorizontalGlue();

		center.add(vg1);

		center.add(centered1);
		centered1.add(hg1);
		centered1.add(dif);
		centered1.add(tam);
		tam.setVisible(false);
		centered1.add(hg2);

		center.add(vg2);

		center.add(centered2);
		centered2.add(hg3);
		centered2.add(facil);
		centered2.add(pequeno);
		pequeno.setVisible(false);
		centered2.add(hg4);

		center.add(vg3);

		center.add(centered3);
		centered3.add(hg5);
		centered3.add(normal);
		centered3.add(mediano);
		mediano.setVisible(false);
		centered3.add(hg6);

		center.add(vg4);

		center.add(centered4);
		centered4.add(hg7);
		centered4.add(dificil);
		centered4.add(grande);
		grande.setVisible(false);
		centered4.add(hg8);

		center.add(vg5);

		center.add(centered5);
		centered5.add(hg9);
		centered5.add(imposible);
		centered5.add(hg10);

		center.add(vg6);

		dificultad.add(center, BorderLayout.CENTER);
		external.add(dificultad);
		external.setSize(601, 601);
		external.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		external.setVisible(true);

		while (!isDifficulty()) {
			facil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dif.setVisible(false);
					facil.setVisible(false);
					normal.setVisible(false);
					dificil.setVisible(false);
					imposible.setVisible(false);

					tam.setVisible(true);
					pequeno.setVisible(true);
					mediano.setVisible(true);
					grande.setVisible(true);

					setDifficulty(1);
				}
			});

			normal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dif.setVisible(false);
					facil.setVisible(false);
					normal.setVisible(false);
					dificil.setVisible(false);
					imposible.setVisible(false);

					tam.setVisible(true);
					pequeno.setVisible(true);
					mediano.setVisible(true);
					grande.setVisible(true);

					setDifficulty(2);
				}
			});

			dificil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dif.setVisible(false);
					facil.setVisible(false);
					normal.setVisible(false);
					dificil.setVisible(false);
					imposible.setVisible(false);

					tam.setVisible(true);
					pequeno.setVisible(true);
					mediano.setVisible(true);
					grande.setVisible(true);

					setDifficulty(3);
				}
			});

			imposible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dif.setVisible(false);
					facil.setVisible(false);
					normal.setVisible(false);
					dificil.setVisible(false);
					imposible.setVisible(false);

					tam.setVisible(true);
					pequeno.setVisible(true);
					mediano.setVisible(true);
					grande.setVisible(true);

					setDifficulty(4);
				}
			});
		}

		while (!isArea()) {
			pequeno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					external.setVisible(false);

					setArea(400, 400);
				}
			});

			mediano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					external.setVisible(false);

					setArea(600, 600);
				}
			});

			grande.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					external.setVisible(false);

					setArea(1000, 1000);
				}
			});
		}
		
		frame.setSize(width, length);

		tablero.setSize(width, length - 200);
		setLugar(frame, tablero.getWidth(), tablero.getHeight());

		setPosiManzana(frame, tablero);
		
		frame.add(mainPanel);

		contador = 0; // nuestro control de los pasos del tiempo. Cada vez que contador cuenta un
						// paso, pasan 10ms
		frame.setVisible(true); // activamos la ventana principal para que sea "pintable"
		external.repaint();
		while (true) { // por siempre jamás (hasta que nos cierren la ventana) estamos controlando el
						// juego.

			// actualizamos el estado del juego
			if (contador % speed == 0) { // cada 200ms nos movemos o crecemos...
				if (frame.tocandoManzana()) { // Cada 600ms crecemos y reseteamos el contador
					contador = 0;
					setPosiManzana(frame,tablero);
					frame.tocaCrecer();
					// hemos crecido... actualizamos puntos.
					puntosNum.setText(Integer.toString(frame.getSerpiente().getPuntos()));
				} else {
					contador++;
					frame.tocaMoverse();
					frame.comprobarEstado(tablero.getHeight(), tablero.getWidth()); // comprobamos si hemos muerto o no.
				}
			} else { // Cada vez que no hay que moverse o crecer, simplemente contamos...
				contador++;
			}

			// hemos terminado?? mostramos msg
			if (frame.mostrarFin()) {
				JOptionPane.showMessageDialog(frame,
						"Se acabo vaquero, has conseguido " + puntosNum.getText() + " puntos");
				setPosiManzana(frame, tablero);
			}

			// Repintamos
			tablero.repaint();

			// Esperamos para dar tiempo al thread de repintado a pintar.
			Thread.sleep(10);

		}
	}

	private static void setDifficulty(int num) {
		switch (num) {
		case 1:
			speed = 30;
			maxCont = 30;
			break;

		case 2:
			speed = 15;
			maxCont = 15;
			break;

		case 3:
			speed = 5;
			maxCont = 5;
			break;

		case 4:
			speed = 1;
			maxCont = 1;
			break;
		}
	}

	private static boolean isDifficulty() {
		if (speed != 0)
			return true;
		else
			return false;
	}

	private static void setArea(int w, int l) {
		width = w;
		length = l;
	}
	
	private static void setLugar(MySnakeFrame f,int x, int y) {
		f.getSerpiente().getSerpiente().get(0).setX(x/2);
		f.getSerpiente().getSerpiente().get(0).setY(y/2);
	}

	private static boolean isArea() {
		if (width != 0)
			return true;
		else
			return false;
	}

	private static void setPosiManzana(MySnakeFrame f, TableroJuego t) {
		int lado = f.getSerpiente().getSerpiente().get(0).getLado();
		int posX = (int) (Math.random() * t.getWidth()),
				posY = (int) (Math.random() * t.getHeight());
		while (posX % 20 != 0) {
			posX = (int) (Math.random() * t.getWidth());
		}
		while (posY % 20 != 0) {
			posY = (int) (Math.random() * t.getHeight());
		}
		
		if (posX > f.getWidth() - lado && posX != t.getWidth()) {
			posX = t.getWidth() - (lado);
		} else if (posY > f.getHeight() - lado && posY != t.getHeight()) {
			posY = t.getHeight() - (lado);
		}
		if (posX < 0 + lado && posX != 0) {
			posX = 0 - (lado);
		} else if (posY < 0 + lado && posY != 0) {
			posY = 0 - (lado);
		}

		
		f.getManzana().setX(posX);
		f.getManzana().setY(posY);
	}

}
