package core.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

public class LevelJsonParser {

    public LevelConfig getLevelConfigFromJson(String jsonPath) {
        Json pjson = new Json();
        LevelConfig levelConfig = pjson.fromJson(LevelConfig.class, Gdx.files.internal(jsonPath).readString());

        return levelConfig;
    }

    public LevelConfig getLevelConfig(int levelNumber) {
        return getLevelConfigFromJson("levels/level_" + levelNumber + ".json");
    }

}
