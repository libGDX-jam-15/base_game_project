package core.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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

public class AchievementsScreen extends ScreenAdapter {
    private final GameMain game;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private Stage stage;
    private Skin skin;
    private AudioHandler audioHandler;

    private int topLevel;

    public AchievementsScreen(GameMain game) {
        this.game = game;
        this.audioHandler = game.getAudioHandler();
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

        Label timesPlayedLabel = new Label("Times Played: " + game.getGameSaveHandler().getSavedData().getTotalTimesPlayed(), skin);
        table.add(timesPlayedLabel).align(Align.center);

        table.row();
        Label topLevelLabel = new Label("Top Level Cleared: " + game.getGameSaveHandler().getSavedData().getTopLevelNumber(), skin);
        topLevelLabel.setAlignment(Align.center);
        table.add(topLevelLabel);

        table.row();
        String gameCompleted = "no";
        if(game.getGameSaveHandler().getSavedData().isGameWon()){
            gameCompleted = "YES - Congratulations";
//            TODO add Dragon Lantern image
        }
        Label gameCompleteLabel = new Label("Game completed: " + gameCompleted, skin);
        gameCompleteLabel.setAlignment(Align.center);
        table.add(gameCompleteLabel);

        table.row();
        TextButton menuButton = new TextButton("Back to Menu!", skin, "default");
        table.add(menuButton).spaceBottom(10.0f).fillX();
        stage.addActor(table);

        // Add listeners to buttons
        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                audioHandler.playButtonSound();
                ScreenManager.getInstance().showScreen( ScreenEnum.MENU_SCREEN, game );
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
