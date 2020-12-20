package core;

import com.badlogic.gdx.Game;

import core.Screens.FirstScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class game extends Game {
	@Override
	public void create() {
		setScreen(new FirstScreen());
	}
}