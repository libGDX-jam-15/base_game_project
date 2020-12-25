package core.save;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameSaveHandler {

    Preferences prefs = Gdx.app.getPreferences("base_game_project_v1_0");

    public GameSaveHandler() {
    }

    public void saveLevelData(LevelSave levelSave){

        //total plays
        int totalTimesPlayed = prefs.getInteger("totalTimesPlayed", 0);
        prefs.putInteger("totalTimesPlayed", ++totalTimesPlayed);

        //top level
        int topLevel = prefs.getInteger("topLevel", 0);
        if(topLevel < levelSave.getTopLevelNumber()) {
            prefs.putInteger("topLevel", levelSave.getTopLevelNumber());
        }

        //high score
        int highScore = prefs.getInteger("highScore", 0);
        if(highScore < levelSave.getHighScore()) {
            prefs.putInteger("highScore", levelSave.getHighScore());
        }

        //isGameWon
        boolean isGameWon = prefs.getBoolean("isGameWon", false);
        if(!isGameWon) {
            prefs.putBoolean("isGameWon", levelSave.isGameWon());
        }

        prefs.flush();
    }

    public LevelSave getSavedData() {
        return new LevelSave(
                prefs.getInteger("totalTimesPlayed", 0),
                prefs.getInteger("topLevel", 0),
                prefs.getInteger("highScore", 0),
                prefs.getBoolean("isGameWon", false)
        );
    }
}
