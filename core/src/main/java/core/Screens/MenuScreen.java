package core.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;

import core.GameMain;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class MenuScreen implements Screen {
    private GameMain game;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private Stage stage;
    private Skin skin;

    public MenuScreen(GameMain game) {
        this.game = game;
    }

    @Override
    public void show() {

    cam = new OrthographicCamera();
    viewport = new FitViewport(800, 400, cam);
    cam.position.set(viewport.getWorldWidth()/2, viewport.getWorldHeight()/2, 0);

    stage = new Stage(viewport, game.batch);

    game.assetManager.load("Skins/freezing-ui.json", Skin.class);
    game.assetManager.finishLoading();


        skin = game.assetManager.get("Skins/freezing-ui.json");
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        Label label = new Label("SLEEPER JEEPER", skin, "pixelFont");
        label.setEllipsis("...");
        table.add(label).spaceTop(5.0f).spaceBottom(10.0f);

        table.row();
        TextButton textButton = new TextButton("PLAY!", skin, "pixelFont");
        table.add(textButton).spaceBottom(10.0f).fillX();

        table.row();
        textButton = new TextButton("LEVELS", skin, "pixelFont");
        table.add(textButton).spaceBottom(10.0f).fillX();

        table.row();
        textButton = new TextButton("HighScores", skin, "pixelFont");
        table.add(textButton).spaceBottom(10.0f).fillX();
        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
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