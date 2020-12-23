package core.Screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;

import core.GameMain;
import core.Screens.game.logic.GameLogic;
import core.Screens.game.stuff.GameStuff;
import core.util.GdxUtils;

public class GameScreen extends ScreenAdapter {

    private GameMain game;
    private final GameLogic logic;
    private final GameRenderer renderer;

    public GameScreen(GameMain game) {
        this.game = game;
        // Create components
        GameAssets assets = new GameAssets(game.getAssetManager());
        GameInput input = new GameInput();
        logic = new GameLogic();
        renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();
        // Connect the components (not everything to everything, just as needed)
        input.setLogic(logic);
        logic.setAssets(assets);
        logic.setStuff(stuff);
        renderer.setStuff(stuff);
        stuff.setAssets(assets);
        // Initialize assets and stuff
        assets.initializeAssets();
        stuff.initializeStuff();
    }

    @Override
    public void render(float delta) {
        // Update game state according to delta first
        logic.update(delta);
        // Then render the frame
        GdxUtils.clearScreen(Color.NAVY);
        renderer.render();
    }
}