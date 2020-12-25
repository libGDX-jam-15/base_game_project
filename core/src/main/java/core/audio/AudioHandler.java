package core.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import core.GameMain;
import core.loading.SoundPaths;

public class AudioHandler {
    private GameMain game;
    private Music backgroundMusic;

    private AssetManager assetManager;
    long gameSoundID;
    float volume = 1;// 0.3f;

    Sound alarmSound;
    Boolean loaded = false;

    public AudioHandler(GameMain game) {
        game = game;
        assetManager = game.getAssetManager();
    }


    public void playButtonSound() {
        Sound sound = assetManager.get(SoundPaths.MENU_BUTTON_AUDIO);
//        if(game.getGameStatsHandler().isAudioOn())
        sound.play(volume);
    }


}
