package Baralho;

import Jogador.Jogador;
import Jogo.SomEfeitos;
import Repositorios.RepositorioJogador;
import View.DesenhaComponenteGrafico;

public class Carta {
	private int id;
	private String nome;
	private double valor;
	public Carta(int id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	public void ativarEfeito(Jogador jogador) {
		DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
		if (this.nome.equals("Sorte")) {
			jogador.getConta().depositar(valor);
			SomEfeitos.play("receber.wav");
			componenteGrafico.mensagemSorteReves(this.nome, valor);
		} else if (this.nome.equals("Reves")) {
			if(jogador.getSaldoBancario() > valor) {
				jogador.getConta().sacar(valor);
				SomEfeitos.play("pagar.wav");
				componenteGrafico.mensagemSorteReves(this.nome, valor);
			} else {
				RepositorioJogador.getInstance().getJogadoresFalidos().add(jogador);
				jogador.transferirPropriedadesParaBanco();
				jogador.getPecaJogador().hide();
				SomEfeitos.play("falencia.wav");
				componenteGrafico.mensagemFalencia();
			}
		}
	}
}