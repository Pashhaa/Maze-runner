package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;

import javax.swing.*;

public class Gold extends AbstractFigur {
    public Gold(){
        setImage(new ImageIcon(getClass().getResource("/images/gold.png")));
    }
}
