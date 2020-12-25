package core.Screens.game.stuff.powers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.CellContent;

import static core.config.Constants.CELL_SIZE;
import static core.config.Constants.POWER_SIZE;

public class GameGoal extends CellContent {

    public GameGoal(Sprite sprite) {
        super(sprite, null);
        //TODO fix size BUG
        this.sprite.setSize(POWER_SIZE/2.5f, POWER_SIZE/2.5f);
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