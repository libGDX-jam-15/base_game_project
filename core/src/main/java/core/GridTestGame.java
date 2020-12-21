package core;

import com.badlogic.gdx.Game;

import core.Screens.game.GameScreen;

public class GridTestGame extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
