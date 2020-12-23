package core.Screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import core.Screens.game.logic.GameLogic;

public class GameInput extends InputAdapter {

    private GameLogic logic;

    public GameInput() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (pointer != 0) {
            return false;
        }
        logic.getInputHandler().touchDown(screenX, Gdx.graphics.getHeight() - screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (pointer != 0) {
            return false;
        }
        logic.getInputHandler().touchDragged(screenX, Gdx.graphics.getHeight() - screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (pointer != 0) {
            return false;
        }
        logic.getInputHandler().touchUp(screenX, Gdx.graphics.getHeight() - screenY);
        return true;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }
}