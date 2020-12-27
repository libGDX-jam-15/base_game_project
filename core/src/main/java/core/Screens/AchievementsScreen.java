package core.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

import core.GameMain;
import core.audio.AudioHandler;
import core.config.GameConfig;
import core.util.GdxUtils;

import static com.badlogic.gdx.utils.compression.CRC.Table;

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
    }


    @Override
    public void show() {
        cam = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, cam);
        cam.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);

        stage = new Stage(viewport, game.batch);

        game.getAssetManager().load("Skins/freezing-ui.json", Skin.class);
        game.getAssetManager().finishLoading();


        skin = game.getAssetManager().get("Skins/freezing-ui.json");
        Gdx.input.setInputProcessor(stage);

        Gdx.input.setInputProcessor(stage);

        com.badlogic.gdx.scenes.scene2d.ui.Table table = new Table();
        table.setFillParent(true);

        Label label = new Label("Times Played: " + game.getGameSaveHandler().getSavedData().getTotalTimesPlayed(), skin, "pixelFont");
        label.setEllipsis("...");
        table.add(label).align(Align.left);

        label = new Label("Top Level Cleared: " + game.getGameSaveHandler().getSavedData().getTopLevelNumber(), skin, "pixelFont");
        label.setAlignment(Align.center);
        label.setEllipsis("...");
        table.add(label);

        table.row();
        ImageTextButton imageTextButton = new ImageTextButton("Back to Menu?", skin);
        table.add(imageTextButton).padTop(10.0f).padBottom(5.0f).spaceTop(20.0f).spaceBottom(10.0f).growY().colspan(2);
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
