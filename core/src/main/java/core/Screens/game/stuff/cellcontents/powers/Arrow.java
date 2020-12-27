package core.Screens.game.stuff.cellcontents.powers;

import com.badlogic.gdx.graphics.g2d.Sprite;

import core.util.Enums.Direction;

public class Arrow extends Power {

    private final Direction direction;

    public Arrow(Sprite powerSprite, Direction direction) {
        super(powerSprite);
        switch (direction) {
            case LEFT:
                sprite.rotate90(true);
            case DOWN:
                sprite.rotate90(true);
            case RIGHT:
                sprite.rotate90(true);
        }
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}