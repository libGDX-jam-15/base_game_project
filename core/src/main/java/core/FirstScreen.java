package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends ScreenAdapter {

    private SpriteBatch spriteBatch;
    private Texture test;

    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        test = new Texture(Gdx.files.internal("mclogo.png"));
    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        spriteBatch.draw(test, 0, 0);
        spriteBatch.end();
    }
}