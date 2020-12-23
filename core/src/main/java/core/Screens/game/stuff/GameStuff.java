package core.Screens.game.stuff;

import core.Screens.game.GameAssets;
import core.Screens.game.logic.MovementLogic;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private PowersPanel powersPanel;
    private Grid grid;
    private Player player;
    private MovementLogic movementLogic;

    public void initializeStuff() {
        powersPanel = new PowersPanel(assets.getPixel());
        grid = new Grid(assets.getTestCell());
        player = new Player(assets.getTestPlayer(), grid);
        movementLogic = new MovementLogic(player, grid, grid.getCells()[1][1], MoveStates.Right);
    }

    // Stuff getters
    public PowersPanel getPowersPanel() {
        return powersPanel;
    }
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