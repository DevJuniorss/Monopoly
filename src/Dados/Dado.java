package Dados;

import java.util.Random;
import jplay.Sprite;
import jplay.URL;

public class Dado extends Sprite{
	private int valor;
	public Dado(int x, int y) {
		super(URL.sprite("face6.png"), 1);
		this.valor = 1;
		this.x = x;
		this.y = y;
	}
	public void lancar() {
		Random rand = new Random();
		this.valor = rand.nextInt(6) + 1;
	}
	public void mudarFace() {
		String face = "face"+getValor()+".png";
		this.loadImage(URL.sprite(face));
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}