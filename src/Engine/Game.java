package Engine;

public abstract class Game {

    private boolean playing = true;
    private RenderingEngine engine;
    private GameTime gameTime;

    public Game() {
        engine = new RenderingEngine();
    }

    public abstract void initialize();
    public abstract void update();
    public abstract void drawOnBuffer(Canvas canvas);

    public final void start() {
        engine.start();
        initialize();

        run();
    }

    private void run() {
        gameTime = new GameTime();
        while (playing) {
            update();
            drawOnBuffer(engine.buildCanvas());
            engine.drawOnScreen();
            gameTime.synchronize();
        }
    }

    public int getWidth() {
        return engine.getWidth();
    }

    public int getHeight() {
        return engine.getHeight();
    }

    public String getElapsedTime() {
        return gameTime.getElapsedFormattedTime();
    }

    public int getFps() {
        return gameTime.getCurrentFps();
    }
}
