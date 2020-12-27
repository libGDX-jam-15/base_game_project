package core.Screens.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Screens.game.stuff.GameStuff;
import core.config.GameConfig;

public class GameRenderer {

    private GameStuff stuff;
    // Renderers, could be SpriteBatches or ShapeRenderers as needed
    private final SpriteBatch spriteBatch;

    public GameRenderer() {
        spriteBatch = new SpriteBatch();
    }

    public void render() {
        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        stuff.getRobotFrame().draw(spriteBatch);
        stuff.getPilotFrame().draw(spriteBatch);
        stuff.getGrid().draw(spriteBatch);
        stuff.getHover().draw(spriteBatch);
        stuff.getPowersPanel().draw(spriteBatch);
        stuff.getPlayer().draw(spriteBatch);
        stuff.getGameGoal().draw(spriteBatch);
        stuff.getBackBar().draw(spriteBatch);
        stuff.getFrontBar().draw(spriteBatch);
        stuff.getKeyFrameBB().draw(spriteBatch);
        stuff.getKeyFrameBT().draw(spriteBatch);
        stuff.getLvlText().draw(spriteBatch, stuff.getLvlString(), 0, GameConfig.SCREEN_HEIGHT - 10);
        spriteBatch.end();
    }

    // The renderer needs to know what to render
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}