package core.loading;

import java.util.ArrayList;
import java.util.List;

public class LoadingPaths {

    public List<String> getTexturePaths() {
        List<String> list = new ArrayList<>();

        list.add(ImagesPaths.STARFIELD);
        list.add(ImagesPaths.ROBOT_FRAME);
        list.add(ImagesPaths.ROBOT);
        list.add(ImagesPaths.PILOT_FRAME);
        list.add(ImagesPaths.PILOT_1);
        list.add(ImagesPaths.PILOT_2);
        list.add(ImagesPaths.PILOT_3);
        list.add(ImagesPaths.CELL);
        list.add(ImagesPaths.SPACESHIP);
        list.add(ImagesPaths.LEVEL_GOAL);
        list.add(ImagesPaths.ASTEROID);
        list.add(ImagesPaths.PIXEL);
        list.add(ImagesPaths.ARROW);
        list.add(ImagesPaths.DRAGON_LANTERN);
        list.add(ImagesPaths.BACK_BAR);
        list.add(ImagesPaths.FRONT_BAR);

        return list;
    }

    public List<String> getFontPaths() {
        List<String> list = new ArrayList<>();
        list.add(FontsPaths.PIXEL_FONT);
        return list;
    }

    public List<String> getTileMapPaths() {
        List<String> list = new ArrayList<>();

        //Levels
        //list.add(LevelNames.LEVEL_1);

        return list;
    }

    public List<String> getMusicPaths() {
        List<String> list = new ArrayList<>();

        list.add(MusicPaths.MOVIN);
        list.add(MusicPaths.SYNERGY);
        list.add(MusicPaths.MOVIN_SYNERGY);

        return list;
    }

    public List<String> getSoundPaths() {
        List<String> list = new ArrayList<>();

        list.add(SoundPaths.MENU_BUTTON_AUDIO);
        list.add(SoundPaths.ROBOT_MESSAGE_1);
        list.add(SoundPaths.ROBOT_MESSAGE_2);
        list.add(SoundPaths.ROBOT_MESSAGE_3);
        list.add(SoundPaths.ROBOT_MESSAGE_4);
        list.add(SoundPaths.ROBOT_MESSAGE_5);

        return list;
    }

    public List<String> getTextureAtlasPaths() {
        List<String> list = new ArrayList<>();

        list.add(ImagesPaths.BLINKING_ATLAS);

        return list;
    }
}