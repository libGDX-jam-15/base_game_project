package core.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import core.GameMain;
import core.loading.MusicPaths;
import core.loading.SoundPaths;

public class AudioHandler {

    private final AssetManager assetManager;
    float volume = 1;// 0.3f;

    public AudioHandler(GameMain game) {
        assetManager = game.getAssetManager();
    }

    public void playButtonSound() {
        Sound sound = assetManager.get(SoundPaths.MENU_BUTTON_AUDIO);
        sound.play(volume);
    }

    public void playMusic() {
        Music movinsynergy = assetManager.get(MusicPaths.MOVIN_SYNERGY);
        movinsynergy.setVolume(0.3f);
        if (movinsynergy.isPlaying()) {
            return;
        }
        movinsynergy.setLooping(true);
        movinsynergy.play();
    }
}