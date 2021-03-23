package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Abstracts.AbstractMovingFigur;

import javax.swing.*;
import java.io.Serializable;

public class Player extends AbstractMovingFigur implements Serializable { ;
    int score = 0;
    transient int countSteps = 50;


    public Player(){
        setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
    }


    public int getScore() {
        return score;
    }

    public int getCountSteps() {
        return countSteps;
    }

    @Override
    public boolean canMove(AbstractFigur nextObject) {
        boolean result = super.canMove(nextObject);
        if(result){
            return  result;
        }
        return nextObject != null &&
                nextObject.getClass() == Gold.class || nextObject.getClass() == Emptiness.class;
    }

}
