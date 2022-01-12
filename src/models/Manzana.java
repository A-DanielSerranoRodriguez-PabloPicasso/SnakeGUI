package models;

import java.awt.Color;
import java.awt.Graphics2D;

public class Manzana extends Cuadrado {

	private boolean comida;

	public Manzana() {
		super(0, 0, 20, 0);
		this.comida = false;
	}
	
	public void setX(int x) {
		this.posX = x;
	}

	public void setY(int y) {
		this.posY = y;
	}

	public boolean isComida() {
		return this.comida;
	}

	public void setComida(boolean comida) {
		this.comida = comida;
	}

	public void pintarse(Graphics2D g) {
		g.setColor(new Color(255,255,255));
		// g.drawRect(posX, posY, lado, lado);
		g.fillRect(this.posX, this.posY, this.lado, this.lado);
		// g.fillOval(posX, posY, lado, lado);
	}
}
