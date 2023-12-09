package Casa.TerrenoComercializavel;

import Casa.Casa;
import Jogador.Jogador;

public abstract class TerrenoComercializavel extends Casa {
	private double valor;
	private Jogador proprietario;
	public TerrenoComercializavel(String nome, int posicao, int id, int x, int y, double valor) {
		super(nome, posicao, id, x, y);
		this.valor = valor;
	}
	public void ativarEfeito(Jogador jogador) {}
	public void ativarEfeitoCompanhia(Jogador jogador, int valorDados) {}
	public void setProprietario(Jogador jogador) {
		this.proprietario = jogador;
	}
	public Jogador getProprietario() {
		return this.proprietario;
	}
	public double getValor() {
		return valor;
	}
}