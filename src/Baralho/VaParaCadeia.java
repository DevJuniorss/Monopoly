package Baralho;

import javax.swing.JOptionPane;
import Jogador.Jogador;
import Jogo.SomEfeitos;
import Repositorios.RepositorioJogador;
import View.DesenhaComponenteGrafico;

public class VaParaCadeia extends Carta{
	public VaParaCadeia(int id, String nome, float efeito) {
		super(id, nome, efeito);
	}
	@Override
	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		jogador.setPosicaoAtual(11, 640, 640);
		RepositorioJogador.getInstance().addJogadorPreso(jogador);
		SomEfeitos.play("cadeia.wav");
		componenteGrafico.mensagemPreso();
		if(jogador.isPasseLivre()) {
			int resposta = componenteGrafico.mensagemConfirmacaoUsoPasseLivre();
			if(resposta == JOptionPane.YES_OPTION) {
				RepositorioJogador.getInstance().removeJogadorPreso(jogador);
				jogador.setPasseLivre(false);
				componenteGrafico.mensagemSaiuComPasse();
			}
		}
	}
}