package core.Screens.game.logic;

import core.GameMain;
import core.Screens.game.GameAssets;
import core.Screens.game.stuff.GameStuff;

public class GameLogic {

    private final DragAndDropHandler dragAndDropHandler;
    private final GridColorLogic gridColorLogic;
    private final InputHandler inputHandler;
    private final MessageHandler messageHandler;
    private final MovementLogic movementLogic;
    private final PowerSpawner powerSpawner;
    private final BlinkLogic blinkLogic;

    public GameLogic() {
        dragAndDropHandler = new DragAndDropHandler();
        gridColorLogic = new GridColorLogic();
        inputHandler = new InputHandler();
        messageHandler = new MessageHandler();
        movementLogic = new MovementLogic();
        powerSpawner = new PowerSpawner();
        blinkLogic = new BlinkLogic();

        inputHandler.setLogic(this);
    }

    public void initialLogic() {
        blinkLogic.setCountdowns();
        gridColorLogic.setup();
    }

    public void update(float delta) {
        blinkLogic.update(delta);
        gridColorLogic.update(delta);
        messageHandler.update(delta);
        movementLogic.update(delta);
        powerSpawner.update(delta);
    }

    public void setGame(GameMain game) {
        movementLogic.setGame(game);
    }

    public void setAssets(GameAssets assets) {
        messageHandler.setAssets(assets);
        powerSpawner.setAssets(assets);
    }

    public void setStuff(GameStuff stuff) {
        dragAndDropHandler.setStuff(stuff);
        gridColorLogic.setStuff(stuff);
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