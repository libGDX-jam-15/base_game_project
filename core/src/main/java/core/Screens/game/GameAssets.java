package core.Screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

// TODO: TEMPORARY CLASS FOR TESTING THE GRID DRAWING
public class GameAssets {

    private final AssetManager assetManager;
    // Sprites
    private Sprite testCell;
    // Fonts
    private BitmapFont font;
    // Audio

    public GameAssets() {
        assetManager = new AssetManager();
    }

    public void queueAssetLoading() {
        assetManager.load("testCell.png", Texture.class);
    }

    // TODO: This is temporary, not asynchronous and just to test the grid
    public void finishLoadingAssets() {
        assetManager.finishLoading();
    }

    // TODO: Use this to load asynchronously
    public boolean loadAssets() {
        return assetManager.update();
    }

    public void initializeAssets() {
        testCell = new Sprite(assetManager.get("testCell.png", Texture.class));
    }

    // Asset getters
    public Sprite getTestCell() {
        return testCell;
    }
}