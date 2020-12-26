package core.Screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import core.loading.FontsPaths;
import core.loading.ImagesPaths;

public class GameAssets {

    private final AssetManager assetManager;
    // Sprites
    private Sprite starfield;
    private Sprite robotFrame;
    private Sprite robot;
    private Sprite pilotFrame;
    private Sprite pilot;
    private Sprite cell;
    private Sprite testPlayer;
    private Sprite testExit;
    private Sprite pixel;
    private Sprite arrow;
    private Sprite backBar;
    private Sprite frontBar;


    private Sprite keyFrameBB;
    private Sprite keyFrameBT;
    // Fonts
    private BitmapFont pixelFont;
    // Audio


    //atlas + animations
    private TextureAtlas blinkingAtlas;

    private Animation<Sprite> blinkingBottom, blinkingTop;

    public GameAssets(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public void initializeAssets() {
        starfield = new Sprite(assetManager.get(ImagesPaths.STARFIELD, Texture.class));
        robotFrame = new Sprite(assetManager.get(ImagesPaths.ROBOT_FRAME, Texture.class));
        robot = new Sprite(assetManager.get(ImagesPaths.ROBOT, Texture.class));
        pilotFrame = new Sprite(assetManager.get(ImagesPaths.PILOT_FRAME, Texture.class));
        pilot = new Sprite(assetManager.get(ImagesPaths.PILOT, Texture.class));
        cell = new Sprite(assetManager.get(ImagesPaths.CELL, Texture.class));
        testPlayer = new Sprite(assetManager.get(ImagesPaths.TEST_PLAYER, Texture.class));
        testExit = new Sprite(assetManager.get(ImagesPaths.TEST_EXIT, Texture.class));
        pixel = new Sprite(assetManager.get(ImagesPaths.PIXEL, Texture.class));
        arrow = new Sprite(assetManager.get(ImagesPaths.ARROW, Texture.class));

        pixelFont = assetManager.get(FontsPaths.PIXEL_FONT, BitmapFont.class);
        pixelFont.getData().setScale(0.5f);

        backBar = new Sprite(assetManager.get(ImagesPaths.BACK_BAR, Texture.class));
        frontBar = new Sprite(assetManager.get(ImagesPaths.FRONT_BAR, Texture.class));

        blinkingAtlas = assetManager.get(ImagesPaths.BLINKING_ATLAS, TextureAtlas.class);
        Animation.PlayMode playMode = Animation.PlayMode.LOOP_PINGPONG;
        blinkingTop = new Animation<Sprite>(1.5f/16f, getBlinkingAtlas().createSprites("eyelid"), playMode);
        blinkingBottom = new Animation<Sprite>(1.5f/16f, getBlinkingAtlas().createSprites("eyelid"), playMode);

        keyFrameBB = new Sprite(getBlinkingAtlas().findRegion("eyelid", 1));
        keyFrameBT = new Sprite(getBlinkingAtlas().findRegion("eyelid", 1));
    }

    // Asset getters
    public Sprite getStarfield() {
        return starfield;
    }

    public Sprite getRobotFrame() {
        return robotFrame;
    }

    public Sprite getRobot() {
        return robot;
    }

    public Sprite getPilotFrame() {
        return pilotFrame;
    }

    public Sprite getPilot() {
        return pilot;
    }

    public Sprite getCell() {
        return cell;
    }

    public Sprite getTestPlayer() {
        return testPlayer;
    }

    public Sprite getTestExit() {
        return testExit;
    }

    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getArrow() {
        return arrow;
    }

    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    public Sprite getBackBar(){return backBar; }

    public Sprite getFrontBar(){return frontBar; }

    public TextureAtlas getBlinkingAtlas() {
        return blinkingAtlas;
    }

    public Animation<Sprite> getBlinkingBottom() {
        return blinkingBottom;
    }

    public Animation<Sprite> getBlinkingTop() {
        return blinkingTop;
    }

    public Sprite getKeyFrameBB() {
        return keyFrameBB;
    }

    public Sprite getKeyFrameBT() {
        return keyFrameBT;
    }

}