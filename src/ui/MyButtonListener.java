package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import models.Manzana;

public class MyButtonListener implements ActionListener {

	private MySnakeFrame snakeFrame;
	private TableroJuego tablero;
	private Manzana manzana;

	public MyButtonListener(MySnakeFrame sf, TableroJuego t, Manzana m) {
		snakeFrame = sf;
		tablero = t;
		manzana = m;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (((JButton) ae.getSource()).getText() == "Start") {
			snakeFrame.empezarDeNuevo();
			tablero.requestFocus();
		} else { // Botón de pausar
			snakeFrame.pausaContinuaJuego();
			tablero.requestFocus();
		}
	}

	private void setPosiManzana() {
		int posXinicial = (int) (Math.random() * ((tablero.getWidth() - 199))), posYinicial = (int) (Math.random() * ((tablero.getHeight() - 199)));
		while (posXinicial % 20 != 0) {
			posXinicial = (int) (Math.random() * ((tablero.getWidth() - 199)));
		}

		manzana.setX(posXinicial);

		while (posYinicial % 20 != 0) {
			posYinicial = (int) (Math.random() * ((tablero.getHeight() - 199)));
		}

		manzana.setY(posYinicial);
	}

}
