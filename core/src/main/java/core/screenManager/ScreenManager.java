package core.screenManager;

import com.badlogic.gdx.Screen;
import core.GameMain;

/**
 * Based on http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/
 */

public class ScreenManager {

    private static ScreenManager instance;
    private GameMain game;
    private ScreenManager() {
    }

    // Singleton: retrieve instance
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void initialize(GameMain game) {
        this.game = game;
    }

    // Show in the game the screen which enum type is received
    public void showScreen(ScreenEnumInterface screenEnumInterface, Object... params) {

        // Get current screen to dispose it
        Screen currentScreen = game.getScreen();

        // Show new screen
        Screen newScreen = screenEnumInterface.getScreen(params);
        game.setScreen(newScreen);

        // Dispose previous screen
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }
}
