package AlphaViking;

import Engine.Canvas;
import Engine.Game;
import Engine.GamePad;

import javax.sound.sampled.*;

public class AlphaVikingGame extends Game {
    private AlphaVikingGamePad gamePad;
    private Player player;
    private World world;
    private Tree tree;
    private int cooldown = 0;

    @Override
    public void initialize() {
        gamePad = new AlphaVikingGamePad();
        addKeyListener(gamePad);
        player = new Player(gamePad, getWidth(), getHeight());
        world = new World();
        tree = new Tree(300, 350);
        loadAssets();
    }

    private void loadAssets() {
        world.load();
        player.load();
        tree.load();
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }

        if (cooldown > 0) {
            cooldown--;
        }

        if (gamePad.isFirePressed() && cooldown == 0) {
            cooldown = 100;
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream stream = AudioSystem.getAudioInputStream(
                        this.getClass().getClassLoader()
                                .getResourceAsStream("audios/fire.wav")
                );
                clip.open(stream);
                FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(-20f);
                clip.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        player.update();
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        world.draw(canvas);
        if (player.getY() < tree.getY() + 52) {
            player.draw(canvas);
            tree.draw(canvas);
        } else {
            tree.draw(canvas);
            player.draw(canvas);
        }
    }
}
