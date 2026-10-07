import java.awt.*;

public final class BouncingBallGame extends Game {
    private final int SCORE_INCREMENT = 10;
    private int score;
    private Ball ball;

    @Override
    public void initialize() {
        ball = new Ball(getWidth(), getHeight());
        score = 0;
    }

    @Override
    public void update() {
        score += ball.update() * SCORE_INCREMENT;
    }

    @Override
    public void drawOnBuffer(Canvas canvas) {
        drawBackground(canvas);
        drawScore(canvas);

        ball.draw(canvas);
    }

    private void drawBackground(Canvas canvas) {
        canvas.drawRectangle(0,0, getWidth(), getHeight(), Color.BLUE);
    }

    private void drawScore(Canvas canvas) {
        canvas.drawString(10, 20, "Score: " + score,  Color.WHITE);
    }
}
