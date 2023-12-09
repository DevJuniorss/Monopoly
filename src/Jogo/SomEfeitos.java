package Jogo;

import jplay.Sound;
import jplay.URL;

public class SomEfeitos {
	private static Sound musica;
	public static void play(String audio) {
		stop();
		musica = new Sound(URL.audio(audio));
		SomEfeitos.musica.play();
		SomEfeitos.musica.setRepeat(false);
	}
	public static void stop() {
		if(SomEfeitos.musica != null) {
			musica.stop();
		}
	}
}