package core.Screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

import core.loading.FontsPaths;
import core.loading.ImagesPaths;
import core.loading.SoundPaths;

public class GameAssets {

    private final AssetManager assetManager;
    // Sprites
    private Sprite starfield;
    private Sprite robotFrame;
    private Sprite robot;
    private Sprite pilotFrame;
    private Sprite pilot_1;
    private Sprite pilot_2;
    private Sprite pilot_3;
    private Sprite cell;
    private Sprite playerSpaceship;
    private Sprite levelGoal;
    private Sprite asteroid;
    private Sprite pixel;
    private Sprite arrow;
    private Sprite backBar;
    private Sprite frontBar;

    private Sprite dragonLantern;

    private Sprite keyFrameBB;
    private Sprite keyFrameBT;
    // Fonts
    private BitmapFont pixelFont;
    // Audio
    private final Array<Sound> soundsArray = new Array<>();

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
        pilot_1 = new Sprite(assetManager.get(ImagesPaths.PILOT_1, Texture.class));
        pilot_2 = new Sprite(assetManager.get(ImagesPaths.PILOT_2, Texture.class));
        pilot_3 = new Sprite(assetManager.get(ImagesPaths.PILOT_2, Texture.class));
        cell = new Sprite(assetManager.get(ImagesPaths.CELL, Texture.class));
        playerSpaceship = new Sprite(assetManager.get(ImagesPaths.SPACESHIP, Texture.class));
        levelGoal = new Sprite(assetManager.get(ImagesPaths.LEVEL_GOAL, Texture.class));
        asteroid = new Sprite(assetManager.get(ImagesPaths.ASTEROID, Texture.class));
        pixel = new Sprite(assetManager.get(ImagesPaths.PIXEL, Texture.class));
        arrow = new Sprite(assetManager.get(ImagesPaths.ARROW, Texture.class));

        pixelFont = assetManager.get(FontsPaths.PIXEL_FONT, BitmapFont.class);
        pixelFont.getData().setScale(0.5f);

        backBar = new Sprite(assetManager.get(ImagesPaths.BACK_BAR, Texture.class));
        frontBar = new Sprite(assetManager.get(ImagesPaths.FRONT_BAR, Texture.class));

        dragonLantern = new Sprite(assetManager.get(ImagesPaths.DRAGON_LANTERN, Texture.class));

        soundsArray.add(assetManager.get(SoundPaths.ROBOT_MESSAGE_1));
        soundsArray.add(assetManager.get(SoundPaths.ROBOT_MESSAGE_2));
        soundsArray.add(assetManager.get(SoundPaths.ROBOT_MESSAGE_3));
        soundsArray.add(assetManager.get(SoundPaths.ROBOT_MESSAGE_4));
        soundsArray.add(assetManager.get(SoundPaths.ROBOT_MESSAGE_5));

        blinkingAtlas = assetManager.get(ImagesPaths.BLINKING_ATLAS, TextureAtlas.class);
        Animation.PlayMode playMode = Animation.PlayMode.LOOP_PINGPONG;
        blinkingTop = new Animation<>(1.5f / 10f, getBlinkingAtlas().createSprites("eyelid"), playMode);
        blinkingBottom = new Animation<>(1.5f / 10f, getBlinkingAtlas().createSprites("eyelid"), playMode);

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

    public Sprite getPilot_1() {
        return pilot_1;
    }

    public Sprite getPilot_2() {
        return pilot_2;
    }

    public Sprite getPilot_3() {
        return pilot_3;
    }

    public Sprite getCell() {
        return cell;
    }

    public Sprite getPlayerSpaceship() {
        return playerSpaceship;
    }

    public Sprite getLevelGoal() {
        return levelGoal;
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

    public Sprite getBackBar() {
        return backBar;
    }

    public Sprite getFrontBar() {
        return frontBar;
    }

    public Sprite getDragonLantern() {
        return dragonLantern;
    }

    public Array<Sound> getSoundsArray() {
        return soundsArray;
    }

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

    public Sprite getAsteroid() {
        return asteroid;
    }
}