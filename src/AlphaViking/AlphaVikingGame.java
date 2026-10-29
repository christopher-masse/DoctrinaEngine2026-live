package AlphaViking;

import Engine.Canvas;
import Engine.Game;
import Engine.GamePad;

public class AlphaVikingGame extends Game {
    private GamePad gamePad;
    private Player player;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        addKeyListener(gamePad);
        player = new Player(gamePad, getWidth(), getHeight());
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
        player.draw(canvas);
    }
}
