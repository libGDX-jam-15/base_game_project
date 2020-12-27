package core.screenManager;

import com.badlogic.gdx.Screen;

/**
 * Based on http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/
 */

public interface ScreenEnumInterface {
    public abstract Screen getScreen(Object... params);
}

