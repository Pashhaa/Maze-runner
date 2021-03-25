package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Abstracts.AbstractMovingFigur;
import Base.Objects.Enums.Action;
import Base.Objects.Enums.ObjectType;

import javax.swing.*;
import java.io.Serializable;

public class Player extends AbstractMovingFigur implements Serializable { ;
    int score = 0;
    transient int countSteps = 50;


    public Player(){
        setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
        setObjectType(ObjectType.PLAYER);
    }


    public int getScore() {
        return score;
    }

    public int getCountSteps() {
        return countSteps;
    }

    @Override
    public Action process(AbstractFigur nextObject) {
        Action result = super.process(nextObject);

        if(result != Action.NONE){
            countSteps--;
            return Action.MOVE;
        }
        if(nextObject == null){
            return Action.NONE;
        }
        if(nextObject.getObjectType() == ObjectType.GOLD){
            score += 5;
            return Action.ADD_GOLD;
        }
        if(nextObject.getObjectType() == ObjectType.EXIT){
            return Action.WIN;
        }
        return Action.NONE;
    }

}
