package core.config;

import static core.config.GameConfig.SCREEN_HEIGHT;
import static core.config.GameConfig.SCREEN_WIDTH;

public class Constants {

    //
    public static final String GAME_NAME = "Astro Sleeper";

    // Grid
    public static final int GRID_COLUMNS = 20;
    public static final int GRID_ROWS = 10;
    public static final int CELL_SIZE = (int) (SCREEN_WIDTH * 0.8f / GRID_COLUMNS);
    public static final int GRID_WIDTH = CELL_SIZE * GRID_COLUMNS;
    public static final int GRID_HEIGHT = CELL_SIZE * GRID_ROWS;
    // Powers panel
    public static final int POWERS_PANEL_WIDTH = SCREEN_WIDTH / 5;
    public static final int POWERS_PANEL_HEIGHT = GRID_HEIGHT;
    public static final int POWERS_PANEL_X = GRID_WIDTH;
    // Powers
    public static final int POWER_SIZE = POWERS_PANEL_WIDTH / 2;
    public static final int POWER_X_POSITION = (int) (POWERS_PANEL_X + POWERS_PANEL_WIDTH / 2f - POWER_SIZE / 2f);
    // Robot frame
    public static final int ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH = CELL_SIZE * 3;
    public static final int ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT = (int) ((SCREEN_HEIGHT - GRID_HEIGHT) * 0.5f);
    public static final int ROBOT_FRAME_BACKGROUND_WIDTH = GRID_WIDTH - ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH / 2;
    public static final int ROBOT_FRAME_BACKGROUND_HEIGHT = (int) (ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT * 0.8f);
    public static final int ROBOT_FRAME_BACKGROUND_X = ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH / 2;
    public static final int ROBOT_FRAME_BACKGROUND_Y = GRID_HEIGHT + ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT / 2 - ROBOT_FRAME_BACKGROUND_HEIGHT / 2;
    public static final int ROBOT_FRAME_ROBOT_WIDTH = ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH / 2;
    public static final int ROBOT_FRAME_ROBOT_HEIGHT = ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT;
    public static final int ROBOT_FRAME_MESSAGE_WIDTH = ROBOT_FRAME_BACKGROUND_WIDTH - ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH - CELL_SIZE;
    public static final String[] ROBOT_MESSAGES = {
            "Wake up sir you are gonna die! please wake up!",
            "WAKE UP OMG OMG OMG!!!",
            "Earth to captain! Don't fall asleep!",
            "Find a way to stay alert captain! You're gonna fall asleep!",
            "If you don't wake up right now the ship is gonna crash!!",
    };
    // Pilot frame
    public static final int PILOT_FRAME_X = GRID_WIDTH - CELL_SIZE * 2;
    public static final int PILOT_FRAME_Y = GRID_HEIGHT;
    public static final int PILOT_FRAME_WIDTH = SCREEN_WIDTH - GRID_WIDTH + CELL_SIZE * 2;
    public static final int PILOT_FRAME_HEIGHT = SCREEN_HEIGHT - GRID_HEIGHT;
    public static final int PILOT_FRAME_PILOT_HEIGHT = (int) (PILOT_FRAME_HEIGHT * 0.8f);
    public static final int PILOT_FRAME_PILOT_WIDTH = PILOT_FRAME_WIDTH / 2;
    public static final int PILOT_FRAME_PILOT_X = PILOT_FRAME_X + PILOT_FRAME_WIDTH / 2 - PILOT_FRAME_PILOT_WIDTH / 2;
    public static final int PILOT_FRAME_PILOT_Y = PILOT_FRAME_Y + PILOT_FRAME_HEIGHT / 2 - PILOT_FRAME_PILOT_HEIGHT / 2;
    // Levels
    public static final int MAX_LEVEL = 15;
}