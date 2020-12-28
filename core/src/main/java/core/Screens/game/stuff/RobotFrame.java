package core.Screens.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

import static core.config.Constants.GRID_HEIGHT;
import static core.config.Constants.ROBOT_FRAME_BACKGROUND_HEIGHT;
import static core.config.Constants.ROBOT_FRAME_BACKGROUND_WIDTH;
import static core.config.Constants.ROBOT_FRAME_BACKGROUND_X;
import static core.config.Constants.ROBOT_FRAME_BACKGROUND_Y;
import static core.config.Constants.ROBOT_FRAME_MESSAGE_WIDTH;
import static core.config.Constants.ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT;
import static core.config.Constants.ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH;

public class RobotFrame {

    private final Sprite background, robotBackground, robot;
    private final BitmapFont font;
    private String message;

    public RobotFrame(Sprite backgroundSprite, Sprite robotBackgroundSprite, Sprite robotSprite, BitmapFont font) {
        background = new Sprite(backgroundSprite);
        background.setPosition(ROBOT_FRAME_BACKGROUND_X, ROBOT_FRAME_BACKGROUND_Y);
        background.setSize(ROBOT_FRAME_BACKGROUND_WIDTH, ROBOT_FRAME_BACKGROUND_HEIGHT);
        background.setColor(Color.PURPLE.cpy().lerp(Color.CLEAR, 0.5f));
        robotBackground = new Sprite(robotBackgroundSprite);
        robotBackground.setY(GRID_HEIGHT);
        robotBackground.setSize(ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH, ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT);
        robot = new Sprite(robotSprite);
        robot.setY(GRID_HEIGHT);
        robot.setSize(ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH, ROBOT_FRAME_ROBOT_BACKGROUND_HEIGHT);
        this.font = font;
        message = "";
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        robotBackground.draw(spriteBatch);
        robot.draw(spriteBatch);
        font.draw(
                spriteBatch,
                message,
                ROBOT_FRAME_ROBOT_BACKGROUND_WIDTH,
                ROBOT_FRAME_BACKGROUND_Y + ROBOT_FRAME_BACKGROUND_HEIGHT,
                ROBOT_FRAME_MESSAGE_WIDTH,
                Align.center,
                true);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}