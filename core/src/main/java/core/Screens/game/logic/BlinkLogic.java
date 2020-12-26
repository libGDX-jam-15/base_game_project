package core.Screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

import core.Screens.game.stuff.GameStuff;

import static core.config.GameConfig.SCREEN_WIDTH;

public class BlinkLogic {
    private GameStuff stuff;
    private float width;
    private float stateTime;
    private float waitTime;
    private boolean flag;
    private final float countDown = 3;
    private final float countUp = 1.5f;
    private Sprite keyFrameBB;
    private Sprite keyFrameBT;
    private float height;
    private float animationStateTime;
    private Animation<Sprite> blinkingTop;
    private Animation<Sprite> blinkingBottom;

    public BlinkLogic() {
        width = SCREEN_WIDTH - 400;
        stateTime = 0.0f;
        waitTime = 0.0f;
        flag = true;

    }

    public void update(float delta){


        if(flag == true) {
            if (stateTime <= countDown && stateTime >= 0) {
                stuff.getFrontBar().setSize((countDown - stateTime)*(width/countDown), stuff.getFrontBar().getHeight() );
                stateTime += delta;
                //Debug
                System.out.print(keyFrameBB);
            } else {flag = false;
            waitTime = 1.5f;}
        }else if (flag == false){
            stuff.getFrontBar().setSize((countUp - waitTime)*(width/countUp), stuff.getFrontBar().getHeight());
            waitTime -= delta;
            animationStateTime += delta;
            keyFrameBB.set(this.blinkingTop.getKeyFrame(animationStateTime, true));

            System.out.println(keyFrameBB);
            keyFrameBT.set(this.blinkingBottom.getKeyFrame(animationStateTime, true));



            if(waitTime < 0.0f){
                stateTime = 0.0f;
                animationStateTime = 0;
                keyFrameBB.set( this.blinkingTop.getKeyFrames()[0]);
                keyFrameBT.set( this.blinkingBottom.getKeyFrames()[0]);
                flag = true;
            }
        }

        //keyFrameBT.set(this.blinkingTop.getKeyFrame(stateTime, true));
        //keyFrameBB.set(this.blinkingBottom.getKeyFrame(stateTime, true));
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;

        keyFrameBB = ( this.stuff.getKeyFrameBB());
        keyFrameBT = (this.stuff.getKeyFrameBT());

        blinkingTop = this.stuff.getBlinkingBottom();
        blinkingBottom = this.stuff.getBlinkingTop();
    }

    public void subStateTime(float subTime) {
        if ((this.stateTime - subTime) >= 0) {
            this.stateTime -= subTime;
        } else {
            this.stateTime = 0;
        }
    }
}
