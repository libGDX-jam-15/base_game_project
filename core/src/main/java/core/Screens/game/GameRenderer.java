package core.Screens.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

import core.Screens.game.stuff.GameStuff;
import core.config.GameConfig;

import static core.config.Constants.ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH;

public class GameRenderer {

    // Structure
    private GameScreen screen;
    private GameStuff stuff;
    // Renderers, could be SpriteBatches or ShapeRenderers as needed
    private final SpriteBatch spriteBatch;

    public GameRenderer() {
        spriteBatch = new SpriteBatch();
    }

    public void render() {
        // Use the camera
        spriteBatch.setProjectionMatrix(screen.getCamera().combined);
        // Render the game
        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        stuff.getRobotFrame().draw(spriteBatch);
        stuff.getPilotFrame().draw(spriteBatch);
        stuff.getGrid().draw(spriteBatch);
        stuff.getHover().draw(spriteBatch);
        stuff.getPowersPanel().draw(spriteBatch);
        //stuff.getDragonLantern().draw(spriteBatch);
        stuff.getPlayer().draw(spriteBatch);
        stuff.getGameGoal().draw(spriteBatch);
        stuff.getBackBar().draw(spriteBatch);
        stuff.getFrontBar().draw(spriteBatch);
        stuff.getKeyFrameBB().draw(spriteBatch);
        stuff.getKeyFrameBT().draw(spriteBatch);
        stuff.getLvlText().draw(
                spriteBatch,
                stuff.getLvlString(),
                0,
                GameConfig.SCREEN_HEIGHT - 10,
                ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH,
                Align.center,
                true
        );
        spriteBatch.end();
    }

    // The SpriteBatch uses a projection matrix from a camera
    public void setScreen(GameScreen screen) {
        this.screen = screen;
    }

    // The renderer needs to know what to render
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}