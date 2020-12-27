package core.Screens.game.logic;

import core.GameMain;
import core.Screens.game.stuff.Cell;
import core.Screens.game.stuff.GameStuff;
import core.Screens.game.stuff.MoveStates;
import core.Screens.game.stuff.Player;
import core.Screens.game.stuff.cellcontents.Asteroid;
import core.Screens.game.stuff.cellcontents.CellContent;
import core.Screens.game.stuff.cellcontents.GameGoal;
import core.Screens.game.stuff.cellcontents.powers.Arrow;
import core.save.LevelSave;
import core.screenManager.ScreenEnum;
import core.screenManager.ScreenManager;

import static core.config.Constants.*;

public class MovementLogic {

    // Structure
    private GameMain game;
    private GameStuff stuff;
    // Logic
    private float stateTime;
    private MoveStates moveState;

    public MovementLogic() {
        this.moveState = MoveStates.Right;
    }

    public void update(float delta) {
        stateTime += delta;
        if (stateTime > 2) {
            stateTime = 0;
            movePlayer();
            checkCell();
        }
    }

    private void movePlayer() {
        Cell playerCell = stuff.getPlayer().getCell();
        int column = playerCell.getColumn();
        int row = playerCell.getRow();
        switch (moveState) {
            case Up:
                row++;
                if (row == GRID_ROWS) {
                    row = 0;
                }
                break;
            case Down:
                row--;
                if (row == -1) {
                    row = GRID_ROWS - 1;
                }
                break;
            case Right:
                column++;
                if (column == GRID_COLUMNS) {
                    column = 0;
                }
                break;
            case Left:
                column--;
                if (column == -1) {
                    column = GRID_COLUMNS - 1;
                }
                break;
        }
        Player player = stuff.getPlayer();
        player.setCell(stuff.getGrid().getCells()[column][row]);
    }

    private void checkCell() {
        int level = stuff.getLevelConfig().getLevelId();
        Player player = stuff.getPlayer();
        Cell playerCell = player.getCell();
        CellContent cellContent = playerCell.getContent();
        if (cellContent instanceof Arrow) {
            Arrow arrow = (Arrow) cellContent;
            switch (arrow.getDirection()) {
                case UP:
                    moveState = MoveStates.Up;
                    player.getSprite().setRotation(90f);
                    break;
                case DOWN:
                    moveState = MoveStates.Down;
                    player.getSprite().setRotation(-90f);
                    break;
                case RIGHT:
                    moveState = MoveStates.Right;
                    player.getSprite().setRotation(0f);
                    break;
                case LEFT:
                    moveState = MoveStates.Left;
                    player.getSprite().setRotation(180);
                    break;
            }
        } else if (cellContent instanceof GameGoal) {
            boolean isGameWon =  (level + 1) >=  MAX_LEVEL;
            game.getGameSaveHandler().saveLevelData(new LevelSave(1, level, 0, isGameWon));
            ScreenManager.getInstance().showScreen(ScreenEnum.LEVEL_CLEARED_SCREEN, game, level);
        } else if (cellContent instanceof Asteroid) {
            ScreenManager.getInstance().showScreen(ScreenEnum.GAME_OVER_SCREEN, game, level);
        }
    }

    public void setGame(GameMain game) {
        this.game = game;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}