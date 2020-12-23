package core.Screens.game.stuff.powers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import core.Screens.game.stuff.CellContent;

import static core.config.Constants.POWER_SIZE;

public abstract class Power extends CellContent {

    public Power(Sprite powerSprite) {
        super(powerSprite, null);
        sprite.setSize(POWER_SIZE, POWER_SIZE);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }
}