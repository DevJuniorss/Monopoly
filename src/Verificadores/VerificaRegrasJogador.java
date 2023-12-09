package Verificadores;

import Jogador.Jogador;
import Casa.TerrenoComercializavel.TerrenoComercializavel;

public interface VerificaRegrasJogador {
	public boolean verificaSaldoJogador(Jogador jogador);
	public boolean validaCasaJogador(TerrenoComercializavel terreno, Jogador jogador);
	public boolean verificaJogadorPreso(Jogador jogador);
	public boolean verificaSaldoParaCompra(Jogador jogador, TerrenoComercializavel terreno);

}
