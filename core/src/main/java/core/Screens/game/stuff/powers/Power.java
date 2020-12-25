package core.Screens.game.stuff.powers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.CellContent;

import static core.config.Constants.CELL_SIZE;
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

    @Override
    public void setCell(Cell cell) {
        super.setCell(cell);
        sprite.setSize(CELL_SIZE, CELL_SIZE);
    }
}