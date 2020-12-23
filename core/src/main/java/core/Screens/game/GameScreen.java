package core.Screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;

import core.GameMain;
import core.Screens.game.stuff.GameStuff;
import core.util.GdxUtils;

public class GameScreen extends ScreenAdapter {

    private GameMain game;
    private final GameRenderer renderer;

    public GameScreen(GameMain game) {
        this.game = game;
        GameAssets assets = new GameAssets(game.getAssetManager());
        renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();

        assets.initializeAssets();

        renderer.setStuff(stuff);
        stuff.setAssets(assets);

        stuff.initializeStuff();

        stuff.getGrid().getCells();
        //stuff.getPlayer().setPosition( 1,1);


    }

    @Override
    public void render(float delta) {
        // Update game state according to delta first
        // todo: logic.update(delta);
        // Then render the frame
        GdxUtils.clearScreen(Color.CHARTREUSE);
        renderer.render();
    }
}