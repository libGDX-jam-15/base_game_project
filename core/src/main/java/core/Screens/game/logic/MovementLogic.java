package core.Screens.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.Grid;
import core.Screens.game.stuff.MoveStates;
import core.Screens.game.stuff.Player;
import core.config.Constants;

import static com.badlogic.gdx.math.MathUtils.clamp;

public class MovementLogic {
    private Grid grid;
    private Vector2 startPos;
    private int row, column;
    private Player player;
    private float stateTime;
    private MoveStates moveState;

    public MovementLogic(Player player, Grid gameStuffGrid, Cell startCell, MoveStates startState) {
        row = startCell.getRow();
        column = startCell.getColumn();
        this.player = player;
        player.setPosition(row, column);
        this.grid = gameStuffGrid;
        this.moveState = startState;
    }

    public void update(){
        stateTime += Gdx.graphics.getDeltaTime();
        if (stateTime > 2 || Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || moveState == MoveStates.Up){
                this.row++;
                stateTime = 0;
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || moveState == MoveStates.Down) {
                this.row--;
                stateTime = 0;
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || moveState == MoveStates.Right) {
                this.column++;
                stateTime = 0;
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || moveState == MoveStates.Left){
                this.column--;
                stateTime = 0;
            }
        }
        this.row = MathUtils.clamp(row, 0, Constants.GRID_ROWS - 1 );
        this.column = MathUtils.clamp(column, 0, Constants.GRID_COLUMNS - 1);

        player.setPosition(this.column, this.row);
    }

public void setGrid(Grid gameStuffGrid){
        this.grid = gameStuffGrid;
    }

    public Player getPlayer(){
        return player;
    }

    public MoveStates getMoveState(){
        return moveState;
    }

}
