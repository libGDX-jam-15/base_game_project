package core.Screens.game.logic;

import core.Screens.game.GameAssets;
import core.Screens.game.stuff.GameStuff;
import core.level.LevelConfig;

public class GameLogic {

    private final DragAndDropHandler dragAndDropHandler;
    private final InputHandler inputHandler;
    private final MessageHandler messageHandler;
    private final MovementLogic movementLogic;
    private final PowerSpawner powerSpawner;
    private final BlinkLogic blinkLogic;

    public GameLogic() {
        dragAndDropHandler = new DragAndDropHandler();
        inputHandler = new InputHandler();
        messageHandler = new MessageHandler();
        movementLogic = new MovementLogic();
        powerSpawner = new PowerSpawner();
        blinkLogic = new BlinkLogic();


        inputHandler.setLogic(this);
    }

    public void update(float delta) {
        messageHandler.update(delta);
        movementLogic.update(delta);
        powerSpawner.update(delta);
        blinkLogic.update(delta);
    }

    public void setAssets(GameAssets assets) {
        powerSpawner.setAssets(assets);
    }

    public void setStuff(GameStuff stuff) {
        dragAndDropHandler.setStuff(stuff);
        inputHandler.setStuff(stuff);
        messageHandler.setStuff(stuff);
        movementLogic.setStuff(stuff);
        powerSpawner.setStuff(stuff);
        blinkLogic.setStuff(stuff);
    }

    public DragAndDropHandler getDragAndDropHandler() {
        return dragAndDropHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}