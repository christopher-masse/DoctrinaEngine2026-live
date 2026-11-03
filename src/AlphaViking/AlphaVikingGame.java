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
        startBackgroundMusic();

        fullScreen();
    }

    private void startBackgroundMusic() {
        SoundEffects.MUSIC.loop();
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

        if (gamePad.isFullScreenPressed()) {
            if (isFullScreen()) {
                windowed();
            } else {
                fullScreen();
            }
        }

        if (cooldown > 0) {
            cooldown--;
        }

        if (gamePad.isFirePressed() && cooldown == 0) {
            cooldown = 100;
            SoundEffects.FIRE.play();
        } else if (gamePad.isFirePressed()) {
            SoundEffects.MURLOC.play();
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
