package AlphaViking;

import Engine.GamePad;

import java.awt.event.KeyEvent;

public class AlphaVikingGamePad extends GamePad {
    private int fireKey = KeyEvent.VK_SPACE;
    private int fullScreenKey = KeyEvent.VK_F;

    public AlphaVikingGamePad() {
        bindKey(fireKey);
        bindKey(fullScreenKey);
    }

    public boolean isFirePressed() {
        return isKeyPressed(fireKey);
    }

    public boolean isFullScreenPressed() {
        return isKeyPressed(fullScreenKey);
    }
}
