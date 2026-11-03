package AlphaViking;

import Engine.Canvas;
import Engine.StaticActor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticActor {
    private static final String IMAGE_PATH = "images/tree.png";
    private Image image;

    public Tree(int x, int y) {
        moveTo(x, y);
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
    }
}
