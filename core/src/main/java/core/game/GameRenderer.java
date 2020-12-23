package core.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.game.stuff.GameStuff;

public class GameRenderer {

    private GameStuff stuff;
    // Renderers, could be SpriteBatches or ShapeRenderers as needed
    private final SpriteBatch spriteBatch;

    public GameRenderer() {
        spriteBatch = new SpriteBatch();
    }

    public void render() {
        spriteBatch.begin();
        stuff.getGrid().draw(spriteBatch);
        stuff.getPlayer().draw(spriteBatch);
        stuff.getMovementLogic().update();
        spriteBatch.end();
    }

    // The renderer needs to know what to render
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}