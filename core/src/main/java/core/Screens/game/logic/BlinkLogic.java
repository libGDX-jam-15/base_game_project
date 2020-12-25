package core.Screens.game.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;

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
    private Sprite keyFrameBB;
    private Sprite keyFrameBT;
    private float height;

    public BlinkLogic() {
        width = SCREEN_WIDTH - 400;
        stateTime = 0.0f;
        waitTime = 0.0f;
        flag = true;
        //keyFrameBB = stuff.getKeyFrameBB();
        //keyFrameBT = stuff.getKeyFrameBT();

        //keyFrameBB.setPosition(0, 0 - keyFrameBB.getHeight());
        //keyFrameBT.setPosition(0, SCREEN_HEIGHT);

        //keyFrameBB.setSize(SCREEN_WIDTH, keyFrameBB.getWidth());
        //keyFrameBT.setSize(SCREEN_WIDTH, keyFrameBT.getHeight());
    }

    public void update(float delta){
        if(flag == true) {
            if (stateTime <= countDown && stateTime >= 0) {
                stuff.getFrontBar().setSize((countDown - stateTime)*(width/countDown), stuff.getFrontBar().getHeight() );
                stateTime += delta;
            } else {flag = false;
            waitTime = 1.5f;}
        }else if (flag == false){
            stuff.getFrontBar().setSize((countUp - waitTime)*(width/countUp), stuff.getFrontBar().getHeight());
            waitTime -= delta;
            if(waitTime < 0.0f){
                stateTime = 0.0f;
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
