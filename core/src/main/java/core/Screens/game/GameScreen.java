package core.Screens.game;

import com.badlogic.gdx.ScreenAdapter;

import core.Screens.game.stuff.GameStuff;

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
    }

    @Override
    public void render(float delta) {
        // Update game state according to delta first
        // todo: logic.update(delta);
        // Then render the frame
        renderer.render();
    }
}