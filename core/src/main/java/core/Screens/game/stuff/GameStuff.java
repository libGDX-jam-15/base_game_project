package core.Screens.game.stuff;

import core.Screens.game.GameAssets;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private Grid grid;

    public void initializeStuff() {
        grid = new Grid(assets.getTestCell());
    }

    // Stuff getters
    public Grid getGrid() {
        return grid;
    }

    // In general, stuff needs assets at construction time
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}