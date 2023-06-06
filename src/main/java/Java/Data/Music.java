package Java.Data;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public interface Music {
    static void playMusic() {
        String musicFile = "music.wav";
        URL url = Thread.currentThread().getContextClassLoader().getResource(musicFile);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

            int loopCount = Clip.LOOP_CONTINUOUSLY;
            clip.setLoopPoints(0, -1);
            clip.loop(loopCount);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
