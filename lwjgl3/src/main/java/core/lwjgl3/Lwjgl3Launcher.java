package core.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import core.GameMain;

import core.config.GameConfig;

import static core.config.Constants.GAME_NAME;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
	public static void main(String[] args) {
		createApplication();
	}

	private static Lwjgl3Application createApplication() {
		return new Lwjgl3Application(new GameMain(), getDefaultConfiguration());
	}

	private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle(GAME_NAME);
		configuration.setWindowedMode(GameConfig.SCREEN_DESKTOP_DISPLAY_WIDTH, GameConfig.SCREEN_DESKTOP_DISPLAY_HEIGHT);
		configuration.setWindowIcon("spaceship_64x64.png", "spaceship_64x64.png", "spaceship_32x32.png", "spaceship_32x32.png");
		return configuration;
	}
}