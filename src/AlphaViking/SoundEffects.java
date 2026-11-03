package AlphaViking;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public enum SoundEffects {
    FIRE("audios/fire.wav"),
    MUSIC("audios/music.wav"),
    MURLOC("audios/murloc.wav");

    private String path;

    SoundEffects(String path) {
        this.path = path;
    }

    private Clip loadClip() {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream stream = AudioSystem.getAudioInputStream(
                    this.getClass().getClassLoader()
                            .getResourceAsStream(path)
            );
            clip.open(stream);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-20f);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return clip;
    }

    public void loop() {
        try (Clip clip = loadClip()) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void play() {
        try (Clip clip = loadClip()) {
            clip.start();
        }
    }
}
