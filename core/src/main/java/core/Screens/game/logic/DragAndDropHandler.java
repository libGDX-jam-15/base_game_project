package core.Screens.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.GameStuff;
import core.Screens.game.stuff.powers.Power;

public class DragAndDropHandler {

    private GameStuff stuff;
    // logic
    private Power draggedPower;
    private float pivotX, pivotY;

    public void touchDownOnPower(Power power, float x, float y) {
        draggedPower = power;
        pivotX = x - power.getBounds().getX();
        pivotY = y - power.getBounds().getY();
    }

    public void touchDragged(float x, float y) {
        if (draggedPower != null) {
            draggedPower.setPosition(x - pivotX, y - pivotY);
        }
    }

    public void touchUp() {
        draggedPower = null;
    }

    public void touchUpOnCell(Cell cell) {
        if (draggedPower == null) {
            return;
        }
        DelayedRemovalArray<Power> powers = stuff.getPowersPanel().getPowers();
        powers.begin();
        powers.removeValue(draggedPower, true);
        powers.end();
        draggedPower.setCell(cell);
        cell.setContent(draggedPower);
        draggedPower = null;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}