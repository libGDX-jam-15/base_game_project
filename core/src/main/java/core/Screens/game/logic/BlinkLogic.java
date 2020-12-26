package core.Screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import core.Screens.game.stuff.GameStuff;

import static core.config.GameConfig.SCREEN_HEIGHT;
import static core.config.GameConfig.SCREEN_WIDTH;

public class BlinkLogic {
    private GameStuff stuff;
    private float width;
    private float stateTime;
    private float waitTime;
    private boolean flag;
    private final float countDown = 3;
    private final float countUp = 1.5f;
    private TextureRegion keyFrameBBthis;
    private TextureRegion keyFrameBTthis;
    private float height;
    private float animationStateTime;
    private Animation<TextureRegion> bottomAnimation;
    private Animation<TextureRegion> topAnimation;

    public BlinkLogic() {
        width = SCREEN_WIDTH - 400;
        stateTime = 0.0f;
        waitTime = 0.0f;
        flag = true;

    }

    public void update(float delta){
        keyFrameBBthis = this.stuff.getKeyFrameBB();
        keyFrameBTthis = this.stuff.getKeyFrameBT();

        bottomAnimation = this.stuff.getBlinkingBottom();
        topAnimation = this.stuff.getBlinkingTop();

        if(flag == true) {
            if (stateTime <= countDown && stateTime >= 0) {
                stuff.getFrontBar().setSize((countDown - stateTime)*(width/countDown), stuff.getFrontBar().getHeight() );
                stateTime += delta;
                //Debug
                System.out.print(keyFrameBBthis);
            } else {flag = false;
            waitTime = 1.5f;}
        }else if (flag == false){
            stuff.getFrontBar().setSize((countUp - waitTime)*(width/countUp), stuff.getFrontBar().getHeight());
            waitTime -= delta;
            animationStateTime += delta;
            keyFrameBBthis = this.bottomAnimation.getKeyFrame(animationStateTime, true);
            System.out.print(keyFrameBBthis);
            keyFrameBTthis = this.topAnimation.getKeyFrame(animationStateTime, true);


            if(waitTime < 0.0f){
                stateTime = 0.0f;
                animationStateTime = 0;
                keyFrameBBthis = this.bottomAnimation.getKeyFrames()[0];
                keyFrameBTthis = this.topAnimation.getKeyFrames()[0];
                flag = true;
            }
        }

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
