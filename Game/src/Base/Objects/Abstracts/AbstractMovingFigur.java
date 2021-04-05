package Base.Objects.Abstracts;

import Base.Objects.Enums.Action;
import Base.Objects.Enums.Direction;
import Base.Objects.Enums.ObjectType;

public abstract class AbstractMovingFigur extends AbstractFigur {


    public Action process(AbstractFigur nextObject) {
        if(nextObject == null){
            return Action.NONE;
        }
        if(nextObject.getObjectType() == ObjectType.EMPTINESS){
            return Action.MOVE;
        }

        return Action.NONE;
    }

    public int[] move(Direction direction) {

        int y = getY();
        int x = getX();

        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;

            case LEFT:
                x--;
                break;

            case RIGHT:
                x++;
                break;
        }

        return new int[] {y, x};

    }


}
