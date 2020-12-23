package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class CellContent {

    protected final Sprite sprite;
    protected Cell cell;

    public CellContent(Sprite cellContentSprite, Cell cell) {
        sprite = new Sprite(cellContentSprite);
        this.cell = cell;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        sprite.setPosition(cell.getX(),cell.getY());
        this.cell = cell;
    }
}