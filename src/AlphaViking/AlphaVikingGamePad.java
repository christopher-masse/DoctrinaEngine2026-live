package AlphaViking;

import Engine.GamePad;

import java.awt.event.KeyEvent;

public class AlphaVikingGamePad extends GamePad {
    private int fireKey = KeyEvent.VK_SPACE;

    public AlphaVikingGamePad() {
        bindKey(fireKey);
    }

    public boolean isFirePressed() {
        return isKeyPressed(fireKey);
    }
}
