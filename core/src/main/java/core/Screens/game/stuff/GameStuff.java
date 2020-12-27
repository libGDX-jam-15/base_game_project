package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.math.Vector2;
import core.Screens.game.GameAssets;
import core.Screens.game.stuff.powers.Asteroid;
import core.Screens.game.stuff.powers.GameGoal;
import core.level.LevelConfig;

import java.util.ArrayList;

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

    private LevelConfig levelConfig;


    private Sprite keyFrameBB;
    private Sprite keyFrameBT;

    private TextureAtlas blinkingAtlas;
    private Animation<Sprite> blinkingTop, blinkingBottom;


    public void initializeStuff(LevelConfig levelConfig) {

        this.levelConfig = levelConfig;

        background = new Sprite(assets.getStarfield());
        background.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        powersPanel = new PowersPanel(assets.getPixel());
        robotFrame = new RobotFrame(assets.getPixel(), assets.getRobotFrame(), assets.getRobot(), assets.getPixelFont());
        // TODO: Awake, half awake, half asleep, asleep images needed
        pilotFrame = new PilotFrame(assets.getPilotFrame(), assets.getPilot_1(), assets.getPilot_2(), assets.getPilot_3(), assets.getPilot_3());
        grid = new Grid(assets.getCell());
        hover = new Sprite(assets.getPixel());
        hover.setSize(CELL_SIZE, CELL_SIZE);
        hover.setColor(Color.CHARTREUSE.cpy().lerp(Color.CLEAR, 0.5f));
        player = new Player(assets.getPlayerSpaceship());
        player.setPosition(grid.getCells()[(int) levelConfig.getPlayerInitialPosition().x][(int) levelConfig.getPlayerInitialPosition().y]); // player start position

        addGameGoal(levelConfig);
        addAsteroids(levelConfig);

        backBar = new Sprite(assets.getBackBar());
        backBar.setPosition(100, SCREEN_HEIGHT - backBar.getHeight() - 20);
        backBar.setSize(SCREEN_WIDTH - 400, backBar.getHeight());
        frontBar = new Sprite(assets.getFrontBar());
        frontBar.setPosition(100, SCREEN_HEIGHT - frontBar.getHeight() - 20);

        blinkingAtlas =      assets.getBlinkingAtlas();
        Animation.PlayMode playMode = Animation.PlayMode.LOOP_PINGPONG;
        blinkingBottom =  assets.getBlinkingBottom();
        blinkingTop = assets.getBlinkingTop();


        keyFrameBB = new Sprite(assets.getKeyFrameBB());
        keyFrameBT = new Sprite(assets.getKeyFrameBT());

        //Todo set keyFrame width, and positions.
        keyFrameBB.setPosition(0, -keyFrameBB.getHeight());
        keyFrameBB.setSize(SCREEN_WIDTH, keyFrameBB.getHeight());

        keyFrameBT.setPosition(0, - keyFrameBT.getHeight());
        keyFrameBT.setSize(SCREEN_WIDTH, keyFrameBT.getHeight());
    }

    private void addGameGoal(LevelConfig levelConfig){
        Cell cell = grid.getCells()[(int) levelConfig.getExitPosition().x][(int) levelConfig.getExitPosition().y];
        gameGoal = new GameGoal(assets.getLevelGoal());
        gameGoal.setPosition(cell.getX(), cell.getY());
        cell.setContent(gameGoal);
    }

    private void addAsteroids(LevelConfig levelConfig){
        ArrayList<Vector2> asteroids = levelConfig.getAsteroids();
        for(Vector2 asteroid: asteroids){
            Cell cell = grid.getCells()[(int) asteroid.x][(int) asteroid.y];
            Asteroid asteroid1 = new Asteroid(assets.getAsteroid());
            asteroid1.setPosition(cell.getX(), cell.getY());
            cell.setContent(asteroid1);
        }
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

    public TextureAtlas getBlinkingAtlas() {
        return blinkingAtlas;
    }

    public Animation<Sprite> getBlinkingTop() {
        return blinkingTop;
    }

    public Animation<Sprite> getBlinkingBottom() {
        return blinkingBottom;
    }


    public Sprite getKeyFrameBB() {
        return keyFrameBB;
    }

    public Sprite getKeyFrameBT() {
        return keyFrameBT;
    }

    // In general, stuff needs assets at initialization time
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public GameGoal getGameGoal() {
        return gameGoal;
    }

    public LevelConfig getLevelConfig() {
        return levelConfig;
    }
}