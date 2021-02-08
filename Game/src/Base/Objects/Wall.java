package Base.Objects;

import javax.swing.*;

public class Wall extends AbstractFigur {
    public Wall(){
        setImage(new ImageIcon(getClass().getResource("/images/wall.png")));
    }
}
