package Casa;

import Jogador.Jogador;
import Jogo.SomEfeitos;
import Repositorios.RepositorioJogador;
import View.DesenhaComponenteGrafico;

public class ImpostoDeRenda extends Casa {

	public ImpostoDeRenda(String nome, int posicao, int id, int x, int y) {
		super(nome, posicao, id, x, y);
	}

	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		if(jogador.getSaldoBancario() > 200) {
			jogador.getConta().sacar(200);
			SomEfeitos.play("pagar.wav");
			componenteGrafico.mensagemImposto();
		} else {
			RepositorioJogador.getInstance().getJogadoresFalidos().add(jogador);
			jogador.transferirPropriedadesParaBanco();
			jogador.getPecaJogador().hide();
			SomEfeitos.play("falencia.wav");
			componenteGrafico.mensagemFalencia();
		}
	}
}