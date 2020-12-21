package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Screens.LoadingScreen;
import core.Screens.MenuScreen;
import core.config.GameConfig;
import core.loading.LoadingPaths;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameMain extends Game {


	private float screenWidth;
	private float screenHeight;

	private final AssetManager assetManager = new AssetManager();
	private LoadingPaths loadingPaths = new LoadingPaths();

	public SpriteBatch batch;
	public MenuScreen menuScreen;

	public GameMain() {
		super();
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		menuScreen = new MenuScreen(this);

		screenWidth = GameConfig.SCREEN_WIDTH;
		screenHeight = GameConfig.SCREEN_HEIGHT;

//		setScreen(menuScreen);
		setScreen(new LoadingScreen(this, loadingPaths,  menuScreen));
	}

	@Override
	public void dispose() {
		batch.dispose();
		menuScreen.dispose();
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
}