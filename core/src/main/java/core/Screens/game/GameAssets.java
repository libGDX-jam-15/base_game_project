package core.Screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import core.loading.FontsPaths;
import core.loading.ImagesPaths;

public class GameAssets {

    private final AssetManager assetManager;
    // Sprites
    private Sprite starfield, robotFrame, robot, pilotFrame, pilot, cell, testPlayer, pixel, arrow,
    backBar, frontBar;
    // Fonts
    private BitmapFont pixelFont;
    // Audio

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
        pixel = new Sprite(assetManager.get(ImagesPaths.PIXEL, Texture.class));
        arrow = new Sprite(assetManager.get(ImagesPaths.ARROW, Texture.class));

        pixelFont = assetManager.get(FontsPaths.PIXEL_FONT, BitmapFont.class);
        pixelFont.getData().setScale(0.5f);

        backBar = new Sprite(assetManager.get(ImagesPaths.BACK_BAR, Texture.class));
        frontBar = new Sprite(assetManager.get(ImagesPaths.FRONT_BAR, Texture.class));
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
}