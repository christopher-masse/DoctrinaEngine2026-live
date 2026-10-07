package MovingRectangle;

import Engine.Canvas;

import java.awt.*;

public class Npc {
    private int positionX;
    private int positionY;
    private int speed;

    private boolean path1 = true;
    private boolean path2 = false;
    private boolean path3 = false;
    private boolean path4 = false;

    public Npc() {
        positionX = 400;
        positionY = 200;
        speed = 2;
    }

    public void update() {
        if (path1) {
            positionY += speed;
            if (positionY >= 500) {
                path1 = false;
                path2 = true;
            }
        } else if (path2) {
            positionX -= speed;
            if (positionX <= 100) {
                path2 = false;
                path3 = true;
            }
        } else if (path3) {
            positionY -= speed;
            if (positionY <= 200) {
                path3 = false;
                path4 = true;
            }
        } else if (path4) {
            positionX += speed;
            if (positionX >= 400) {
                path4 = false;
                path1 = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRectangle(positionX, positionY, 10, 10, Color.YELLOW);
    }
}
