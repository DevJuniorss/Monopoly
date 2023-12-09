package Casa;

import Jogador.Jogador;

public class Partida extends Casa {
	public Partida(String nome, int posicao, int id, int x, int y) {
		super(nome, posicao, id, x, y);
	}
	@Override
	public void ativarEfeito(Jogador jogador) {
		return;
	}
}