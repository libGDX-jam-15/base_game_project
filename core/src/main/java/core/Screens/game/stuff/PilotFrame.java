package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PilotFrame {

    private final Sprite background, pilot;

    public PilotFrame(Sprite backgroundSprite, Sprite pilotSprite) {
        background = new Sprite(backgroundSprite);
        pilot = new Sprite(pilotSprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        pilot.draw(spriteBatch);
    }
}