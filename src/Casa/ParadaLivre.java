package Casa;

import Jogador.Jogador;
import View.DesenhaComponenteGrafico;

public class ParadaLivre extends Casa {
	public ParadaLivre(String nome, int posicao, int id, int x, int y) {
		super(nome, posicao, id, x, y);
	}
	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		componenteGrafico.mensagemParadaLivre();
	}
}