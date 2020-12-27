package core.Screens.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.GameStuff;
import core.Screens.game.stuff.cellcontents.powers.Power;

import static core.config.Constants.CELL_SIZE;
import static core.config.Constants.POWER_SIZE;
import static core.config.Constants.POWER_X_POSITION;

public class DragAndDropHandler {

    private GameStuff stuff;
    // logic
    private Power draggedPower;
    private float initialX, initialY;
    private float pivotX, pivotY;

    public void touchDownOnPower(Power power, float x, float y) {
        draggedPower = power;
        initialX = power.getBounds().x;
        initialY = power.getBounds().y;
        pivotX = x - power.getBounds().getX();
        pivotY = y - power.getBounds().getY();
    }

    public void dragOverCell(Cell cell) {
        clearHighlightedCell();
        cell.setColor(Color.CHARTREUSE);
        stuff.getHover().setPosition(cell.getX(), cell.getY());
    }

    public void touchDragged(float x, float y) {
        if (draggedPower != null) {
            draggedPower.setPosition(x - pivotX, y - pivotY);
        }
    }

    public void touchUp() {
        if (draggedPower != null) {
            draggedPower.setPosition(initialX, initialY);
        }
        draggedPower = null;
        clearHighlightedCell();
    }

    public void touchUpOnCell(Cell cell) {
        clearHighlightedCell();
        if (draggedPower == null) {
            return;
        }
        if (!cell.isEmpty()) {
            draggedPower.setPosition(initialX, initialY);
            draggedPower = null;
            return;
        }
        accommodatePowers();
        placePower(cell);
    }

    private void clearHighlightedCell() {
        for (Cell[] cellRow : stuff.getGrid().getCells()) {
            for (Cell c : cellRow) {
                c.setColor(Color.WHITE);
            }
        }
        stuff.getHover().setPosition(-CELL_SIZE, -CELL_SIZE);
    }

    private void accommodatePowers() {
        DelayedRemovalArray<Power> powers = stuff.getPowersPanel().getPowers();
        powers.begin();
        powers.removeValue(draggedPower, true);
        powers.end();
        for (int i = 0; i < powers.size; i++) {
            powers.get(i).setPosition(POWER_X_POSITION, POWER_SIZE * i);
        }
    }

    private void placePower(Cell cell) {
        draggedPower.setCell(cell);
        cell.setContent(draggedPower);
        draggedPower = null;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}