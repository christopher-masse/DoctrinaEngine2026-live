package Engine;

import java.awt.*;

public abstract class MovableActor extends StaticActor {
    private int speed = 3;
    private final int maxWidth;
    private final int maxHeight;
    private Collision collision;

    private Direction direction = Direction.UP;

    private int lastX = Integer.MAX_VALUE;
    private int lastY = Integer.MAX_VALUE;
    private boolean moved = false;

    public MovableActor(int maxWidth, int maxHeight) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        collision = new Collision(this);
    }

    public void update() {
        moved = false;
    }

    public boolean hasMoved() {
        return moved;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Rectangle getHitBox() {
        return switch (direction) {
            case UP -> getUpperHitBox();
            case DOWN -> getLowerHitBox();
            case LEFT -> getLeftHitBox();
            case RIGHT -> getRightHitBox();
        };
    }

    public Rectangle getUpperHitBox() {
        return new Rectangle(x, y - speed, width, speed);
    }

    public Rectangle getLowerHitBox() {
        return new Rectangle(x, y + height, width, speed);
    }

    public Rectangle getLeftHitBox() {
        return new Rectangle(x - speed, y, speed, height);
    }

    public Rectangle getRightHitBox() {
        return new Rectangle(x + width, y, speed, height);
    }

    public boolean hitBoxIntersectsWith(StaticActor actor) {
        if (actor == null) {
            return false;
        }
        return getHitBox().intersects(actor.getBounds());
    }

    public void move() {
        int allowedSpeed = collision.getAllowedSpeed(direction);
        x = x + direction.calculateVelocityX(allowedSpeed);
        y = y + direction.calculateVelocityY(allowedSpeed);
        moved = (x != lastX || y != lastY);
        lastX = x;
        lastY = y;
    }

    public void move(Direction direction) {
        this.direction = direction;
        move();
    }

    public void moveUp(int min) {
        if (y >= min) {
            move(Direction.UP);
        }
    }

    public void moveUp() {
        if (y >= 0) {
            move(Direction.UP);
        }
    }

    public void moveLeft(int min) {
        if (x >= min) {
            move(Direction.LEFT);
        }
    }

    public void moveLeft() {
        if (x >= 0) {
            move(Direction.LEFT);
        }
    }

    public void moveDown(int max) {
        if (y <= max - height) {
            move(Direction.DOWN);
        }
    }

    public void moveDown() {
        if (y <= maxHeight - height) {
            move(Direction.DOWN);
        }
    }

    public void moveRight(int max) {
        if (x <= max-width) {
            move(Direction.RIGHT);
        }
    }

    public void moveRight() {
        if (x <= maxWidth-width) {
            move(Direction.RIGHT);
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
