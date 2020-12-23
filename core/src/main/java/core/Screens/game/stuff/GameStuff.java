package core.Screens.game.stuff;

import core.Screens.game.GameAssets;
import core.Screens.game.logic.MovementLogic;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private Grid grid;
    private Player player;
    private MovementLogic movementLogic;

    public void initializeStuff() {
        grid = new Grid(assets.getTestCell());
        player = new Player(assets.getTestPlayer(), grid);
        movementLogic = new MovementLogic(player, grid, grid.getCells()[1][1], MoveStates.Right);
    }

    // Stuff getters
    public Grid getGrid() {
        return grid;
    }
    public Player getPlayer() { return player; }
    public MovementLogic getMovementLogic() {return movementLogic; }

    // In general, stuff needs assets at construction time
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}