package core.Screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import core.GameMain;
import core.loading.LoadingPaths;
import core.util.GdxUtils;

public class LoadingScreen extends ScreenAdapter {

    private static final float PROGRESS_BAR_WIDTH = 400;
    private static final float PROGRESS_BAR_HEIGHT = 30;
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private Camera camera;
    private float progress = 0;
    private final GameMain game;
    protected final AssetManager assetManager;
    protected final LoadingPaths loadingPaths;
    protected ScreenAdapter firstScreen;

    public LoadingScreen(GameMain game, LoadingPaths loadingPaths, ScreenAdapter firstScreen) {
        this.game = game;
        this.assetManager = game.getAssetManager();
        this.loadingPaths = loadingPaths;
        this.firstScreen = firstScreen;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.position.set(game.getScreenWidth() / 2, game.getScreenHeight(), 0);
        camera.update();
        viewport = new FitViewport(game.getScreenWidth(), game.getScreenHeight(), camera);
        shapeRenderer = new ShapeRenderer();

        // Textures
        if (loadingPaths.getTexturePaths() != null)
            loadingPaths.getTexturePaths()
                    .forEach(path -> {
                        if (path != null) assetManager.load(path, Texture.class);
                    });

        // BitmapFonts
        if (loadingPaths.getFontPaths() != null)
            loadingPaths.getFontPaths()
                    .forEach(path -> {
                        if (path != null) assetManager.load(path, BitmapFont.class);
                    });

        // TileMaps
        if (loadingPaths.getTileMapPaths() != null)
            loadingPaths.getTileMapPaths()
                    .forEach(path -> {
                        if (path != null) assetManager.load(path, TiledMap.class);
                    });

        // Musics
        if (loadingPaths.getMusicPaths() != null)
            loadingPaths.getMusicPaths()
                    .forEach(path -> {
                        if (path != null) assetManager.load(path, Music.class);
                    });

        // Sounds
        if (loadingPaths.getSoundPaths() != null)
            loadingPaths.getSoundPaths()
                    .forEach(path -> {
                        if (path != null) assetManager.load(path, Sound.class);
                    });

        //TextureAtlases
        if (loadingPaths.getTextureAtlasPaths() != null)
            loadingPaths.getTextureAtlasPaths()
                    .forEach(path -> {
                        if (path != null) assetManager.load(path, TextureAtlas.class);
                    });



    }


    @Override
    public void render(float delta) {
        update();
        GdxUtils.clearScreen();
        draw();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    private void update() {
        if (assetManager.update()) {
            game.setScreen(firstScreen);
        } else {
            progress = assetManager.getProgress();
        }
    }

    private void draw() {
        shapeRenderer.setProjectionMatrix(camera.projection);
        shapeRenderer.setTransformMatrix(camera.view);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(
                (game.getScreenWidth() - PROGRESS_BAR_WIDTH) / 2,
                (game.getScreenHeight() - PROGRESS_BAR_HEIGHT / 2),
                progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
        shapeRenderer.end();

    }
}