package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class RenderingEngine {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 536;

    private JPanel mainPanel;
    private Screen screen;

    private BufferedImage bufferedImage;

    public RenderingEngine() {
        initializeScreen();
        initializePanel();
    }

    private void initializePanel() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLUE);
        mainPanel.setFocusable(true);
        mainPanel.setDoubleBuffered(true);
        screen.setPanel(mainPanel);
    }

    public void addKeyListener(KeyListener keyListener) {
        mainPanel.addKeyListener(keyListener);
    }

    private void initializeScreen() {
        screen = new Screen();
        screen.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void start() {
        screen.start();
    }

    public Canvas buildCanvas() {
        bufferedImage = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D bufferEngine = bufferedImage.createGraphics();
        bufferEngine.setRenderingHints(buildRenderingHints());
        return new Canvas(bufferEngine);
    }

    private RenderingHints buildRenderingHints() {
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        return hints;
    }

    public int getWidth() {
        return mainPanel.getWidth();
    }

    public int getHeight() {
        return mainPanel.getHeight();
    }

    public void drawOnScreen() {
        Graphics2D graphics = (Graphics2D) mainPanel.getGraphics();

        graphics.drawImage(bufferedImage, 0, 0, mainPanel);
        graphics.dispose();
    }

    public void stop() {
        screen.stop();
    }

}
