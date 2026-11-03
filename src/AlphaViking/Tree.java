package AlphaViking;

import Engine.Blockade;
import Engine.Canvas;
import Engine.StaticActor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticActor {
    private static final String IMAGE_PATH = "images/tree.png";
    private Image image;
    private Blockade blockade;

    public Tree(int x, int y) {
        moveTo(x, y);
        blockade = new Blockade();
        blockade.setDimensions(22, 12);
        blockade.moveTo(x+20, y+50);
    }

    public void load() {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(IMAGE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(image, x, y);
        blockade.draw(canvas);
    }
}
