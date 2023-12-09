package Jogo;

import Repositorios.RepositorioJogador;
import Verificadores.VerificaRegrasInsereJogador;
import View.DesenhaComponenteGrafico;

public class InsereJogador implements VerificaRegrasInsereJogador {
	private DesenhaComponenteGrafico desenha;
	public InsereJogador() {
		this.desenha = new DesenhaComponenteGrafico();
	}
	public void inserirQtdJogadores() {
		int qtdJogadores = desenha.telaInserirQtdJogador();
		for(int i = 0; i < qtdJogadores; i++) {
			RepositorioJogador.getInstance().adicionarJogador();
		}
	}
	public boolean verificaQtdJogadores(int qtdJogadores) {
		return false;
	}
}