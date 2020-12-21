package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static core.Constants.CELL_SIZE;

public class Cell {

    private final Sprite sprite;
    private final int column, row;

    public Cell(Sprite cellSprite, int column, int row) {
        sprite = new Sprite(cellSprite);
        sprite.setSize(CELL_SIZE, CELL_SIZE);
        this.column = column;
        this.row = row;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    // Getters
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}