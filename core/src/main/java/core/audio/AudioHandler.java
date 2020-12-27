package core.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import core.GameMain;
import core.loading.MusicPaths;
import core.loading.SoundPaths;

public class AudioHandler {

    private GameMain game;
    private Music backgroundMusic;

    private final AssetManager assetManager;
    long gameSoundID;
    float volume = 1;// 0.3f;

    Sound alarmSound;
    Boolean loaded = false;

    public AudioHandler(GameMain game) {
        this.game = game;
        assetManager = game.getAssetManager();
    }


    public void playButtonSound() {
        Sound sound = assetManager.get(SoundPaths.MENU_BUTTON_AUDIO);
//        if(game.getGameStatsHandler().isAudioOn())
        sound.play(volume);
    }

    public void playMusic() {
        Music movin = assetManager.get(MusicPaths.MOVIN);
        movin.setVolume(0.5f);
        Music synergy = assetManager.get(MusicPaths.SYNERGY);
        synergy.setVolume(0.5f);
        movin.setOnCompletionListener(music -> synergy.play());
        synergy.setOnCompletionListener(music -> movin.play());
        movin.play();
    }
}