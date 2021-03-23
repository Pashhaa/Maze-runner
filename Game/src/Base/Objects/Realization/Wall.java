package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;

import javax.swing.*;

public class Wall extends AbstractFigur {
    public Wall(){
        setImage(new ImageIcon(getClass().getResource("/images/wall.png")));
    }
}
