package core.config;


public class GameConfig {

    private GameConfig() {
    }

    public static final int SCREEN_WIDTH = 800; // pixels

    public static final int SCREEN_HEIGHT = 480; // pixels
    // Only used for HTML Display size
    public static final int SCREEN_HTML_DISPLAY_WIDTH = SCREEN_WIDTH; // pixels

    public static final int SCREEN_HTML_DISPLAY_HEIGHT = SCREEN_HEIGHT; // pixels
    // Only used for Desktop Display size
    public static final int SCREEN_DESKTOP_DISPLAY_WIDTH = SCREEN_WIDTH; // pixels

    public static final int SCREEN_DESKTOP_DISPLAY_HEIGHT = SCREEN_HEIGHT; // pixels

    public static final String GAME_VERSION = "V.0.0.1";

    public static final boolean DEBUG = true;
}