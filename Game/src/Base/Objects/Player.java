package Base.Objects;

import javax.swing.*;

public class Player extends AbstractMovingFigur{
    int score = 0;
    int countSteps = 50;
    public Player(){
        setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
    }

    public int getScore() {
        return score;
    }

    public int getCountSteps() {
        return countSteps;
    }



}
