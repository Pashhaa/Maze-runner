package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Abstracts.AbstractMovingFigur;
import Base.Objects.Enums.Action;
import Base.Objects.Enums.ObjectType;

import javax.swing.*;

public class Bot extends AbstractMovingFigur {

    public Bot(){
        setImage(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
        setObjectType(ObjectType.BOT);
    }

    @Override
    public Action process(AbstractFigur nextObject) {
        if (nextObject == null){
            return Action.NONE;
        }
        if(nextObject.getObjectType() == ObjectType.PLAYER){
            return Action.LOSE;
        }
        return Action.NONE;
    }

}
