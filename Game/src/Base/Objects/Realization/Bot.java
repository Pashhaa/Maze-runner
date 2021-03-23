package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Abstracts.AbstractMovingFigur;

import javax.swing.*;

public class Bot extends AbstractMovingFigur {

    public Bot(){
        setImage(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
    }
    @Override
    public boolean canMove(AbstractFigur nextObject) {
        if(nextObject == null){
            return  false;
        }

        return nextObject.getClass() == Emptiness.class;
    }

}
