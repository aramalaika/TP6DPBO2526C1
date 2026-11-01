import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip bgmClip;

    public void playBGM() {
        try {
            File file = new File("src/sounds/bgm.wav");
            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(file);

            bgmClip = AudioSystem.getClip();
            bgmClip.open(audio);
            bgmClip.loop(Clip.LOOP_CONTINUOUSLY);
            bgmClip.start();

        } catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException e) {
            System.out.println("BGM gagal: " + e.getMessage());
        }
    }

    public void stopBGM() {
        if (bgmClip != null && bgmClip.isRunning()) {
            bgmClip.stop();
        }
    }

    public void playSFX(String namaFile) {
        try {
            File file = new File("src/sounds/" + namaFile);
            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(file);

            Clip sfxClip = AudioSystem.getClip();
            sfxClip.open(audio);
            sfxClip.start();

            sfxClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    sfxClip.close();
                }
            });

        } catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException e) {
            System.out.println("SFX gagal: " + e.getMessage());
        }
    }
}
