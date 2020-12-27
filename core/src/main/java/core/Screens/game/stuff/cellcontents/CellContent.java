package core.Screens.game.stuff.cellcontents;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Screens.game.stuff.Cell;

import static core.config.Constants.CELL_SIZE;

public abstract class CellContent {

    protected Cell cell;
    protected final Sprite sprite;

    public CellContent(Cell cell, Sprite cellContentSprite) {
        this.cell = cell;
        sprite = new Sprite(cellContentSprite);
        if (cell != null) {
            sprite.setPosition(cell.getX(), cell.getY());
            sprite.setSize(CELL_SIZE, CELL_SIZE);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public Cell getCell() {
        return cell;
    }
}