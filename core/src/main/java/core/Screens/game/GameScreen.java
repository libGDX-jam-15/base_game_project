package core.Screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

import core.GameMain;
import core.Screens.game.logic.GameLogic;
import core.Screens.game.stuff.GameStuff;
import core.audio.AudioHandler;
import core.level.LevelConfig;
import core.level.LevelJsonParser;
import core.save.LevelSave;
import core.util.GdxUtils;

import static core.config.GameConfig.SCREEN_HEIGHT;
import static core.config.GameConfig.SCREEN_WIDTH;

public class GameScreen extends ScreenAdapter {

    private GameMain game;
    private final GameLogic logic;
    private final GameRenderer renderer;
    private LevelJsonParser parser = new LevelJsonParser();
    private AudioHandler audioHandler;
    // Screen related
    private final OrthographicCamera camera;

    public GameScreen(GameMain game, int levelNumber) {
        this.game = game;
        this.audioHandler = game.getAudioHandler();
        LevelConfig levelConfig = parser.getLevelConfig(levelNumber);
        game.getGameSaveHandler().saveLevelData(new LevelSave(1, levelNumber, 0, false));

        // Create components
        GameAssets assets = new GameAssets(game.getAssetManager());
        GameInput input = new GameInput();
        logic = new GameLogic();
        renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();
        // Connect the components (not everything to everything, just as needed)
        input.setLogic(logic);
        logic.setGame(game);
        logic.setAssets(assets);
        logic.setStuff(stuff);
        renderer.setScreen(this);
        renderer.setStuff(stuff);
        stuff.setAssets(assets);
        // Initializations
        assets.initializeAssets();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
        stuff.initializeStuff(levelConfig);
        logic.initialLogic();
        audioHandler.playMusic();
    }

    @Override
    public void render(float delta) {
        // Update game state according to delta first
        logic.update(delta);
        // Then render the frame
        GdxUtils.clearScreen();
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}