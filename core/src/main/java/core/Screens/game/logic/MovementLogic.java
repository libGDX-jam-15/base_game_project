package core.Screens.game.logic;

import com.badlogic.gdx.math.MathUtils;
import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.CellContent;
import core.Screens.game.stuff.GameStuff;
import core.Screens.game.stuff.MoveStates;
import core.Screens.game.stuff.powers.Arrow;
import core.config.Constants;

public class MovementLogic {

    private GameStuff stuff;
    private int column, row;
    private float stateTime;
    private MoveStates moveState;

    public MovementLogic() {
        column = 0;
        row = 0;
        this.moveState = MoveStates.Right;
    }

    public void update(float delta) {
        stateTime += delta;
        if (stateTime > 2) {
            if (moveState == MoveStates.Up) {
                this.row++;
                stateTime = 0;
            } else if (moveState == MoveStates.Down) {
                this.row--;
                stateTime = 0;
            } else if (moveState == MoveStates.Right) {
                this.column++;
                stateTime = 0;
            } else if (moveState == MoveStates.Left) {
                this.column--;
                stateTime = 0;
            }
        }
        this.row = MathUtils.clamp(row, 0, Constants.GRID_ROWS - 1);
        this.column = MathUtils.clamp(column, 0, Constants.GRID_COLUMNS - 1);

        Cell newPlayerCell = stuff.getGrid().getCells()[column][row];
        stuff.getPlayer().setPosition(newPlayerCell);
        CellContent cellContent = newPlayerCell.getContent();
        if (cellContent instanceof Arrow) {
            switch (((Arrow) cellContent).getDirection()) {
                case UP: {
                    moveState = MoveStates.Up;
                    break;
                }
                case DOWN: {
                    moveState = MoveStates.Down;
                    break;
                }
                case RIGHT: {
                    moveState = MoveStates.Right;
                    break;
                }
                case LEFT: {
                    moveState = MoveStates.Left;
                    break;
                }
            }
        }
    }

    public MoveStates getMoveState() {
        return moveState;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}
