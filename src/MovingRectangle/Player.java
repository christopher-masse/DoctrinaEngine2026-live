package MovingRectangle;

import Engine.Canvas;
import Engine.Controller;

import java.awt.*;

public class Player {
    private Controller controller;
    private int positionX;
    private int positionY;
    private int speed;
    private final int maxWidth;
    private final int maxHeight;
    private final int height = 60;
    private final int width = 20;

    public Player(Controller controller, int width, int height) {
        this.controller = controller;
        positionX = 200;
        positionY = 200;
        speed = 3;
        maxHeight = height;
        maxWidth = width;
    }

    public void update() {
        if (controller.isUpPressed()) {
            if (positionY >= 0) {
                positionY -= speed;
            }
        } else if (controller.isDownPressed()) {
            if (positionY <= maxHeight-height) {
                positionY += speed;
            }
        } else if (controller.isLeftPressed()) {
            if (positionX >= 0) {
                positionX -= speed;
            }
        } else if (controller.isRightPressed()) {
            if (positionX <= maxWidth-width) {
                positionX += speed;
            }
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRectangle(positionX, positionY, width, height, Color.WHITE);
    }
}
