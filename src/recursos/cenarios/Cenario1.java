package recursos.cenarios;

import java.util.List;

import Dados.Dado;
import Jogador.Jogador;
import Jogo.Som;
import jplay.Animation;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {
	private Window window;
	private Scene scene;
	private List<Jogador> jogadores;
	private Keyboard teclado;
	private Dado dado1;
	private Dado dado2;
	private Animation faixaJogadorDaVez;	
	public Cenario1(Window window, List<Jogador> jogadores, Scene scene, Keyboard teclado) {
		this.window = window;
		this.teclado = teclado;
		this.scene = scene;
		this.scene.loadFromFile(URL.scenario("cenario.scn"));
		this.jogadores = jogadores;
		this.dado1 = new Dado(500, 128);
		this.dado2 = new Dado(555, 128);
		this.faixaJogadorDaVez = new Animation(URL.sprite("faixa1.png"));
		this.faixaJogadorDaVez.x = 222;
		this.faixaJogadorDaVez.y = 230;
		Som.play("audio1.wav");
		this.scene.draw();
	}
	public void run() {
		scene.draw();
		desenhaDados();
		faixaJogadorDaVez.draw();
		for(Jogador j: jogadores) {
			j.getPecaJogador().draw();
			j.getPecaJogador().update();
		}
		window.update();
	}
	public void desenhaDados() {
		this.dado1.draw();
		this.dado1.update();
		this.dado2.draw();
		this.dado2.update();
	}
	public Window getWindow() {
		return window;
	}
	public void setWindow(Window window) {
		this.window = window;
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public Dado getDado1() {
		return this.dado1;
	}
	public Dado getDado2() {
		return this.dado2;
	}
	public void setFaixaJogadorDaVez(int id) {
		this.faixaJogadorDaVez.loadImage(URL.sprite("faixa"+id+".png"));
	}
}