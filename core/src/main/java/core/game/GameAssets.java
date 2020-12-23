package core.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import core.loading.ImagesPaths;

// TODO: TEMPORARY CLASS FOR TESTING THE GRID DRAWING
public class GameAssets {

    private final AssetManager assetManager;
    // Sprites
    private Sprite testCell, testPlayer;
    // Fonts
    private BitmapFont font;
    // Audio

    public GameAssets(AssetManager assetManager) {
        this.assetManager = assetManager;
    }


    public void initializeAssets() {
        testCell = new Sprite(assetManager.get(ImagesPaths.TEST_CELL, Texture.class));
        testPlayer = new Sprite(assetManager.get(ImagesPaths.TEST_PLAYER, Texture.class));
    }

    // Asset getters
    public Sprite getTestCell() {
        return testCell;
    }
    public Sprite getTestPlayer(){ return testPlayer; }
}