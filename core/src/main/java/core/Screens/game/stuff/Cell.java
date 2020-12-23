package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static core.config.Constants.CELL_SIZE;

public class Cell {

    private final Sprite sprite;
    private final int column, row;
    private CellContent content;

    public Cell(Sprite cellSprite, int column, int row) {
        sprite = new Sprite(cellSprite);
        sprite.setSize(CELL_SIZE, CELL_SIZE);
        this.column = column;
        this.row = row;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
        if (content != null) {
            content.draw(spriteBatch);
        }
    }

    public Vector2 getCenter() {
        return new Vector2(sprite.getX() + sprite.getWidth() / 2f, sprite.getY() + sprite.getHeight() / 2f);
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public CellContent getContent() {
        return content;
    }

    public void setContent(CellContent content) {
        this.content = content;
    }
}