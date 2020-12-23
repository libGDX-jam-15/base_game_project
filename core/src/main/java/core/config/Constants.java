package core.config;

import static core.config.GameConfig.SCREEN_WIDTH;

public class Constants {

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
}