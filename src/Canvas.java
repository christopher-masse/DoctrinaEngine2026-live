import java.awt.*;

public class Canvas {
    private Graphics2D graphics;

    public Canvas(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public void drawRectangle(int x, int y, int width, int height, Paint paint) {
        graphics.setPaint(paint);
        graphics.fillRect(x, y, width, height);
    }

    public void drawCircle(int x, int y, int diameter, Paint paint) {
        graphics.setPaint(paint);
        graphics.fillOval(x, y, diameter, diameter);
    }

    public void drawString(int x, int y, String string, Paint paint) {
        graphics.setPaint(paint);
        graphics.drawString(string, x, y);
    }
}
