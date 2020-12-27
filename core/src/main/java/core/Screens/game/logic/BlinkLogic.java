package core.Screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

import core.Screens.game.stuff.GameStuff;

import static core.config.Constants.GRID_HEIGHT;
import static core.config.Constants.GRID_WIDTH;
import static core.config.GameConfig.SCREEN_HEIGHT;
import static core.config.GameConfig.SCREEN_WIDTH;

public class BlinkLogic {
    private GameStuff stuff;
    private float barWidth;
    private float stateTime;
    private float waitTime;
    private boolean flag;
    private float countDown = 3;
    private float countUp = 1.5f;
    private float height;
    private float animationStateTime;

    public BlinkLogic() {
        barWidth = SCREEN_WIDTH - 400;
        stateTime = 0.0f;
        waitTime = 0.0f;
        flag = true;
    }

    public void setCountdowns() {
        countDown = stuff.getLevelConfig().getBlackoutIntervalTime();
        countUp = stuff.getLevelConfig().getBlackoutPeriod();
    }

    public void update(float delta) {
        Sprite keyFrameBB = stuff.getKeyFrameBB();
        Sprite keyFrameBT = stuff.getKeyFrameBT();
        Animation<Sprite> blinkingTop = stuff.getBlinkingTop();
        Animation<Sprite> blinkingBottom = stuff.getBlinkingBottom();

        if (flag) {
            if (stateTime <= countDown && stateTime >= 0) {
                stuff.getFrontBar().setSize((countDown - stateTime) * (barWidth / countDown), stuff.getFrontBar().getHeight());
                stateTime += delta;

            } else {
                flag = false;
                waitTime = 1.5f;
            }
        } else {
            stuff.getFrontBar().setSize((countUp - waitTime) * (barWidth / countUp), stuff.getFrontBar().getHeight());
            waitTime -= delta;
            height = (countUp - waitTime) * GRID_HEIGHT / 2;
            animationStateTime += delta;

            keyFrameBB.setPosition(0, 0);
            keyFrameBB.set(blinkingBottom.getKeyFrame(animationStateTime, false));
            keyFrameBB.setSize(GRID_WIDTH, height);

            keyFrameBT.set(blinkingTop.getKeyFrame(animationStateTime, false));
            keyFrameBT.setPosition(0, GRID_HEIGHT);
            keyFrameBT.setSize(GRID_WIDTH, -height);

            if (!keyFrameBT.isFlipX()) {
                keyFrameBT.flip(true, false);
            }

            if (waitTime < 0.0f) {
                stateTime = 0.0f;
                animationStateTime = 0;
                keyFrameBB.set(blinkingTop.getKeyFrames()[0]);
                keyFrameBT.set(blinkingBottom.getKeyFrames()[0]);
                keyFrameBB.setSize(100, 100);
                keyFrameBT.setSize(100, 100);
                keyFrameBB.setPosition(0, -keyFrameBB.getHeight());
                keyFrameBT.setPosition(0, SCREEN_HEIGHT);
                flag = true;
            }
        }

        //keyFrameBT.set(this.blinkingTop.getKeyFrame(stateTime, true));
        //keyFrameBB.set(this.blinkingBottom.getKeyFrame(stateTime, true));
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }

    public void subStateTime(float subTime) {
        if ((this.stateTime - subTime) >= 0) {
            this.stateTime -= subTime;
        } else {
            this.stateTime = 0;
        }
    }
}
