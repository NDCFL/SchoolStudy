package QQfase;

import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sound {
	public Sound(String filename) {
		try {
			FileInputStream fileau = new FileInputStream("musics/"+filename);
			AudioStream as = new AudioStream(fileau);
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		new Sound();
	}
}
