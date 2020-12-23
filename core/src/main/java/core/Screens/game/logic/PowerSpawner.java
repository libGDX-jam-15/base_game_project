package core.Screens.game.logic;

import com.badlogic.gdx.math.MathUtils;

import core.Screens.game.GameAssets;
import core.Screens.game.stuff.GameStuff;
import core.Screens.game.stuff.PowersPanel;
import core.Screens.game.stuff.powers.Arrow;
import core.Screens.game.stuff.powers.Power;

import static core.config.Constants.POWER_SIZE;
import static core.config.Constants.POWER_X_POSITION;
import static core.util.Enums.Direction.DOWN;
import static core.util.Enums.Direction.LEFT;
import static core.util.Enums.Direction.RIGHT;
import static core.util.Enums.Direction.UP;

public class PowerSpawner {

    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        if (time == 0f) {
            if (stuff.getPowersPanel().getPowers().size < 4) {
                spawnRandomPower();
            }
            time = 3f;
        }
        time = Math.max(time - delta, 0f);
    }

    private void spawnRandomPower() {
        // Randomize the power
        int random = MathUtils.random(3);
        Power power = null;
        switch (random) {
            case 0:
                power = new Arrow(assets.getArrow(), UP);
                break;
            case 1:
                power = new Arrow(assets.getArrow(), RIGHT);
                break;
            case 2:
                power = new Arrow(assets.getArrow(), DOWN);
                break;
            case 3:
                power = new Arrow(assets.getArrow(), LEFT);
                break;
        }
        // Position the new power
        PowersPanel powersPanel = stuff.getPowersPanel();
        int numberOfPowers = powersPanel.getPowers().size;
        power.setPosition(POWER_X_POSITION, POWER_SIZE * numberOfPowers);
        // Add the power
        stuff.getPowersPanel().getPowers().add(power);
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}