package core.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static core.config.Constants.CELL_SIZE;
import static core.config.Constants.GRID_COLUMNS;
import static core.config.Constants.GRID_ROWS;

public class Grid {

    private final Cell[][] cells;

    public Grid(Sprite cellSprite) {
        cells = new Cell[GRID_COLUMNS][];
        for (int column = 0; column < GRID_COLUMNS; column++) {
            cells[column] = new Cell[GRID_ROWS];
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row] = new Cell(cellSprite, column, row);
                cells[column][row].setPosition(column * CELL_SIZE, row * CELL_SIZE);
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row].draw(spriteBatch);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}