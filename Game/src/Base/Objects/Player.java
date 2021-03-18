package Base.Objects;

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
        return super.canMove(nextObject);
    }

}
