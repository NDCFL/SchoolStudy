package QQSQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;

public class Sound {

	public Sound(int cmd) {
		try {
			String filename = "sound/Audio.wav";
			switch(cmd){
			case QQminlin.CMD_ADDFRI:
				filename="musics/system.wav";
				break;
			case QQminlin.CMD_SEND:
				filename="musics/msg.wav";
				break;
			case QQminlin.CMD_SHAKE:
				filename="musics/shake.wav";
				break;
			case QQminlin.CMD_ONLINE:
				filename="musics/system.wav";
				break;
				
			}
			File file = new File(filename);
			InputStream is = new FileInputStream(file);
			int size = is.available();
			byte b[] = new byte[size];
			is.read(b, 0, size);
			AudioData ad = new AudioData(b);
			AudioDataStream ds = new AudioDataStream(ad);
			AudioPlayer.player.start(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Sound(QQminlin.CMD_ARGEE);
	}
}
