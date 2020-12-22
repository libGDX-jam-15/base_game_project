package core.Screens.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.Grid;
import core.Screens.game.stuff.Player;
import core.config.Constants;

import static com.badlogic.gdx.math.MathUtils.clamp;

public class MovementLogic {
    private Grid grid;
    private Vector2 startPos;
    private int row, column;
    private Player player;

    public MovementLogic(Player player, Grid gameStuffGrid, Cell startCell) {
        row = startCell.getRow();
        column = startCell.getColumn();
        this.player = player;
        player.setPosition(row, column);
        this.grid = gameStuffGrid;
    }

    public void update(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            this.row++;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            this.row--;
        } else  if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            this.column++;
        }else  if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            this.column--;
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

}
