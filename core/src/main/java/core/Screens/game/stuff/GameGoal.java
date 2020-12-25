package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static core.config.Constants.CELL_SIZE;

public class GameGoal {

    private final Sprite sprite;
    private Cell cell;

    public GameGoal(Sprite gameEndSprite) {
        sprite = new Sprite(gameEndSprite);
        sprite.setSize(CELL_SIZE, CELL_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public Vector2 getCenter() {
        return new Vector2(sprite.getX() + sprite.getWidth() / 2f, sprite.getY() + sprite.getHeight() / 2f);
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public void setPosition(Cell cell) {
        sprite.setPosition(cell.getX(), cell.getY());
        this.cell = cell;
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

    public Cell getCell() {
        return cell;
    }
}