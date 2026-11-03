package AlphaViking;

import Engine.Canvas;
import Engine.Game;
import Engine.GamePad;

public class AlphaVikingGame extends Game {
    private GamePad gamePad;
    private Player player;
    private World world;
    private Tree tree;

    @Override
    public void initialize() {
        gamePad = new GamePad();
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
