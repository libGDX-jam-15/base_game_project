package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.util.Enums.PilotState;

import static core.config.Constants.PILOT_FRAME_HEIGHT;
import static core.config.Constants.PILOT_FRAME_PILOT_HEIGHT;
import static core.config.Constants.PILOT_FRAME_PILOT_WIDTH;
import static core.config.Constants.PILOT_FRAME_PILOT_X;
import static core.config.Constants.PILOT_FRAME_PILOT_Y;
import static core.config.Constants.PILOT_FRAME_WIDTH;
import static core.config.Constants.PILOT_FRAME_X;
import static core.config.Constants.PILOT_FRAME_Y;

public class PilotFrame {

    private final Sprite background, awake, halfAwake, halfAsleep, asleep;
    private Sprite current;

    public PilotFrame(Sprite backgroundSprite, Sprite awakeSprite, Sprite halfAwakeSprite, Sprite halfAsleepSprite, Sprite asleepSprite) {
        background = new Sprite(backgroundSprite);
        background.setPosition(PILOT_FRAME_X, PILOT_FRAME_Y);
        background.setSize(PILOT_FRAME_WIDTH, PILOT_FRAME_HEIGHT);
        awake = new Sprite(awakeSprite);
        halfAwake = new Sprite(halfAwakeSprite);
        halfAsleep = new Sprite(halfAsleepSprite);
        asleep = new Sprite(asleepSprite);
        awake.setPosition(PILOT_FRAME_X, PILOT_FRAME_Y);
        halfAwake.setPosition(PILOT_FRAME_X, PILOT_FRAME_Y);
        halfAsleep.setPosition(PILOT_FRAME_X, PILOT_FRAME_Y);
        asleep.setPosition(PILOT_FRAME_X, PILOT_FRAME_Y);
        awake.setSize(PILOT_FRAME_WIDTH, PILOT_FRAME_HEIGHT);
        halfAwake.setSize(PILOT_FRAME_WIDTH, PILOT_FRAME_HEIGHT);
        halfAsleep.setSize(PILOT_FRAME_WIDTH, PILOT_FRAME_HEIGHT);
        asleep.setSize(PILOT_FRAME_WIDTH, PILOT_FRAME_HEIGHT);
        current = awake;
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        current.draw(spriteBatch);
    }

    public void setState(PilotState state) {
        switch (state) {
            case AWAKE:
                current = awake;
                break;
            case HALF_AWAKE:
                current = halfAwake;
                break;
            case HALF_ASLEEP:
                current = halfAsleep;
                break;
            case ASLEEP:
                current = asleep;
                break;
        }
    }
}