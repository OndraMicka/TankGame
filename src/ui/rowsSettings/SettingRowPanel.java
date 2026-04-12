package ui.rowsSettings;

import javax.swing.*;
import java.awt.*;

public abstract class SettingRowPanel extends JPanel {

    public SettingRowPanel(String displayName) {
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(0, 50));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        setBorder(BorderFactory.createEtchedBorder());

        add(new JLabel(displayName), BorderLayout.WEST);
        setVisible(true);
    }

}
