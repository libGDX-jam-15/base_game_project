package core.screenManager;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import core.GameMain;
import core.Screens.LoadingScreen;
import core.Screens.MenuScreen;
import core.Screens.game.GameScreen;
import core.loading.LoadingPaths;


/**
 * Based on http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/
 */

public enum ScreenEnum implements ScreenEnumInterface {
    GAME_SCREEN {
        public Screen getScreen(Object... params) {
            return new GameScreen((GameMain) params[0], (Integer) params[1]);
        }
    },
    LOADING_SCREEN {
        public Screen getScreen(Object... params) {
            return new LoadingScreen((GameMain)params[0], (LoadingPaths)params[1], (ScreenAdapter)params[2]);
        }
    },
    MENU_SCREEN {
        public Screen getScreen(Object... params) {
            return new MenuScreen((GameMain)params[0]);
        }
    }

}
