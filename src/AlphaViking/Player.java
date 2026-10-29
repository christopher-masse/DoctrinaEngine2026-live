package AlphaViking;

import Engine.Canvas;
import Engine.ControllableActor;
import Engine.Direction;
import Engine.MovementController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends ControllableActor {
    private static final String SPRITE_PATH = "images/player.png";
    private static final int ANIMATION_SPEED = 12;

    private BufferedImage spriteSheet;
    private Image[] rightFrames;
    private Image[] leftFrames;
    private Image[] upFrames;
    private Image[] downFrames;

    private int updateAnimationFrame = ANIMATION_SPEED;
    private int currentAnimationFrame = 1;

    public Player(MovementController controller, int maxWidth, int maxHeight) {
        super(controller, maxWidth, maxHeight);
        setDimensions(32,32);
    }

    public void load() {
        loadSpriteSheet();
        loadAnimationFrames();
    }

    private void loadSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnimationFrames() {
        downFrames = new Image[3];
        downFrames[0] = spriteSheet.getSubimage(0, 128, width, height);
        downFrames[1] = spriteSheet.getSubimage(32, 128, width, height);
        downFrames[2] = spriteSheet.getSubimage(64, 128, width, height);

        leftFrames = new Image[3];
        leftFrames[0] = spriteSheet.getSubimage(0, 160, width, height);
        leftFrames[1] = spriteSheet.getSubimage(32, 160, width, height);
        leftFrames[2] = spriteSheet.getSubimage(64, 160, width, height);

        rightFrames = new Image[3];
        rightFrames[0] = spriteSheet.getSubimage(0, 192, width, height);
        rightFrames[1] = spriteSheet.getSubimage(32, 192, width, height);
        rightFrames[2] = spriteSheet.getSubimage(64, 192, width, height);

        upFrames = new Image[3];
        upFrames[0] = spriteSheet.getSubimage(0, 224, width, height);
        upFrames[1] = spriteSheet.getSubimage(32, 224, width, height);
        upFrames[2] = spriteSheet.getSubimage(64, 224, width, height);
    }


    @Override
    public void update() {
        super.update();
        moveWithController();

        if (hasMoved()) {
            updateAnimationFrame--;
            if (updateAnimationFrame == 0) {
                currentAnimationFrame++;
                if (currentAnimationFrame >= 3) {
                    currentAnimationFrame = 0;
                }
                updateAnimationFrame = ANIMATION_SPEED;
            }
        } else {
            currentAnimationFrame = 1;
        }

    }

    @Override
    public void draw(Canvas canvas) {
        if (getDirection() == Direction.UP) {
            canvas.drawImage(upFrames[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.DOWN) {
            canvas.drawImage(downFrames[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.LEFT) {
            canvas.drawImage(leftFrames[currentAnimationFrame], x, y);
        } else if (getDirection() == Direction.RIGHT) {
            canvas.drawImage(rightFrames[currentAnimationFrame], x, y);
        }
    }
}
