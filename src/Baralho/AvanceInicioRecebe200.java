package Baralho;

import Jogador.Jogador;
import Jogo.SomEfeitos;
import View.DesenhaComponenteGrafico;

public class AvanceInicioRecebe200 extends Carta{
	public AvanceInicioRecebe200(int id, String nome, double valor) {
		super(id, nome, valor);
	}
	@Override
	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		jogador.setPosicaoAtual(1, 640, 0);
		jogador.getConta().depositar(200);
		SomEfeitos.play("receber.wav");
		componenteGrafico.mensagemVaiInicioGanha200();
	}
}