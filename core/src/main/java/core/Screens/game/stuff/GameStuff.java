package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

import core.Screens.game.GameAssets;

import static core.config.Constants.CELL_SIZE;
import static core.config.GameConfig.SCREEN_HEIGHT;
import static core.config.GameConfig.SCREEN_WIDTH;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private Sprite background;
    private PowersPanel powersPanel;
    private RobotFrame robotFrame;
    private Grid grid;
    private Sprite hover;
    private Player player;

    public void initializeStuff() {
        background = new Sprite(assets.getStarfield());
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        powersPanel = new PowersPanel(assets.getPixel());
        robotFrame = new RobotFrame(assets.getPixel(), assets.getRobotFrame(), assets.getRobot(), assets.getPixelFont());
        grid = new Grid(assets.getCell());
        hover = new Sprite(assets.getPixel());
        hover.setSize(CELL_SIZE, CELL_SIZE);
        hover.setColor(Color.CHARTREUSE.cpy().lerp(Color.CLEAR, 0.5f));
        player = new Player(assets.getTestPlayer());
        player.setPosition(grid.getCells()[0][0]);
    }

    // Stuff getters
    public Sprite getBackground() {
        return background;
    }

    public PowersPanel getPowersPanel() {
        return powersPanel;
    }

    public RobotFrame getRobotFrame() {
        return robotFrame;
    }

    public Grid getGrid() {
        return grid;
    }

    public Sprite getHover() {
        return hover;
    }

    public Player getPlayer() {
        return player;
    }

    // In general, stuff needs assets at initialization time
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}