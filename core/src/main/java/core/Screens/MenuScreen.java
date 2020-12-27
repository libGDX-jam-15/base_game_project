package core.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import core.GameMain;
import core.audio.AudioHandler;
import core.config.GameConfig;
import core.screenManager.ScreenEnum;
import core.screenManager.ScreenManager;
import core.util.GdxUtils;

import static core.config.Constants.GAME_NAME;
import static core.loading.ImagesPaths.UI_SKIN_JSON;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class MenuScreen extends ScreenAdapter {
    private final GameMain game;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private Stage stage;
    private Skin skin;
    private AudioHandler audioHandler;

    private int topLevel;

    public MenuScreen(GameMain game) {
        this.game = game;
        this.audioHandler = game.getAudioHandler();
        topLevel = game.getGameSaveHandler().getSavedData().getTopLevelNumber();
    }

    @Override
    public void show() {

        cam = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, cam);
        cam.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);

        stage = new Stage(viewport, game.batch);

        game.getAssetManager().load(UI_SKIN_JSON, Skin.class);
        game.getAssetManager().finishLoading();


        skin = game.getAssetManager().get(UI_SKIN_JSON);
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        Label nameLabel = new Label(GAME_NAME, skin, "default");
        nameLabel.setEllipsis("...");
        table.add(nameLabel).spaceTop(5.0f).spaceBottom(10.0f);

        table.row();
        TextButton playButton = new TextButton("PLAY!", skin, "default");
        table.add(playButton).spaceBottom(10.0f).fillX();

        table.row();
        TextButton continueButton = new TextButton("Continue to " + topLevel, skin, "default");
        table.add(continueButton).spaceBottom(10.0f).fillX();

        table.row();
        TextButton achievements = new TextButton("Achievements", skin, "default");
        table.add(achievements).spaceBottom(10.0f).fillX();

        table.row();
        Label versionLabel = new Label(GameConfig.GAME_VERSION, skin);
        table.add(versionLabel).spaceTop(2.0f).spaceBottom(10.0f);

        table.row();
        Label numberOfTimesPlayed = new Label("Number of times played: " + game.getGameSaveHandler().getSavedData().getTotalTimesPlayed(), skin);
        table.add(numberOfTimesPlayed).spaceTop(2.0f).spaceBottom(10.0f);

        // Add listeners to buttons
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                audioHandler.playButtonSound();
                ScreenManager.getInstance().showScreen( ScreenEnum.GAME_SCREEN, game, 1 );
            }
        });

        continueButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                audioHandler.playButtonSound();
                ScreenManager.getInstance().showScreen( ScreenEnum.GAME_SCREEN, game, topLevel );
            }
        });

        achievements.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                audioHandler.playButtonSound();
                ScreenManager.getInstance().showScreen( ScreenEnum.ACHIEVEMENTS_SCREEN, game, topLevel );
            }
        });

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();
        viewport.apply();
        game.batch.setProjectionMatrix(cam.combined);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}