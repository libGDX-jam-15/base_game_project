package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import core.Screens.game.GameAssets;
import core.Screens.game.stuff.powers.GameGoal;
import core.level.LevelConfig;

import static core.config.Constants.CELL_SIZE;
import static core.config.GameConfig.SCREEN_HEIGHT;
import static core.config.GameConfig.SCREEN_WIDTH;

public class GameStuff {

    private GameAssets assets;
    // Stuff
    private Sprite background;
    private PowersPanel powersPanel;
    private RobotFrame robotFrame;
    private PilotFrame pilotFrame;
    private Grid grid;
    private Sprite hover;
    private Player player;
    private GameGoal gameGoal;
    private Sprite backBar;
    private Sprite frontBar;

    public void initializeStuff(LevelConfig levelConfig) {
        background = new Sprite(assets.getStarfield());
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        powersPanel = new PowersPanel(assets.getPixel());
        robotFrame = new RobotFrame(assets.getPixel(), assets.getRobotFrame(), assets.getRobot(), assets.getPixelFont());
        // TODO: Awake, half awake, half asleep, asleep images needed
        pilotFrame = new PilotFrame(assets.getPilotFrame(), assets.getPilot(), assets.getPilot(), assets.getPilot(), assets.getPilot());
        grid = new Grid(assets.getCell());
        hover = new Sprite(assets.getPixel());
        hover.setSize(CELL_SIZE, CELL_SIZE);
        hover.setColor(Color.CHARTREUSE.cpy().lerp(Color.CLEAR, 0.5f));
        player = new Player(assets.getTestPlayer());
        player.setPosition(grid.getCells()[(int) levelConfig.getPlayerInitialPosition().x][(int) levelConfig.getPlayerInitialPosition().y]); // player start position

        addGameGoal(levelConfig);
        backBar = new Sprite(assets.getBackBar());
        backBar.setPosition(100, SCREEN_HEIGHT - backBar.getHeight() - 20);
        backBar.setSize(SCREEN_WIDTH - 400, backBar.getHeight());
        frontBar = new Sprite(assets.getFrontBar());
        frontBar.setPosition(100, SCREEN_HEIGHT - frontBar.getHeight() - 20);

    }

    private void addGameGoal(LevelConfig levelConfig){
        Cell cell = grid.getCells()[(int) levelConfig.getExitPosition().x][(int) levelConfig.getExitPosition().y];
        gameGoal = new GameGoal(assets.getTestExit());
        gameGoal.setPosition(cell.getX(), cell.getY());
        cell.setContent(gameGoal);
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

    public PilotFrame getPilotFrame() {
        return pilotFrame;
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

    public Sprite getBackBar(){ return backBar; }

    public Sprite getFrontBar(){return frontBar; }

    // In general, stuff needs assets at initialization time
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public GameGoal getGameGoal() {
        return gameGoal;
    }
}