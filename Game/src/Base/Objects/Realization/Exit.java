package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;
import Base.Objects.Enums.ObjectType;

import javax.swing.*;

public class Exit extends AbstractFigur {
    private static Exit instance;
    private Exit(){
        setImage(new ImageIcon(getClass().getResource("/images/exit.gif")));
        setObjectType(ObjectType.EXIT);
    };

    public static Exit getExit(){
        if (instance == null){
            instance = new Exit();
        }
        return instance;
    }
}
