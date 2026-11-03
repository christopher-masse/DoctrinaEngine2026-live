package Engine;

import java.awt.*;

public class Blockade extends StaticActor {

    public Blockade() {
        CollidableRepository.getInstance().registerActor(this);
    }

    @Override
    public void draw(Canvas canvas) {
        if (Config.DEBUG) {
            canvas.drawRectangle(this, new Color(255, 0, 0, 100));
        }
    }
}
