package Base.Objects;

import javax.swing.*;

public class Bot extends AbstractMovingFigur{

    public Bot(){
        setImage(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
    }
    @Override
    public boolean canMove(AbstractFigur nextObject) {
        return super.canMove(nextObject);
    }

}
