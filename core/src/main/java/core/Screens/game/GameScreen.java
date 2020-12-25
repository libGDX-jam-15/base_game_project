package core.Screens.game;

import com.badlogic.gdx.ScreenAdapter;
import core.GameMain;
import core.Screens.game.logic.GameLogic;
import core.Screens.game.stuff.GameStuff;
import core.audio.AudioHandler;
import core.level.LevelConfig;
import core.level.LevelJsonParser;
import core.save.LevelSave;
import core.util.GdxUtils;

public class GameScreen extends ScreenAdapter {

    private GameMain game;
    private final GameLogic logic;
    private final GameRenderer renderer;
    private LevelJsonParser parser = new LevelJsonParser();
    private AudioHandler audioHandler;

    public GameScreen(GameMain game, int levelNumber) {
        this.game = game;
        this.audioHandler = new AudioHandler(game);
        LevelConfig levelConfig = parser.getLevelConfig(levelNumber);
        game.getGameSaveHandler().saveLevelData(new LevelSave(1, levelNumber, 0, false ));


        // Create components
        GameAssets assets = new GameAssets(game.getAssetManager());
        GameInput input = new GameInput();
        logic = new GameLogic(levelConfig);
        renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();
        // Connect the components (not everything to everything, just as needed)
        input.setLogic(logic);
        logic.setAssets(assets);
        logic.setStuff(stuff);
        renderer.setStuff(stuff);
        stuff.setAssets(assets);
        // Initialize assets and stuff
        assets.initializeAssets();
        stuff.initializeStuff(levelConfig);
    }



    @Override
    public void render(float delta) {
        // Update game state according to delta first
        logic.update(delta);
        // Then render the frame
        GdxUtils.clearScreen();
        renderer.render();
    }
}