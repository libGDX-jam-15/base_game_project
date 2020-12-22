package core.Screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;

import core.Screens.game.logic.MovementLogic;
import core.Screens.game.stuff.GameStuff;
import core.util.GdxUtils;

public class GameScreen extends ScreenAdapter {

    private final GameRenderer renderer;

    public GameScreen() {
        GameAssets assets = new GameAssets();
        renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();

        assets.queueAssetLoading();
        assets.finishLoadingAssets(); // TODO: not async for now
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