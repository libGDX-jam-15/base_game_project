package core.Screens.game.logic;

import core.Screens.game.GameAssets;
import core.Screens.game.stuff.GameStuff;

public class GameLogic {

    private final DragAndDropHandler dragAndDropHandler;
    private final InputHandler inputHandler;
    private final PowerSpawner powerSpawner;

    public GameLogic() {
        dragAndDropHandler = new DragAndDropHandler();
        inputHandler = new InputHandler();
        powerSpawner = new PowerSpawner();

        inputHandler.setLogic(this);
    }

    public void update(float delta) {
        // TODO: time based updates + each frame updates
        powerSpawner.update(delta);
    }

    public void setAssets(GameAssets assets) {
        powerSpawner.setAssets(assets);
    }

    public void setStuff(GameStuff stuff) {
        dragAndDropHandler.setStuff(stuff);
        inputHandler.setStuff(stuff);
        powerSpawner.setStuff(stuff);
    }

    public DragAndDropHandler getDragAndDropHandler() {
        return dragAndDropHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
}