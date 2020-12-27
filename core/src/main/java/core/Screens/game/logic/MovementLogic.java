package core.Screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
    private Sprite player;


    public MovementLogic() {
        this.moveState = MoveStates.Right;
    }

    public void update(float delta) {
        column = stuff.getPlayer().getCell().getColumn();
        row = stuff.getPlayer().getCell().getRow();

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
        this.row = MathUtils.clamp(row, -1, Constants.GRID_ROWS );
        this.column = MathUtils.clamp(column, -1, Constants.GRID_COLUMNS);

        switch(row){
            case -1:{
                row = Constants.GRID_ROWS - 1;
                break;
            }
            case Constants.GRID_ROWS:{
                row = 0;
                break;
            }
        }

        switch (column){
            case -1:{
                column = Constants.GRID_COLUMNS - 1;
                break;
            } case Constants.GRID_COLUMNS:{
                column = 0;
                break;
            }
        }

        Cell newPlayerCell = stuff.getGrid().getCells()[column][row];
        stuff.getPlayer().setPosition(newPlayerCell);
        CellContent cellContent = newPlayerCell.getContent();
        if (cellContent instanceof Arrow) {
            switch (((Arrow) cellContent).getDirection()) {
                case UP: {
                    moveState = MoveStates.Up;

                    player.rotate(25);
                    break;
                }
                case DOWN: {
                    moveState = MoveStates.Down;

                   player.rotate(-25);
                    break;
                }
                case RIGHT: {
                    moveState = MoveStates.Right;

                    player.rotate(-25);
                    break;
                }
                case LEFT: {
                    moveState = MoveStates.Left;

                   player.rotate(25);
                    break;
                }
            }
        } else
            switch (moveState){
            case Up:{
                stuff.getPlayer().getSprite().setRotation(90f);
                stuff.getPlayer().setPosition(newPlayerCell);
                break;}
            case Down:{
                stuff.getPlayer().getSprite().setRotation(-90f);
                stuff.getPlayer().setPosition(newPlayerCell);
                break;}
            case Right:{
                stuff.getPlayer().getSprite().setRotation(0f);
                stuff.getPlayer().setPosition(newPlayerCell);
                break;}
            case Left:{
                stuff.getPlayer().getSprite().setRotation(180);
                stuff.getPlayer().setPosition(newPlayerCell);
                break;}
        }


    }

    public MoveStates getMoveState() {
        return moveState;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
        player = stuff.getPlayer().getSprite();
        player.setOrigin(player.getWidth()/2, player.getOriginY()/2);
    }
}
