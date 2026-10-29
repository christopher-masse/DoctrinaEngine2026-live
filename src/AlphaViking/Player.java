package AlphaViking;

import Engine.Canvas;
import Engine.ControllableActor;
import Engine.MovementController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends ControllableActor {
    private static final String SPRITE_PATH = "images/player.png";

    private BufferedImage spriteSheet;
    private Image[] rightFrames;
    private Image[] leftFrames;
    private Image[] upFrames;
    private Image[] downFrames;

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
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(downFrames[1], x, y);
    }
}
