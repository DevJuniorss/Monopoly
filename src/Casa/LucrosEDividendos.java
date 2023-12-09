package Casa;

import Jogador.Jogador;
import Jogo.SomEfeitos;
import View.DesenhaComponenteGrafico;

public class LucrosEDividendos extends Casa {

	public LucrosEDividendos(String nome, int posicao, int id, int x, int y) {
		super(nome, posicao, id, x, y);
	}

	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		jogador.getConta().depositar(200);
		SomEfeitos.play("receber.wav");
		componenteGrafico.mensagemLucrosDividendos();	
	}
}