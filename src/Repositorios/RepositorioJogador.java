package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Jogador.ContaBancaria;
import Jogador.Jogador;

public class RepositorioJogador {
	private static RepositorioJogador instance = null;
	private List<Jogador> jogadores = new ArrayList<>();
	private List<Jogador> jogadoresJogando = new ArrayList<>();
	private List<Jogador> jogadoresPresos =  new ArrayList<>();
	private List<Jogador> jogadoresFalidos = new ArrayList<>();
	private RepositorioJogador() {
	}
	public static RepositorioJogador getInstance() {
		if(instance == null) {
			instance = new RepositorioJogador();
		}
		return instance;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public List<Jogador> getJogadoresJogando() {
		return jogadoresJogando;
	}
	public List<Jogador> getJogadoresPresos() {
		return jogadoresPresos;
	}
	public List<Jogador> getJogadoresFalidos(){
		return jogadoresFalidos;
	}
	
	public void addJogadorPreso(Jogador jogador) {
		jogadoresPresos.add(jogador);
	}
	
	public void removeJogadorPreso(Jogador jogador) {
		jogadoresPresos.remove(jogador);
	}
	
	public void adicionarJogador() {
		Jogador jogador = new Jogador(new ContaBancaria());
		jogadores.add(jogador);
	}
}