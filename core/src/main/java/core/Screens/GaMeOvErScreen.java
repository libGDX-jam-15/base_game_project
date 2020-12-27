package core.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

import core.GameMain;
import core.audio.AudioHandler;
import core.config.GameConfig;

public class GaMeOvErScreen extends ScreenAdapter {
    private final GameMain game;
    private OrthographicCamera cam;
    private FitViewport viewport;
    private Stage stage;
    private Skin skin;
    private AudioHandler audioHandler;

    private int topLevel;




    public GaMeOvErScreen(GameMain game) {
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

        Table table = new Table();
        table.setFillParent(true);

        Label label = new Label("GaMe OvEr AsTrOnAuT!", skin, "pixelFont");
        label.setEllipsis("...");
        table.add(label).align(Align.left);

        table.row();
        TextButton textButton = new TextButton("Try Again?", skin);
        table.add(textButton).padTop(10.0f).padBottom(2.0f).minSize(2.0f).maxWidth(300.0f).maxHeight(100.0f).prefWidth(200.0f).prefHeight(50.0f);

        table.row();
        ImageTextButton imageTextButton = new ImageTextButton("Back to Menu?", skin);
        table.add(imageTextButton).padTop(10.0f).padBottom(5.0f).spaceTop(20.0f).spaceBottom(10.0f).colspan(2);
        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
