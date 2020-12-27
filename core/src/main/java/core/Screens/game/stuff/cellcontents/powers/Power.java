package core.Screens.game.stuff.cellcontents.powers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.cellcontents.CellContent;

import static core.config.Constants.CELL_SIZE;
import static core.config.Constants.POWER_SIZE;

public abstract class Power extends CellContent {

    public Power(Sprite powerSprite) {
        super(null, powerSprite);
        sprite.setSize(POWER_SIZE, POWER_SIZE);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        sprite.setPosition(cell.getX(), cell.getY());
        sprite.setSize(CELL_SIZE, CELL_SIZE);
    }
}