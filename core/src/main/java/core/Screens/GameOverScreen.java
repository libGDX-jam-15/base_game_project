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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import core.GameMain;
import core.audio.AudioHandler;
import core.config.GameConfig;
import core.screenManager.ScreenEnum;
import core.screenManager.ScreenManager;
import core.util.GdxUtils;

import static core.loading.ImagesPaths.UI_SKIN_JSON;

public class GameOverScreen extends ScreenAdapter {
    private final GameMain game;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private Stage stage;
    private Skin skin;
    private AudioHandler audioHandler;

    private int currentLevel;


    public GameOverScreen(GameMain game, int currentLevel) {
        this.game = game;
        this.audioHandler = game.getAudioHandler();
        this.currentLevel = currentLevel;
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

        com.badlogic.gdx.scenes.scene2d.ui.Table table = new Table();
        table.setFillParent(true);

        Label label = new Label("GAME OVER ", skin);
        label.setEllipsis("...");
        table.add(label).align(Align.left);

        table.row();
        TextButton retryButton = new TextButton("Retry!", skin, "default");
        table.add(retryButton).spaceBottom(10.0f).fillX();


        table.row();
        TextButton menuButton = new TextButton("Back to Menu!", skin, "default");
        table.add(menuButton).spaceBottom(10.0f).fillX();
        stage.addActor(table);

        // Add listeners to buttons

        retryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                audioHandler.playButtonSound();
                ScreenManager.getInstance().showScreen(ScreenEnum.GAME_SCREEN, game, currentLevel);
            }
        });

        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                audioHandler.playButtonSound();
                ScreenManager.getInstance().showScreen(ScreenEnum.MENU_SCREEN, game);
            }
        });

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
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
