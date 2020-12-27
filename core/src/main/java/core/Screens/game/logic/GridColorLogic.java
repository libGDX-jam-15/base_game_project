package core.Screens.game.logic;

import com.badlogic.gdx.graphics.Color;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.GameStuff;

import static core.config.Constants.GRID_COLUMNS;
import static core.config.Constants.GRID_ROWS;

public class GridColorLogic {

    private GameStuff stuff;
    // Logic
    private final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.CHARTREUSE,
            Color.FOREST, Color.BLUE, Color.PURPLE};
    private int lastColorIndex;
    private Color color;
    private float progress;

    public void setup() {
        lastColorIndex = 0;
        color = colors[0];
        Cell[][] cells = stuff.getGrid().getCells();
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row].setColor(color);
            }
        }
    }

    public void update(float delta) {
        progress = progress + delta;
        if (progress >= 1f) {
            lastColorIndex = lastColorIndex + 1 == colors.length ? 0 : lastColorIndex + 1;
            progress = 0f;
        }
        int nextIndex = lastColorIndex + 1 == colors.length ? 0 : lastColorIndex + 1;
        color = colors[lastColorIndex].cpy().lerp(colors[nextIndex], progress);
        Cell[][] cells = stuff.getGrid().getCells();
        for (int column = 0; column < GRID_COLUMNS; column++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                cells[column][row].setColor(color);
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}