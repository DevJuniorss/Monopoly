package Casa;

import Jogador.Jogador;

public abstract class Casa implements IEfeitoCasa {
	private String nome;
	private int posicao;
	private int id;
	private int x;
	private int y;
	public Casa(String nome, int posicao, int id, int x, int y) {
		super();
		this.nome = nome;
		this.posicao = posicao;
		this.id = id;
		this.x = x;
		this.y = y;
	}
	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public abstract void ativarEfeito(Jogador jogador);
}