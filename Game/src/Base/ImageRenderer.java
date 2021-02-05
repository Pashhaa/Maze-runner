package Base;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by Asus on 17.08.2020.
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    private JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {


        lbl.setText(null);

        if (value.equals("B")) {
            lbl.setIcon(new ImageIcon(getClass().getResource("/images/wall.png")));
        } else if (value.equals("P")) {
            lbl.setIcon(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
        } else if (value.equals("M")) {
            lbl.setIcon(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
        } else if (value.equals("E")) {
            lbl.setIcon(new ImageIcon(getClass().getResource("/images/exit.gif")));
        } else if (value.equals("G")) {
            lbl.setIcon(null);
        } else if (value.equals("GG")) {
            lbl.setIcon(new ImageIcon(getClass().getResource("/images/gold.png")));
        }


        return lbl;
    }

}