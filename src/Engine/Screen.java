package Engine;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private JFrame mainFrame;
    private DisplayMode fullScreenDisplayMode;
    private GraphicsDevice device;
    private boolean isFullScreen;


    public Screen() {
        initializeFrame();
        initializeDevice();
    }

    private void initializeDevice() {
        device = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice();
        fullScreenDisplayMode = device.getDisplayMode();

    }

    public void fullScreen() {
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(mainFrame);
        }
        mainFrame.setLocationRelativeTo(null);
        isFullScreen = true;
    }

    public void windowed() {
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(null);
        }
        mainFrame.setLocationRelativeTo(null);
        isFullScreen = false;
    }

    private void initializeFrame() {
        mainFrame = new JFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setState(JFrame.NORMAL);
        mainFrame.setUndecorated(true);
    }

    public void start() {
        mainFrame.setVisible(true);
    }

    public void stop() {
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    public void setPanel(JPanel panel) {
        mainFrame.add(panel);
    }

    public void setSize(int width, int height) {
        mainFrame.setSize(width, height);
        mainFrame.setLocationRelativeTo(null);
    }

    public int getWidth() {
        return mainFrame.getWidth();
    }

    public int getHeight() {
        return mainFrame.getHeight();
    }

    public boolean isFullScreen() {
        return isFullScreen;
    }
}
