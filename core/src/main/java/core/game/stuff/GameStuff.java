package core.game.stuff;

import core.game.GameAssets;
import core.game.logic.MovementLogic;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private Grid grid;
    private Player player;
    private MovementLogic movementLogic;

    public void initializeStuff() {
        grid = new Grid(assets.getTestCell());
        player = new Player(assets.getTestPlayer());
        movementLogic = new MovementLogic(player, grid, grid.getCells()[1][1]);
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