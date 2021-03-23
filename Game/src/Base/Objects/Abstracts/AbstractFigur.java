package Base.Objects.Abstracts;

import javax.swing.*;

public abstract class AbstractFigur {
    private int x, y;
    private ImageIcon image;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
