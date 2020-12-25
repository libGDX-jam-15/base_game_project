package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Screens.LoadingScreen;
import core.Screens.MenuScreen;
import core.audio.AudioHandler;
import core.config.GameConfig;
import core.loading.LoadingPaths;
import core.save.GameSaveHandler;
import core.save.LevelSave;

public class GameMain extends Game {
    private float screenWidth;
    private float screenHeight;

    private final AssetManager assetManager = new AssetManager();
    private LoadingPaths loadingPaths = new LoadingPaths();

    public SpriteBatch batch;
    public MenuScreen menuScreen;
    private AudioHandler audioHandler;
    private GameSaveHandler gameSaveHandler;


    public GameMain() {
        super();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        audioHandler = new AudioHandler(this);
        gameSaveHandler = new GameSaveHandler();

        screenWidth = GameConfig.SCREEN_WIDTH;
        screenHeight = GameConfig.SCREEN_HEIGHT;

//		setScreen(menuScreen);
        setScreen(new LoadingScreen(this, loadingPaths,  new MenuScreen(this)));
    }

    @Override
    public void dispose() {
        batch.dispose();
        assetManager.dispose();
        super.dispose();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    public float getScreenWidth() {
        return screenWidth;
    }

    public float getScreenHeight() {
        return screenHeight;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public LoadingPaths getLoadingPaths() {
        return loadingPaths;
    }

    public AudioHandler getAudioHandler() {
        return audioHandler;
    }

    public GameSaveHandler getGameSaveHandler() {
        return gameSaveHandler;
    }
}