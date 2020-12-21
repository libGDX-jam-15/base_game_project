package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Screens.MenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameMain extends Game {
	public AssetManager assetManager;
	public SpriteBatch batch;
	public MenuScreen menuScreen;

	public GameMain() {
		super();
	}

	@Override
	public void create() {
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
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


}