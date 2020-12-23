package core.Screens.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.GameStuff;
import core.Screens.game.stuff.powers.Power;

public class InputHandler {

    private GameLogic logic;
    private GameStuff stuff;

    public void touchDown(float x, float y) {
        DelayedRemovalArray<Power> powers = stuff.getPowersPanel().getPowers();
        for (int i = 0; i < powers.size; i++) {
            Power power = powers.get(i);
            if (power.getBounds().contains(x, y)) {
                logic.getDragAndDropHandler().touchDownOnPower(power, x, y);
                break;
            }
        }
    }

    public void touchDragged(float x, float y) {
        outer:
        for (Cell[] cellRow : stuff.getGrid().getCells()) {
            for (Cell cell : cellRow) {
                if (cell.getBounds().contains(x, y)) {
                    logic.getDragAndDropHandler().dragOverCell(cell);
                    break outer;
                }
            }
        }
        logic.getDragAndDropHandler().touchDragged(x, y);
    }

    public void touchUp(float x, float y) {
        for (Cell[] cellRow : stuff.getGrid().getCells()) {
            for (Cell cell : cellRow) {
                if (cell.getBounds().contains(x, y)) {
                    logic.getDragAndDropHandler().touchUpOnCell(cell);
                    return;
                }
            }
        }
        logic.getDragAndDropHandler().touchUp();
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}