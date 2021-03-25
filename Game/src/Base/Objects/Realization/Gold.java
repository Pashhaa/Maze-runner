package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Enums.ObjectType;

import javax.swing.*;

public class Gold extends AbstractFigur {
    public Gold(){
        setImage(new ImageIcon(getClass().getResource("/images/gold.png")));
        setObjectType(ObjectType.GOLD);
    }
}
