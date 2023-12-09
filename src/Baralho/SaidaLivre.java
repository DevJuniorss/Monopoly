package Baralho;

import Jogador.Jogador;
import View.DesenhaComponenteGrafico;

public class SaidaLivre extends Carta{
	public SaidaLivre(int id, String nome, float efeito) {
		super(id, nome, efeito);
	}
	@Override
	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		jogador.setPasseLivre(true);
		componenteGrafico.mensagemSorteSaidaLivre();
	}
}