package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;

import core.Screens.game.stuff.cellcontents.powers.Power;

import static core.config.Constants.POWERS_PANEL_HEIGHT;
import static core.config.Constants.POWERS_PANEL_WIDTH;
import static core.config.Constants.POWERS_PANEL_X;

public class PowersPanel {

    private final Sprite background;
    private final DelayedRemovalArray<Power> powers;

    public PowersPanel(Sprite backgroundSprite) {
        background = new Sprite(backgroundSprite);
        background.setSize(POWERS_PANEL_WIDTH, POWERS_PANEL_HEIGHT);
        background.setX(POWERS_PANEL_X);
        background.setColor(Color.PURPLE.cpy().lerp(Color.CLEAR, 0.5f));
        powers = new DelayedRemovalArray<>();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        for (int i = 0; i < powers.size; i++) {
            powers.get(i).draw(spriteBatch);
        }
    }

    public DelayedRemovalArray<Power> getPowers() {
        return powers;
    }
}