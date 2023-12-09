package Casa;

import Baralho.IteratorSorteReves;
import Jogador.Jogador;

public class SorteReves extends Casa{
	public SorteReves(String nome, int posicao, int id, int x, int y) {
		super(nome, posicao, id, x, y);
	}
	public void ativarEfeito(Jogador jogador) {
		IteratorSorteReves.getInstance().pegaCarta().ativarEfeito(jogador);
	}
}