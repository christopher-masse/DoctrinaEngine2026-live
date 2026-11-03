package Engine;

import javax.swing.*;

public class Screen {
    private JFrame mainFrame;

    public Screen() {
        initializeFrame();
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
}
