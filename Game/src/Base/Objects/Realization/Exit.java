package Base.Objects.Realization;

import Base.Objects.Abstracts.AbstractFigur;

import javax.swing.*;

public class Exit extends AbstractFigur {
    private static Exit instance;
    private Exit(){
        setImage(new ImageIcon(getClass().getResource("/images/exit.gif")));
    };

    public static Exit getExit(){
        if (instance == null){
            instance = new Exit();
        }
        return instance;
    }
}
