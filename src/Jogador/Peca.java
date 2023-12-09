package Jogador;

import jplay.Sprite;
import jplay.URL;

public class Peca extends Sprite{
	private String cor;
	public Peca(int x, int y, int id) {
		super(URL.sprite("peca"+id+".png"), 1);
		if(id == 1) this.cor = "vermelho";
		else if(id == 2) this.cor = "amarelo";
		else if(id == 3) this.cor = "verde";
		else if(id == 4) this.cor = "azul";
		else if(id == 5) this.cor = "rosa";
		else this.cor = "cinza";
		this.x = x;
		this.y = y;
	}
	public String getCor() {
		return this.cor;
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}