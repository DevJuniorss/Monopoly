package Baralho;

import java.util.List;
import Repositorios.RepositorioCartas;

public class IteratorSorteReves implements IteratorCarta{
	private static IteratorSorteReves instance = null;
	private List<Carta> cartas = RepositorioCartas.getInstance().getCartas();
	private int cursorAtual;
	private IteratorSorteReves() {
	}
	public static IteratorSorteReves getInstance() {
		if(instance == null) {
			instance = new IteratorSorteReves();
		}
		return instance;
	}
	@Override
	public boolean existeProximo() {
		if (cursorAtual < this.cartas.size()) {
			return true;
		}
		this.cursorAtual = 0;
		return true;
	}
	@Override
	public Carta pegaCarta() {
		Carta carta = null;  
		if (existeProximo()) {
			carta = cartas.get(cursorAtual);
			cursorAtual++;
			return carta;
		}
		return carta;
	}
}