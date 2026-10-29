package AlphaViking;

import Engine.Canvas;
import Engine.Game;
import Engine.GamePad;

public class AlphaVikingGame extends Game {
    private GamePad gamePad;
    private Player player;
    private World world;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        addKeyListener(gamePad);
        player = new Player(gamePad, getWidth(), getHeight());
        world = new World();
        world.load();
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        world.draw(canvas);
        player.draw(canvas);
    }
}
