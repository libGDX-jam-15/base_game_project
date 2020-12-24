package core.Screens.game.logic;

import com.badlogic.gdx.math.MathUtils;

import core.Screens.game.stuff.GameStuff;

import static core.config.Constants.ROBOT_MESSAGES;

public class MessageHandler {

    private GameStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        if (time >= 10f) {
            int randomMessage = MathUtils.random(4);
            stuff.getRobotFrame().setMessage(ROBOT_MESSAGES[randomMessage]);
            time = 0f;
        }
        time += delta;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}