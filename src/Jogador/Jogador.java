package Jogador;

import java.util.ArrayList;
import java.util.List;
import Casa.TerrenoComercializavel.Imovel;
import Casa.TerrenoComercializavel.TerrenoComercializavel;
import Jogo.SomEfeitos;
import View.DesenhaComponenteGrafico;

public class Jogador {
	private static int identificador;
	private int id;
	private int posicaoAtual;
	private ContaBancaria conta;
	private List<TerrenoComercializavel> propriedades;
	private Peca pecaJogador;
	private int qtdRodadasPrisao;
	private boolean passeLivre;
	public Jogador(ContaBancaria conta) {
		super();
		this.id = identificador + 1;
		identificador++;
		this.posicaoAtual = 1;
		this.conta = conta;
		this.pecaJogador = new Peca(640, 0, id);
		this.propriedades = new ArrayList<>();
		this.qtdRodadasPrisao = 0;
		this.passeLivre = false;
	}
	public void comprar(TerrenoComercializavel terreno) {
		if (this.getConta().getSaldo() >= terreno.getValor()) {
			this.getConta().sacar(terreno.getValor());
			terreno.setProprietario(this);
			this.propriedades.add(terreno);
			SomEfeitos.play("pagar.wav");
		}
		else {
			DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
			componenteGrafico.mensagemSaldoInsuficiente();
		}
	}
	public void pagarTaxa(double taxa) {
		this.getConta().sacar(taxa);
	}
	public void receberTaxa(double taxa) {
		this.getConta().depositar(taxa);
	}
	public void addMinhaPropriedade(TerrenoComercializavel terreno) {
		this.propriedades.add(terreno);
	}
	public int getId() {
		return id;
	}
	public double getSaldoBancario() {
		return this.conta.getSaldo();
	}
	public ContaBancaria getConta() {
		return this.conta;
	}
	public int getPosicaoAtual() {
		return this.posicaoAtual;
	}
	public Peca getPecaJogador() {
		return pecaJogador;
	}
	public void setPosicaoAtual(int posicao, int x, int y) {
		this.posicaoAtual = posicao;
		this.getPecaJogador().x = x;
		this.getPecaJogador().y = y;
	}
	public List<TerrenoComercializavel> getMinhasPropriedades() {
		return this.propriedades;
	}
	public void incrementaQtdRodadasPrisao() {
		this.qtdRodadasPrisao++;
	}
	public int getQtdRodadasPrisao() {
		return this.qtdRodadasPrisao;
	}
	public void zeraQtdRodadasPrisao() {
		this.qtdRodadasPrisao = 0;
	}
	public void transferirPropriedadesParaBanco() {
		for(TerrenoComercializavel terreno: propriedades) {
			terreno.setProprietario(null);
		}
	}
	public boolean isPasseLivre() {
		return passeLivre;
	}
	public void setPasseLivre(boolean passeLivre) {
		this.passeLivre = passeLivre;
	}
	public void comprarCondominio(Imovel imovel) {
		if (this.getConta().getSaldo() >= imovel.getValorCondominio()) {
			this.getConta().sacar(imovel.getValorCondominio());
			imovel.setCountCondominios(imovel.getCountCondominios() + 1);
			SomEfeitos.play("pagar.wav");
		}
		else {
			DesenhaComponenteGrafico componenteGrafico = new DesenhaComponenteGrafico();
			componenteGrafico.mensagemSaldoInsuficiente();
		}
	}
}